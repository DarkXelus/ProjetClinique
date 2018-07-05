package fr.eni.clinique.ihm.animaux;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import fr.eni.clinique.BO.Animaux;
import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.clients.EcranGestionClients;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class EcranGestionAnimaux extends JFrame {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	String[] sex = { "F", "H", "M"};
	String[] espece = { "Chien","Chat"};
	ClientsManager cm = new ClientsManager();
	List<Clients> lstClients = new ArrayList<Clients>();
	private JTextField textField_4;
	
	public EcranGestionAnimaux()
	{
		super("Ajout d'un animal"); 
		setSize(new Dimension(670, 330));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 40, 100, 78, 60, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(EcranGestionAnimaux.class.getResource("/fr/eni/clinique/ressource/checked.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 1;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(EcranGestionAnimaux.class.getResource("/fr/eni/clinique/ressource/back-arrow.png")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 1;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblClient = new JLabel("Client:");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 1;
		gbc_lblClient.gridy = 2;
		getContentPane().add(lblClient, gbc_lblClient);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 5;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox comboSex = new JComboBox(sex);
		comboSex.setSelectedIndex(0);
		GridBagConstraints gbc_comboSex = new GridBagConstraints();
		gbc_comboSex.gridwidth = 3;
		gbc_comboSex.insets = new Insets(0, 0, 5, 5);
		gbc_comboSex.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSex.gridx = 6;
		gbc_comboSex.gridy = 5;
		getContentPane().add(comboSex, gbc_comboSex);
		
		JLabel lblNewLabel_2 = new JLabel("Couleur");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 6;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Esp\u00E8ce");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 7;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox comboEspece = new JComboBox(espece);
		comboEspece.setSelectedIndex(0);
		GridBagConstraints gbc_comboEspece = new GridBagConstraints();
		gbc_comboEspece.insets = new Insets(0, 0, 5, 5);
		gbc_comboEspece.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboEspece.gridx = 2;
		gbc_comboEspece.gridy = 7;
		getContentPane().add(comboEspece, gbc_comboEspece);
		
		JLabel lblNewLabel_5 = new JLabel("Race");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 7;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JComboBox comboRace = new JComboBox();
		GridBagConstraints gbc_comboRace = new GridBagConstraints();
		gbc_comboRace.gridwidth = 3;
		gbc_comboRace.insets = new Insets(0, 0, 5, 5);
		gbc_comboRace.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboRace.gridx = 5;
		gbc_comboRace.gridy = 7;
		getContentPane().add(comboRace, gbc_comboRace);
		
		JLabel lblNewLabel_4 = new JLabel("Tatouage");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 8;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAntcdent = new JLabel("Ant\u00E9c\u00E9dents");
		GridBagConstraints gbc_lblAntcdent = new GridBagConstraints();
		gbc_lblAntcdent.anchor = GridBagConstraints.EAST;
		gbc_lblAntcdent.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntcdent.gridx = 1;
		gbc_lblAntcdent.gridy = 9;
		getContentPane().add(lblAntcdent, gbc_lblAntcdent);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 9;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
	
	}
	
	
}
