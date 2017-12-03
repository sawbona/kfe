define(['ojs/ojcore', 'knockout',
    'jquery', 'app/facade/projectsFacade', "kf",
    'ojs/ojtable', 'ojs/ojarraytabledatasource'], function (oj, ko, $, projectsFacade, kf) {

    function findByStatusId(activities, statusId) {
        return $.grep(activities, function (activity) {
            return activity.status.statusId === statusId;
        });
    }

    function ActivitiesViewModel() {
        var self = this;
        self.project = ko.observable({});
        self.newActivity = {
            name: ko.observable(),
            description: ko.observable(),
            owner: ko.observable()
        };
        self.projectName = ko.pureComputed(function () {
            return self.project().name;
        });
        self.validations = ko.observable();
        self.validationsObserver = kf.observeValidations(self.validations);

        self.activities = ko.observableArray([]);
        self.datasource = new oj.ArrayTableDataSource(self.activities, {idAttribute: 'id'});

        self.newActivities = ko.observableArray([]);
        self.inProgressActivities = ko.observableArray([]);
        self.doneActivities = ko.observableArray([]);

        self.activities.subscribe(function (changes) {
            var activities = self.activities();
            self.newActivities(findByStatusId(activities, 1));
            self.inProgressActivities(findByStatusId(activities, 2));
            self.doneActivities(findByStatusId(activities, 3));
        });

        self.newActivitiesDatasource = new oj.ArrayTableDataSource(self.newActivities, {idAttribute: 'id'});

        self.inProgressDatasource = new oj.ArrayTableDataSource(self.inProgressActivities, {idAttribute: 'id'});

        self.doneDatasource = new oj.ArrayTableDataSource(self.doneActivities, {idAttribute: 'id'});

        self.selectedActivityModal = ko.observable({});

        // common functions.
        function showActivityModal(modalId, activity){
            $("#" + modalId).modal("show");
            self.selectedActivityModal(activity);
        }

        self.showNewActivityModal = function (data, event) {
            showActivityModal("newActivityModal", data);
        };
        
        self.showInProgresActivityModal = function(data, event){
            showActivityModal("inProgressActivityModal", data);
        };
        
        self.moveToCompleted = function(data, event){
            // loading...
            var button = $(event.target);
            button.button("loading");
            var activity = self.selectedActivityModal();
            activity.status.statusId = 3;
            projectsFacade.updateActivity(activity).then(function (response) {

                // reset loading...
                $("#move-to-button").button("reset");
                $("#inProgressActivityModal").modal("hide");
                self.inProgressActivities.remove(function (item) {
                    return item.id === response.payload.id;
                });
                self.doneActivities.push(activity);
            });
        };

        self.moveToInprogress = function () {

            // loading...
            $("#move-to-button").button("loading");
            var activity = self.selectedActivityModal();
            activity.status.statusId = 2;
            projectsFacade.updateActivity(activity).then(function (response) {

                // reset loading...
                $("#move-to-button").button("reset");
                $("#newActivityModal").modal("hide");
                self.newActivities.remove(function (item) {
                    return item.id === response.payload.id;
                });
                self.inProgressActivities.push(activity);
            });
        };

        self.createActivity = function (data, event) {
            var button = $(event.target);
            button.button("loading");
            kf.log("description", self.newActivity.description());
            var activityDto = {
                projectId: self.project().id,
                name: self.newActivity.name(),
                description: self.newActivity.description(),
                owner: self.newActivity.owner()
            };
            kf.log("activityDto", activityDto);
            projectsFacade.createActivity(activityDto).then(function (result) {
                button.button("reset");
                kf.log("result", result);
                self.validations(result.validations);
                if (result.valid) {
                    $("#myModal").modal("hide");
                    self.newActivity.name(null);
                    self.newActivity.description(null);
                    self.newActivity.owner(null);
                    var activity = result.payload;

                    self.newActivities.push(activity);
                }
            });
        };

        projectsFacade.getProjectDetails(kf.getUrlParameter("p")).
                then(function (result) {
                    kf.log("result", result);
                    self.project(result.payload);
                    self.activities(result.payload.activities);
                });
    }
    return new ActivitiesViewModel();
});