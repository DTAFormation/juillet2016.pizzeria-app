(function () {
    'use strict';

    var config = function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: "home/home.html",
            controller: "homeCtrl",
            controllerAs: 'home'
        });
        $routeProvider.when('/livreurs', {
            templateUrl: "livreurs/livreurs.html",
            controller: "livCtrl",
            controllerAs: 'liv'
        });
        /*
         * Pizzas
         */
        $routeProvider.when('/pizzas', {
            templateUrl: "pizzas/pizzas.html",
            controller: "pizzCtrl",
            controllerAs: 'pizz'
        });
        $routeProvider.when('/pizzas/:id', {
            templateUrl: "pizzas/pizzaDetails.html",
            controller: "pizzDetailsCtrl",
            controllerAs: 'pizzD'
        });
        /*
         * Clients
         */
        $routeProvider.when('/inscription', {
            templateUrl: "client/inscription.html",
            controller: "insriCtrl",
            controllerAs: 'inscri'
        });
        $routeProvider.when('/connection', {
            templateUrl: "client/connection.html",
            controller: "clientCtrl",
            controllerAs: 'client'
        });
        $routeProvider.when('/deconnection', {
            templateUrl: "client/deconnection.html",
            controller: "decoCtrl",
            controllerAs: 'deco'
        });
    };

    module.exports = config;
}());
