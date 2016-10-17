(function () {
    'use strict';
    var controller = function(pizzService, $log, constantImg) {

        var constImg = constantImg.apiUrlImg ;
        console.log(constImg);

        var vm = this;
        pizzService.getAllPizzas().then(function(result) {
            vm.allPizzas = result;
            console.log(vm.allPizzas);
        }); 
        vm.categories = ['SANS','VIANDE','POISSON'];

        
    };

    module.exports = controller;
}());
