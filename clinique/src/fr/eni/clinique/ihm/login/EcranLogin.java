package fr.eni.clinique.ihm.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class EcranLogin extends JFrame {
	
	private JLabel lblNom, lblMdp;
	private JTextField jTxtNom;
	private JPasswordField jPassMdp;
	private JButton btnConnexion;
	
	public EcranLogin () {
		super("Page de Connexion");
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
			//btnAjouter.setActionCommand(metalClassName);
			//btnConnexion.addActionListener(new ActionListener() {
				
			//	@Override
			//	public void actionPerformed(ActionEvent e) {
					/*try {
						updateState();
					} catch (Exception e1) {
						e1.printStackTrace();
					} 	*/
			//	}
			//});
		}
		return btnConnexion;
	}

	private void initIHM() {
		
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getLblNom(),gbc);
		
		gbc.gridx = 1;
		panel.add(getjTxtNom(),gbc);
		
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(getLblMdp(),gbc);
		
		gbc.gridx = 1;
		panel.add(getjTxtMdp(),gbc);
		
		//Ligne 3 
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(getBtnConnexion(),gbc);
		
		this.setContentPane(panel);
	}

}
