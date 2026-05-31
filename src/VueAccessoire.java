import java.awt.*;
import javax.swing.*;


public class VueAccessoire extends JPanel {

    JButton btnRetour;
    JButton btnAcheter;
    Accessoire acc;

    public VueAccessoire(Accessoire a) {
        acc = a;
        this.setLayout(new BorderLayout());

        // Titre
        JLabel titre = new JLabel("Fiche accessoire : " + acc.nom);
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBackground(new Color(235, 140, 45));
        titre.setFont(new Font("Brush Script MT", Font.BOLD, 28));
        titre.setForeground(Color.BLACK);
        this.add(titre, BorderLayout.NORTH);

        // Centre : infos
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS)); // Y_AXIS pour empiler les labels verticalement

        centre.setFont(new Font("Serif", Font.PLAIN, 18));
        centre.setForeground(Color.black);
        centre.add(new JLabel("Nom : " + acc.nom));
        centre.add(new JLabel("Prix : " + acc.prix + "€"));
        centre.add(new JLabel("Stock : " + acc.stock));

        centre.setBackground(new Color(235, 140, 45));
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
 

