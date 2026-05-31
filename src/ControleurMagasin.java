import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

public class ControleurMagasin implements ActionListener {

    VueMagasin vue;
    Magasin mag;

    public ControleurMagasin(VueMagasin v, Magasin m) {
        vue = v;
        mag = m;

        // On attache le contrôleur aux menus
        vue.el1.addActionListener(this); // Instruments
        vue.el2.addActionListener(this); // Accessoires

        vue.el3.addActionListener(this); // Réparation 
        vue.el4.addActionListener(this); // Gestion du magasin

        // Boutons "Voir Fiche" & "Retour" pour affichage de la liste d'instruments

        vue.vueListeInstr.btnVoir.addActionListener(this);
        vue.vueListeInstr.btnBack.addActionListener(this);

        // Boutons "Voir Fiche" & "Retour" pour affichage de la liste d'accessoires

        vue.vueListeAcc.btnVoir.addActionListener(this);
        vue.vueListeAcc.btnBack.addActionListener(this);

        // BOUTON CONNEXION POUR LA GESTION DU MAGASIN

        vue.vueGestion.btnConnexion.addActionListener(this);

        //BOUTON GESTON DU MAGASIN (AJOUT/SUPPRESSION CLIENTS, AJOUT INSTRUMENT/ACCESSOIRE, DECONNEXION)
        vue.vueGerant.btnAjoutClient.addActionListener(this);
        vue.vueGerant.btnVoirOuSuppClients.addActionListener(this);
        vue.vueGerant.btnAjoutInstrument.addActionListener(this);
        vue.vueGerant.btnAjoutAccessoire.addActionListener(this);
        vue.vueGerant.deconnexion.addActionListener(this);
       

    
        

    }

    @Override
    public void actionPerformed(ActionEvent evenement) {

        Object bouton = evenement.getSource();

        // INSTRUMENTS
        if (bouton == vue.el1) {
            vue.cards.show(vue.panelCentral, "listeInstru");
        }

        // ACCESSOIRES
        if (bouton == vue.el2) {
            vue.vueListeAcc.rafraichir(mag);
            vue.cards.show(vue.panelCentral, "accessoires");


        }

        // REPARATION
        if (bouton == vue.el3) {
            vue.cards.show(vue.panelCentral, "vueRepar");

            // Bouton valider
        vue.vueRepa.btnValider.addActionListener(e -> {

            String nomInstru = vue.vueRepa.nomInstru.getText().trim();
            String probleme = vue.vueRepa.probleme.getText().trim();
            String emailRepa = vue.vueRepa.email.getText().trim();

            // Vérifier que les champs ne sont pas vides
            if (nomInstru.isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Veuillez entrer le nom de l'instrument.");
                return;
            }
            if (probleme.isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Veuillez décrire le problème.");
                return;
            }
            if (emailRepa.isEmpty() || !(emailRepa.endsWith("@gmail.com") || emailRepa.endsWith("@hotmail.fr"))) {
                JOptionPane.showMessageDialog(vue, "Merci d'écrire une adresse email valide : exemple1@gmail.com / exemple2@hotmail.fr");
                return;
            }

            // Chercher l'instrument dans le magasin
            Instrument inst = null;
            for (Instrument i : mag.list_instru) {
                if (i.nom.equalsIgnoreCase(nomInstru)) {
                    inst = i;
                    break;
                }
            }

            if (inst == null) {
                JOptionPane.showMessageDialog(vue, "Instrument '" + nomInstru + "' non trouvé dans le magasin.");
                return;
            }

            // Créer réparation
            double tarif = 20.0;
            String type = "Réparation standard";
            Client cli = null;
            int ticket = mag.genererNumeroReparation();
            LocalDate date = LocalDate.now();

            Reparation r = new Reparation(tarif, type, mag, cli, ticket, date);
            r.ajoutInstru(inst);
            mag.ajoutReparation(r);

            JOptionPane.showMessageDialog(vue, "Réparation enregistrée !\n" +
                    "Instrument : " + inst.nom + "\n" +
                    "Problème : " + probleme + "\n" +
                    "Email de confirmation : " + emailRepa + "\n" +
                    "Ticket : 2006." + ticket);

            JOptionPane.showMessageDialog(vue, " Veuillez déposer l'instrument dans les 15 jours.");

            // Réinitialiser les champs
            vue.vueRepa.nomInstru.setText("");
            vue.vueRepa.probleme.setText("");
            vue.vueRepa.email.setText("");

            vue.cards.show(vue.panelCentral, "accueil");
        });

        // Bouton retour
        vue.vueRepa.btnRetour.addActionListener(e -> {
            vue.cards.show(vue.panelCentral, "accueil");
        });
}
        

        // GESTION DU MAGASIN
        if (bouton == vue.el4) {
            vue.cards.show(vue.panelCentral, "gestion");
        }

        // CONNEXION GERANT
        if(bouton == vue.vueGestion.btnConnexion) {
            String correctId = vue.vueGestion.IdGerant.getText();
            String correctNom = vue.vueGestion.NomGerant.getText();
            String correctPrenom = vue.vueGestion.PrenomGerant.getText();

            boolean gerant1 = correctId.equals("2477") && (correctNom.equals("JB") || correctNom.equals("jb") || correctNom.equals("Jb")) && (correctPrenom.equals("Moi") || correctPrenom.equals("moi") || correctPrenom.equals("MOI"));
        
            if (gerant1) {
                vue.cards.show(vue.panelCentral, "accueilGerant");

            } else {
                JOptionPane.showMessageDialog(vue, "Identifiants incorrects. Accès refusé.");
            }
        }

        // BOUTON DECONNEXION DE LA GESTION DU MAGASIN
        if (bouton == vue.vueGerant.deconnexion) {
            vue.cards.show(vue.panelCentral, "accueil");
        }

        // BOUTON RETOUR DANS LA LISTE DES INSTRUMENTS ET DANS LA LISTE DES ACCESSOIRES

        if (bouton == vue.vueListeInstr.btnBack) {
            vue.cards.show(vue.panelCentral, "accueil");
        }

        if (bouton == vue.vueListeAcc.btnBack) {
            vue.cards.show(vue.panelCentral, "accueil");
        }


        // FICHE INTRUMENT SI CLICK SUR 'VOIR' (affichage de la fiche de l'instrument sélectionné dans la liste)

        if (bouton == vue.vueListeInstr.btnVoir) {
            Instrument instrSelected = vue.vueListeInstr.liste.getSelectedValue();
            if(instrSelected != null) {
                vue.vueInstr = new VueInstrument(instrSelected); //ON STOCK LA FICHE
                vue.panelCentral.add(vue.vueInstr, "ficheInstru");
                vue.cards.show(vue.panelCentral, "ficheInstru");

                // AJOUT LISTENER ICI POUR LE BOUTON ACHETER DE LA FICHE INSTRUMENT
                vue.vueInstr.btnAcheter.addActionListener(this);


                vue.vueInstr.btnRetour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        vue.cards.show(vue.panelCentral, "listeInstru");
                    }
                });
            }
        }

        // FICHE ACCESSOIRE (affichage de la fiche de l'accessoire sélectionné dans la liste)

        if (bouton == vue.vueListeAcc.btnVoir) {
            Accessoire accSelected = vue.vueListeAcc.liste.getSelectedValue();
            
            if(accSelected != null) {
                VueAccessoire ficheAcc = new VueAccessoire(accSelected);
                vue.panelCentral.add(ficheAcc, "ficheAcc");
                vue.cards.show(vue.panelCentral, "ficheAcc");

                // Stocke la fiche active et ajoute le listener sur son bouton Acheter
                vue.vueAcc = ficheAcc;
                vue.vueAcc.btnAcheter.addActionListener(this);

                ficheAcc.btnRetour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        vue.cards.show(vue.panelCentral, "accessoires");
                    }
                });
            }
        }

        // BOUTON ACHAT D'UN INSTRUMENT
        if (vue.vueInstr != null && bouton == vue.vueInstr.btnAcheter) {
            vue.vueAchInstr = new VueAchatInstr(vue.vueInstr.instr); // ON STOCK LA FICHE D'ACHAT AVEC L'INSTRUMENT SELECTIONNE
            vue.panelCentral.add(vue.vueAchInstr, "achat"); 
            vue.cards.show(vue.panelCentral, "achat");

            vue.vueAchInstr.btnConfirmer.addActionListener(this);
            vue.vueAchInstr.btnRetour.addActionListener(this);

            vue.vueInstr.btnRetour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vue.cards.show(vue.panelCentral, "listeInstru");
                }
            });
        }

        // BOUTON ACHAT D'UN ACCESSOIRE
        if (vue.vueAcc != null && bouton == vue.vueAcc.btnAcheter) {
            vue.vueAchAcc = new VueAchatAcc(vue.vueAcc.acc); // ON STOCK LA FICHE D'ACHAT AVEC L'ACCESSOIRE SELECTIONNE
            vue.panelCentral.add(vue.vueAchAcc, "achatAcc"); 
            vue.cards.show(vue.panelCentral, "achatAcc");

            vue.vueAchAcc.btnConfirmer.addActionListener(this);
            vue.vueAchAcc.btnRetour.addActionListener(this);

            vue.vueAcc.btnRetour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vue.cards.show(vue.panelCentral, "accessoires");
                }
            });
        }

        // BOUTON CONFIRMATION ACHAT INSTRUMENT

        if (vue.vueAchInstr != null && bouton == vue.vueAchInstr.btnConfirmer) {
            String email = vue.vueAchInstr.IdClient.getText().trim();

            //restriction format add email
            if (email.isEmpty() || !(email.endsWith("@gmail.com") || email.endsWith("@hotmail.fr"))) {
                JOptionPane.showMessageDialog(vue, "Merci d'écrire une adresse email valide : exemple1@gmail.com / exemple2@hotmail.fr");
            } else {
                JOptionPane.showMessageDialog(vue, "Achat confirmé !\nVous allez recevoir un message de confirmation à " + email + ".");
                vue.cards.show(vue.panelCentral, "listeInstru");
            }
        }

        // Retour depuis la page d'achat instrument
        if (vue.vueAchInstr != null && bouton == vue.vueAchInstr.btnRetour) {
            vue.cards.show(vue.panelCentral, "listeInstru");
        }


        // BOUTON CONFIRMATION ACHAT ACCESSOIRE

        if (vue.vueAchAcc != null && bouton == vue.vueAchAcc.btnConfirmer) {
            String email = vue.vueAchAcc.IdClient.getText().trim();
            // restriction format add email
            if (email.isEmpty() || !(email.endsWith("@gmail.com") || email.endsWith("@hotmail.fr"))) {
                JOptionPane.showMessageDialog(vue, "Merci d'écrire une adresse email valide : exemple1@gmail.com / exemple2@hotmail.fr");
            } else {
                JOptionPane.showMessageDialog(vue, "Achat confirmé !\nVous allez recevoir un message de confirmation à " + email + ".");
                vue.cards.show(vue.panelCentral, "accessoires");
            }
        }

        // Retour depuis la page d'achat accessoire
        if (vue.vueAchAcc != null && bouton == vue.vueAchAcc.btnRetour) {
            vue.cards.show(vue.panelCentral, "accessoires");
        }


        // BOUTON AJOUT CLIENT
        if (bouton == vue.vueGerant.btnAjoutClient) {
            vue.vueAjoutCli.btnAjouter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String id = vue.vueAjoutCli.IdClient.getText();
                        String nom = vue.vueAjoutCli.NomClient.getText();
                        
                        if (id.isEmpty() || nom.isEmpty()) {
                            JOptionPane.showMessageDialog(vue, "Tous les champs doivent être remplis.");
                            return;
                        }
                        
                        Client nouveauClient = new Client(Integer.parseInt(id), nom, mag);
                        vue.vueListeCli.rafraichir(mag);
                        
                        JOptionPane.showMessageDialog(vue, "Client ajouté avec succès !");
                        
                        vue.vueAjoutCli.IdClient.setText("");
                        vue.vueAjoutCli.NomClient.setText("");
                        
                        vue.cards.show(vue.panelCentral, "accueilGerant");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(vue, "L'identifiant doit être un nombre valide.");
                    }
                }
            });
            
            vue.vueAjoutCli.btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vue.vueAjoutCli.IdClient.setText("");
                    vue.vueAjoutCli.NomClient.setText("");
                    vue.cards.show(vue.panelCentral, "accueilGerant");
                }
            });
            
            vue.cards.show(vue.panelCentral, "ajoutClient");
        }

        

        // BOUTON VOIR LA LISTE DES CLIENTS OU SUPPRIMER UN CLIENT
        if (bouton == vue.vueGerant.btnVoirOuSuppClients) {
            vue.vueListeCli.rafraichir(mag);

            // LISTENERS BOUTON RETOUR OU CONFIRMER LA SUPPRESSION D'UN CLIENT
            vue.vueListeCli.btnSupprimer.addActionListener(this);
            vue.vueListeCli.btnRetour.addActionListener(this);
            

            vue.cards.show(vue.panelCentral, "listeClients");

            
        }


        // BOUTON SUPPRIMER UN CLIENT DE LA LISTE DES CLIENTS

        if(bouton == vue.vueListeCli.btnSupprimer) {

            Client c = vue.vueListeCli.listeCli.getSelectedValue();
            int idCliSuppr = c.num_client;
            int confirmation = JOptionPane.showConfirmDialog(vue, "Êtes-vous sûr de vouloir supprimer le client " + c.nom + " (ID: " + idCliSuppr + ") ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                mag.supprimerClient(idCliSuppr);
                vue.vueListeCli.listeCli.updateUI(); // Met à jour la liste des clients affichée
                JOptionPane.showMessageDialog(vue, "Client supprimé avec succès !");
            } else {
                JOptionPane.showMessageDialog(vue, "Suppression annulée.");
            }
        }

        // BOUTON RETOUR DE LA LISTE DES CLIENTS
        if(bouton == vue.vueListeCli.btnRetour) {
            vue.cards.show(vue.panelCentral, "accueilGerant");
        }
        
        ////

        // BOUTON AJOUT INSTRUMENT
        if (bouton == vue.vueGerant.btnAjoutInstrument) {

        vue.vueAjoutInstr = new VueAjoutInstrument(mag);
        vue.panelCentral.add(vue.vueAjoutInstr, "ajoutInstru");
        vue.cards.show(vue.panelCentral, "ajoutInstru");

        // Remplir la combobox au démarrage
        Famille fInitiale = (Famille) vue.vueAjoutInstr.comboFamille.getSelectedItem();
        if (fInitiale != null) {
            vue.vueAjoutInstr.updateInstruments(mag, fInitiale);
        }

        // Listener pour mettre à jour la liste selon la famille
        vue.vueAjoutInstr.comboFamille.addActionListener(e -> {
            Famille f = (Famille) vue.vueAjoutInstr.comboFamille.getSelectedItem();
            if (f != null) {
                vue.vueAjoutInstr.updateInstruments(mag, f);
            }
        });

        // Listener pour AJOUTER l’instrument
        vue.vueAjoutInstr.btnAjouter.addActionListener(e -> {

        // Vérifier famille
        Famille fam = (Famille) vue.vueAjoutInstr.comboFamille.getSelectedItem();
        if (fam == null) {
            JOptionPane.showMessageDialog(vue, "Sélectionnez une famille.");
            return;
        }

        // Vérifier instrument
        Instrument instr = (Instrument) vue.vueAjoutInstr.comboInstru.getSelectedItem();
        if (instr == null) {
            JOptionPane.showMessageDialog(vue, "Sélectionnez un instrument.");
            return;
        }

        // Vérifier quantité
        String qte = vue.vueAjoutInstr.quantite.getText().trim();
        if (qte.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Entrez une quantité.");
            return;
        }

        int q;
        try {
            q = Integer.parseInt(qte);
            if (q < 1) {
                JOptionPane.showMessageDialog(vue, "Quantité invalide.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vue, "La quantité doit être un entier.");
            return;
        }

        // Mise à jour du stock
        instr.stock += q;

        JOptionPane.showMessageDialog(vue,
            "Instrument ajouté : " + instr.nom + " +" + q);

        vue.vueAjoutInstr.quantite.setText("");
    });

        // Bouton retour
        vue.vueAjoutInstr.btnRetour.addActionListener(e -> {
        vue.cards.show(vue.panelCentral, "accueilGerant");
    });

}

    ////
    // BOUTON AJOUT ACCESSOIRE

    if(bouton == vue.vueGerant.btnAjoutAccessoire) {
        vue.vueAjoutAcc = new VueAjoutAccessoire(mag);
        vue.panelCentral.add(vue.vueAjoutAcc, "ajoutAccessoire");
        vue.cards.show(vue.panelCentral, "ajoutAccessoire");
        // Listener pour AJOUTER un accessoire
        vue.vueAjoutAcc.btnAjouter.addActionListener(e -> {

        // 1. Récupérer les champs
        String nom = vue.vueAjoutAcc.nomAcc.getText().trim();
        String prixStr = vue.vueAjoutAcc.prixAcc.getText().trim();
        String stockStr = vue.vueAjoutAcc.stockAcc.getText().trim();

        // 2. Vérifier que les champs ne sont pas vides
        if (nom.isEmpty() || prixStr.isEmpty() || stockStr.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Tous les champs doivent être remplis.");
            return;
        }

        // 3. Vérifier prix
        double prix;
        try {
            prix = Double.parseDouble(prixStr);
            if (prix <= 0) {
                JOptionPane.showMessageDialog(vue, "Le prix doit être positif.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vue, "Le prix doit être un nombre.");
            return;
    }

        // 4. Vérifier stock
        int stock;
        try {
            stock = Integer.parseInt(stockStr);
            if (stock < 1) {
                JOptionPane.showMessageDialog(vue, "Le stock doit être un entier positif.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vue, "Le stock doit être un entier.");
            return;
        }

        // 5. Créer l’accessoire
        Accessoire acc = new Accessoire(nom, prix, mag, null, stock);
        mag.ajoutAcc(acc);

        // 6. Message de succès
        JOptionPane.showMessageDialog(vue, "Accessoire ajouté avec succès !\n" + nom + " — " + prix + "€ — stock +" + stock);

        // 7. Reset des champs
        vue.vueAjoutAcc.nomAcc.setText("");
        vue.vueAjoutAcc.prixAcc.setText("");
        vue.vueAjoutAcc.stockAcc.setText("");

        // 8. Retour à l’accueil gérant
        vue.cards.show(vue.panelCentral, "accueilGerant");
    });

    }

    // Bouton retour 
        vue.vueAjoutAcc.btnBack.addActionListener(e -> {
        vue.cards.show(vue.panelCentral, "accueilGerant");
    });

}}


