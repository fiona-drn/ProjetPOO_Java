import javax.swing.*;
import java.awt.*;

public class VueReparation extends JPanel {

    public JTextField nomInstru;
    public JTextArea probleme;
    public JTextField email;
    public JButton btnValider;
    public JButton btnRetour;


    public VueReparation(Magasin mag) {

        this.setLayout(new BorderLayout(10, 10));

        // FORM PANEL
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // NOM DE L'INSTRUMENT
        nomInstru = new JTextField();
        formPanel.add(new JLabel("Nom de l'instrument :"));
        formPanel.add(nomInstru);

        // PROBLEME
        formPanel.add(new JLabel("Problème :"));
        probleme = new JTextArea(3, 20);
        probleme.setLineWrap(true);
        probleme.setWrapStyleWord(true);
        JScrollPane scrollProbleme = new JScrollPane(probleme);
        formPanel.add(scrollProbleme);

        // EMAIL
        email = new JTextField();
        formPanel.add(new JLabel("Email (pour confirmation) :"));
        formPanel.add(email);

        // BUTTONS
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnValider = new JButton("Valider réparation");
        btnRetour = new JButton("Retour");
        buttonPanel.add(btnValider);
        buttonPanel.add(btnRetour);

        this.add(formPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
