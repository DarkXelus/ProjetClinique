package fr.eni.clinique.ihm.animaux;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.BO.Animaux;
import fr.eni.clinique.BO.Animaux.Sex;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.dal.DALException;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class EcranGestionAnimaux extends JFrame {
	private JTextField txtCouleur;
	private JTextField txtNom;
	private JTextField txtTatouage;
	private JTextField txtAntecedents;
	String[] sex = { "F", "H", "M" };
	String[] espece = { "Chien", "Chat" };
	ClientsManager cm = new ClientsManager();
	List<String> lstRace = new ArrayList<String>();
	private JTextField txtClient;
	String resultSex = "";
	String resultEspece = "";
	String resultRace = "";
	static JFrame frame;

	public EcranGestionAnimaux() {
		super("Ajout d'un animal");
		setSize(new Dimension(670, 330));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 40, 100, 78, 60, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setIcon(
				new ImageIcon(EcranGestionAnimaux.class.getResource("/fr/eni/clinique/ressource/checked.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 1;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranGestionAnimaux.this.dispose();
			}
		});
		btnNewButton_1.setIcon(
				new ImageIcon(EcranGestionAnimaux.class.getResource("/fr/eni/clinique/ressource/back-arrow.png")));
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

		txtClient = new JTextField();
		GridBagConstraints gbc_txtClient = new GridBagConstraints();
		gbc_txtClient.gridwidth = 5;
		gbc_txtClient.insets = new Insets(0, 0, 5, 5);
		gbc_txtClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClient.gridx = 1;
		gbc_txtClient.gridy = 3;
		getContentPane().add(txtClient, gbc_txtClient);
		txtClient.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nom");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNom = new JTextField();
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 3;
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 2;
		gbc_txtNom.gridy = 5;
		getContentPane().add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);

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

		txtCouleur = new JTextField();
		GridBagConstraints gbc_txtCouleur = new GridBagConstraints();
		gbc_txtCouleur.gridwidth = 3;
		gbc_txtCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_txtCouleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCouleur.gridx = 2;
		gbc_txtCouleur.gridy = 6;
		getContentPane().add(txtCouleur, gbc_txtCouleur);
		txtCouleur.setColumns(10);

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
		resultEspece = comboSex.getSelectedItem().toString();

		JLabel lblNewLabel_5 = new JLabel("Race");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 7;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		String[] array = {};
		try {
			String espece = comboEspece.getSelectedItem().toString();
			lstRace = cm.selectRaces(espece);
			array = new String[lstRace.size()];
			for (int i = 0; i < lstRace.size(); i++) {
				array[i] = lstRace.get(i);
			}
		} catch (DALException | BLLException e) {
			e.printStackTrace();
		}
		JComboBox comboRace = new JComboBox(array);
		GridBagConstraints gbc_comboRace = new GridBagConstraints();
		gbc_comboRace.gridwidth = 3;
		gbc_comboRace.insets = new Insets(0, 0, 5, 5);
		gbc_comboRace.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboRace.gridx = 5;
		gbc_comboRace.gridy = 7;
		getContentPane().add(comboRace, gbc_comboRace);
		comboEspece.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String espece = comboEspece.getSelectedItem().toString();
				String[] array = {};
				try {
					lstRace = cm.selectRaces(espece);
					array = new String[lstRace.size()];
					for (int i = 0; i < lstRace.size(); i++) {
						array[i] = lstRace.get(i);
					}
					comboRace.setModel(new DefaultComboBoxModel(array));
				} catch (DALException | BLLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel lblNewLabel_4 = new JLabel("Tatouage");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtTatouage = new JTextField();
		GridBagConstraints gbc_txtTatouage = new GridBagConstraints();
		gbc_txtTatouage.gridwidth = 3;
		gbc_txtTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_txtTatouage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTatouage.gridx = 2;
		gbc_txtTatouage.gridy = 8;
		getContentPane().add(txtTatouage, gbc_txtTatouage);
		txtTatouage.setColumns(10);

		JLabel lblAntcdent = new JLabel("Ant\u00E9c\u00E9dents");
		GridBagConstraints gbc_lblAntcdent = new GridBagConstraints();
		gbc_lblAntcdent.anchor = GridBagConstraints.EAST;
		gbc_lblAntcdent.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntcdent.gridx = 1;
		gbc_lblAntcdent.gridy = 9;
		getContentPane().add(lblAntcdent, gbc_lblAntcdent);

		txtAntecedents = new JTextField();
		GridBagConstraints gbc_txtAntecedents = new GridBagConstraints();
		gbc_txtAntecedents.gridwidth = 3;
		gbc_txtAntecedents.insets = new Insets(0, 0, 5, 5);
		gbc_txtAntecedents.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAntecedents.gridx = 2;
		gbc_txtAntecedents.gridy = 9;
		getContentPane().add(txtAntecedents, gbc_txtAntecedents);
		txtAntecedents.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientsManager cm = new ClientsManager();
				Sex var = null;
				try {
					resultSex = comboSex.getSelectedItem().toString();
					resultEspece = comboEspece.getSelectedItem().toString();
					resultRace = comboRace.getSelectedItem().toString();
					if (!txtNom.getText().equals("") && !txtCouleur.getText().equals("")) {
						switch (resultSex) {
						case "F":
							var = Sex.F;
							break;
						case "H":
							var = Sex.H;
							break;
						case "M":
							var = Sex.M;
						default:
							break;
						}
						Long id = (long) 20 ;
						Animaux ani = new Animaux(txtNom.getText(), var, txtCouleur.getText(), resultRace, resultEspece,
								txtTatouage.getText(), txtAntecedents.getText(), false, id);
						cm.createAnimaux(ani);
						EcranGestionAnimaux.this.dispose();
						JOptionPane.showMessageDialog(frame, "Ajout éffectué");
					} else {
						JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs obligatoire");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
			}
		});
	}

}
