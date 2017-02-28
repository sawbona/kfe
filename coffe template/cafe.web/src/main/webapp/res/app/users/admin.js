/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require(['ojs/ojcore',
    'knockout',
    'jquery',
    'app/facade/usersRestFacade',
    'ojs/ojbutton',
    'ojs/ojdialog',
    'ojs/ojknockout'], function (oj, ko, $, usersFacade) {

    function UsersModel() {
        var self = this;
        self.users = ko.observableArray();
        self.currentUser = ko.observable({});
        self.loading = ko.observable(true);

        self.setCurrentUser = function () {
            self.currentUser(this);
        };

        self.removeCurrentUser = function () {
            $("#myModal").modal("show");
        };

        self.confirmDeleteUser = function () {
            usersFacade.deleteUser(self.currentUser()).
                    then(function (deleted) {
                        self.users.remove(function (item) {
                            return item.email === deleted;
                        });
                    });
        };
        this.hideUser = function (elem) {
            if (elem.nodeType === 1)
                $(elem).slideUp(function () {
                    $(elem).remove();
                });
        };

        usersFacade.getUsers().then(function(list){
            self.users(list);
            self.loading(false);
        }, function(){
            self.loading(false);
        });
    }

    var vm = new UsersModel;
    $(document).ready(function () {
        ko.applyBindings(vm, document.getElementById("#body-container"));
    });
});