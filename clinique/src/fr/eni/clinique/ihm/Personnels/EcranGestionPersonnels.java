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
import fr.eni.clinique.bll.PersonnelsManager;

public class EcranGestionPersonnels extends JFrame {
	static JFrame frame;
	JButton btnAjout;

	public EcranGestionPersonnels(String role, String nom) {
		super();
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(role, nom);
	}

	public JButton btnAjout(String role) {
		if (btnAjout == null) {
			btnAjout = new JButton("Ajouter");
			if (!role.equals("PDA")) {
				btnAjout.setEnabled(false);
				btnAjout.setFocusable(false);
			}
			btnAjout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						// Passage du role et du nom dans la vue Main
						 AjoutPersonnels ajout = new AjoutPersonnels();
						 ajout.setVisible(true);
						 
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Mot de passe ou nom incorrect");
					}
				}
			});

		}
		return btnAjout;

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
		panel.add(btnAjout(role), gbc);

		this.setContentPane(panel);
	}
}
