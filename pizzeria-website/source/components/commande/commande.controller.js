(function () {
    'use strict';
    
    var controller = function($window, cliService, $log, $timeout, localeStorageService) {
        var vm = this;
        
        vm.panier = localeStorageService.getDataLocalestorage();
        //$log.info(vm.panier);
    };
    module.exports = controller;
}());