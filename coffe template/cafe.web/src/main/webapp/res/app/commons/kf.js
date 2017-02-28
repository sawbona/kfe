define(["jquery"], function ($) {
    
    function kf($) {
        var self = this;
        
        
        /* 
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
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
        
        $(document).ajaxError(function() {
            $(".log-container").show();
            $(".log-text").text("It is not possible to complete your request. Check your log file and try it again.");
        });
        
        $(document).ajaxSend(function(e, xhr, options) {
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
