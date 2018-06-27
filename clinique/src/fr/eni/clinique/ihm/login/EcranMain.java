package fr.eni.clinique.ihm.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD
@SuppressWarnings("serial")
=======
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;

>>>>>>> 3baa5ee3e3ed0d12b5467786fb4e7f5d6c1c7613
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
<<<<<<< HEAD
			lblNom = new JLabel("Bonjour " + nom + " rôle: " + role);
=======
			lblNom = new JLabel("Bonjour " + nom + " role: " + role);
>>>>>>> 3baa5ee3e3ed0d12b5467786fb4e7f5d6c1c7613
		}
		return lblNom;
	}

<<<<<<< HEAD
=======
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

>>>>>>> 3baa5ee3e3ed0d12b5467786fb4e7f5d6c1c7613
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
<<<<<<< HEAD
=======
		gbc.gridx = 0;
		gbc.gridy = 20;
		panel.add(getBtnPersonnels(nom, role), gbc);

>>>>>>> 3baa5ee3e3ed0d12b5467786fb4e7f5d6c1c7613
		this.setContentPane(panel);
	}

}
