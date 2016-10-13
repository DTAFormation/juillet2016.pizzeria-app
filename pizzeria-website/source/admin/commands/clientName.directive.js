(function () {
    'use strict';
    var directive = function(cliService, $log, $timeout, _) {
        return {
            restrict: "A",
            template: "<div>{{name}}</div>",
            scope: {
                clientName: '='
            },
            link: function(scope, element, attrs) {
                //scope.clientName
                cliService.getAllClients().then(function(result) {
                    scope.name = _.find(result.data, {"id": scope.clientName}).name;
                });
            }
        };
    };

    module.exports = directive;
}());
