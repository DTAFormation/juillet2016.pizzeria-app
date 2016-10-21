(function () {
    'use strict';
    var service = function($rootScope) {
        this.getDataLocalestorage = function() {
            return JSON.parse(localStorage.getItem("panier"));
        };
        this.postLocaleStorage = function(panier) {
            //Appel de mon event panier pour la récupération de celui ci
            $rootScope.$emit('panierevent', panier);
            return localStorage.setItem("panier", JSON.stringify(panier));
        };
    
    };

    module.exports = service;
}());
