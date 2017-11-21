define(["jquery", 'knockout'], function ($, ko) {

    function kf($) {
        var self = this;

        self.observeValidations = function (validations) {
            return ko.computed(function () {
                var containers = $(".kf-error-container");
                containers.text(null);
                for (var key in validations()) {
                    var expression = '[data-kf-error-for="' + key + '"]';
                    self.log("expression", expression);
                    var keyErrorContainers = $(expression);
                    self.log("length", {length: keyErrorContainers.length});
                    var messages = validations()[key].join(", ");
                    self.log("messages", {key: key, messages: messages});
                    keyErrorContainers.text(messages);
                }
            });
        };

        self.getUrlParameter = function (name) {
            var url = window.location.href;
            name = name.replace(/[\[\]]/g, "\\$&");
            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                    results = regex.exec(url);
            if (!results)
                return null;
            if (!results[2])
                return '';
            return decodeURIComponent(results[2].replace(/\+/g, " "));
        };

        self.getPathVariables = function (index) {
            var path = window.location.pathname // /account/search
            return index === undefined ? path.split("/") : path.split("/")[index];
        };

        self.getLastPathVariable = function () {
            var variables = self.getPathVariables();
            return variables[variables.length - 1];
        };

        self.log = function (message, object) {
            if (object === undefined) {
                object = message;
                message = "log";
            }
            //console.log(message + " = " + JSON.stringify(object));
        };

        self.processErrorMessages = function () {
            $(function () {
                $(".kf-generic-validation-error").each(function () {
                    var error = $(this);
                    var seleccion = $(".cafe-error-container." + error.attr("id"));
                    seleccion.text(error.val());
                    var hiddens = $(".cafe-show-on-error." + error.attr("id") + ".hidden");
                    hiddens.removeClass("hidden");
                });
            });
        };


        self.processErrorMessages();
        $("#loading").hide();

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $(document).ajaxError(function () {
            $(".log-container").show();
            $(".log-text").text("It is not possible to complete your request. Check your log file and try it again.");
        });

        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });

        jQuery.each(["put", "delete"], function (i, method) {
            jQuery[ method ] = function (url, data, callback, type) {
                if (jQuery.isFunction(data)) {
                    type = type || callback;
                    callback = data;
                    data = undefined;
                }

                return jQuery.ajax({
                    url: url,
                    type: method,
                    dataType: type,
                    data: data,
                    success: callback
                });
            };
        });
    }

    return new kf($);
});
