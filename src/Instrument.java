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
        //si mets == alors compares les réferences, avec equales c'est les valeurs
        if (nom.equals("violloncelle") || nom.equals("contrebasse") || nom.equals("alto") || nom.equals("violon") || nom.equals("guitare") || nom.equals("harpe") || nom.equals("ukulele")|| nom.equals("basse")) {
            list_fam.add(Famille.Cordes);
        }
        if(nom.equals("flute") || nom.equals("clarinette") || nom.equals("saxophone") || nom.equals("hautbois") || nom.equals("basson") || nom.equals("trompette") || nom.equals("trombone") || nom.equals("cor") || nom.equals("tuba")) {
            list_fam.add(Famille.Vents);
        }
        if(nom.equals("batterie") || nom.equals("cymbales") || nom.equals("timbales") || nom.equals("marimba") || nom.equals("xylophone") || nom.equals("djembé") || nom.equals("caisse claire") || nom.equals("grosse caisse") || nom.equals("triangle") || nom.equals("piano") ||nom.equals("orgue")) {
            list_fam.add(Famille.Percussions);
        }
        if (nom.equals("luth") || nom.equals("viole de gambe") || nom.equals("mandoline") || nom.equals("clavecin") || nom.equals("lyre") || nom.equals("psaltérion") || nom.equals("balafon") || nom.equals("bendir") || nom.equals("gong") || nom.equals("guzheng") || nom.equals("vina") || nom.equals("tabla")){
            list_fam.add(Famille.Anciens);
        }
    }

    // Convertir en String pour l'affichage de l'interface (VueListeInstruments)
    @Override
    public String toString() {
    return nom + " | " + qualite + " | Taille: " + taille.size + " | " + prix + "€" + " | Stock: " + stock + " | ID: " + identifiant;
}

}

