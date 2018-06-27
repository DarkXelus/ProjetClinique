package fr.eni.clinique.ihm.clients;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
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

@SuppressWarnings("serial")
public class EcranGestionClients extends JFrame {
	private JTextField txtFieldCodeClient;
	private JTextField txtFieldNom;
	private JTextField txtFieldPrenom;
	private JTextField txtFieldAdresse;
	private JTextField textField;
	private JTextField textField_1;
	
	public EcranGestionClients() {
		super("Ecran de Gestion des Clients");
		setSize(810,340);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\search.png"));
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
				EcranAddClient ac = new EcranAddClient();
				ac.setVisible(true);
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\add (1).png"));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 6;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);
		
		JButton btnDelete = new JButton("Supprimer");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\rubbish-bin.png"));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 1;
		getContentPane().add(btnDelete, gbc_btnDelete);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\checked.png"));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 11;
		gbc_btnValider.gridy = 1;
		getContentPane().add(btnValider, gbc_btnValider);
		
		JButton btnSupprimer = new JButton("Annuler");
		btnSupprimer.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\back-arrow.png"));
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
		
		txtFieldCodeClient = new JTextField();
		GridBagConstraints gbc_txtFieldCodeClient = new GridBagConstraints();
		gbc_txtFieldCodeClient.gridwidth = 5;
		gbc_txtFieldCodeClient.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldCodeClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldCodeClient.gridx = 2;
		gbc_txtFieldCodeClient.gridy = 3;
		getContentPane().add(txtFieldCodeClient, gbc_txtFieldCodeClient);
		txtFieldCodeClient.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 4;
		getContentPane().add(lblNom, gbc_lblNom);
		
		txtFieldNom = new JTextField();
		GridBagConstraints gbc_txtFieldNom = new GridBagConstraints();
		gbc_txtFieldNom.gridwidth = 5;
		gbc_txtFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldNom.gridx = 2;
		gbc_txtFieldNom.gridy = 4;
		getContentPane().add(txtFieldNom, gbc_txtFieldNom);
		txtFieldNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.anchor = GridBagConstraints.EAST;
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 1;
		gbc_lblPrnom.gridy = 5;
		getContentPane().add(lblPrnom, gbc_lblPrnom);
		
		txtFieldPrenom = new JTextField();
		GridBagConstraints gbc_txtFieldPrenom = new GridBagConstraints();
		gbc_txtFieldPrenom.gridwidth = 5;
		gbc_txtFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldPrenom.gridx = 2;
		gbc_txtFieldPrenom.gridy = 5;
		getContentPane().add(txtFieldPrenom, gbc_txtFieldPrenom);
		txtFieldPrenom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 6;
		getContentPane().add(lblAdresse, gbc_lblAdresse);
		
		txtFieldAdresse = new JTextField();
		GridBagConstraints gbc_txtFieldAdresse = new GridBagConstraints();
		gbc_txtFieldAdresse.gridwidth = 5;
		gbc_txtFieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldAdresse.gridx = 2;
		gbc_txtFieldAdresse.gridy = 6;
		getContentPane().add(txtFieldAdresse, gbc_txtFieldAdresse);
		txtFieldAdresse.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code Postal:");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.anchor = GridBagConstraints.EAST;
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 1;
		gbc_lblCodePostal.gridy = 7;
		getContentPane().add(lblCodePostal, gbc_lblCodePostal);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 7;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville:");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.insets = new Insets(0, 0, 0, 5);
		gbc_lblVille.gridx = 1;
		gbc_lblVille.gridy = 8;
		getContentPane().add(lblVille, gbc_lblVille);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 8;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
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
	}

}
