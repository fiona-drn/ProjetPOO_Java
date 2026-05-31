import java.awt.*;
import javax.swing.*;


public class VueInstrument extends JPanel {

    JLabel titre;
    JButton btnRetour;
    JButton btnAcheter;
    Instrument instr;
    
    public VueInstrument(Instrument i) {
        instr = i;

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(235, 140, 45));

        // Titre
        titre = new JLabel("Fiche instrument : " + instr.nom);
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        titre.setFont(new Font("Brush Script MT", Font.BOLD, 28));
        titre.setForeground(Color.BLACK);
        this.add(titre, BorderLayout.NORTH);

        // Centre : infos
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS)); // Y_AXIS pour empiler les labels verticalement

        centre.setFont(new Font("Serif", Font.PLAIN, 18));
        centre.setForeground(Color.black);

        centre.add(new JLabel("Nom : " + instr.nom));
        centre.add(new JLabel("Qualité : " + instr.qualite));
        centre.add(new JLabel("Taille : " + instr.taille.size));
        centre.add(new JLabel("Prix : " + instr.prix + "€"));
        centre.add(new JLabel("Stock : " + instr.stock));
        centre.add(new JLabel("Identifiant : " + instr.identifiant));

        centre.setBackground(new Color(235, 140, 45));

        // Familles
        if (!instr.list_fam.isEmpty()) {
            centre.add(new JLabel("Familles : " + instr.list_fam.toString()));
        }

        this.add(centre, BorderLayout.CENTER);

        // Bas : boutons
        btnRetour = new JButton("Retour");
        btnAcheter = new JButton("Acheter");
        JPanel bas = new JPanel();
        bas.add(btnRetour);
        bas.add(btnAcheter);

        this.add(bas, BorderLayout.SOUTH);
    }
}
