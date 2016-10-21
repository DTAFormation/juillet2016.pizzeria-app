(function () {
    'use strict';
    var controller = function(pizzService, cmdPizzService, cmdService, livService, cliService, $log, $q) {
        var vm = this;
        vm.clients = {};
        pizzService.getAllPizzas().then(function(result) {
            vm.pizzas = result.data;
            pizzService.allPizzas = result.data;
        });
        var command = {
            "livreur_id": "",
            "client_id": "",
            "etat_commande": "",
            "date_commande": ""
        };
        var requestPizzas = [];
        vm.commandPizza = function() {
            var date = new Date();
            /*
             * Set date + state command
             */
            command.date_commande = date.toISOString();
            command.etat_commande = "En cours";
            /*
             * Post new client
             */
            cliService.postClient(vm.clients).then(function(resultClient) {
                command.client_id = resultClient.data.id;
                /*
                 * Get all free "livreurs"
                 */
                livService.getAllLivreurs({
                    params: {
                        "disponibilite": true
                    }
                }).then(function(resultLivreur) {
                    command.livreur_id = resultLivreur.data[0].id;
                    /*
                     * Post new command
                     */
                    cmdService.postCommand(command).then(function(resultCommand) {
                        /*
                         * Create our command pizza object and promise
                         */
                        for (var id in vm.command_pizza.pizza) {
                            var command_pizza = {
                                "command_id" : resultCommand.data.id,
                                "pizza_id": id,
                                "quantite": vm.command_pizza.pizza[id].quantite,
                                "heure_commande": command.date_commande
                            };
                            requestPizzas.push(cmdPizzService.postCommandPizza(command_pizza));
                        }
                        /*
                         * Promise with all command pizza
                         */
                        $q.all(requestPizzas).then(function() {
                            /*
                             * Update our "livreur"
                             */
                            livService.updateOne(command.livreur_id, {disponibilite: false});
                        });
                    });
                });
            });
        };
    };

    module.exports = controller;
}());
