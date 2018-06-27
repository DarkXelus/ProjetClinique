package fr.eni.clinique.ihm.Personnels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.PersonnelsManager;

@SuppressWarnings("serial")
public class AjoutPersonnels extends JFrame {
	static JFrame frame;
	JLabel lblNom, lblPrenom, lblRole, lblMdp;
	JTextField txtNom, txtPrenom, txtRole;
	JPasswordField mdp;
	JButton btnConfirmer;

	public AjoutPersonnels() {
		super("Ajouter un membre du personnel");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			// txtRole.;
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
					PersonnelsManager pm = new PersonnelsManager();
					try {
						Personnels perso = new Personnels(txtNom.getText(), txtPrenom.getText(), mdp.getText(),
								txtRole.getText(), false);

						pm.Create(perso);
						AjoutPersonnels.this.dispose();
						JOptionPane.showMessageDialog(frame,"Ajout éffectué");
						
					} catch (Exception e) {
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

		this.setContentPane(panel);
	}
}
