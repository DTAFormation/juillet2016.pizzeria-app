(function () {
    'use strict';
    var directive = function(livService, $log, $timeout, _) {
        return {
            restrict: "A",
            template: "<div>{{livreur.nom}} {{livreur.prenom}}</div>",
            scope: {
                livreurName: '='
            },
            link: function(scope, element, attrs) {
                //scope.clientName
                livService.getAllLivreurs().then(function(result) {
                    scope.livreur = _.find(result.data, {"id": scope.livreurName});
                });
            }
        };
    };

    module.exports = directive;
}());
