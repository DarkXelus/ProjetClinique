package fr.eni.clinique.ihm.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnelstest;
import fr.eni.clinique.ihm.clients.EcranGestionClients;

@SuppressWarnings("serial")
public class EcranMain extends JFrame {
	static JFrame frame;
	private JLabel lblNom;
	private JButton btnPersonnels, btnClients;

	public EcranMain(String role, String nom) {
		super("Ecran Principal");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(role, nom);
	}

	public JLabel getLblNom(String nom, String role) {
		if (lblNom == null) {
			lblNom = new JLabel("Bonjour " + nom + " r�le: " + role);
			lblNom = new JLabel("Bonjour " + nom + " role: " + role);
		}
		return lblNom;
	}

	public JButton getBtnPersonnels(String nom, String role) {
		if (btnPersonnels == null) {
			btnPersonnels = new JButton("Gestion du personnels");
			btnPersonnels.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					if (role.equals("PDA")) {
						// Passage du role et du nom dans la vue Main
						EcranGestionPersonnels ecranPersonnels;
						try {
							ecranPersonnels = new EcranGestionPersonnels();
							ecranPersonnels.setVisible(true);
						} catch (DALException | BLLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
					}
				}
			});
		}
		return btnPersonnels;
	}

	public JButton getBtnClients(String role) {
		if (btnClients == null) {

			btnClients = new JButton("Gestion des Clients");
			btnClients.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (role.equals("AST")) {
						EcranGestionClients clients = new EcranGestionClients();
						clients.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
					}
				}
			});
		}

		return btnClients;
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
		panel.add(getLblNom(nom, role), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(getBtnPersonnels(nom, role), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(getBtnClients(role), gbc);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnGnral = new JMenu("G\u00E9n\u00E9ral");
		menuBar.add(mnGnral);

		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mnGnral.add(mntmDconnexion);

		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mnGnral.add(mntmFermer);

		JMenu mnAjoutDunClient = new JMenu("Client");
		menuBar.add(mnAjoutDunClient);

		JMenuItem mntmGrerLesClients = new JMenuItem("G\u00E9rer les clients");
		mnAjoutDunClient.add(mntmGrerLesClients);

		JMenu mnPersonnel = new JMenu("Personnel");
		menuBar.add(mnPersonnel);

		JMenuItem mntmGrerLePersonnel = new JMenuItem("G\u00E9rer le personnel");
		mnPersonnel.add(mntmGrerLePersonnel);

		this.setContentPane(panel);
	}

}
