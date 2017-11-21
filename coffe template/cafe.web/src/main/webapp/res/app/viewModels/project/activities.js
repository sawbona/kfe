define(['ojs/ojcore', 'knockout',
    'jquery', 'app/facade/projectsFacade', "kf",
    'ojs/ojtable', 'ojs/ojarraytabledatasource'], function(oj, ko, $, projectsFacade, kf){
    function ActivitiesViewModel(){
        var self = this;
        self.project = ko.observable({});
        self.newActivity = {
            name: ko.observable(),
            description: ko.observable(),
            owner: ko.observable()
        };
        self.projectName = ko.pureComputed(function(){
            return self.project().name;
        });
        self.validations = ko.observable();
        self.validationsObserver = kf.observeValidations(self.validations);
        
        self.activities = ko.observableArray();
        self.datasource = new oj.ArrayTableDataSource(self.activities, {idAttribute: 'id'});
        
        // methods
        
        self.createActivity = function(){
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
            projectsFacade.createActivity(activityDto).then(function(result){
                button.button("reset");
                kf.log("result", result);
                self.validations(result.validations);
                if(result.valid){
                    $("#myModal").modal("hide");
                    self.newActivity.name(null);
                    self.newActivity.description(null);
                    self.activities.push(result.payload);
                }
            });
        };
        
        projectsFacade.getProjectDetails(kf.getUrlParameter("p")).
                then(function(result){
                    kf.log("result", result);
                    self.project(result.payload);
                    self.activities(result.payload.activities);
                });;
    }
    return new ActivitiesViewModel();
});