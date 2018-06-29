package fr.eni.clinique.ihm.clients;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.login.EcranLogin;
import fr.eni.clinique.ihm.login.EcranMain;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class EcranGestionClients extends JFrame {
	private JTextField txtCodeClient;
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

	public EcranGestionClients() {
		super("Ecran de Gestion des Clients");
		setSize(878, 430);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setIcon(new ImageIcon(
				"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\search.png"));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAdd.setIcon(new ImageIcon(
				"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\add (1).png"));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 6;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);

		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientsManager cm = new ClientsManager();
				try {
					Clients client = cm.SelectAll().get(table.getSelectedRow());
					cm.delete(client);
					table = new JTable(initTableModel());
				} catch (DALException | BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\rubbish-bin.png"));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 1;
		getContentPane().add(btnDelete, gbc_btnDelete);

		JButton btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon(
				"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\checked.png"));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 11;
		gbc_btnValider.gridy = 1;
		getContentPane().add(btnValider, gbc_btnValider);

		JButton btnSupprimer = new JButton("Annuler");
		btnSupprimer.setIcon(new ImageIcon(
				"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\back-arrow.png"));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridx = 12;
		gbc_btnSupprimer.gridy = 1;
		getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		JLabel lblCodeClient = new JLabel("Code Client:");
		GridBagConstraints gbc_lblCodeClient = new GridBagConstraints();
		gbc_lblCodeClient.anchor = GridBagConstraints.EAST;
		gbc_lblCodeClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeClient.gridx = 1;
		gbc_lblCodeClient.gridy = 3;
		getContentPane().add(lblCodeClient, gbc_lblCodeClient);

		txtCodeClient = new JTextField();
		GridBagConstraints gbc_txtCodeClient = new GridBagConstraints();
		gbc_txtCodeClient.gridwidth = 5;
		gbc_txtCodeClient.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodeClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodeClient.gridx = 2;
		gbc_txtCodeClient.gridy = 3;
		getContentPane().add(txtCodeClient, gbc_txtCodeClient);
		txtCodeClient.setColumns(10);

		JLabel lblNom = new JLabel("Nom du Client:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 4;
		getContentPane().add(lblNom, gbc_lblNom);

		txtNom = new JTextField();
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 5;
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 4;
		getContentPane().add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		
		table = new JTable(initTableModel());
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// System.out.println(table.getValueAt(table.getSelectedRow(),
				// 0).toString());
				String nomClient = table.getValueAt(table.getSelectedRow(), 0).toString();
				String prenomClient = table.getValueAt(table.getSelectedRow(), 1).toString();
				ClientsManager cm = new ClientsManager();
				try {
					Long Id = cm.GetID(nomClient, prenomClient);
					Clients client = cm.read(Id);
					txtCodeClient.setText(Id.toString());
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
					// TODO Auto-generated catch block
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

		txtPrenom = new JTextField();
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

		txtAdresse1 = new JTextField();
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

		txtAdresse2 = new JTextField();
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

		txtCodePostal = new JTextField();
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

		txtVille = new JTextField();
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

		txtNumTel = new JTextField();
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

		txtAssurance = new JTextField();
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

		txtEmail = new JTextField();
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

		txtRemarque = new JTextField();
		GridBagConstraints gbc_txtRemarque = new GridBagConstraints();
		gbc_txtRemarque.gridwidth = 5;
		gbc_txtRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_txtRemarque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRemarque.gridx = 2;
		gbc_txtRemarque.gridy = 13;
		getContentPane().add(txtRemarque, gbc_txtRemarque);
		txtRemarque.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnGnral = new JMenu("G\u00E9n\u00E9ral");
		menuBar.add(mnGnral);

		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mntmDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranLogin login = new EcranLogin();
				login.setVisible(true);
				EcranGestionClients.this.dispose();
			}
		});
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
	}

	private TableModel initTableModel() {
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 5;
			}

			public int getRowCount() {
				ClientsManager cm = new ClientsManager();
				int cnt = 0;
				try {
					cnt = cm.SelectAll().size();
				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
				return cnt;
			}

			public Object getValueAt(int row, int col) {
				ClientsManager cm = new ClientsManager();
				List<Clients> lstClient = new ArrayList<Clients>();
				try {
					lstClient = cm.SelectAll();
					switch (col) {
					case 0:
						return lstClient.get(row).getNomClient();
					case 1:
						return lstClient.get(row).getPrenomClient();
					case 2:
						return lstClient.get(row).getNumTel();
					case 3:
						return lstClient.get(row).getEmail();
					case 4:
						return lstClient.get(row).getAssurance();
					default:
						break;
					}
				} catch (DALException | BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ("erreur");
			}
		};
		return dataModel;
	}

}
