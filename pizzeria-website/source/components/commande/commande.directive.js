(function () {
    'use strict';
var directive = function (localeStorageService, constantImg, $rootScope) {

        return {
      restrict: "E", 
            transclude: true, 
            scope: {
                MyCommandePanier: "="
            }, 
            link: function (scope, element, attrs) {
                console.log('Do action with data', scope.myDirective);
            }
        };
    };
    module.exports = directive;
})();