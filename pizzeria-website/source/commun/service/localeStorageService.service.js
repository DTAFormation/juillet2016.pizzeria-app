(function () {
    'use strict';
    var service = function($rootScope) {
        var vm = this;
        this.getDataLocalestorage = function() {
            return JSON.parse(localStorage.getItem("panier"));
        };
        this.postLocaleStorage = function(panier) {
            //Appel de mon event panier pour la récupération de celui ci
            $rootScope.$emit('panierevent', panier);
            return localStorage.setItem("panier", JSON.stringify(panier));
        };
        this.deleteElementLocaleStorage = function(pizza){
            var monPanier = JSON.parse(localStorage.getItem("panier"));
            var newPanier = [];
            monPanier.find(function(maPizza){
                if(maPizza.id != pizza.id ){
                newPanier.push(maPizza);
               }
               vm.postLocaleStorage(newPanier);
            });
            
        };
        this.clearLocalStorage = function(){
            localStorage.clear();
        };
    
    };

    module.exports = service;
}());
