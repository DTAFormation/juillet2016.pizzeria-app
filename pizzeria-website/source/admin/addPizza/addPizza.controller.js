(function () {
    'use strict';
    var controller = function(pizzService, $log, $timeout) {
        var vm = this;
        vm.error = false;
        vm.success = false;
        vm.newPizza = {
            "nom": "",
            "prix": "",
            "url_image": "",
            "ingredients": [""]
        };
        vm.addNewPizza = function() {
            pizzService.postPizza(this.newPizza).then(function() {
                vm.success = true;
                $timeout(function() {
                    vm.success = false;
                }, 1000);
            }, function() {
                vm.error = true;
                $timeout(function() {
                    vm.error = false;
                }, 1000);
            });
        };
    };

    module.exports = controller;
}());
