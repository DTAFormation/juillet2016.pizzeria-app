(function () {
    'use strict';
    var service = function($http, pizzConst) {
        this.getAllClient = function(params) {
            return $http.get(pizzConst.apiUrl + "clients", params);
        };
        this.getOneClient = function(id) {
            return $http.get(pizzConst.apiUrl + "clients/" + id);
        };
        this.postClient = function(data) {
            return $http.post(pizzConst.apiUrl + "clients", data);
        };
    };

    module.exports = service;
}());
