import java.time.LocalDate;
import java.util.*;

public class Client {
	//attributs
	public String nom; 
	public Magasin mag;
	public int num_client;
	public Vector<Achat> list_achat=new Vector<Achat>();
    public Vector<Location> list_location=new Vector<Location>();
    public Vector<Reparation> list_reparation=new Vector<Reparation>();


    public Client(int numClient, String nomClient, Magasin magasin) { 
		num_client = numClient;
		nom = nomClient;
		mag = magasin;
		mag.ajoutClient(this);
    }
	
	public void ajoutAchat (Achat achat){
		list_achat.add(achat);
	}
	
	public void ajoutLocation (Location location){
		list_location.add(location);
	}
	public void ajoutReparation (Reparation reparation){
		list_reparation.add(reparation);
	}

	//afficher un client 
	public void afficher(){
		System.out.println("Client #" + num_client + " : " + nom);
	}


	//afficher achats
	public void afficherAchats(int numClient) {
		System.out.println("Achats du client " + nom + " (" + numClient + "):");
		for (Achat achat : list_achat) {
			System.out.println("- Achat de quantité : " + achat.quantite + " montant : " + achat.montant() + "€");
		}
		
	}

	//afficher locations du client w (avec infos : date, instru loués)
	public void afficherLocations(int numClient) {
		System.out.println("Locations du client " + nom + " (" + numClient + "):");
		for (Location location : list_location) {
			System.out.println("- Location du " + location.date_location + " au " + location.date_retour_prevue);
			for (Instrument instru : location.list_instru) {
				System.out.println("  - Instrument : " + instru.nom);
			}
		}
	}

	// afficher réparations du client
	public void afficherReparations(int numClient) {
		System.out.println("Réparations du client " + nom + " (" + numClient + "):");
		for (Reparation reparation : list_reparation) {
			System.out.println("- Réparation : " + reparation.type + " tarif : " + reparation.tarifs + "€");
			for (Instrument instru : reparation.list_instru) {
				System.out.println("  - Instrument : " + instru.nom);
			}
		}
	}
	
	// montant total des achats du client
	public double montantAchats() {
		double total = 0;
		for (Achat achat : list_achat) {
			total += achat.montant();
		}
		return total;
	}

	public double montantAchatsPeriode(LocalDate debut, LocalDate fin) {
		double total = 0;
		for (Achat achat : list_achat) {
			if (((achat.date_achat.isEqual(debut)) || (achat.date_achat.isAfter(debut))) &&
				(achat.date_achat.isEqual(fin) || achat.date_achat.isBefore(fin))) {
				total += achat.montant();
			}
		}
		return total;
	}

	// montant total des loc du client
	public double montantLoc() {
		double total = 0;
		for (Location location : list_location) {
			total += location.montantLocation();
		}
		return total;
	}

	public double montantLocPeriode(LocalDate debut, LocalDate fin) {
		double total = 0;
		for (Location location : list_location) {
			if ((location.date_location.isEqual(debut) || location.date_location.isAfter(debut)) &&
				(location.date_location.isEqual(fin) || location.date_location.isBefore(fin))) {
				total += location.montantLocation();
			}
		}
		return total;
	}

	// montant total des réparations du client
	public double montantReparations() {
		double total = 0;
		for (Reparation reparation : list_reparation) {
			total += reparation.tarifs;
		}
		return total;
	}

	public double montantRepaPeriode(LocalDate debut, LocalDate fin) {
		double total = 0;
		for (Reparation reparation : list_reparation) {
			if ((reparation.date_repa.isEqual(debut) || reparation.date_repa.isAfter(debut)) &&
				(reparation.date_repa.isEqual(fin) || reparation.date_repa.isBefore(fin))) {
				total += reparation.tarifs;
			}
		}
		return total;
	}

	// total du client : achats + locations + réparations
	public double Total() {
		return montantAchats() + montantLoc() + montantReparations();
	}

	// total du client pour une période 
	public double TotalPeriode(LocalDate debut, LocalDate fin) {
		return montantAchatsPeriode(debut, fin) + montantLocPeriode(debut, fin) + montantRepaPeriode(debut, fin);
	}

	// Convertit en string pour l'affichage de l'interface (VueListeAccessoires)
    public String toString() {
        return "Nom du client : " + nom + " | Identifiant : " + num_client;
    }
}

