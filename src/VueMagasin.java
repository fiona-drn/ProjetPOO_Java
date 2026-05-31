import java.awt.*;
import javax.swing.*;

public class VueMagasin extends JFrame {

    JMenu menu1 = new JMenu("Produits");
	JMenu menu2 = new JMenu("Réparation");
    JMenu menu3 = new JMenu("Gestion du magasin");
    JMenuBar menubar;
	JMenuItem el1 = new JMenuItem("Instruments");
	JMenuItem el2 = new JMenuItem("Accessoires");
    JMenuItem el3 = new JMenuItem("Réparer un instrument");
    JMenuItem el4 = new JMenuItem("Connexion gérant");
    JLabel affnom;
    JLabel affadr;
    JLabel afftel;
    
    CardLayout cards;
    JPanel panelCentral;

    Magasin mag;
    VueListeInstruments vueListeInstr;
    VueListeAccessoires vueListeAcc;
    VueInstrument vueInstr;
    VueAccessoire vueAcc;
    VueGestionMagasin vueGestion;
    VueAccueilGerant vueGerant;
    VueAchatInstr vueAchInstr;
    VueAchatAcc vueAchAcc;
    VueReparation vueRepa;
    VueAjoutClient vueAjoutCli;
    VueListeClients vueListeCli;
    VueAjoutInstrument vueAjoutInstr;
    VueAjoutAccessoire vueAjoutAcc;

    public VueMagasin(Magasin m) {
        mag = m;

        // MENU
        menubar = new JMenuBar();

        menubar.setBackground(new Color(255, 228, 196)); // fond en beige

        menu1.add(el1);
		menu1.add(el2);
        menu2.add(el3);
        menubar.add(menu1);
		menubar.add(menu2);

        menubar.add(Box.createHorizontalGlue()); // pour pousser le menu3 à droite
        menubar.add(menu3);
        menu3.add(el4);

        this.setJMenuBar(menubar);

        this.setTitle(mag.nom);

        // CARDLAYOUT

        cards = new CardLayout();
        panelCentral = new JPanel(cards);

        // AJOUT DES PANELS AU CARDLAYOUT
        panelCentral.add(creerAccueil(), "accueil");

        vueListeInstr = new VueListeInstruments(mag);
        panelCentral.add(vueListeInstr, "listeInstru");

        vueListeAcc = new VueListeAccessoires(mag);
        panelCentral.add(vueListeAcc, "accessoires");

        // Réparation
        vueRepa = new VueReparation(mag);
        panelCentral.add(vueRepa, "vueRepar");

        vueGestion = new VueGestionMagasin(mag);
        panelCentral.add(vueGestion, "gestion");

        vueGerant = new VueAccueilGerant();
        panelCentral.add(vueGerant, "accueilGerant");

        // Vues pour la gestion (ajout/suppression clients, ajout produits, listes)
        vueAjoutCli = new VueAjoutClient(mag);
        panelCentral.add(vueAjoutCli, "ajoutClient");

        vueListeCli = new VueListeClients(mag);
        panelCentral.add(vueListeCli, "listeClients");

        vueAjoutInstr = new VueAjoutInstrument(mag);
        panelCentral.add(vueAjoutInstr, "ajoutInstru");

        vueAjoutAcc = new VueAjoutAccessoire(mag);
        panelCentral.add(vueAjoutAcc, "ajoutAccessoire");


        this.add(panelCentral);
        this.setSize(400, 300);
        this.setVisible(true);

        new ControleurMagasin(this, mag);

    }

    private JPanel creerAccueil() {
        JPanel accueil = new JPanel();
        accueil.setLayout(new BorderLayout());
        accueil.setBackground(new Color(235, 140, 45)); // fond en beige

        affnom = new JLabel("Bienvenue chez " + mag.nom);
        affnom.setHorizontalAlignment(SwingConstants.CENTER);
        affnom.setFont(new Font("Brush Script MT", Font.BOLD, 32)); //cursive, gras, taille 32
        affnom.setForeground(Color.black); // txt noir

        affadr = new JLabel("📍 " + mag.adresse);
        afftel = new JLabel("📞 " + mag.telephone);
        JPanel coord = new JPanel(new GridLayout(2,1));
        coord.add(affadr);
        coord.add(afftel);

        coord.setBackground(new Color(235, 140, 45)); // fond en beige
        affadr.setHorizontalAlignment(SwingConstants.LEFT);
        afftel.setHorizontalAlignment(SwingConstants.LEFT);
        affadr.setForeground(Color.black); // txt noir
        afftel.setForeground(Color.black); // txt noir

        accueil.add(affnom, BorderLayout.CENTER);
        accueil.add(coord, BorderLayout.SOUTH);

        return accueil;
    }
}
