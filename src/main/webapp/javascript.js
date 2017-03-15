var serveurUrl = "http://localhost:8080/StarWars_Capitalist/";
            var currentWorld;
            var bar = [];
            $(document).ready(function () {

            // Récupération du monde de l'utilisateur
            $.getJSON(serveurUrl + "webresources/generic/world", function (world) {
            currentWorld = world;
            $("#monde img").html('<img src="' + serveurUrl + currentWorld.logo + '"/>');
            $("#monde h2").html(currentWorld.name);
            $("#argent h1").html(currentWorld.money + " CR");
            //Pour chaque produit//
            $.each(world.products.product, function (index, product) {
            var produit = $(".template").clone();
            produit.removeClass("template");
            produit.attr("class", "product");
            produit.attr("id", "p" + (index + 1));
            if (product.id < 5) {
            produit.attr("style", "width:50%;float:left");
            } else {
            produit.attr("style", "width:50%;float:right");
            }
            produit.find(".nom p").html(product.name);
            produit.find(".roundedImage").html('<img style="width:100%;height:100%" src="' + serveurUrl + product.logo + '"/>');
            produit.find(".quantite").html(product.quantite);
            produit.find(".revenu").html(product.revenu);
            produit.find(".timeleft").html(product.timeleft);
            //Click sur l'image de produit
            $(".roundedImage").click(function (event) {
            var id = $(this).parents(".product").attr("id").substr(1) - 1;
            var product = currentWorld.products.product[id];
            });
            
            var vd=$("#light").ProgressBarWars({porcentaje:20,estilo:"vader"});
            produit.appendTo("#liste");
            });
            });
            
            //Animation de la barre de progession
            
            
            //Fonction calcul de score
            
            });