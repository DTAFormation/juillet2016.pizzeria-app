(function () {
    'use strict';
    var controller = function(livService, $log, $timeout) {
        var vm = this;
        vm.error = false;
        vm.success = false;
        vm.newClient = {};
        vm.addNewClient = function() {
            cliService.postClient(vm.newClient).then(function(result) {
                vm.success = true;
                console.log(result);
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