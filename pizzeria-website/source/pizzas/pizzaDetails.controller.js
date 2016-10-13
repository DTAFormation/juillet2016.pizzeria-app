(function () {
    'use strict';
    var controller = function(pizzService, $log, $routeParams) {
        var id = $routeParams.id;
        var vm = this;
        pizzService.getOne(id).then(function(result) {
            vm.pizza = result.data;
        });
    };

    module.exports = controller;
}());
