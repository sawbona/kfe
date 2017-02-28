/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global contextPath */
var app = angular.module('usersApp', []);
app.controller('usersCtrl', function ($scope, $http) {
    var userCtrl = $scope;
    $http.get(contextPath + "/api/users/").then(
            function (response) {
                $scope.users = response.data.users;
            }
    );
    userCtrl.delete = function (index) {
        var user = $scope.users[index];
        $http.delete(contextPath + "/api/users/" + user.id).then(
                function (reponse) {
                    $scope.users.splice(index, 1);
                }
        );
    };

    userCtrl.selectUser = function (user) {
    }
});
$(function () {
    $("#nav-menu-users").addClass("active");
});