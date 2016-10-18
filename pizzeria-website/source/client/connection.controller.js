(function () {
    'use strict';
    var controller = function(cliService, $log, $timeout) {
        var vm = this;
        vm.error = false;
        vm.success = false;
        vm.client = {};
        vm.logClient = function() {
            vm.client.email = vm.cli.email;
            vm.client.password = vm.cli.password;
            cliService.connectionClient(vm.client).then(function(result) { 
                vm.success = true;
                vm.cli = {};
                $timeout(function() {
                    vm.success = false;
                }, 5000);
            }, function() {
                vm.error = true;
                $timeout(function() {
                    vm.error = false;
                }, 5000);
            });
        };
    };

    module.exports = controller;
}());