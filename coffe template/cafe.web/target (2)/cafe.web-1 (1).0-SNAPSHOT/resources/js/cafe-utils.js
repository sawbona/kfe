/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function processErrorMessages() {
    $(".errorvalidacion").each(function () {
        var error = $(this);
        var seleccion = $(".cafe-error-container." + error.attr("id"));
        seleccion.text(error.val());
        var hiddens = $(".cafe-show-on-error." + error.attr("id") + ".hidden");
        hiddens.removeClass("hidden");
    });
}

$(function () {
    processErrorMessages();
});