(function () {
    "use strict";
    /*
     * Load Librairies
     */
    require("angular");
    require("angular-route");
    require("angular-translate");

    "use strict";


    angular.module("pizzeria", ['ngRoute', 'pascalprecht.translate'])
        // Load services
        .service("pizzService", require("./service/pizzService.service"))
        .service("cliService", require("./service/cliService.service"))
        .service("cmdService", require("./service/cmdService.service"))
        .service("livService", require("./service/livService.service"))
        .service("cmdPizzService", require("./service/cmdPizzService.service"))
        // Load config
        .config(require("./config/app.config"))
        // Load routes
        .config(require("./config/routes.config"))
        // Load constant
        .constant("pizzConst", require("./config/config.constant"))
        /*
         * Load Lodash
         */
        .constant("_", require("lodash"))
        /*
         * Home
         */
        .controller("homeCtrl", require("./home/home.controller"))
        /*
         * Livreurs
         */
        .controller("livCtrl", require("./livreurs/livreurs.controller"))
        /*
         * Pizzas
         */
        .controller("pizzCtrl", require("./pizzas/pizzas.controller"))
        .controller("pizzDetailsCtrl", require("./pizzas/pizzaDetails.controller"))
        /*
         * Admin
         */
        .controller("cmdCtrl", require("./admin/commands/commands.controller"))
        .directive("clientName", require("./admin/commands/clientName.directive"))
        .directive("livreurName", require("./admin/commands/livreurName.directive"))
        .controller("addPizzCtrl", require("./admin/addPizza/addPizza.controller"))
        .controller("addLivCtrl", require("./admin/addLivreur/addLivreur.controller"))
        /**
         * Translate
         */
        .controller("translateCtrl", require("./translate/translate.controller"))
        .config(require("./config/translate.config"))
        .directive("myDirective", require("./translate/directive/myDirective.directive"));

} ());