package fr.eni.clinique.ihm.login;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EcranMain1 extends JFrame {
	public EcranMain1() {
		setTitle("Ani Form");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ttourgis2017\\Documents\\GitHub\\ProjetClinique\\clinique\\icon\\ico_veto.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGestionClients = new JMenu("Gestion des clients");
		menuBar.add(mnGestionClients);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gerer les clients");
		mnGestionClients.add(mntmNewMenuItem);
		
		JMenu mnGestionPersonnels = new JMenu("Gestion du personnels");
		menuBar.add(mnGestionPersonnels);
		
		JMenuItem mntmGererPerso = new JMenuItem("Gerer le personnels");
		mnGestionPersonnels.add(mntmGererPerso);
		getContentPane().setLayout(null);
	}

}
