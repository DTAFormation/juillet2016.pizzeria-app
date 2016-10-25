(function () {
    'use strict';
    var service = function($http, pizzConst) {
        this.getAllCommands = function(data) {
            return $http.get(pizzConst.apiUrl + "commandes");
        };
        this.postCommand = function(data) {
            return $http.post(pizzConst.apiUrl + "commandes", data);
        };
    };
    module.exports = service;
}());
