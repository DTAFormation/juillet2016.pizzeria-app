/*(function () {
    'use strict';
    var filter = function() {

        return function (items, cat) {
        var filtered = [];
        var catMatch = new RegExp(cat, 'i');
        console.log("items",items);
        console.log("cat", cat);
        if (cat === "TOUTES"){
            filtered = items;
        } else{
        for (var i = 0; i < items.length; i++) {
                var item = items[i];
                if (catMatch.test(item.categorie)){
                    filtered.push(item);
                }
            }
        }

     console.log("ici", this.tri.categorie.value) ; 
        return filtered;
    };
     
    };
    
   
    module.exports = filter;
}());
*/
