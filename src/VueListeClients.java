import javax.swing.*;
import java.awt.*;

public class VueListeClients extends JPanel {

    JList<Client> listeCli;
    JButton btnSupprimer;
    JButton btnRetour;
    JLabel selection;

    public VueListeClients(Magasin mag) {

        this.setLayout(new BorderLayout());

        // Titre
        JLabel titre = new JLabel("Liste des clients");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);

        selection = new JLabel("Sélectionnez un client et cliquez sur 'Supprimer ce client' pour le supprimer");

        // Liste des clients
        listeCli = new JList<>(mag.list_clients);
        this.add(new JScrollPane(listeCli), BorderLayout.CENTER);

        // Bas
        JPanel bas = new JPanel();
        bas.setLayout(new BoxLayout(bas, BoxLayout.Y_AXIS));

        btnSupprimer = new JButton("Supprimer ce client");
        btnRetour = new JButton("Retour");

        bas.add(selection);
        bas.add(btnSupprimer);
        bas.add(btnRetour);

        this.add(bas, BorderLayout.SOUTH);
    }

    public void rafraichir(Magasin mag) {
        listeCli.setListData(mag.list_clients);
}


}

