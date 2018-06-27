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

import fr.eni.clinique.bll.LoginManager;

public class EcranGestionPersonnels extends JFrame {
	static JFrame frame;
	private JLabel lblNom, lblMdp;
	private JTextField jTxtNom;
	private JPasswordField jPassMdp;
	private JButton btnConnexion;

	public EcranGestionPersonnels(String role,String nom) {
		super();
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(role,nom);
	}

	public JLabel getLblNom(String nom, String rôle) {
		if (lblNom == null) {
			lblNom = new JLabel("Bonjour " + nom + " rôle: " + rôle);
		}
		return lblNom;
	}

	public JLabel getLblMdp() {
		if (lblMdp == null) {
			lblMdp = new JLabel("Mot De Passe: ");
		}
		return lblMdp;
	}

	public JTextField getjTxtNom() {
		if (jTxtNom == null) {
			jTxtNom = new JTextField(20);
			jTxtNom.setBounds(5, 5, 30, 25);
		}
		return jTxtNom;
	}

	public JPasswordField getjTxtMdp() {
		if (jPassMdp == null) {
			jPassMdp = new JPasswordField(20);
			jPassMdp.setBounds(5, 5, 10, 25);

		}
		return jPassMdp;
	}

	public JButton getBtnConnexion() {
		if (btnConnexion == null) {
			btnConnexion = new JButton("Connexion");
			btnConnexion.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					LoginManager lm = new LoginManager();
					try {
						String nom = jTxtNom.getText();
						String role = lm.Login(nom, jPassMdp.getSelectedText());
						if(role == "PDA")
						{
							btnConnexion.setEnabled(false);
						}
						// Passage du rôle et du nom dans la vue Main
						/*EcranMain main = new EcranMain(rôle, nom);
						main.setVisible(true);*/
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Mot de passe ou nom incorrect");
					}
				}
			});

		}
		return btnConnexion;

	}

	private void initIHM(String rôle, String nom) {

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getLblNom(nom, rôle), gbc);

		this.setContentPane(panel);
	}
}
