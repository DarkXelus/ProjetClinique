package fr.eni.clinique.ihm.Personnels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.dal.DALException;
import javafx.scene.control.ListView;

@SuppressWarnings("serial")
public class EcranGestionPersonnelstest extends JFrame {
	static JFrame frame;
	JButton btnAjout, btnSuppression;

	public EcranGestionPersonnelstest(String role, String nom) {
		super();
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(role, nom);
	}

	public JButton btnAjout() {
		if (btnAjout == null) {
			btnAjout = new JButton("Ajouter");
			btnAjout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
						// Passage du role et du nom dans la vue Main
						AjoutPersonnels ajout = new AjoutPersonnels();
						ajout.setVisible(true);
				}
			});

		}
		return btnAjout;

	}

	public JButton btnSuppression() {
		if (btnAjout == null) {
			btnAjout = new JButton("Supprimer");

			btnAjout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					/*
					 * try { // Passage du role et du nom dans la vue Main
					 * AjoutPersonnels ajout = new AjoutPersonnels();
					 * ajout.setVisible(true);
					 * 
					 * } catch (Exception e) {
					 * JOptionPane.showMessageDialog(frame,
					 * "Mot de passe ou nom incorrect"); }
					 */
				}
			});

		}
		return btnAjout;
	}

	public JList<Personnels> lPersonnels() {
		PersonnelsManager pm = new PersonnelsManager();
		DefaultListModel<Personnels> dlm = new DefaultListModel<Personnels>();
		JList<Personnels> lPersonnels = new JList<Personnels>(dlm);
		List<Personnels> list = new ArrayList<Personnels>();
		try {
			list = pm.SelectAll();
			for (Personnels personnels : list) {
				dlm.addElement(personnels);
			}
			lPersonnels.setModel(dlm);
			lPersonnels.setVisible(true);
		} catch (DALException | BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lPersonnels;
	}

	private void initIHM(String role, String nom) {

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(btnAjout(), gbc);

		// Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(lPersonnels(), gbc);

		this.setContentPane(panel);
	}
}
