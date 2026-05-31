import java.time.LocalDate;
import java.util.*;

public class Reparation {
    public double tarifs;
    public String type;
    public Magasin mag;
    public Client client;
    public int ticket;
    public LocalDate date_repa;
    
    public Vector<Instrument> list_instru=new Vector<Instrument>();


    public Reparation(double somme, String type, Magasin mag, Client cli, int t, LocalDate d) {
        tarifs = somme;
        this.type = type;
        this.mag = mag;
        client = cli;
        ticket = t;
        date_repa = d;
    }
    
    public void ajoutInstru (Instrument instru){
        list_instru.add(instru);
    }

    //afficher les réparations d'un client w
    public void afficherReparationsClient(int numClient) {
        System.out.println("Réparations du client " + client.nom + " (" + numClient + "):");
        for (Instrument instru : list_instru) {
            //nom instru, type répa, prix
            System.out.println("- Réparation de " + instru.nom + " : " + type + " tarif : " + tarifs + "€");
        }
    }
}
