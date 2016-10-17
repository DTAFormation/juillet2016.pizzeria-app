(function () {
    'use strict';
    var config = function ($translateProvider) {
        $translateProvider.translations('en', {
            TITLE: 'Hello',
            FOO: 'This is a paragraph.',
            HOME: 'Home',
            LIVREUR: 'Deliverers',
            CATE:'Sorting by category',
            DESCRIPTION:'Click on the map to access news Welcome to the developer pizzeria DTA, we are a specialist teaches pizzeria pizzas for new and experienced developers. Present since 2012 in several cities of France: 44800 Saint Herblain, 53000 Laval, 34000 Montpeliier. We welcome you from Monday to Saturday to discover our wide selection of pizzas made with local products, while you\'re at work or at home. Visit our website and order our generous pizzas * delivery or takeaway. Thank you for your visit and goodbye.'
        });
        $translateProvider.translations('fr', {
            TITLE: 'Bonjour',
            FOO: 'Ceci est un paragraphe.',
            HOME: 'Accueil',
            LIVREUR: 'Les livreurs',
            CATE:'Tri par catégorie',
            DESCRIPTION:'Cliquez sur la carte pour accéder à l\'actualité Bienvenue à La pizzéria du developpeur DTA, nous sommes une enseigne de pizzeria spécialiste des pizzas pour développeurs débutants ou expérimentés. Présent depuis 2012 dans plusieurs villes de France : 44800 Saint-Herblain, 53000 Laval, 34000 Montpeliier. Nous vous accueillons du lundi au samedi pour découvrir notre large choix de pizzas faites avec des produits locaux,pendant vos heures de travail ou de chez vous. Visitez notre site et commandez nos pizzas généreuses en livraison* ou à emporter. Merci pour votre visite et à bientôt.'
        });
        $translateProvider.preferredLanguage('fr');
    };
    module.exports = config;
} ()); 
