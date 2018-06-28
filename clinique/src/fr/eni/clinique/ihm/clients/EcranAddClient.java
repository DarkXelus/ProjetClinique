package fr.eni.clinique.ihm.clients;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EcranAddClient extends JFrame {
	
	private JTextField txtFieldNom;
	private JTextField txtFieldPrenom;
	private JTextField txtFieldAdresse;
	private JTextField txtFieldCodePostal;
	private JTextField txtFieldNumTel;
	private JTextField txtFieldVille;
	private JTextField txtFieldAssurance;
	private JTextField txtFieldEmail;
	private JTextField txtFieldRemarque;
	
	public EcranAddClient() {
		super("Ajouter un nouveau client");
		setSize(650,400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 122, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnAdd = new JButton("Valider");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\checked.png"));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 14;
		gbc_btnAdd.gridy = 1;
		getContentPane().add(btnAdd, gbc_btnAdd);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\back-arrow.png"));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 16;
		gbc_btnCancel.gridy = 1;
		getContentPane().add(btnCancel, gbc_btnCancel);
		
		JLabel lblNom = new JLabel("Nom:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 3;
		gbc_lblNom.gridy = 3;
		getContentPane().add(lblNom, gbc_lblNom);
		
		txtFieldNom = new JTextField();
		txtFieldNom.setColumns(10);
		GridBagConstraints gbc_txtFieldNom = new GridBagConstraints();
		gbc_txtFieldNom.gridwidth = 8;
		gbc_txtFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldNom.gridx = 5;
		gbc_txtFieldNom.gridy = 3;
		getContentPane().add(txtFieldNom, gbc_txtFieldNom);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom:");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 3;
		gbc_lblPrenom.gridy = 4;
		getContentPane().add(lblPrenom, gbc_lblPrenom);
		
		txtFieldPrenom = new JTextField();
		txtFieldPrenom.setColumns(10);
		GridBagConstraints gbc_txtFieldPrenom = new GridBagConstraints();
		gbc_txtFieldPrenom.gridwidth = 8;
		gbc_txtFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldPrenom.gridx = 5;
		gbc_txtFieldPrenom.gridy = 4;
		getContentPane().add(txtFieldPrenom, gbc_txtFieldPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 3;
		gbc_lblAdresse.gridy = 5;
		getContentPane().add(lblAdresse, gbc_lblAdresse);
		
		txtFieldAdresse = new JTextField();
		txtFieldAdresse.setColumns(10);
		GridBagConstraints gbc_txtFieldAdresse = new GridBagConstraints();
		gbc_txtFieldAdresse.gridwidth = 8;
		gbc_txtFieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldAdresse.gridx = 5;
		gbc_txtFieldAdresse.gridy = 5;
		getContentPane().add(txtFieldAdresse, gbc_txtFieldAdresse);
		
		JLabel lblCodePostal = new JLabel("Code Postal:");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 3;
		gbc_lblCodePostal.gridy = 6;
		getContentPane().add(lblCodePostal, gbc_lblCodePostal);
		
		txtFieldCodePostal = new JTextField();
		GridBagConstraints gbc_txtFieldCodePostal = new GridBagConstraints();
		gbc_txtFieldCodePostal.gridwidth = 8;
		gbc_txtFieldCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldCodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldCodePostal.gridx = 5;
		gbc_txtFieldCodePostal.gridy = 6;
		getContentPane().add(txtFieldCodePostal, gbc_txtFieldCodePostal);
		txtFieldCodePostal.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville:");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 3;
		gbc_lblVille.gridy = 7;
		getContentPane().add(lblVille, gbc_lblVille);
		
		txtFieldVille = new JTextField();
		GridBagConstraints gbc_txtFieldVille = new GridBagConstraints();
		gbc_txtFieldVille.gridwidth = 8;
		gbc_txtFieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldVille.gridx = 5;
		gbc_txtFieldVille.gridy = 7;
		getContentPane().add(txtFieldVille, gbc_txtFieldVille);
		txtFieldVille.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 8;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtFieldNumTel = new JTextField();
		GridBagConstraints gbc_txtFieldNumTel = new GridBagConstraints();
		gbc_txtFieldNumTel.gridwidth = 9;
		gbc_txtFieldNumTel.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldNumTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldNumTel.gridx = 4;
		gbc_txtFieldNumTel.gridy = 8;
		getContentPane().add(txtFieldNumTel, gbc_txtFieldNumTel);
		txtFieldNumTel.setColumns(10);
		
		JLabel lblAssurance = new JLabel("Assurance:");
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 3;
		gbc_lblAssurance.gridy = 9;
		getContentPane().add(lblAssurance, gbc_lblAssurance);
		
		txtFieldAssurance = new JTextField();
		GridBagConstraints gbc_txtFieldAssurance = new GridBagConstraints();
		gbc_txtFieldAssurance.gridwidth = 8;
		gbc_txtFieldAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldAssurance.gridx = 5;
		gbc_txtFieldAssurance.gridy = 9;
		getContentPane().add(txtFieldAssurance, gbc_txtFieldAssurance);
		txtFieldAssurance.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 3;
		gbc_lblEmail.gridy = 10;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		txtFieldEmail = new JTextField();
		GridBagConstraints gbc_txtFieldEmail = new GridBagConstraints();
		gbc_txtFieldEmail.gridwidth = 7;
		gbc_txtFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldEmail.gridx = 6;
		gbc_txtFieldEmail.gridy = 10;
		getContentPane().add(txtFieldEmail, gbc_txtFieldEmail);
		txtFieldEmail.setColumns(10);
		
		JLabel lblRemarque = new JLabel("Remarque:");
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_lblRemarque.gridx = 3;
		gbc_lblRemarque.gridy = 11;
		getContentPane().add(lblRemarque, gbc_lblRemarque);
		
		txtFieldRemarque = new JTextField();
		GridBagConstraints gbc_txtFieldRemarque = new GridBagConstraints();
		gbc_txtFieldRemarque.gridwidth = 7;
		gbc_txtFieldRemarque.insets = new Insets(0, 0, 0, 5);
		gbc_txtFieldRemarque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldRemarque.gridx = 6;
		gbc_txtFieldRemarque.gridy = 11;
		getContentPane().add(txtFieldRemarque, gbc_txtFieldRemarque);
		txtFieldRemarque.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGnral = new JMenu("G\u00E9n\u00E9ral");
		menuBar.add(mnGnral);
		
		JLabel lblDconnexion = new JLabel("D\u00E9connexion");
		mnGnral.add(lblDconnexion);
		
		JLabel lblFermer = new JLabel("Fermer");
		mnGnral.add(lblFermer);
		
		JMenu mnClient = new JMenu("Client");
		menuBar.add(mnClient);
		
		JLabel lblGrerLesClients = new JLabel("G\u00E9rer les clients");
		mnClient.add(lblGrerLesClients);
		
		JMenu mnPersonnel = new JMenu("Personnel");
		menuBar.add(mnPersonnel);
		
		JLabel lblGrerPersonnel = new JLabel("G\u00E9rer le personnel");
		mnPersonnel.add(lblGrerPersonnel);
		
	}

}
