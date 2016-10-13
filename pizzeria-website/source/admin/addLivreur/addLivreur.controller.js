(function () {
    'use strict';
    var controller = function(livService, $log, $timeout) {
        var vm = this;
        vm.error = false;
        vm.success = false;
        vm.newLivreur = {
            "nom": "",
            "prenom": "",
            "disponibilite": true
        };
        vm.addNewLivreur = function() {
            livService.postLivreur(vm.newLivreur).then(function() {
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
