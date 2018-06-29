package fr.eni.clinique.ihm.clients;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.ClientsManager;

@SuppressWarnings("serial")
public class AjoutClient extends JFrame {
	static JFrame frame;
	JLabel lblNom, lblPrenom, lblAdresse1, lblAdresse2, lblCodePostal, lblVille, lblNumTel, lblAssurance, lblEmail,
			lblRemarque;
	JTextField txtNom, txtPrenom, txtAdresse1, txtAdresse2, txtCodePostal, txtVille, txtNumTel, txtAssurance, txtEmail,
			txtRemarque;
	JButton btnValider, btnAnnuler;

	public AjoutClient() {
		super("Ajout d'un nouveau client");
		setSize(600, 375);
		setLocationRelativeTo(null);
		setVisible(true);
		initIHM();
	}

	public JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom:* ");
		}
		return lblNom;
	}

	public JLabel getLblPrenom() {
		if (lblPrenom == null) {
			lblPrenom = new JLabel("Prénom:* ");
		}
		return lblPrenom;
	}

	public JLabel getLblAdresse1() {
		if (lblAdresse1 == null) {
			lblAdresse1 = new JLabel("Adresse1:* ");
		}
		return lblAdresse1;
	}

	public JLabel getLblAdresse2() {
		if (lblAdresse2 == null) {
			lblAdresse2 = new JLabel("Adresse2: ");
		}
		return lblAdresse2;
	}

	public JLabel getLblCodePostal() {
		if (lblCodePostal == null) {
			lblCodePostal = new JLabel("Code Postal:* ");
		}
		return lblCodePostal;
	}

	public JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville:* ");
		}
		return lblVille;
	}

	public JLabel getLblNumTel() {
		if (lblNumTel == null) {
			lblNumTel = new JLabel("Numéro Téléphone:* ");
		}
		return lblNumTel;
	}

	public JLabel getLblAssurance() {
		if (lblAssurance == null) {
			lblAssurance = new JLabel("Assurance:* ");
		}
		return lblAssurance;
	}

	public JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:* ");
		}
		return lblEmail;
	}

	public JLabel getLblRemarque() {
		if (lblRemarque == null) {
			lblRemarque = new JLabel("Remarque: ");
		}
		return lblRemarque;
	}

	public JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField(20);
			txtNom.setBounds(5, 5, 30, 25);
		}
		return txtNom;
	}

	public JTextField getTxtPrenom() {
		if (txtPrenom == null) {
			txtPrenom = new JTextField(20);
			txtPrenom.setBounds(5, 5, 30, 25);
		}
		return txtPrenom;
	}

	public JTextField getTxtAdresse1() {
		if (txtAdresse1 == null) {
			txtAdresse1 = new JTextField(20);
			txtAdresse1.setBounds(5, 5, 30, 25);
		}
		return txtAdresse1;
	}

	public JTextField getTxtAdresse2() {
		if (txtAdresse2 == null) {
			txtAdresse2 = new JTextField(20);
			txtAdresse2.setBounds(5, 5, 30, 25);
		}
		return txtAdresse2;
	}

	public JTextField getTxtCodePostal() {
		if (txtCodePostal == null) {
			txtCodePostal = new JTextField(20);
			txtCodePostal.setBounds(5, 5, 30, 25);
		}
		return txtCodePostal;
	}

	public JTextField getTxtVille() {
		if (txtVille == null) {
			txtVille = new JTextField(20);
			txtVille.setBounds(5, 5, 30, 25);
		}
		return txtVille;
	}

	public JTextField getTxtNumTel() {
		if (txtNumTel == null) {
			txtNumTel = new JTextField(20);
			txtNumTel.setBounds(5, 5, 30, 25);
		}
		return txtNumTel;
	}

	public JTextField getTxtAssurance() {
		if (txtAssurance == null) {
			txtAssurance = new JTextField(20);
			txtAssurance.setBounds(5, 5, 30, 25);
		}
		return txtAssurance;
	}

	public JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField(20);
			txtEmail.setBounds(5, 5, 30, 25);
		}
		return txtEmail;
	}

	public JTextField getTxtRemarque() {
		if (txtRemarque == null) {
			txtRemarque = new JTextField(20);
			txtRemarque.setBounds(5, 5, 30, 25);
		}
		return txtRemarque;
	}

	public JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.setIcon(new ImageIcon(
					"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\checked.png"));
			btnValider.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					ClientsManager cm = new ClientsManager();
					try {
						if (txtNom.getText() != null || txtPrenom.getText() != null || txtAdresse1.getText() != null ||
								txtCodePostal.getText() != null || txtVille.getText() != null ||
								txtNumTel.getText() != null || txtAssurance.getText() != null ||
								txtEmail.getText() != null) {
							Clients cli = new Clients(txtNom.getText(), txtPrenom.getText(), txtAdresse1.getText(),
									txtAdresse2.getText(), txtCodePostal.getText(), txtVille.getText(),
									txtNumTel.getText(), txtAssurance.getText(), txtEmail.getText(),
									txtRemarque.getText(), false);

							cm.create(cli);
							AjoutClient.this.dispose();
							JOptionPane.showMessageDialog(frame, "Ajout éffectué");
						} else {
							JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs obligatoire");
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, e.getMessage());
					}
				}
			});
		}
		return btnValider;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.setIcon(new ImageIcon(
					"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\back-arrow.png"));
			btnAnnuler.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					EcranGestionClients back = new EcranGestionClients();
					back.setVisible(true);
					AjoutClient.this.dispose();
				}
			});
		}
		return btnAnnuler;
	}

	private void initIHM() {
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 2;
		panel.add(getBtnValider(), gbc);

		gbc.gridx = 3;
		panel.add(getBtnAnnuler(), gbc);

		// Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;

		// Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		panel.add(getLblNom(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtNom(), gbc);

		// Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 0;
		panel.add(getLblPrenom(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtPrenom(), gbc);

		// Ligne 5
		gbc.gridy = 4;
		gbc.gridx = 0;
		panel.add(getLblAdresse1(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtAdresse1(), gbc);

		// Ligne 6
		gbc.gridy = 5;
		gbc.gridx = 0;
		panel.add(getLblAdresse2(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtAdresse2(), gbc);

		// Ligne 7
		gbc.gridy = 6;
		gbc.gridx = 0;
		panel.add(getLblCodePostal(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtCodePostal(), gbc);

		// Ligne 8
		gbc.gridy = 7;
		gbc.gridx = 0;
		panel.add(getLblVille(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtVille(), gbc);

		// Ligne 9
		gbc.gridy = 8;
		gbc.gridx = 0;
		panel.add(getLblNumTel(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtNumTel(), gbc);

		// Ligne 10
		gbc.gridy = 9;
		gbc.gridx = 0;
		panel.add(getLblAssurance(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtAssurance(), gbc);

		// Ligne 11
		gbc.gridy = 10;
		gbc.gridx = 0;
		panel.add(getLblEmail(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtEmail(), gbc);

		// Ligne 12
		gbc.gridy = 11;
		gbc.gridx = 0;
		panel.add(getLblRemarque(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtRemarque(), gbc);

		this.setContentPane(panel);
	}
}
