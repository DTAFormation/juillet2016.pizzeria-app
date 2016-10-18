(function () {
    'use strict';
    var controller = function ($translate, $scope, $log, $cookies) {
        $cookies.put("language","fr");
        this.changeLanguage = function (key) {
            $cookies.put("language",key);
            $translate.use(key);
        };
    };
    module.exports = controller;
} ()); 
