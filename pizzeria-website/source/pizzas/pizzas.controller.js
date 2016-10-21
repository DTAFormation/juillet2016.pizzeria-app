(function () {
    'use strict';
    var controller = function (pizzService, localeStorageService, $log, constantImg) {
        var constImg = constantImg.apiUrlImg;
        /*console.log(constImg);*/
        var vm = this;
        pizzService.getAllPizzas().then(function (result) {
            vm.allPizzas = result.data;
        });
        var panier = [];
        console.log("panier debut")
        this.ajoutPanier = function (pizza) {
            console.log("this.pizza");
            console.log(pizza);
            panier.push(pizza);
            console.log("panier ajouté");
            console.log(panier);
            localeStorageService.postLocaleStorage(panier);
        };
        
        vm.localpanier = localeStorageService.getDataLocalestorage();
    };
    /*console.log(vm.allPizzas);*/
    module.exports = controller;
}());