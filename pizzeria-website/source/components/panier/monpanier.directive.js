(function () {
    'use strict';
    var directive = function (localeStorageService) {
        return {
            restrict: "E", 
            transclude: true, 
            scope: {
                "panier": "=dirPanier"
            }, 
            templateUrl: "./source/components/panier/monpanierdirective.html", 
            link: function (scope, element, attrs) {
                scope.storedPanier = localeStorageService.getDataLocalestorage();
                console.log("scope.storedPanier", scope.storedPanier);
                
                scope.total = function () {
                    var total = 0.0;
                    scope.storedPanier.forEach(function (pizz) {
                        total += pizz.prix;
                       /* for (var i = 0; i < pizz.length; i++) {
                            total += pizz[i].prix;
                            console.log("dedans");
                            console.log(total);
                        }*/
                        
                        return total;
                    });
                    console.log(total);
                };
            }
        };
    };
    module.exports = directive;
})();