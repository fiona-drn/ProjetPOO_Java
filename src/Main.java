import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin("Mayona Sonora", "2 boulevard de la sonorité", "01 17 42 58 96");
        
        // Initialisation des instrus et des accessoires dans le magasin

        magasin.IniInstru();
        magasin.EnsembleAcc();


        Client client1 = new Client(1, "Orphée", magasin);
        
        Client client2 = new Client(2, "Oedipe", magasin);
        
        Client client3 = new Client(3, "Méduse", magasin);

        Taille taille1 = new Taille(EnumSize.un_quart);
        Taille taille2 = new Taille(88);

        Achat achat1 = new Achat(client1, 1, LocalDate.of(2026, 12, 20));
        Achat achat2 = new Achat(client2, 1, LocalDate.of(2026, 12, 21));
        Achat achat3 = new Achat(client3, 2, LocalDate.of(2026, 12, 22));
    
        LocalDate debut = LocalDate.of(2026, 12, 1);
        LocalDate fin = LocalDate.of(2026, 12, 31);
        //nom, prix, qualité, taille, magasin, achat, stock, id
        Instrument instrument1 = new Instrument("Lyre", 500, "Parfait état", taille1, magasin, achat1, 1, 1);
        magasin.ajoutInstru(instrument1);
        instrument1.ajoutFam(Famille.Anciens);
        achat1.ajoutInstru(instrument1);
        client1.ajoutAchat(achat1);

        Instrument instrument2 = new Instrument("Piano", 2000, "Bon état", taille2, magasin, achat2, 2, 1);
        magasin.ajoutInstru(instrument2);
        instrument2.ajoutFam(Famille.Percussions);
        
        //nom, prix, magasin, achat, stock
        Accessoire acc = new Accessoire("Médiator", 10, magasin, achat3, 3);
        magasin.ajoutAcc(acc);
        achat3.ajoutAcc(acc);
        client3.ajoutAchat(achat3);

        Reparation rep = new Reparation(20, "Changement de cordes", magasin, client1, 1, LocalDate.of(2026, 12, 20));
        rep.ajoutInstru(instrument1);
        client1.ajoutReparation(rep);
        magasin.ajoutReparation(rep);

        LocalDate entree = LocalDate.of(2026, 12, 20);
        LocalDate sortiePrevue = LocalDate.of(2026, 12, 21);
        
        Location location1 = new Location(entree, sortiePrevue, null, "Parfait", "Abîmé", client3);
        location1.ajoutInstru(instrument2);
        client3.ajoutLocation(location1);

        System.out.println("Le magasin " + magasin.nom + " situé à " + magasin.adresse + " avec le numéro de téléphone " + magasin.telephone);

        System.out.println("\nListe des clients enregistrés :");
        magasin.affClients();

        System.out.println("\nInformations sur le client 1 :");
        client1.afficher();

        magasin.addClient(4, "Isis");
        System.out.println("\nAprès ajout d'un client :");
        magasin.affClients();

        magasin.supprimerClient(5);
        magasin.supprimerClient(4);
        System.out.println("\nAprès suppression :");
        magasin.affClients();

        System.out.println("\nStocks des instruments :");
        magasin.affStockInstru(instrument1);
        magasin.affStockInstru(instrument2);

        System.out.println("\nStocks des accessoires :");
        magasin.afficherStockAccessoires(acc);

        magasin.afficherFam();

        System.out.println("\nLocations en cours :");
        magasin.affLoca();

        System.out.println("\nRéparations en cours :");
        magasin.affRepar();

        System.out.println("\nRevenu total du magasin : " + magasin.Revenu() + "€");
        magasin.ChiffreAffaire(debut, fin);

        System.out.println("\nDétail du chiffre d\'affaires :");
        System.out.println("- Achats : " + magasin.montantAchat(debut, fin) + "€");
        System.out.println("- Locations : " + magasin.montantLoca(debut, fin) + "€");
        System.out.println("- Réparations : " + magasin.montantRepar(debut, fin) + "€");

        System.out.println("\nAchats du client 1 :");
        magasin.affAchatClient(client1);

        System.out.println("\nLocations du client 3 :");
        magasin.afficherLocClient(client3.num_client);

        System.out.println("\nRéparations du client 1 :");
        magasin.afficherReparationsClient(client1);

        System.out.println("\nAchats du client 1 :");
        magasin.affAchats(client1);

        System.out.println("\nCréation d'un achat pour le client 1 :");
        Achat c = new Achat(client1, 1, LocalDate.now());
        magasin.addInstruCom(c, instrument1);
        client1.list_achat.add(c);
        magasin.AffAllAchats(c);

        System.out.println("\nLocation rendue pour le client 3 :");
        location1.date_retour_rendue = sortiePrevue.plusDays(3);
        magasin.retireLocaRendue(location1);
        System.out.println("Stock de " + instrument2.nom + " après retour : " + instrument2.stock);


        // Tester restockage
        magasin.RestockageInstru(instrument1, 5);
        magasin.RestockageAcc(acc, 20);
        System.out.println("Après restockage, stock de " + instrument1.nom + " : " + instrument1.stock);
        System.out.println("Après restockage, stock de " + acc.nom + " : " + acc.stock);

        //client 1 : achat lyre
        System.out.println("Le client " + client1.nom + " a acheté " + instrument1.nom + " de taille " + instrument1.taille.size + " à " + instrument1.prix + " euros ");
        
        //client 2 : achat piano et médiator
        System.out.println("Le client " + client2.nom + " a acheté " + instrument2.nom + " à " + instrument2.prix + " euros " + instrument2.taille.num + "et a acheté un médiator à " + acc.prix + " euros");

        //client 3 : médiator et location
        System.out.println("Le client " + client3.nom + " a acheté " + acc.nom + " à " + acc.prix + " euros" + " et a loué un instrument le " + location1.date_location + " l'a rendu le " + location1.date_retour_rendue + " il est passé de " + location1.etat_depart + " à " + location1.etat_retour);

        //client 1 : réparation
        System.out.println("Le client " + client1.nom + " a fait réparer un instrument pour " + rep.type + " à " + rep.tarifs + " euros.");


        //affichage des clients
        System.out.println("\nListe des clients enregistrés :");
        magasin.affClients();

        //afficher info d'un client
        client1.afficher();

        //location rendue : client 3 a rendu un instrument loué + prix
        location1.date_retour_rendue = sortiePrevue.plusDays(3);
        System.out.println("Le client " + client3.nom + " a rendu l'instrument loué le " + location1.date_retour_rendue + "et a payé " + magasin.montantLoca(debut, fin) + " euros pour la location.");
        magasin.retireLocaRendue(location1);
        System.out.println("\nAprès retour de location, stock de " + instrument2.nom + " : " + instrument2.stock);

        //// INTEGRATION DES VUES
        VueMagasin vueMag = new VueMagasin(magasin);
        vueMag.show();
        vueMag.pack();
    }
}
