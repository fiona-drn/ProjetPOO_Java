import java.awt.*;
import javax.swing.*;

public class VueListeInstruments extends JPanel {

    JList<Instrument> liste;
    JButton btnVoir;
    JButton btnBack;
    Magasin mag;

    public VueListeInstruments(Magasin m) {
        mag = m;

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(235, 140, 45));

        liste = new JList<>(mag.list_instru);
        this.add(new JScrollPane(liste), BorderLayout.CENTER);

        liste.setFont(new Font("Serif", Font.PLAIN, 18));
        liste.setForeground(Color.black);
        liste.setBackground(new Color(235, 140, 45));
        liste.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //Boutons en bas
        JPanel bas = new JPanel();
        btnVoir = new JButton("Voir l'instrument");
        btnBack = new JButton("Retour");

        btnVoir.setBackground(new Color(255, 228, 196));
        btnBack.setBackground(new Color(255, 228, 196));

        btnVoir.setFont(new Font("Serif", Font.BOLD, 16));
        btnBack.setFont(new Font("Serif", Font.BOLD, 16)); 

        bas.add(btnVoir);
        bas.add(btnBack); 
        bas.setBackground(new Color(235, 140, 45));

        this.add(bas, BorderLayout.SOUTH);
    }

    public void rafraichir(Magasin mag) {
        liste.setListData(mag.list_instru);
        liste.updateUI();
    }
}
