import java.time.LocalDate;
import java.util.*;

public class Achat {
    public Client client;
    public int quantite;
    public LocalDate date_achat;
    public Vector<Instrument> list_instru = new Vector<Instrument>();
    public Vector<Accessoire> list_acc = new Vector<Accessoire>();
    public Vector<Produit> list_produits = new Vector<Produit>();
    
   
    public Achat(Client cli, int q, LocalDate d) {
        client = cli;
        quantite = q;
        date_achat = d;
    }

    //ajoute produit dans liste produit et dans liste correspondante

    //private car use que intérieure classe Achat
    private void ajouterProduit(Produit produit) {
        if (produit != null && !list_produits.contains(produit)) {
            list_produits.add(produit);
        }
    }
    
    public void ajoutInstru(Instrument instru) {
        if (instru != null) {
            list_instru.add(instru);
            ajouterProduit(instru);
        }
    }

    public void ajoutAcc(Accessoire acc) {
        if (acc != null) {
            list_acc.add(acc);
            ajouterProduit(acc);
        }
    }


    // Montant total achat : somme_produits * quantité
    public double montant() {
        double total = 0;
        for (Produit p : list_produits) { 
            if (p instanceof Instrument) {
                total += ((Instrument) p).prix;
            } else if (p instanceof Accessoire) {
                total += ((Accessoire) p).prix;
            }
        }
        return total * quantite;
    }

    //afficher la commande (client, date, quantité, produits) - affiche la commande elle-m
    public void afficherAchat(int numClient) {
        System.out.println("Commande du client : " + client.nom + " (" + numClient + ")");
        System.out.println("Date de commande : " + date_achat);
        System.out.println("Quantité : " + quantite);
        System.out.println("Instruments dans la commande :");
        for (Instrument instru : list_instru) {
            System.out.println("- " + instru.nom + " prix : " + instru.prix + "€");
        }
    }
}

