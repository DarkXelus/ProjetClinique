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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bll.LoginManager;

public class EcranMain extends JFrame{
	static JFrame frame;
	private JLabel lblNom, lblMdp;
	private JTextField jTxtNom;
	private JPasswordField jPassMdp;
	private JButton btnConnexion;

	public EcranMain(String r�le,String nom) {
		super();
		setSize(500, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM(r�le,nom);
	}

	public JLabel getLblNom(String nom,String r�le) {
		if (lblNom == null) {
			lblNom = new JLabel("Bonjour " + nom + " r�le: " + r�le);
		}
		return lblNom;
	}

	private void initIHM(String r�le,String nom) {

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getLblNom(nom,r�le), gbc);

		this.setContentPane(panel);
	}

}
