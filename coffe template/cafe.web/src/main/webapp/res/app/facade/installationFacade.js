define(["jquery",
    "app/context/utils",
    "kf",
    "promise"], function ($, utils, kf) {
    function InstallationFacade(){
        var self = this;
        self.getInstallationProperties = function(){
            return new Promise(function (resolve, reject){
                $.getJSON(utils.contextPath + "/api/installationProperties/", function(page){
                    resolve(page);
                }).always(reject);
            });
        };
    }
    
    return new InstallationFacade();
});