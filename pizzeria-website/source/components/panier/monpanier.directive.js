(function () {
    'use strict';
var directive = function (localeStorageService, constantImg, $rootScope) {

        return {
      restrict: "E", 
            transclude: true, 
            scope: {
                "panier": "=dirPanier"
            }, 
            templateUrl: "./source/components/panier/monpanierdirective.html", 
            link: function (scope, element, attrs) {
                //recuperation du panier
                scope.storedPanier = localeStorageService.getDataLocalestorage();
                //eventement qui vérifie l'arrivée d'une nouvelle pizza
                //But affichier directement l'ajout d'une pizza sans F5
                $rootScope.$on("panierevent", function(event, data){
                    scope.storedPanier = data;
                });
                //récuperation des images de pizza
                scope.imageP = function(url){
                   return constantImg.apiUrlImg + url;
                };
                //calcul de la somme totale pour le client

                scope.total = function () {
                    var total = 0.0;
                    angular.forEach(scope.storedPanier, function (storedPizza) {
                        total += (storedPizza.pizza.prix * storedPizza.quan);
                    });
                    return total;
                };
                scope.changeQuant = function(nombre) {
                    scope.storedPanier.quan = nombre;
                };
            }
        };
    };
    module.exports = directive;
})();