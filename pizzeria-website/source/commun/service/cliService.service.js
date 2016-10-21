(function () {
    'use strict';
    var service = function($http, pizzConst, $cookies) {

        var clientConnecte;

        this.getAllClient = function(params) {
            return $http.get(pizzConst.apiUrl + "clients", params);
        };
        this.getOneClient = function(id) {
            return $http.get(pizzConst.apiUrl + "clients/" + id);
        };
        this.postClient = function(data) {
            return $http.post(pizzConst.apiUrl + "clients", data);
        };
        this.connectionClient = function(data) {
            return $http.post(pizzConst.apiUrl + "clients/connection", data).then(function(result) {
                //$cookies.put("connecter", true);
                localStorage.setItem("client", JSON.stringify(result.data));
                return result;  
            });
        };
        this.deconnectionClient = function() {
           // $cookies.put("connecter", false);
            localStorage.removeItem("client");
        };
        this.isConnected = function() {
            return localStorage.getItem("client") !== null; //$cookies.get("connecter") === "true";
        };
        this.getClientConnecte = function() {
           return JSON.parse(localStorage.getItem("client"));
        };
    };

    module.exports = service;
}());
