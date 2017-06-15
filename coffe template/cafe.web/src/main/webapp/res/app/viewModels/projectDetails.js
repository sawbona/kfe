/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define(['ojs/ojcore', 'knockout'], function (oj, ko, $) {

    var router = oj.Router.rootInstance;
    console.log("router.retrieve() = " + JSON.stringify(router.retrieve()));

    function ProjectDetailsViewModel() {
        var self = this;
        var projectsRoot = ko.dataFor(document.getElementById('projectsRootElement'));
        self.project = projectsRoot.selectedProject;
        self.activities = [{name: "todo"}];
    }

    return new ProjectDetailsViewModel();
});