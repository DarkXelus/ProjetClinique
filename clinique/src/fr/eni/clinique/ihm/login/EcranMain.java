package fr.eni.clinique.ihm.login;

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

import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;

@SuppressWarnings("serial")
public class EcranMain extends JFrame {
	static JFrame frame;
	private JLabel lblNom;
	private JButton btnPersonnels;

	public EcranMain(String role, String nom) {
		super();
		setSize(500, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(role, nom);
	}

	public JLabel getLblNom(String nom, String role) {
		if (lblNom == null) {
			lblNom = new JLabel("Bonjour " + nom + " rôle: " + role);
			lblNom = new JLabel("Bonjour " + nom + " role: " + role);
		}
		return lblNom;
	}

	public JButton getBtnPersonnels(String nom, String role) {
		if (btnPersonnels == null) {
			btnPersonnels = new JButton("Gestion du personnels");
			btnPersonnels.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					LoginManager lm = new LoginManager();
					try {
						// Passage du role et du nom dans la vue Main
						EcranGestionPersonnels ecranPersonnels = new EcranGestionPersonnels(role, nom);
						ecranPersonnels.setVisible(true);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Mot de passe ou nom incorrect");
					}
				}
			});

		}
		return btnPersonnels;

	}

	private void initIHM(String role, String nom) {

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getLblNom(nom, role), gbc);

		gbc.gridx = 0;
		gbc.gridy = 20;
		panel.add(getBtnPersonnels(nom, role), gbc);

		this.setContentPane(panel);
	}

}
