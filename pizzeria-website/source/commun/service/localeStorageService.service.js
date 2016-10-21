(function () {
    'use strict';
    var service = function() {
        this.getDataLocalestorage = function() {
            return JSON.parse(localStorage.getItem("panier"));
        };
        this.postLocaleStorage = function(panier) {
            return localStorage.setItem("panier", JSON.stringify(panier));
        };
    
    };

    module.exports = service;
}());
