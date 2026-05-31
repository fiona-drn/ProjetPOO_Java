import javax.swing.*;
import java.awt.*;

public class VueAjoutClient extends JPanel {

    
    JTextField IdClient;
    JTextField NomClient;
    JLabel lblId;
    JLabel lblClient;
    JButton btnAjouter;
    JButton btnBack;

    Magasin mag;

    public VueAjoutClient(Magasin m) {
        mag = m;
        this.setLayout(new GridLayout(8, 2));

        lblId = new JLabel("Identifiant du client :");
        IdClient = new JTextField();
        lblClient = new JLabel("Nom du client :");
        NomClient = new JTextField();
        
        btnAjouter = new JButton("Ajouter le client");
        btnBack = new JButton("Retour");

        this.add(lblId);
        this.add(IdClient);
        this.add(lblClient);
        this.add(NomClient);
        this.add(btnAjouter);
        this.add(btnBack);
    }
}
