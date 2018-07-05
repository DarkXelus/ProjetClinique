package fr.eni.clinique.ihm.Personnels;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.SingletonGestionPersonnels;
import fr.eni.clinique.bll.SingletonMain;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.clients.EcranGestionClients;
import fr.eni.clinique.ihm.login.EcranLogin;

@SuppressWarnings("serial")
public class AjoutPersonnels extends JFrame {
	static JFrame frame;
	JLabel lblNom, lblPrenom, lblRole, lblMdp;
	JTextField txtNom, txtPrenom, txtRole;
	JPasswordField mdp;
	JButton btnConfirmer;

	public AjoutPersonnels() {
		super("Ajouter un membre du personnel");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		initIHM();
	}

	public JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom: ");
		}
		return lblNom;
	}

	public JLabel getLblMdp() {
		if (lblMdp == null) {
			lblMdp = new JLabel("Mot De Passe: ");
		}
		return lblMdp;
	}

	public JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField(20);
			txtNom.setBounds(5, 5, 30, 25);
		}
		return txtNom;
	}

	public JPasswordField getmdp() {
		if (mdp == null) {
			mdp = new JPasswordField(20);
			mdp.setBounds(5, 5, 10, 25);

		}
		return mdp;
	}

	public JLabel getLblPrenom() {
		if (lblPrenom == null) {
			lblPrenom = new JLabel("Prenom: ");
		}
		return lblPrenom;
	}

	public JLabel getLblRole() {
		if (lblRole == null) {
			lblRole = new JLabel("Role: ");
		}
		return lblRole;
	}

	public JTextField getTxtPrenom() {
		if (txtPrenom == null) {
			txtPrenom = new JTextField(20);
			txtPrenom.setBounds(5, 5, 10, 25);

		}
		return txtPrenom;
	}

	public JTextField getTxtRole() {
		if (txtRole == null) {
			txtRole = new JTextField(20);
			txtRole.setBounds(5, 5, 10, 25);

		}
		return txtRole;
	}

	public JButton getBtnConfirmer() {
		if (btnConfirmer == null) {
			btnConfirmer = new JButton("Créer");
			btnConfirmer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {

						PersonnelsManager pm = new PersonnelsManager();
						Personnels perso = new Personnels(txtNom.getText(), txtPrenom.getText(), mdp.getText(),
								txtRole.getText(), false);

						pm.Create(perso);
						SingletonGestionPersonnels.getInstance().getEcran().dispose();
						
						AjoutPersonnels.this.dispose();
						EcranGestionPersonnels ecranPerso = new EcranGestionPersonnels();
						ecranPerso.setVisible(true);
						JOptionPane.showMessageDialog(frame, "Ajout éffectué");
					} catch (DALException | BLLException e) {
						JOptionPane.showMessageDialog(frame, e.getMessage());
					}

				}
			});

		}
		return btnConfirmer;
	}

	private void initIHM() {

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getLblNom(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtNom(), gbc);

		// Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(getLblPrenom(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtPrenom(), gbc);

		// Ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(getLblMdp(), gbc);

		gbc.gridx = 1;
		panel.add(getmdp(), gbc);

		// Ligne 4
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(getLblRole(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtRole(), gbc);

		// Ligne 5
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(getBtnConfirmer(), gbc);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				SingletonGestionPersonnels.getInstance().getEcran().dispose();
				AjoutPersonnels.this.dispose();
			}
		});
		mnFichier.add(mntmFermer);

		JMenuItem mntmDeconecter = new JMenuItem("Deconnexion");
		mntmDeconecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				SingletonGestionPersonnels.getInstance().getEcran().dispose();
				AjoutPersonnels.this.dispose();
				EcranLogin el = new EcranLogin();
				el.setVisible(true);

			}
		});
		mnFichier.add(mntmDeconecter);

		JMenu mnGestionClients = new JMenu("Gestion des clients");
		menuBar.add(mnGestionClients);

		JMenuItem mntmNewMenuItem = new JMenuItem("Gerer les clients");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (SingletonMain.getInstance().getEcran().role.equals("AST")) {
					EcranGestionClients clients = new EcranGestionClients();
					clients.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
				}

			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionClients.add(mntmNewMenuItem);

		JMenu mnGestionPersonnels = new JMenu("Gestion du personnels");
		menuBar.add(mnGestionPersonnels);

		JMenuItem mntmGererPerso = new JMenuItem("Gerer le personnels");
		mntmGererPerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (SingletonMain.getInstance().getEcran().role.equals("PDA")) {
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
		mnGestionPersonnels.add(mntmGererPerso);

		this.setContentPane(panel);
	}
}
