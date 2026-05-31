import java.awt.*;
import javax.swing.*;

public class VueGestionMagasin extends JPanel {

    JLabel lblId;
    JLabel lblNom;
    JLabel lblPrenom;
    JTextField IdGerant;
    JTextField NomGerant;
    JTextField PrenomGerant;
    JButton btnConnexion;

    Magasin mag;

    public VueGestionMagasin(Magasin m) {
        mag = m;
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(235, 140, 45));

        //centre : infos gérant
        JPanel centre = new JPanel();
        centre.setLayout(new GridLayout(4, 2, 10, 20)); 
        centre.setBackground(new Color(235, 140, 45));
        this.add(centre, BorderLayout.CENTER);

        Font styleField = new Font("Serif", Font.PLAIN, 20);

        lblId = new JLabel("Identifiant du gérant :", SwingConstants.CENTER);
        lblId.setFont(new Font("Serif", Font.BOLD, 20));

        IdGerant = new JTextField();
        IdGerant.setFont(styleField);

        lblNom = new JLabel("Nom du gérant :", SwingConstants.CENTER);
        lblNom.setFont(new Font("Serif", Font.BOLD, 20));

        NomGerant = new JTextField();
        NomGerant.setFont(styleField);

        lblPrenom = new JLabel("Prénom du gérant :", SwingConstants.CENTER);
        lblPrenom.setFont(new Font("Serif", Font.BOLD, 20));

        PrenomGerant = new JTextField();
        PrenomGerant.setFont(styleField);

        btnConnexion = new JButton("Connexion");
        btnConnexion.setBackground(new Color(255, 228, 196));
        btnConnexion.setFont(new Font("Serif", Font.BOLD, 20));
        JPanel bas = new JPanel();

        centre.add(lblId);
        centre.add(IdGerant);
        centre.add(lblNom);
        centre.add(NomGerant);
        centre.add(lblPrenom);
        centre.add(PrenomGerant);

        bas.add(btnConnexion);
        bas.setBackground(new Color(235, 140, 45));
        this.add(bas, BorderLayout.SOUTH);
    }
}
