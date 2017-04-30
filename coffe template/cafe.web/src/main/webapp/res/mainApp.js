/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Example of Require.js boostrap javascript
 */
var contextPath = contextPath || '/';

console.log("contextPath = " + contextPath);

requirejs.config({

    baseUrl: contextPath + '/res/jet/js/',
    // Path mappings for the logical module names
    paths: {
        'knockout': 'libs/knockout/knockout-3.4.0',
        'jquery': 'libs/jquery/jquery-3.1.0.min',
        'jqueryui-amd': 'libs/jquery/jqueryui-amd-1.12.0.min',
        'ojs': 'libs/oj/v2.3.0/min',
        'ojL10n': 'libs/oj/v2.3.0/ojL10n',
        'ojtranslations': 'libs/oj/v2.3.0/resources',
        'text': 'libs/require/text',
        'promise': 'libs/es6-promise/es6-promise.min',
        'hammerjs': 'libs/hammer/hammer-2.0.8.min',
        'signals': 'libs/js-signals/signals.min',
        'ojdnd': 'libs/dnd-polyfill/dnd-polyfill-1.0.0.min',
        'css': 'libs/require-css/css.min',
        'customElements': 'libs/webcomponents/CustomElements.min',
        'proj4': 'libs/proj4js/dist/proj4',
        'bootstrapjs': contextPath + '/res/bs/js/bootstrap',
        'app': '../../app',
        'mainApp': contextPath + "/res/mainApp"
    },
    // Shim configurations for modules that do not expose AMD
    shim: {
        'jquery': {
            exports: ['jQuery', '$']
        },
        "bootstrapjs": {"deps": ['jquery']}
    },

    // This section configures the i18n plugin. It is merging the Oracle JET built-in translation
    // resources with a custom translation file.
    // Any resource file added, must be placed under a directory named "nls". You can use a path mapping or you can define
    // a path that is relative to the location of this main.js file.
    config: {
        ojL10n: {
            merge: {
                //'ojtranslations/nls/ojtranslations': 'resources/nls/myTranslations'
            }
        },
        text: {
            // Override for the requirejs text plugin XHR call for loading text resources on CORS configured servers
            useXhr: function (url, protocol, hostname, port) {
                // Override function for determining if XHR should be used.
                // url: the URL being requested
                // protocol: protocol of page text.js is running on
                // hostname: hostname of page text.js is running on
                // port: port of page text.js is running on
                // Use protocol, hostname, and port to compare against the url being requested.
                // Return true or false. true means "use xhr", false means "fetch the .js version of this resource".
                return true;
            }
        },
        'app/facade/usersRestFacade': {
            path: contextPath || "/hola"
        }
    }
});


/**
 * A top-level require call executed by the Application.
 * Although 'ojcore' and 'knockout' would be loaded in any case (they are specified as dependencies
 * by the modules themselves), we are listing them explicitly to get the references to the 'oj' and 'ko'
 * objects in the callback.
 *
 * For a listing of which JET component modules are required for each component, see the specific component
 * demo pages in the JET cookbook.
 */
require(['ojs/ojcore',
    'knockout',
    'jquery',
    'app/commons/kf',
    'ojs/ojknockout',
    'ojs/ojbutton',
    'ojs/ojtoolbar',
    'ojs/ojmenu',
    'bootstrapjs',
    'ojs/ojmodule', 'ojs/ojrouter'], function (oj, ko, $) {

    console.log("inside require.mainApp.js");

    oj.ModuleBinding.defaults.modelPath = '../../app/routing/viewModels/';
    oj.ModuleBinding.defaults.viewPath = 'text!../../app/routing/views/';

    $(function () {
        ko.applyBindings({});
    });


});