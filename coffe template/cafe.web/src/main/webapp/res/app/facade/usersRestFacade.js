define(["jquery",
    "module",
    "app/commons/kf",
    "promise"], function ($, module, kf) {

    var path = module.config().path;

    function usersRestFacade($) {
        var self = this;

        self.getUsers = function () {
            return new Promise(function (resolve, reject) {
                $.getJSON(path + "/api/users/", function (page) {
                    
                    // payload type Page<UserDto>.
                    resolve(page.payload.content);
                }).always(reject);
            });
        };

        self.deleteUser = function (user) {
            return new Promise(function (resolve, reject) {
                
                $.delete(path + "/api/users/", function(user){
                    resolve(user.email);
                });
            });
        };
    }

    return new usersRestFacade($);
});

