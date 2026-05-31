import java.time.LocalDate;
import java.util.*;

public class Magasin {
    public String nom;
    public String adresse;
    public String telephone;
    
    public Vector<Instrument> list_instru=new Vector<Instrument>();
    public Vector<Accessoire> list_acc=new Vector<Accessoire>();
    public Vector<Client> list_clients=new Vector<Client>();
    public Vector<Reparation> list_reparation=new Vector<Reparation>();

    private Client clientTechnique;

    private int comptId = 0; 



    public Magasin(String nomMagasin, String adr, String tel) {
        nom = nomMagasin;
        adresse = adr;
        telephone = tel;

        clientTechnique = new Client(0, "Try", this);
    }

    public void initClients() {
    // Quelques clients de test (les ajoutes dans le magasin)
    new Client(101, "Maaya", this);
    new Client(102, "Fiona", this);
    new Client(103, "Mr Melliti", this);

    
}


    public void ajoutInstru (Instrument instru){
        list_instru.add(instru);
    }

    // pour ajout un instru manuellement nous même
    public void ajouterInstrument(Instrument instru) {
        ajoutInstru(instru);
    }

    public void ajoutAcc (Accessoire acc){
        list_acc.add(acc); 
    }

    // pour ajout un accessoire manuellement nous même
    public void ajouterAccessoire(Accessoire acc) {
        ajoutAcc(acc);
    }

    public void ajoutClient (Client client){
        list_clients.add(client);
    }
    public void ajoutReparation (Reparation reparation){
        list_reparation.add(reparation);
    }


    //liste des accessoires + leurs prix + mag + achat + stock
    public void EnsembleAcc(){
        LocalDate date = LocalDate.now();
        Achat ach = new Achat(clientTechnique, 0, date); //quantite et client et date

        //crée obj puis ajoute dans liste acc (et produits)
        Accessoire acc1 = new Accessoire("Cahier de portée musicale", 6.95, this, ach, 10);
        ajoutAcc(acc1);
        Accessoire acc2 = new Accessoire("Livre : La guitare en autodidacte", 20, this, ach, 10);
        ajoutAcc(acc2);
        Accessoire acc3 = new Accessoire("Livre : La guitare pour les gauchers", 15, this, ach, 15);
        ajoutAcc(acc3);
        Accessoire acc4 = new Accessoire("Livre : Tous en rythme", 20.02, this, ach, 25);
        ajoutAcc(acc4);
        Accessoire acc5 = new Accessoire("Livre avec CD: Et si nous chantions", 25.0, this, ach, 21);
        ajoutAcc(acc5);
        Accessoire acc6 = new Accessoire("Livre en braille + CD : 101 partitions en clé de Sol", 36.0, this, ach, 32);
        ajoutAcc(acc6);
        Accessoire acc7 = new Accessoire("Livre + CD : Tire Pousse", 25.25, this, ach, 15);
        ajoutAcc(acc7);

        Accessoire acc8 = new Accessoire("Accordeur", 18.99, this, ach, 30);
        ajoutAcc(acc8);
        Accessoire acc9 = new Accessoire("Pupitre", 28.98, this, ach, 30);
        ajoutAcc(acc9);
        Accessoire acc10 = new Accessoire("Métronome", 18.25, this, ach, 25);
        ajoutAcc(acc10);
        Accessoire acc11 = new Accessoire("Sourdine", 100, this, ach, 10);
        ajoutAcc(acc11);
        Accessoire acc12 = new Accessoire("Lot de 5 médiators", 6.90, this, ach, 10);
        ajoutAcc(acc12);
        Accessoire acc13 = new Accessoire("Capodastre", 11, this, ach, 5);
        ajoutAcc(acc13);
        Accessoire acc14 = new Accessoire("Colophane", 12.30, this, ach, 10);
        ajoutAcc(acc14);
        Accessoire acc15 = new Accessoire("Archet 1/4", 33, this, ach, 5);
        ajoutAcc(acc15);
        Accessoire acc16 = new Accessoire("Archet 2/4", 33, this, ach, 5);
        ajoutAcc(acc16);
        Accessoire acc17 = new Accessoire("Archet 3/4", 33, this, ach, 5);
        ajoutAcc(acc17);
        Accessoire acc18 = new Accessoire("Archet 4/4", 33, this, ach, 10);
        ajoutAcc(acc18);
        Accessoire acc19 = new Accessoire("Cordes", 53.56, this, ach, 10);
        ajoutAcc(acc19);
        Accessoire acc20 = new Accessoire("Carillon", 48.91, this, ach, 15);
        ajoutAcc(acc20);
    }

    //INSTRUMENTS

    //prix des instru
    //nom, prix, état, taille, mag, achat, id
    public void AjoutInstruEnum(String nom, double prix, String qualite, EnumSize t, int stock){
        LocalDate date = LocalDate.now();
        Achat ach = new Achat(clientTechnique, 0, date); // quantite et client et date

        for (int i = 0; i < stock; i++){
            Instrument inst = new Instrument(nom, prix, qualite, new Taille(t), this, ach, comptId++, 1); // Id censé être unique, stock ini 1
            inst.InstruCatego(nom);
            ajoutInstru(inst);
        }
    }

    public void AjoutInstruNum(String nom, double prix, String qualite, int tNum, int stock){
        LocalDate date = LocalDate.now();
        Achat ach = new Achat(clientTechnique, 0, date); // quantite et client et date

        for (int i = 0; i < stock; i++){
            Instrument inst = new Instrument(nom, prix, qualite, new Taille(tNum), this, ach, comptId++, 1); // Id censé être unique, stock ini 1
            inst.InstruCatego(nom);
            ajoutInstru(inst);
        }
    }

    public void IniInstru(){
        AjoutInstruEnum("Violon", 1000.0, "Parfait", EnumSize.quatre_quarts, 10);
        AjoutInstruEnum("Violon", 1000.0, "Parfait", EnumSize.trois_quarts, 10);
        AjoutInstruEnum("Violon", 1000.0, "Parfait", EnumSize.deux_quarts, 10);
        AjoutInstruEnum("Violon", 1000.0, "Parfait", EnumSize.un_quart, 10);

        AjoutInstruEnum("Alto", 1000.0, "Parfait", EnumSize.quatre_quarts, 10);
        AjoutInstruEnum("Alto", 1000.0, "Parfait", EnumSize.trois_quarts, 10);
        AjoutInstruEnum("Alto", 1000.0, "Parfait", EnumSize.deux_quarts, 10);
        AjoutInstruEnum("Alto", 1000.0, "Parfait", EnumSize.un_quart, 10);

        AjoutInstruEnum("Contrebasse", 1200.0, "Parfait", EnumSize.quatre_quarts, 10);
        AjoutInstruEnum("Contrebasse", 1200.0, "Parfait", EnumSize.trois_quarts, 10);
        AjoutInstruEnum("Contrebasse", 1200.0, "Parfait", EnumSize.deux_quarts, 10);
        AjoutInstruEnum("Contrebasse", 1200.0, "Parfait", EnumSize.un_quart, 10);

        AjoutInstruEnum("Violoncelle", 1300.0, "Parfait", EnumSize.quatre_quarts, 10);
        AjoutInstruEnum("Violoncelle", 1300.0, "Parfait", EnumSize.trois_quarts, 10);
        AjoutInstruEnum("Violoncelle", 1300.0, "Parfait", EnumSize.deux_quarts, 10);
        AjoutInstruEnum("Violoncelle", 1300.0, "Parfait", EnumSize.un_quart, 10);
        
        AjoutInstruEnum("Guitare", 536.0, "Parfait", EnumSize.quatre_quarts, 10);
        AjoutInstruEnum("Guitare", 536.0, "Parfait", EnumSize.trois_quarts, 10);
        AjoutInstruEnum("Guitare", 536.0, "Parfait", EnumSize.deux_quarts, 10);
        AjoutInstruEnum("Guitare", 536.0, "Parfait", EnumSize.un_quart, 10);

        AjoutInstruEnum("Basse", 400.0, "Parfait", EnumSize.quatre_quarts, 10);
        AjoutInstruEnum("Basse", 400.0, "Parfait", EnumSize.trois_quarts, 10);
        AjoutInstruEnum("Basse", 400.0, "Parfait", EnumSize.deux_quarts, 10);
        AjoutInstruEnum("Basse", 400.0, "Parfait", EnumSize.un_quart, 10);

        AjoutInstruEnum("Ukulele", 150.0, "Parfait", EnumSize.quatre_quarts, 5);
        AjoutInstruEnum("Ukulele", 150.0, "Parfait", EnumSize.trois_quarts, 5);
        AjoutInstruEnum("Ukulele", 150.0, "Parfait", EnumSize.deux_quarts, 5);
        AjoutInstruEnum("Ukulele", 150.0, "Parfait", EnumSize.un_quart, 5);
        
        AjoutInstruEnum("Harpe", 2500.0, "Parfait", EnumSize.quatre_quarts, 5);
        AjoutInstruEnum("Harpe", 2500.0, "Parfait", EnumSize.trois_quarts, 5);
        AjoutInstruEnum("Harpe", 2500.0, "Parfait", EnumSize.deux_quarts, 5);
        AjoutInstruEnum("Harpe", 2500.0, "Parfait", EnumSize.un_quart, 5);

        //taille unique - vents
        AjoutInstruEnum("Tuba", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Trombonne", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Flute", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Clarinette", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Saxophone", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Hautbois", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Basson", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Trompette", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Cor", 800.0, "Parfait", EnumSize.aucun, 10);

        //taille unique - percu
        AjoutInstruEnum("Batterie", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Cymbales", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Timbales", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Xylophone", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Marimba", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Djembé", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Grosse Caisse", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Caisse claire", 800.0, "Parfait", EnumSize.aucun, 10);
        AjoutInstruEnum("Triangle", 800.0, "Parfait", EnumSize.aucun, 10);
        
        //taille num - percu 
        AjoutInstruNum("Piano", 600, "Parfait", 25, 10);
        AjoutInstruNum("Orgue", 600, "Parfait", 25, 10);

        //taille enum -anciens 
        AjoutInstruEnum("Luth", 800.0, "Parfait", EnumSize.aucun, 10);

        //taille unique-anciens
        AjoutInstruEnum("Tabla", 800.0, "Parfait", EnumSize.aucun, 10);

        //taille num - anciens
        AjoutInstruNum("Clavecin", 600, "Parfait", 25, 10);
    }

    //trouver un instru selon son id (tous different car qualite peut changer)
    public Instrument trouverInstruId (int id){
        for (int i =0; i<list_instru.size(); i++){
            Instrument inst = list_instru.get(i);
            if(inst.identifiant == id){
                System.out.println("Voici les infos sur cet instrument :" + inst);
                return inst;
            }
        }
        System.out.println("On n'a pas cet instrument");
        return null;
    }

    //trouver un instrument par son nom
    public Instrument trouverInstruNom(String nomInstru) {
        for (int i = 0; i < list_instru.size(); i++) {
            Instrument inst = list_instru.get(i);
            if (inst.nom.equals(nomInstru)) {
                System.out.println("Voici les infos sur cet instrument :" + inst);
                return inst;
            }
        }
        System.out.println("On n'a pas cet instrument");
        return null;
    }

    //CLIENTS
    //trouver un client par son numéro
    public Client rechercherClientParId(int numClient) {
        for (int i = 0; i < list_clients.size(); i++) {
            if (list_clients.get(i).num_client == numClient) {
                return list_clients.get(i);
            }
        }
        return null;
    }
    
    //trouver un client par son nom
    public Client rechercheClientParNom(String nomClient) {
        for (int i = 0; i < list_clients.size(); i++) {
            if (list_clients.get(i).nom.equals(nomClient)) {
                return list_clients.get(i);
            }
        }
        return null;
    }

    //ajouter un client
    public void addClient(int numClient, String nom) {
        new Client(numClient, nom, this); //this ref à magasin
    }

    //supprimer un client s'il existait déjà
    public void supprimerClient(int numClient) {
        Client client = rechercherClientParId(numClient);
        if (client != null) {
            list_clients.remove(client);
            System.out.println("Client #" + numClient + " supprimé.");
        } else {
            System.out.println("Client #" + numClient + " non trouvé.");
        }
    }

    //afficher liste des clients avec le nombre tout en bas
    public void affClients(){
        for (int i=0; i<list_clients.size(); i++){
            list_clients.get(i).afficher();
        }
        System.out.println("Nombre total de clients : " + list_clients.size()); 
    }

    //afficher les familles 
    public void afficherFam(){
        System.out.println("Les familles d'instruments sont :");
        for(Famille f : Famille.values()){
            System.out.println("- " + f);
        }
    }


    //ACHATS

    //ajouter un instru dans listeachat
    public void addInstruCom(Achat achat, Instrument instru) {
        if (instru.stock <= 0) {
            System.out.println("Instrument indisponible pour l'achat : " + instru.nom);
        }else{
            achat.ajoutInstru(instru);
            instru.stock--;
        }
    }

    //affiche toutes les commandes confondues
    public void AffAllAchats(Achat achat) { 
        System.out.println("Produits dans l'achat :");
        for (Instrument instru : achat.list_instru) {
            System.out.println("- " + instru.nom);
        }
    }

    //afficher l'achat du client w
    public void affAchats(Client client) {
        System.out.println("Achats du client " + client.nom + " (" + client.num_client + "):");
        for (Achat achat : client.list_achat) {
            achat.afficherAchat(client.num_client); //d'un client spécifique
        }
    }

    
    //REPARATIONS

    //afficher les réparations en cours
    public void affRepar() {
        System.out.println("Réparations en cours :");
        for (Reparation reparation : list_reparation) {
            System.out.println("- Ticket " + reparation.ticket + " : " + reparation.type);
        }
    }

    //ajouter un instru dans liste répar
    public void addInstruRepar(Reparation reparation, Instrument instru) {
        reparation.ajoutInstru(instru);
    }

    //retirer une reparation si date passée
    public void retireRepar(Reparation reparation) {
        list_reparation.remove(reparation);
        System.out.println("Réparation retirée.");
    }

    //afficher les réparations d'un client w
    public void afficherReparationsClient(Client client) {
        client.afficherReparations(client.num_client);
    }


    //LOCATIONS

    //afficher les locations en cours (non rendus)
    public void affLoca() {
        System.out.println("Locations en cours :");
        for (Client client : list_clients) {
            for (Location location : client.list_location) {
                if (location.date_retour_rendue == null) {
                    System.out.println("- Client " + client.nom + " : " + location.date_location + " au " + location.date_retour_prevue);
                }
            }
        }
    }

    //ajouter un instru dans liste location
    public void addInstruLoc(Location location, Instrument instru) {
        if (instru.stock <= 0) {
            System.out.println("Instrument indisponible pour la location : " + instru.nom);
        }else{
        location.ajoutInstru(instru);
        instru.stock--;
        }
    }

    //retirer une location rendue;si date passée et pas rendue +50€; mettre à jour l'état de l'instru
    public void retireLocaRendue(Location location) {
        location.date_retour_rendue = LocalDate.now();
        double penalite = location.calcPenalite();

        if (penalite > 0) {
            System.out.println("Pénalité de " + penalite + "€ pour retard.");
        }
        for (Instrument instru : location.list_instru) {
            instru.ChgtEtat(location.etat_retour);
            instru.stock++; // remettre le stock à disposition
        }
        // pour le CA on garde loca en historique
    }

    //afficher les locations d'un client w
    public void afficherLocClient(int numClient) {
        Client client = rechercherClientParId(numClient);
        if (client != null) {
            client.afficherLocations(numClient);
        } else {
            System.out.println("Client non trouvé.");
        }
    }
    
    
    //CHIFFRE D'AFFAIRE & VENTES

    //afficher achat du client w
    public void affAchatClient(Client client) {
        client.afficherAchats(client.num_client);
    }

    //calc le revenu total 
    public double Revenu() {
        double revenu = 0;
        for (Client client : list_clients) {
            revenu += client.Total();
        }
        return revenu;
    }

    // chiffre d'affaire période (si le total depuis créeation du mag -> date création mag)
    public void ChiffreAffaire(LocalDate debut, LocalDate fin) {
        double chiffre = 0;
        for (Client client : list_clients) {
            chiffre += client.TotalPeriode(debut, fin);
        }
        System.out.println("Chiffre d'affaire du " + debut + " au " + fin + " : " + chiffre + "€");
    }

    // calculer le montant total des achats
    public double montantAchat(LocalDate debut, LocalDate fin) {
        double total = 0;
        for (Client client : list_clients) {
            total += client.montantAchatsPeriode(debut, fin);
        }
        return total;
    }

    // calculer le montant total des locations
    public double montantLoca(LocalDate debut, LocalDate fin) {
        double total = 0;
        for (Client client : list_clients) {
            total += client.montantLocPeriode(debut, fin);
        }
        return total;
    }

    //calculer le montant total des réparations
    public double montantRepar(LocalDate debut, LocalDate fin) {
        double total = 0;
        for (Client client : list_clients) { //si pas réparation = +0
            total += client.montantRepaPeriode(debut, fin);
        }
        return total;
    }
    
    //STOCK
    //afficher le stock par instru et si 0 quand reçoit?
    public void affStockInstru(Instrument instru) {
        if (instru.stock > 0) {
            System.out.println("- " + instru.nom + " : stock " + instru.stock);
        } else {
            System.out.println("- " + instru.nom + " : stock épuisé.");
        }
    }
    

    //afficher le stock par acc; si 0 quand reçoit ?
    public void afficherStockAccessoires(Accessoire nomAcc) {
        if (nomAcc.stock == 0) {
            System.out.println("  Stock épuisé, recevoir bientôt.");
        }else{
            System.out.println("- " + nomAcc.nom + " : stock " + nomAcc.stock);  
        }
    }

    //si stock est refait mettre à jour pour acc
    public void RestockageAcc(Accessoire acc, int nouveauStock) {
        acc.stock = nouveauStock;
        System.out.println("Stock mis à jour pour " + acc.nom + " : " + nouveauStock);
    }

    //si stock est refait mettre à jour pour acc
    public void RestockageInstru(Instrument instru, int nouveauStock) {
        instru.stock = nouveauStock;
        System.out.println("Stock mis à jour pour " + instru.nom + " : " + nouveauStock);
    }

    
    //afficher les clients
    public void afficherClients(){
        for (int i=0; i<list_clients.size(); i++){
            list_clients.get(i).afficher();
        }
    }

    // Générer un numéro de réparation unique
        
    private int compteurRepar = 2006;

    public int genererNumeroReparation() {
    return compteurRepar++;
}

}
