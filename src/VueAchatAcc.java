import java.awt.*;
import javax.swing.*;


public class VueAchatAcc extends JPanel {
    JLabel affAchat;
    JLabel cptClient;
    JTextField IdClient;
    Accessoire acc;
    JButton btnConfirmer;
    JButton btnRetour;

    public VueAchatAcc (Accessoire a) {
        acc = a;
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(235, 140, 45));

        //infos
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS)); // Y_AXIS pour empiler les labels verticalement
        centre.setBackground(new Color(235, 140, 45));

        affAchat = new JLabel("Vous avez choisi d'acheter l'accessoire suivant: " );
        affAchat.setFont(new Font("Serif", Font.BOLD, 20));
        affAchat.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(affAchat);

        JLabel nom = new JLabel("Nom : " + acc.nom);
        nom.setFont(new Font("Serif", Font.PLAIN, 18));
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(nom);

        JLabel prix = new JLabel("Prix : " + acc.prix + "€");
        prix.setFont(new Font("Serif", Font.PLAIN, 18));
        prix.setAlignmentX(Component.CENTER_ALIGNMENT);
        centre.add(prix);

        centre.add(Box.createRigidArea(new Dimension(0, 20))); // espace vertical

        cptClient = new JLabel("Entrez votre adresse mail pour confirmer l'achat :");
        IdClient = new JTextField();
        IdClient.setMaximumSize(new Dimension(400, 30));
        centre.add(cptClient);
        centre.add(IdClient);

        this.add(centre, BorderLayout.CENTER);

        JPanel bas = new JPanel();
        bas.setBackground(new Color(235, 140, 45));

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

    

