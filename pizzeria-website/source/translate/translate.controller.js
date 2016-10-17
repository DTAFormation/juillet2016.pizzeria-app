(function () {
    'use strict';
    var controller = function ($translate, $scope, $log) {
        this.p = 'yolo';
        $log.info("here");
        this.changeLanguage = function (key) {
            $log.info("here");
            $log.info("qsfsdfdfs");
            $translate.use(key);
        };

        this.test = function () {
            $log.info("test");
            return "p";
        };
    };
    module.exports = controller;
} ()); 
