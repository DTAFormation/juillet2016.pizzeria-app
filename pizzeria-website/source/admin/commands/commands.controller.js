(function () {
    'use strict';
    var controller = function(cmdService, $log, _) {
        var vm = this;
        cmdService.getAllCommands().then(function(result) {
            vm.commands = result.data;
        });
    };

    module.exports = controller;
}());
