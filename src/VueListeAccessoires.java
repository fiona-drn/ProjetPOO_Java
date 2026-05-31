import java.awt.*;
import javax.swing.*;

public class VueListeAccessoires extends JPanel {

    JList<Accessoire> liste;
    JButton btnVoir;
    JButton btnBack;
    Magasin mag;

    public VueListeAccessoires(Magasin m) {
        mag = m;

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(235, 140, 45));

        liste = new JList<>(mag.list_acc);
        this.add(new JScrollPane(liste), BorderLayout.CENTER);

        liste.setFont(new Font("Serif", Font.PLAIN, 18));
        liste.setBackground(new Color(235, 140, 45));
        liste.setForeground(Color.black);
        liste.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel bas = new JPanel();
        btnVoir = new JButton("Voir l'accessoire");
        btnBack = new JButton("Retour");
        bas.add(btnVoir);
        bas.add(btnBack);
        bas.setBackground(new Color(235, 140, 45));

        this.add(bas, BorderLayout.SOUTH);
    }

    public void rafraichir(Magasin mag) {
        liste.setListData(mag.list_acc);
        liste.updateUI();
    }
}


