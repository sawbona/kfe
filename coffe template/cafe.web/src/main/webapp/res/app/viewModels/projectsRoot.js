/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([
    'ojs/ojcore', 'knockout', 
    'jquery', 'ojs/ojknockout', 
    'ojs/ojbutton', 'ojs/ojtoolbar', 
    'ojs/ojrouter',
    'ojs/ojmodule','ojs/ojmenu'], 
    function (oj, ko, $) {
    var router = oj.Router.rootInstance;
    
    // Add three states to the router with id 'home', 'book' and 'tables
    router.configure({
       'projectsList':   { label: 'Projects',   value: 'homeContent', isDefault: true },
       'projectDetails':   { label: 'Project Details',   value: 'bookContent' }
    });
    
    function ProjectsRoot(){
        var self = this;
        self.router = router;
    }
    oj.Router.sync();
//    oj.Router.sync().then(
//    function() {
//       ko.applyBindings(new ProjectsRouterModel);
//    },
//    function(error) {
//       oj.Logger.error('Error when starting router: ' + error.message);
//    });
//    
    return new ProjectsRoot;
});