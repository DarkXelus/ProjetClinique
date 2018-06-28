package fr.eni.clinique.ihm.Personnels;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EcranGestionPersonnels extends JFrame{
	public EcranGestionPersonnels() {
		setSize(500, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjoutPersonnels ajout = new AjoutPersonnels();
				ajout.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.gridx = 0;
		gbc_btnAjouter.gridy = 0;
		getContentPane().add(btnAjouter, gbc_btnAjouter);
	}


}
