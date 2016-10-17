(function () {
    'use strict';
    var config = function ($translateProvider) {
        $translateProvider.translations('en', {
            TITLE: 'Hello',
            FOO: 'This is a paragraph.',
            HOME: 'Home',
            LIVREUR: 'Deliverers'
        });
        $translateProvider.translations('fr', {
            TITLE: 'Bonjour',
            FOO: 'Ceci est un paragraphe.',
            HOME: 'Accueil',
            LIVREUR: 'Les livreurs'
        });
        $translateProvider.preferredLanguage('fr');
    };
    module.exports = config;
} ()); 
