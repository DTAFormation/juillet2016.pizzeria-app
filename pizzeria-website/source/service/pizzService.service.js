(function () {
    'use strict';
    var service = function($http, pizzConst) {
        this.getAllPizzas = function() {
            return $http.get(pizzConst.apiUrl + "pizzas").then(function(result){
                    return result.data.map(function(p){
                        if (p.categorie === 'SANS_VIANDE') {
                            p.categorie = 'SANS';
                        }
                        return p;
                    });
                });
        };
        this.postPizza = function(data) {
            return $http.post(pizzConst.apiUrl + "pizzas", data);
        };
        this.getOne = function(id) {
            return $http.get(pizzConst.apiUrl + "pizzas/" + id);
        };
    };

    module.exports = service;
}());
