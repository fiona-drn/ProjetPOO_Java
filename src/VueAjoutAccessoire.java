import javax.swing.*;
import java.awt.*;


public class VueAjoutAccessoire extends JPanel {
    JTextField nomAcc;
    JTextField prixAcc;
    JTextField stockAcc;
    JLabel lblNom;
    JLabel lblPrix;
    JLabel lblStock;
    JButton btnAjouter;
    JButton btnBack;
    JList<Accessoire> listeAcc;

    Magasin mag;

    public VueAjoutAccessoire(Magasin m) {
        mag = m;
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(new Color(235, 140, 45));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(new Color(235, 140, 45));

        lblNom = new JLabel("Nom de l'accessoire :");
        nomAcc = new JTextField();
        lblPrix = new JLabel("Prix de l'accessoire :");
        prixAcc = new JTextField();
        lblStock = new JLabel("Stock de l'accessoire :");
        stockAcc = new JTextField();
        
        btnAjouter = new JButton("Ajouter l'accessoire");
        btnBack = new JButton("Retour");

        formPanel.add(lblNom);
        formPanel.add(nomAcc);
        formPanel.add(lblPrix);
        formPanel.add(prixAcc);
        formPanel.add(lblStock);
        formPanel.add(stockAcc);
        formPanel.add(btnAjouter);
        formPanel.add(btnBack);

        this.add(formPanel, BorderLayout.NORTH);

        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.setBackground(new Color(235, 140, 45));
        JLabel lblListe = new JLabel("Liste des accessoires en stock :");
        lblListe.setFont(new Font("Serif", Font.BOLD, 16));
        listPanel.add(lblListe, BorderLayout.NORTH);

        listeAcc = new JList<>(mag.list_acc);
        listeAcc.setFont(new Font("Serif", Font.PLAIN, 14));
        listPanel.add(new JScrollPane(listeAcc), BorderLayout.CENTER);

        this.add(listPanel, BorderLayout.CENTER);
    }
}
