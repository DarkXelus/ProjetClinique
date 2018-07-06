package fr.eni.clinique.ihm.clients;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.BO.Animaux;
import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.SingletonGestionClients;
import fr.eni.clinique.bll.SingletonMain;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.animaux.EcranGestionAnimaux;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;
import fr.eni.clinique.ihm.login.EcranLogin;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class EcranGestionClients extends JFrame {
	EcranGestionClients ecran = this;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAdresse1;
	private JTextField txtAdresse2;
	private JTextField txtCodePostal;
	private JTextField txtVille;
	private JTextField txtNumTel;
	private JTextField txtAssurance;
	private JTextField txtEmail;
	private JTextField txtRemarque;
	private JTable table;
	private JFrame frame;
	ClientsManager cm = new ClientsManager();

	public EcranGestionClients() {
		super("Ecran de Gestion des Clients");
		SingletonGestionClients.getInstance().setEcran(ecran);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EcranGestionClients.class.getResource("/fr/eni/clinique/ressource/ico_veto.png")));
		setSize(878, 430);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 140, 0, 0, 0, 0, 0, 94, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, -3, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClients search = new SearchClients();
				search.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 1;
		gbc_btnRechercher.gridy = 1;
		getContentPane().add(btnRechercher, gbc_btnRechercher);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjoutClient ac = new AjoutClient();
				ac.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 6;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);

		JButton btnDelete = new JButton("Supprimer");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 1;
		getContentPane().add(btnDelete, gbc_btnDelete);

		JButton btnValider = new JButton("Valider");
		btnValider.setEnabled(false);
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 12;
		gbc_btnValider.gridy = 1;
		getContentPane().add(btnValider, gbc_btnValider);
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setEnabled(false);
		
		JButton btnSupprimer = new JButton("Annuler");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomClient = table.getValueAt(table.getSelectedRow(), 0).toString();
				String prenomClient = table.getValueAt(table.getSelectedRow(), 1).toString();
				ClientsManager cm = new ClientsManager();
				try {
					Long Id = cm.GetID(nomClient, prenomClient);
					Clients client = cm.read(Id);
					txtNom.setText(client.getNomClient());
					txtPrenom.setText(client.getPrenomClient());
					txtAdresse1.setText(client.getAdresse1());
					txtAdresse2.setText(client.getAdresse2());
					txtCodePostal.setText(client.getCodePostal());
					txtVille.setText(client.getVille());
					txtNumTel.setText(client.getNumTel());
					txtAssurance.setText(client.getAssurance());
					txtEmail.setText(client.getEmail());
					txtRemarque.setText(client.getRemarque());
				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				EcranGestionClients.this.dispose();
			}
		});
		mnFichier.add(mntmFermer);

		JMenuItem mntmDeconecter = new JMenuItem("Deconnexion");
		mntmDeconecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				EcranGestionClients.this.dispose();
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


		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 13;
		gbc_btnSupprimer.gridy = 1;
		getContentPane().add(btnAnnuler, gbc_btnSupprimer);

		JLabel lblNom = new JLabel("Nom du Client:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 3;
		getContentPane().add(lblNom, gbc_lblNom);

		txtNom = new JTextField();
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 5;
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 3;
		getContentPane().add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom du Client:");
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.anchor = GridBagConstraints.EAST;
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 1;
		gbc_lblPrnom.gridy = 4;
		getContentPane().add(lblPrnom, gbc_lblPrnom);

		txtPrenom = new JTextField();
		GridBagConstraints gbc_txtPrenom = new GridBagConstraints();
		gbc_txtPrenom.gridwidth = 5;
		gbc_txtPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrenom.gridx = 2;
		gbc_txtPrenom.gridy = 4;
		getContentPane().add(txtPrenom, gbc_txtPrenom);
		txtPrenom.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse 1:");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 5;
		getContentPane().add(lblAdresse, gbc_lblAdresse);

		txtAdresse1 = new JTextField();
		GridBagConstraints gbc_txtAdresse1 = new GridBagConstraints();
		gbc_txtAdresse1.gridwidth = 5;
		gbc_txtAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdresse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresse1.gridx = 2;
		gbc_txtAdresse1.gridy = 5;
		getContentPane().add(txtAdresse1, gbc_txtAdresse1);
		txtAdresse1.setColumns(10);

		JLabel lblCodePostal = new JLabel("Adresse 2:");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.EAST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 1;
		gbc_lblCodePostal.gridy = 6;
		getContentPane().add(lblCodePostal, gbc_lblCodePostal);

		txtAdresse2 = new JTextField();
		GridBagConstraints gbc_txtAdresse2 = new GridBagConstraints();
		gbc_txtAdresse2.gridwidth = 5;
		gbc_txtAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdresse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresse2.gridx = 2;
		gbc_txtAdresse2.gridy = 6;
		getContentPane().add(txtAdresse2, gbc_txtAdresse2);
		txtAdresse2.setColumns(10);

		JLabel lblVille = new JLabel("Code Postal:");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 1;
		gbc_lblVille.gridy = 7;
		getContentPane().add(lblVille, gbc_lblVille);

		txtCodePostal = new JTextField();
		GridBagConstraints gbc_txtCodePostal = new GridBagConstraints();
		gbc_txtCodePostal.gridwidth = 5;
		gbc_txtCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodePostal.gridx = 2;
		gbc_txtCodePostal.gridy = 7;
		getContentPane().add(txtCodePostal, gbc_txtCodePostal);
		txtCodePostal.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ville:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		txtVille = new JTextField();
		GridBagConstraints gbc_txtVille = new GridBagConstraints();
		gbc_txtVille.gridwidth = 5;
		gbc_txtVille.insets = new Insets(0, 0, 5, 5);
		gbc_txtVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVille.gridx = 2;
		gbc_txtVille.gridy = 8;
		getContentPane().add(txtVille, gbc_txtVille);
		txtVille.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro t\u00E9l:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 9;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNumTel = new JTextField();
		GridBagConstraints gbc_txtNumTel = new GridBagConstraints();
		gbc_txtNumTel.gridwidth = 5;
		gbc_txtNumTel.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumTel.gridx = 2;
		gbc_txtNumTel.gridy = 9;
		getContentPane().add(txtNumTel, gbc_txtNumTel);
		txtNumTel.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Assurance:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtAssurance = new JTextField();
		GridBagConstraints gbc_txtAssurance = new GridBagConstraints();
		gbc_txtAssurance.gridwidth = 5;
		gbc_txtAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_txtAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAssurance.gridx = 2;
		gbc_txtAssurance.gridy = 10;
		getContentPane().add(txtAssurance, gbc_txtAssurance);
		txtAssurance.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 11;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 5;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 11;
		getContentPane().add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Remarque:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 12;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtRemarque = new JTextField();
		GridBagConstraints gbc_txtRemarque = new GridBagConstraints();
		gbc_txtRemarque.gridwidth = 5;
		gbc_txtRemarque.insets = new Insets(0, 0, 5, 5);
		gbc_txtRemarque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRemarque.gridx = 2;
		gbc_txtRemarque.gridy = 12;
		getContentPane().add(txtRemarque, gbc_txtRemarque);
		txtRemarque.setColumns(10);
	}

	// Constructeur appelé avec un client en paramètre

	public EcranGestionClients(Clients cli) {
		super("Ecran de Gestion des Clients");
		Clients client = cli;

		setSize(880, 500);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClients search = new SearchClients();
				search.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 1;
		gbc_btnRechercher.gridy = 1;
		getContentPane().add(btnRechercher, gbc_btnRechercher);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjoutClient ac = new AjoutClient();
				ac.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 6;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);

		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cm.delete(client);
					JOptionPane.showMessageDialog(frame, "Client supprimé");
					EcranGestionClients.this.dispose();
					EcranGestionClients eg = new EcranGestionClients();
					eg.setVisible(true);

				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}

			}
		});

		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 1;
		getContentPane().add(btnDelete, gbc_btnDelete);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				EcranGestionClients.this.dispose();
			}
		});
		mnFichier.add(mntmFermer);

		JMenuItem mntmDeconecter = new JMenuItem("Deconnexion");
		mntmDeconecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				EcranGestionClients.this.dispose();
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

		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Clients client = new Clients(txtNom.getText(), txtPrenom.getText(), txtAdresse1.getText(),
							txtAdresse2.getText(), txtCodePostal.getText(), txtVille.getText(), txtNumTel.getText(),
							txtAssurance.getText(), txtEmail.getText(), txtRemarque.getText(), false);
					cm.update(client);
					EcranGestionClients.this.dispose();
					EcranGestionClients clients = new EcranGestionClients();
					clients.setVisible(true);
					clients.setLocationRelativeTo(null);
					JOptionPane.showMessageDialog(frame, "Modification effectué");
				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 11;
		gbc_btnValider.gridy = 1;
		getContentPane().add(btnValider, gbc_btnValider);

		JButton btnSupprimer = new JButton("Annuler");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNom.setText(client.getNomClient());
				txtPrenom.setText(client.getPrenomClient());
				txtAdresse1.setText(client.getAdresse1());
				txtAdresse2.setText(client.getAdresse2());
				txtCodePostal.setText(client.getCodePostal());
				txtVille.setText(client.getVille());
				txtNumTel.setText(client.getNumTel());
				txtAssurance.setText(client.getAssurance());
				txtEmail.setText(client.getEmail());
				txtRemarque.setText(client.getRemarque());
			}
		});

		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridx = 12;
		gbc_btnSupprimer.gridy = 1;
		getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranGestionAnimaux ega = new EcranGestionAnimaux(cli.getCodeClient());
				ega.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 2;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setEnabled(false);
		btnSupprimer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "A venir");
			}
		});
		GridBagConstraints gbc_btnSupprimer_1 = new GridBagConstraints();
		gbc_btnSupprimer_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer_1.gridx = 11;
		gbc_btnSupprimer_1.gridy = 2;
		getContentPane().add(btnSupprimer_1, gbc_btnSupprimer_1);

		JButton btnEditer = new JButton("Editer");
		btnEditer.setEnabled(false);
		btnEditer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "A venir");
			}
		});
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditer.gridx = 12;
		gbc_btnEditer.gridy = 2;
		getContentPane().add(btnEditer, gbc_btnEditer);

		JLabel lblNom = new JLabel("Nom du Client:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 4;
		getContentPane().add(lblNom, gbc_lblNom);

		txtNom = new JTextField(client.getNomClient());
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 5;
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 4;
		getContentPane().add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);

		table = new JTable(initTableModel(client));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				btnSupprimer_1.setEnabled(true);
				btnEditer.setEnabled(true);
				Long codeAnimal = (Long) table.getValueAt(table.getSelectedRow(),0);
				try {
					Animaux ani = cm.selectAnimal(codeAnimal);
					EcranGestionAnimaux ega = new EcranGestionAnimaux(cli.getCodeClient());
					
					} catch (DALException | BLLException e) {
					e.printStackTrace();
				}

			}
		});
		table.setBorder(null);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 11;
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 8;
		gbc_table.gridy = 4;
		getContentPane().add(table, gbc_table);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom du Client:");
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.anchor = GridBagConstraints.EAST;
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 1;
		gbc_lblPrnom.gridy = 5;
		getContentPane().add(lblPrnom, gbc_lblPrnom);

		txtPrenom = new JTextField(client.getPrenomClient());
		GridBagConstraints gbc_txtPrenom = new GridBagConstraints();
		gbc_txtPrenom.gridwidth = 5;
		gbc_txtPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrenom.gridx = 2;
		gbc_txtPrenom.gridy = 5;
		getContentPane().add(txtPrenom, gbc_txtPrenom);
		txtPrenom.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse 1:");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 6;
		getContentPane().add(lblAdresse, gbc_lblAdresse);

		txtAdresse1 = new JTextField(client.getAdresse1());
		GridBagConstraints gbc_txtAdresse1 = new GridBagConstraints();
		gbc_txtAdresse1.gridwidth = 5;
		gbc_txtAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdresse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresse1.gridx = 2;
		gbc_txtAdresse1.gridy = 6;
		getContentPane().add(txtAdresse1, gbc_txtAdresse1);
		txtAdresse1.setColumns(10);

		JLabel lblCodePostal = new JLabel("Adresse 2:");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.EAST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 1;
		gbc_lblCodePostal.gridy = 7;
		getContentPane().add(lblCodePostal, gbc_lblCodePostal);

		txtAdresse2 = new JTextField(client.getAdresse2());
		GridBagConstraints gbc_txtAdresse2 = new GridBagConstraints();
		gbc_txtAdresse2.gridwidth = 5;
		gbc_txtAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdresse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresse2.gridx = 2;
		gbc_txtAdresse2.gridy = 7;
		getContentPane().add(txtAdresse2, gbc_txtAdresse2);
		txtAdresse2.setColumns(10);

		JLabel lblVille = new JLabel("Code Postal:");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 1;
		gbc_lblVille.gridy = 8;
		getContentPane().add(lblVille, gbc_lblVille);

		txtCodePostal = new JTextField(client.getCodePostal());
		GridBagConstraints gbc_txtCodePostal = new GridBagConstraints();
		gbc_txtCodePostal.gridwidth = 5;
		gbc_txtCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodePostal.gridx = 2;
		gbc_txtCodePostal.gridy = 8;
		getContentPane().add(txtCodePostal, gbc_txtCodePostal);
		txtCodePostal.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ville:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		txtVille = new JTextField(client.getVille());
		GridBagConstraints gbc_txtVille = new GridBagConstraints();
		gbc_txtVille.gridwidth = 5;
		gbc_txtVille.insets = new Insets(0, 0, 5, 5);
		gbc_txtVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVille.gridx = 2;
		gbc_txtVille.gridy = 9;
		getContentPane().add(txtVille, gbc_txtVille);
		txtVille.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro t\u00E9l:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 10;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNumTel = new JTextField(client.getNumTel());
		GridBagConstraints gbc_txtNumTel = new GridBagConstraints();
		gbc_txtNumTel.gridwidth = 5;
		gbc_txtNumTel.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumTel.gridx = 2;
		gbc_txtNumTel.gridy = 10;
		getContentPane().add(txtNumTel, gbc_txtNumTel);
		txtNumTel.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Assurance:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 11;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtAssurance = new JTextField(client.getAssurance());
		GridBagConstraints gbc_txtAssurance = new GridBagConstraints();
		gbc_txtAssurance.gridwidth = 5;
		gbc_txtAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_txtAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAssurance.gridx = 2;
		gbc_txtAssurance.gridy = 11;
		getContentPane().add(txtAssurance, gbc_txtAssurance);
		txtAssurance.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 12;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtEmail = new JTextField(client.getEmail());
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 5;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 12;
		getContentPane().add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Remarque:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 13;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtRemarque = new JTextField(client.getRemarque());
		GridBagConstraints gbc_txtRemarque = new GridBagConstraints();
		gbc_txtRemarque.gridwidth = 5;
		gbc_txtRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_txtRemarque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRemarque.gridx = 2;
		gbc_txtRemarque.gridy = 13;
		getContentPane().add(txtRemarque, gbc_txtRemarque);
		txtRemarque.setColumns(10);
	}

	private TableModel initTableModel(Clients client) {
		Long codeclient = client.getCodeClient();
		ClientsManager cm = new ClientsManager();

		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 7;
			}

			public int getRowCount() {
				int cnt = 0;
				try {
					cnt = cm.selectAnimauxClient(codeclient).size();
				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
				return cnt;
			}

			public Object getValueAt(int row, int col) {
				List<Animaux> lstAnimaux = new ArrayList<Animaux>();
				try {
					lstAnimaux = cm.selectAnimauxClient(codeclient);
					if (lstAnimaux.size() == 0) {
						System.out.println("erreur");
					}
					switch (col) {
					case 0:
						return lstAnimaux.get(row).getCodeAnimal();
					case 1:
						return lstAnimaux.get(row).getNomAnimal();
					case 2:
						return lstAnimaux.get(row).getSexe();
					case 3:
						return lstAnimaux.get(row).getCouleur();
					case 4:
						return lstAnimaux.get(row).getRace();
					case 5:
						return lstAnimaux.get(row).getEspece();
					case 6:
						return lstAnimaux.get(row).getTatouage();
					default:
						break;
					}
				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
				return ("erreur");
			}
		};
		return dataModel;
	}

}
