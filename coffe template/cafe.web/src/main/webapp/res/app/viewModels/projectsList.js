define(['ojs/ojcore', 'knockout',
    'jquery', 'app/facade/projectsFacade'], function (oj, ko, $, facade) {

    console.log("projectsFacade = " + facade);

    function ProjectsViewModel() {
        var self = this;

        // properties
        
        self.newProjectName = ko.observable(null);
        self.projects = ko.observableArray();

        // methods
        
        facade.getProjects().then(function(page){
            console.log("project list page = " + JSON.stringify(page));
        });

        self.createProject = function () {
            if (self.newProjectName() !== null) {
                self.projects.push({
                    id: '',
                    name: self.newProjectName()
                });
                self.newProjectName(null);
                $("#myModal").modal("hide");
            }
        };

        self.showAddProjectModal = function () {

        };

    }
    return new ProjectsViewModel;
});