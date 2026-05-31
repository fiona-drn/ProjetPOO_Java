import java.awt.*;
import javax.swing.*;

public class VueAccueilGerant extends JPanel {
    JButton btnAjoutClient;
    JButton btnVoirOuSuppClients;
    JButton btnAjoutInstrument;
    JButton btnAjoutAccessoire;
    JButton deconnexion;

    public VueAccueilGerant() {
        this.setLayout(new GridLayout(5, 2));

        btnAjoutClient = new JButton("Ajouter un client");
        btnVoirOuSuppClients = new JButton("Voir / Supprimer un client");
        btnAjoutInstrument = new JButton("Ajouter un instrument");
        btnAjoutAccessoire = new JButton("Ajouter un accessoire");
        deconnexion = new JButton("Deconnexion");
        
        btnAjoutClient.setBackground(new Color(255, 228, 196));
        btnVoirOuSuppClients.setBackground(new Color(230, 180, 120));
        btnAjoutInstrument.setBackground(new Color(255, 228, 196));
        btnAjoutAccessoire.setBackground(new Color(230, 180, 120));
        deconnexion.setBackground(new Color(150, 75, 0));

        btnAjoutClient.setFont(new Font("Serif", Font.BOLD, 18));
        btnVoirOuSuppClients.setFont(new Font("Serif", Font.BOLD, 18));
        btnAjoutInstrument.setFont(new Font("Serif", Font.BOLD, 18));
        btnAjoutAccessoire.setFont(new Font("Serif", Font.BOLD, 18));
        deconnexion.setFont(new Font("Serif", Font.BOLD, 18));

        this.add(btnAjoutClient);
        this.add(btnVoirOuSuppClients);
        this.add(btnAjoutInstrument);
        this.add(btnAjoutAccessoire);
        this.add(deconnexion);
    }
    
}
