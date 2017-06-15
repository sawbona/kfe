/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define(["jquery",
    "app/context/utils",
    "promise"], function ($, utils) {
    console.log("utils = " + utils);
    
    function ProjectsFacade(){
        var self = this;
        
        // methods
        self.getProjects = function(){
            return new Promise(function (resolve, reject){
                $.getJSON(utils.contextPath + "/api/projects/", function(page){
                    console.log("page = " + JSON.stringify(page));
                    resolve(page);
                }).always(reject);
            });
        };
    }
    
    return new ProjectsFacade();
});