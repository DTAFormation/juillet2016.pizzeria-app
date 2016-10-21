(function () {
    'use strict';
    var controller = function (pizzService, localeStorageService, $log, constantImg) {
        var constImg = constantImg.apiUrlImg;
        /*console.log(constImg);*/
        var vm = this;
        pizzService.getAllPizzas().then(function (result) {
            vm.allPizzas = result.data;
        });
        vm.panier = [];
        vm.pizz = {};
        vm.trouver = false;
        console.log("panier debut");
        this.ajoutPanier = function (pizza) {
            console.log("this.pizza");
            console.log(pizza);
            if (vm.panier.length > 0) {
                /* for (var i = 0; i < vm.panier.length; i++) {
                     if (pizza.id === vm.panier[i].pizz.id) {
                         var qua = 0;
                         qua = vm.panier.pizz.quan + 1;
                         vm.panier.pizz.quan.push(qua);
                         console.log("nouvelle quantité ajouté panier");
                         vm.trouver = true;
                     }
                 }*/

                if (!vm.trouver) {
                    vm.pizz.id = pizza.id;
                    vm.pizz.pizza = pizza;
                    vm.pizz.quan = 1;
                    console.log("pizza", vm.pizz);
                    vm.panier.push(vm.pizz);
                    console.log("panier", vm.panier);
                    vm.pizz = {};
                    console.log("nouvelle pizza ajouté panier");
                }
                vm.trouver = false;
            } else {
                vm.pizz.id = pizza.id;
                vm.pizz.pizza = pizza;
                vm.pizz.quan = 1;
                console.log("pizza", vm.pizz);
                vm.panier.push(vm.pizz);
                console.log("panier", vm.panier);
                vm.pizz = {};
                console.log("nouvelle pizza ajouté panier");
            }
            console.log(vm.panier);
            localeStorageService.postLocaleStorage(vm.panier);
        };
        vm.localpanier = localeStorageService.getDataLocalestorage();
    };
    /*console.log(vm.allPizzas);*/
    module.exports = controller;
} ());