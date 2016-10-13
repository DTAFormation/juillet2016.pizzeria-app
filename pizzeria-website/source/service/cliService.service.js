(function () {
    'use strict';
    var service = function($http, pizzConst) {
        this.getAllClients = function(params) {
            return $http.get(pizzConst.apiUrl + "clients", params);
        };
        this.getOneClients = function(id) {
            return $http.get(pizzConst.apiUrl + "clients/" + id);
        };
        this.postClient = function(data) {
            return $http.post(pizzConst.apiUrl + "clients", data);
        };
    };

    module.exports = service;
}());
