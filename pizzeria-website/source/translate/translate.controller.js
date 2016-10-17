(function () {
    'use strict';
    var controller = function ($translate, $scope, $log, $cookies) {
        $cookies.put("language","fr");
        $log.info("here");
        this.changeLanguage = function (key) {
            $cookies.put("language",key);
            $log.info("here");
            $log.info("qsfsdfdfs");
            $translate.use(key);
        };
    };
    module.exports = controller;
} ()); 
