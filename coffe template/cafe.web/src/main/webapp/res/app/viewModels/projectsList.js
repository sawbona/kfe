define(['ojs/ojcore', 'knockout',
    'jquery', 'app/facade/projectsFacade', "kf"], function (oj, ko, $, projectsFacade, kf) {

    console.log("projectsFacade = " + projectsFacade);

    function ProjectsViewModel() {
        var self = this;

        // properties

        self.newProjectName = ko.observable(null);
        self.projects = ko.observableArray();
        self.validations = ko.observable();
        
        
        self.displayNameValidations = ko.pureComputed(function () {
            for (var key in self.validations()) {
                console.log("key = " + key);
                if (key === 'name') {
                    return true;
                }
            }
            return false;
        });

        self.nameValidations = ko.pureComputed(function () {
            var messages = "";
            for (var key in self.validations()) {
                if (key === 'name') {
                    var ms = self.validations()[key];
                    messages = ms.join(", ");
                }
            }
            return messages;
        });


        // methods

        projectsFacade.getProjects().then(function (result) {
            kf.log("result", result);
            self.projects(result.payload.content);
        });

        self.createProject = function (data, event) {
            var button = $(event.target);
            button.button("loading");
            var projectDto = {
                name: self.newProjectName()
            };
            console.log("createProject");
            projectsFacade.createProject(projectDto).then(function (result) {
                button.button("reset");
                kf.log("result", result);
                self.validations(result.validations);
                if (result.valid) {
                    self.projects.push({
                        id: result.payload.id,
                        name: result.payload.name
                    });
                    self.newProjectName(null);
                    $("#myModal").modal("hide");
                }
            });
        };

        self.showAddProjectModal = function () {

        };

    }
    return new ProjectsViewModel;
});