import java.util.*;

public class Instrument extends Produit {
    public String nom;
    public double prix;
    public String qualite;
    public Taille taille;
    public int stock;
    public int identifiant; //chaque instru unique - surtout pour état

    public Location location;
    public Reparation reparation;
    public Achat achat;
    public Magasin mag;

    public Vector<Famille> list_fam=new Vector<Famille>();
    

    public Instrument(String nomInstru, double prixInstru, String qualiteInstru, Taille tailleInstru, Magasin magasin, Achat ach, int id, int stk) {
        super(ach);
        nom = nomInstru;
        prix = prixInstru;
        qualite = qualiteInstru;
        taille = tailleInstru;
        mag = magasin;
        identifiant = id;
        stock = stk;
    }
    
    public void ajoutFam (Famille famille){
        list_fam.add(famille);
    }

    //méthodes

    //changer une qualité ex après une location
    public void ChgtEtat (String etat){
        qualite = etat;
    }

    //mettre x instru dans y categorie (si c'est un violon alors cordes...)
    public void InstruCatego(String categorie) {
        String lower = nom.toLowerCase();
        // Cordes
        if (lower.equals("violoncelle") || lower.equals("contrebasse") || lower.equals("alto") || lower.equals("violon") || lower.equals("guitare") || lower.equals("harpe") || lower.equals("ukulele") || lower.equals("basse")) {
            list_fam.add(Famille.Cordes);
        }
        // Vents / cuivres
        if (lower.equals("flute") || lower.equals("clarinette") || lower.equals("saxophone") || lower.equals("hautbois") || lower.equals("basson") || lower.equals("trompette") || lower.equals("trombone") || lower.equals("cor") || lower.equals("tuba")) {
            list_fam.add(Famille.Vents);
        }
        // Percussions
        if (lower.equals("batterie") || lower.equals("cymbales") || lower.equals("timbales") || lower.equals("marimba") || lower.equals("xylophone") || lower.equals("djembé") || lower.equals("caisse claire") || lower.equals("grosse caisse") || lower.equals("triangle") || lower.equals("piano") || lower.equals("orgue")) {
            list_fam.add(Famille.Percussions);
        }
        // Anciens / instruments historiques
        if (lower.equals("luth") || lower.equals("viole de gambe") || lower.equals("mandoline") || lower.equals("clavecin") || lower.equals("lyre") || lower.equals("psaltérion") || lower.equals("balafon") || lower.equals("bendir") || lower.equals("gong") || lower.equals("guzheng") || lower.equals("vina") || lower.equals("tabla")) {
            list_fam.add(Famille.Anciens);
        }
    }

    // Convertir en String pour l'affichage de l'interface (VueListeInstruments)
    @Override
    public String toString() {
    return nom + " | " + qualite + " | Taille: " + taille.size + " | " + prix + "€" + " | Stock: " + stock + " | ID: " + identifiant;
}

}

