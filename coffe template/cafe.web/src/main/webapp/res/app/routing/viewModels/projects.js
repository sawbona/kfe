define(['ojs/ojcore', 'knockout',
    'jquery', "../viewModels/mainProjects"], function (oj, ko, $, parent) {

    console.log("parent = " + parent.router.go());

    function ProjectsViewModel() {
        var self = this;

        self.newProjectName = ko.observable(null);


        self.projects = ko.observableArray([{name: "oracle jet", gotoDetails:function(){}}]);
        self.createProject = function () {
            console.log("newProjectName = " + self.newProjectName);
            if (self.newProjectName() !== null) {
                self.projects.push({name: self.newProjectName()});
                self.newProjectName(null);
            }

        };



        self.goToProjectDetails = function (event, ui) {
            console.log("mainProject.goToProjectsDetails");
            console.log("event = " + JSON.stringify(event));
            console.log("ui = " + ui);
            if (ui) {
                parent.router.go("projectDetails");
            }


//            if ('selected' === ui.option) {
//                // Invoke go() on the selected RouterState object.
//                router.states[ui.value].go();
//            }
        };
    }
    return new ProjectsViewModel;
});