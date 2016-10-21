(function () {
    'use strict';
    var directive = function (localeStorageService,constantImg) {
        return {
      restrict: "E", 
            transclude: true, 
            scope: {
                "panier": "=dirPanier"
            }, 
            templateUrl: "panier/monpanierdirective.html", 
            link: function (scope, element, attrs) {

                scope.storedPanier = localeStorageService.getDataLocalestorage();
                scope.urlImg = constantImg.apiUrlImg + scope.imgUrl ;

                scope.imageP = function(url){
                    return constantImg.apiUrlImg + url;
                };
                /*console.log("scope.storedPanier", scope.storedPanier);*/
                
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