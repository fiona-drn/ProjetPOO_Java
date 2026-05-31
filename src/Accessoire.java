public class Accessoire extends Produit {
    public String nom;
    public double prix;
    public Magasin mag;
    public int stock;

    public Accessoire(String nomAcc, double prixAcc, Magasin magasin, Achat ach, int s) {
    	super(ach);
        nom = nomAcc;
        prix = prixAcc;
        mag = magasin;
        stock = s;
    }

   //si cherche acc x donner le stock, prix et nom
   public void afficherAcc(String nomAcc) {
       if (this.nom.equals(nomAcc)) {
           System.out.println("Accessoire : " + nomAcc + ", Prix : " + prix + "€ , Stock : " + stock);
       } else {
           System.out.println("Accessoire " + nomAcc + " non trouvé.");
       }
   }

   //restock d'un acc x
    public void restockAcc(String nomA, int nb) {
    if (this.nom.equals(nomA)) {
        stock += nb;
        }
    }

    // Convertit en string pour l'affichage de l'interface (VueListeAccessoires)
    public String toString() {
        return "Accessoire : " + nom + " | Prix : " + prix + "€  | Stock : " + stock;
    }
}
