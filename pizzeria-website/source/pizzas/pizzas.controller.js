(function () {
    'use strict';
    var controller = function(pizzService, $log) {
        var vm = this;
        pizzService.getAllPizzas().then(function(result) {
            vm.allPizzas = result.data;
        });
    };

    module.exports = controller;
}());
