package fr.eni.clinique.ihm.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EcranMain extends JFrame {
	static JFrame frame;
	private JLabel lblNom;
	private JButton btnPersonnels;

	public EcranMain(String rôle, String nom) {
		super();
		setSize(500, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(rôle, nom);
	}

	public JLabel getLblNom(String nom, String rôle) {
		if (lblNom == null) {
			lblNom = new JLabel("Bonjour " + nom + " rôle: " + rôle);
		}
		return lblNom;
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
		this.setContentPane(panel);
	}

}
