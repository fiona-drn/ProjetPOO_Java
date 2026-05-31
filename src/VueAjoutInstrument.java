import javax.swing.*;
import java.awt.*;

public class VueAjoutInstrument extends JPanel {

    public JComboBox<Famille> comboFamille;
    public JComboBox<Instrument> comboInstru;
    public JList<Instrument> listeInstru;
    public JTextField quantite;
    public JButton btnAjouter;
    public JButton btnRetour;

    public VueAjoutInstrument(Magasin mag) {

        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(new Color(235, 140, 45));

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(new Color(235, 140, 45));

        // SELECTION FAMILLE
        comboFamille = new JComboBox<>(Famille.values());
        comboFamille.setSelectedIndex(0);  // Force la sélection du premier élément
        formPanel.add(new JLabel("Famille :"));
        formPanel.add(comboFamille);

        // SELECTION INSTRUMENT SELON LA FAMILLE CHOISIE
        comboInstru = new JComboBox<>();
        Famille fInitiale = (Famille) comboFamille.getSelectedItem();
        if (fInitiale != null) {
            updateInstruments(mag, fInitiale);
        }
        formPanel.add(new JLabel("Instrument :"));
        formPanel.add(comboInstru);

        // Quantité
        quantite = new JTextField();
        formPanel.add(new JLabel("Quantité à ajouter :"));
        formPanel.add(quantite);

        // Boutons
        btnAjouter = new JButton("Ajouter au stock");
        btnRetour = new JButton("Retour");

        formPanel.add(btnAjouter);
        formPanel.add(btnRetour);

        this.add(formPanel, BorderLayout.NORTH);

        // Liste complète des instruments en stock
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.setBackground(new Color(235, 140, 45));
        JLabel lblListe = new JLabel("Liste des instruments en stock :");
        lblListe.setFont(new Font("Serif", Font.BOLD, 16));
        listPanel.add(lblListe, BorderLayout.NORTH);

        listeInstru = new JList<>(mag.list_instru);
        listeInstru.setFont(new Font("Serif", Font.PLAIN, 14));
        listPanel.add(new JScrollPane(listeInstru), BorderLayout.CENTER);

        this.add(listPanel, BorderLayout.CENTER);
    }

    // Méthode pour mettre à jour la liste des instruments selon la famille
    public void updateInstruments(Magasin mag, Famille f) {
        comboInstru.removeAllItems();

        for (Instrument i : mag.list_instru) {
            if (i.list_fam.contains(f)) {
                comboInstru.addItem(i);
            }
        }
    }
}
