(function () {
    'use strict';
    var directive = function ($translate,$log) {
        return {
            // template: "<img ng-src='img/en.png' ng-click='changeLanguage('fr')'/>'<img ng-src='img/fr.png' ng-click='changeLanguage('en')'/>",
            template: "<div>{{ myDirective }}</div>",
            scope: {
                myDirective: '='
            },
            link: function (scope, element, attrs) {
                $log.info(scope.myDirective);
                scope.changeLanguage = function (key) {
                    $log.info('fsdfsd');
                    $translate.use(key);
                };
            }
        };
    };
    module.exports = directive;
} ());