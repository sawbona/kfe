/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define(["jquery",
    "app/context/utils",
    "kf",
    "promise"], function ($, utils, kf) {
    console.log("utils = " + utils);
    
    function ProjectsFacade(){
        var self = this;
        
        // methods
        self.getProjects = function(){
            return new Promise(function (resolve, reject){
                $.getJSON(utils.contextPath + "/api/projects/", function(page){
                    resolve(page);
                }).always(reject);
            });
        };
        
        self.createProject = function(project){
            return new Promise(function(resolve, reject){
                $.post(utils.contextPath + "/api/projects/", project, function(result){
                    kf.log(result);
                    resolve(result);
                });
            });
        };
    }
    
    return new ProjectsFacade();
});