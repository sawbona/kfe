/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define(['ojs/ojcore', 'knockout',
    'jquery'], function (oj, ko, $){
    var rootViewModel = ko.dataFor(document.getElementById('main-container'));
    
    function Utils(){
        var self = this;
        self.contextPath = rootViewModel.contextPath;
    }
    
    return new Utils();
});