define(['ojs/ojcore', 'knockout',
    'jquery', 'app/facade/projectsFacade', "kf"], function (oj, ko, $, projectsFacade, kf) {

    console.log("projectsFacade = " + projectsFacade);

    function ProjectsViewModel() {
        var self = this;

        // properties

        self.newProjectName = ko.observable(null);
        self.projects = ko.observableArray();
        self.validations = ko.observable();
        
        self.validationsObserver = ko.computed(function(){
            var containers = $(".kf-error-container");
            containers.text(null);
            for(var key in self.validations()){
                var keyErrorContainers = containers.find("[data-kf-error-for='" + key + "']");
                var messages = self.validations()[key].join(", ");
                kf.log("messages", {m: messages});
                keyErrorContainers.text(messages);
            }
        });

        // methods
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

        projectsFacade.getProjects().then(function (result) {
            kf.log("result", result);
            self.projects(result.payload.content);
        });


    }
    return new ProjectsViewModel;
});