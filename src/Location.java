import java.time.LocalDate;
import java.util.*;

public class Location {
    public LocalDate date_location;
    public LocalDate date_retour_prevue; //date donnée par mag
    public LocalDate date_retour_rendue; //date rendue par client
    public String etat_depart;
    public String etat_retour;
    public Client client;

    public Vector<Instrument> list_instru=new Vector<Instrument>();



    public Location(LocalDate dateLoc, LocalDate dateRet, LocalDate dateRen, String etatDep, String etatSort, Client cli) {
        date_location = dateLoc;
        date_retour_prevue = dateRet;
        date_retour_rendue = dateRen;
        etat_depart = etatDep;
        etat_retour = etatSort;
        client = cli;
    }

    public void ajoutInstru(Instrument instru){
        list_instru.add(instru);
    }

    //afficher les locs d'un client w
    public void afficherLocationsClient(int numClient) {
        System.out.println("Locations du client " + client.nom + " (" + numClient + "):");
        for (Instrument instru : list_instru) {
            System.out.println("- Instrument : " + instru.nom + " du " + date_location + " au " + date_retour_prevue);
        }
    }

    //prix d'une location -25% que prix initial de l'instru
    //+50€/jour de retard
    public double calculerPrixLocation() {
        if (list_instru == null){
            return 0;
        }
        double total = 0;
        for (Instrument instru : list_instru) {
            total += instru.prix * 0.25;
        }
        return total;
    }
    // Retard ->pénalité
    //si pas encore rendue : la date prevue < ajd -> retard sinon il a encore le t
    public double calcPenalite(){
        LocalDate rendue = date_retour_rendue;
        LocalDate prevue = date_retour_prevue;

        if(rendue!= null || prevue.isAfter(LocalDate.now())){
            return 0;
        }
        else{ //si compte nb de jours
            int nb_j = 0;
            while(prevue.isBefore(LocalDate.now())){
                nb_j++;
                prevue = prevue.plusDays(1);
            }
            return 50.0*nb_j;
        }
    }

    // Montant total location : pénalités comprises
    public double montantLocation() {
        return calculerPrixLocation() + calcPenalite();
    }
}
