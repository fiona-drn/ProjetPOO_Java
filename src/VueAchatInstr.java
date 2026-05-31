import java.awt.*;
import javax.swing.*;


public class VueAchatInstr extends JPanel {
    JLabel affAchat;
    JLabel cptClient;
    JTextField IdClient;
    Instrument instr;
    JButton btnConfirmer;
    JButton btnRetour;

    public VueAchatInstr (Instrument i) {
        instr = i;

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(235, 140, 45));

        //infos
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS)); // Y_AXIS pour empiler les labels verticalement
        centre.setBackground(new Color(235, 140, 45));
        
        affAchat = new JLabel("Vous avez choisi d'acheter l'instrument suivant: " );
        affAchat.setFont(new Font("Serif", Font.BOLD, 20));
        affAchat.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(affAchat);

        JLabel nom = new JLabel("Nom : " + instr.nom);
        nom.setFont(new Font("Serif", Font.PLAIN, 18));
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(nom);

        JLabel qualite = new JLabel("Qualité : " + instr.qualite);
        qualite.setFont(new Font("Serif", Font.PLAIN, 18));
        qualite.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(qualite);

        JLabel taille = new JLabel("Taille : " + instr.taille.size);
        taille.setFont(new Font("Serif", Font.PLAIN, 18));
        taille.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(taille);

        JLabel prix = new JLabel("Prix : " + instr.prix + "€");
        prix.setFont(new Font("Serif", Font.PLAIN, 18));
        prix.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(prix);

        JLabel identifiant = new JLabel("Identifiant : " + instr.identifiant);
        identifiant.setFont(new Font("Serif", Font.PLAIN, 18));
        identifiant.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(identifiant);

        cptClient = new JLabel("Entrez votre adresse mail pour confirmer l'achat :");
        IdClient = new JTextField();
        IdClient.setMaximumSize(new Dimension(400, 30));
        centre.add(cptClient);
        centre.add(IdClient);

        this.add(centre, BorderLayout.CENTER);

        JPanel bas = new JPanel();

        btnConfirmer = new JButton("Confirmer l'achat");
        btnRetour = new JButton("Retour");

        btnConfirmer.setBackground(new Color(255, 228, 196));
        btnRetour.setBackground(new Color(255, 228, 196));
        btnConfirmer.setFont(new Font("Serif", Font.BOLD, 20));
        btnRetour.setFont(new Font("Serif", Font.BOLD, 20));

        bas.add(btnConfirmer);
        bas.add(btnRetour);

        this.add(centre, BorderLayout.CENTER);
        this.add(bas, BorderLayout.SOUTH);
    }
}
