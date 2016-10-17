(function () {
    'use strict';
    var controller = function(cliService, $log, $timeout) {
        var vm = this;
        vm.error = false;
        vm.success = false;
        vm.newClientPost = {};
        vm.addNewClient = function() {
            vm.newClientPost.email = vm.newClient.email;
            vm.newClientPost.password = vm.newClient.password;
            vm.newClientPost.nom = vm.newClient.nom;
            vm.newClientPost.prenom = vm.newClient.prenom;
            vm.newClientPost.sexe = vm.newClient.sexe;
            vm.newClientPost.date = vm.newClient.date;
            vm.newClientPost.adresse = vm.newClient.adresse;
            vm.newClientPost.telephone = vm.newClient.tel;
            cliService.postClient(vm.newClientPost).then(function(result) {  
                console.log(result.data);
                vm.success = true;
                vm.newClient = {};
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