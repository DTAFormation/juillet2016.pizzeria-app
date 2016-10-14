(function () {
    'use strict';

    var config = function ($routeProvider) {

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
        
        $routeProvider.when('/pizza/:id', {
            templateUrl: "pizzas/pizzaDetails.html",
            controller: "pizzDetailsCtrl",
            controllerAs: 'pizzD'
        });
        /*
         * Admin
         */
        $routeProvider.when('/admin', {
            templateUrl: "admin/commands/commands.html",
            controller: "cmdCtrl",
            controllerAs: 'cmd'
        });
        $routeProvider.when('/admin/ajout_pizza', {
            templateUrl: "admin/addPizza/addPizza.html",
            controller: "addPizzCtrl",
            controllerAs: 'addPizz'
        });
        $routeProvider.when('/admin/ajout_livreur', {
            templateUrl: "admin/addLivreur/addLivreur.html",
            controller: "addLivCtrl",
            controllerAs: 'addLiv'
        });
    };

    module.exports = config;
} ());
