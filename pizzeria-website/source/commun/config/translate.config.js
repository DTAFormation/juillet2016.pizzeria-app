(function () {
    'use strict';
    var config = function ($translateProvider) {
        $translateProvider.useSanitizeValueStrategy('escape');
        $translateProvider.translations('en', {
            HOME: 'Home',
            PIZZA: 'pizzas',
            CONNECTION: 'Log in',
            DECO: 'Log out',
            INSCRIT:'Register',
            TITRE: 'Experts cooking for developers!',
            MENU:'Pizza Menu',
            CATE:'Sorting by category',
            LIEN: 'Click here to access the news:',
            PANIER:'Basket',
            SEE: 'Confirm order',
            AJOUT:'Add',
            DETAIL: 'Details',
            DESCRIPTION1:'What we offer Welcome to the developer pizzeria DTA, we are a specialist teaches pizzeria pizzas for new and experienced developers. Present since 2012 in several cities of France: 44800 Saint Herblain, 53000 Laval, 34000 Montpellier. We welcome you from Monday to Saturday to discover our wide selection of pizzas made with local products, while you\'re at work or at home. Visit our website and order our pizzas generous in delivery or takeaway. Thank you for your visit and goodbye.',
            DESCRIPTION2: 'The pizza, a whole story ... The word appears in 997 Pizza in Latin médiévial: He means "Fouace", "pancake". But it is in Naples in the sixteenth century, it is evidenced in its current direction. This word derives from Pide (or pita), the Turkish word for bread. We recognize in the pide, a likely ancestor of the famous Anatolian Italian recipe. The pizza (pl pizzas. Italian term) was linked to the work of the baker. It was used primarily to verify the correct temperature of the home before they are deposited bread, or take advantage of the last embers. The pizza has long been one way: "The bianca" which was coated with cream or lard. From the eighteenth century, appears the "rossa" decorated with a tomato sauce. She then diversified as evidenced by Alexandre Dumas, in 1844, in a travel book: "The pizza is oil, pizza is baked, the pizza is cheese, pizza is tomato, pizza is small fish; thermometer is a gourmet market; it increase or decrease in price, depending on the course designated above ingredients, depending on the abundance or scarcity of the Year "in June 1889 to honor the Queen, the leader Raffaele Esposito. , of the famous pizzeria Pietro e basta così decided to create a special pizza just for her. He cooked her dough in the oven and complete with tomatoes, cheese Mozzarella (not included ingredient in the recipe as too expensive for farmers to whom it was intended) and fresh basil (the colors of the Italian flag: green, white, and red). This recipe is a favorite pizza Margherita queen and when the rumor that it is the favorite food of the queen, the pizza becomes even more popular among the Italians. The story does not say if Raffaele served his creation in his own pizzeria but it started a culinary tradition, the Pizza Margherita, which still continues and has spread worldwide.',
            CONTACT: 'Contact us'
        });
        $translateProvider.translations('fr', {
            HOME: 'Accueil',
            PIZZA: 'Les pizzas',
            CONNECTION: 'Se connecter',
            DECO: 'Se déconnecter',
            INSCRIT: 'S\'inscrire',
            TITRE: 'Les experts de la cuisson pour développeurs !',
            MENU: 'Menu des Pizzas',
            CATE:'Filtre par catégorie',
            LIEN: 'Cliquer ici pour accéder à l\'actualitée :',
            PANIER: 'Panier',
            SEE: 'Valider ma commande',
            AJOUT: 'Ajouter',
            DETAIL: 'Détails',
            DESCRIPTION1:'Ce que nous vous proposons Bienvenue à La pizzeria du developpeur DTA, nous sommes une enseigne de pizzeria spécialiste des pizzas pour développeurs débutants ou expérimentés. Présent depuis 2012 dans plusieurs villes de France : 44800 Saint-Herblain, 53000 Laval, 34000 Montpellier. Nous vous accueillons du lundi au samedi pour découvrir notre large choix de pizzas faites avec des produits locaux,pendant vos heures de travail ou de chez vous. Visitez notre site et commandez nos pizzas généreuses, en livraison ou à emporter. Merci pour votre visite et à bientôt.',
            DESCRIPTION2: 'La Pizza, toute une histoire… Le mot Pizza apparaît en 997 en latin médiévial: Il signifie alors “Fouace”, “galette”. Mais c’est à Naples,au XVIe siècle, qu’il est attesté dans son sens actuel. Ce mot dériverait de Pide (ou pita), mot turc qui signifie pain. On reconnaît dans la pide, un ancêtre anatolien très probable de la fameuse recette italienne. La pizza (pl. pizze : terme italien) était lié au travail du boulanger. Elle servait avant tout à vérifier la bonne température du foyer avant qu’on y dépose le pain, ou à tirer partie des dernières braises. La pizza a été pendant longtemps d’une seule sorte : “la bianca” qui était enduite de crème ou de saindoux. A partir du XVIIIème siècle, apparaît la “rossa” agrémentée d’une sauce à la tomate. Elle s’est ensuite diversifiée comme en témoigne Alexandre DUMAS, en 1844, dans un récit de voyages : ” La pizza est à l’huile, la pizza est au lard, la pizza est au fromage, la pizza est aux tomates, la pizza est aux petits poissons; c’est un thermomètre gastronomique du marché: elle hausse ou baisse de prix , selon le cours des ingrédients sus désignés, selon l’abondance ou la disette de l’année.” En juin 1889, pour honorer sa reine, le chef Raffaele Esposito, de l’illustre pizzeria Pietro e basta così décide de créer une pizza spéciale, juste pour elle. Il fait cuire sa pâte au four et la complète avec des tomates, du fromage de Mozzarella (ingrédient non-inclus dans la recette originale car trop onéreux pour les paysans à qui elle était destinée) et du basilic frais (les couleurs du drapeau italien : vert, blanc, et rouge). Cette recette devient la pizza préférée de la reine Margherita et quand le bruit court que c’est le plat préféré de la reine, la pizza devient encore plus populaire parmi les Italiens. L’histoire ne dit pas si Raffaele a servi sa création dans sa propre pizzeria mais il a lancé une tradition culinaire, la pizza Margherita, qui dure encore et s’est répandue dans le monde entier.',
            CONTACT: 'Nous contacter'
        });
        $translateProvider.preferredLanguage('fr');
    };
    module.exports = config;
} ()); 
