/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define(['ojs/ojcore', 'knockout',
    'jquery', 'ojs/ojknockout'], function (oj, ko, $) {
    
    console.log("insie projectDetails.js");
    
    function ProjectDetailsViewModel(){
        var self = this;
        self.activities = [{name: "todo"}];
    }
    
    return new ProjectDetailsViewModel;
});