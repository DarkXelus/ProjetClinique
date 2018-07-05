package fr.eni.clinique.ihm.login;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.SingletonMain;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.ImagePanel;
import fr.eni.clinique.ihm.Personnels.AjoutPersonnels;
import fr.eni.clinique.ihm.Personnels.EcranGestionPersonnels;
import fr.eni.clinique.ihm.clients.AjoutClient;
import fr.eni.clinique.ihm.clients.EcranGestionClients;
import fr.eni.clinique.ihm.clients.SearchClients;

import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EcranMain extends JFrame {
	public String role;
	static JFrame frame;
	EcranMain em = EcranMain.this;

	public EcranMain(String role, String nom) {
		this.role = role;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SingletonMain.getInstance().setEcran(em);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 232, 230, 230, 230 };
		gridBagLayout.rowHeights = new int[] { 170, 170, 170, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		ImagePanel panel = new ImagePanel(new ImageIcon(
				EcranMain.class.getResource("/fr/eni/clinique/ressource/fond_frame.jpg"))
						.getImage());
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.getContentPane().add(panel, gbc_panel);

		JTree treePersonnels = new JTree();
		treePersonnels.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Personnels") {
				{
					add(new DefaultMutableTreeNode("Gerer le personnel"));
					add(new DefaultMutableTreeNode("Ajouter un membre du personnel"));
				}
			}
		));

		treePersonnels.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePersonnels.getLastSelectedPathComponent();

				/* if nothing is selected */
				if (node == null)
					return;

				/* retrieve the node that was selected */
				Object nodeInfo = node.getUserObject();
				switch (nodeInfo.toString()) {
				case "Gerer le personnel":
					EcranGestionPersonnels EP;
					try {
						if (role.equals("PDA")) {
							EP = new EcranGestionPersonnels();
							EP.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
						}
					} catch (DALException | BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					break;

				case "Ajouter un membre du personnel":

					if (role.equals("PDA")) {
						AjoutPersonnels AP = new AjoutPersonnels();
						AP.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
					}
					break;
				}
			}
		});

		GridBagConstraints gbc_treePersonnels = new GridBagConstraints();
		gbc_treePersonnels.fill = GridBagConstraints.BOTH;
		gbc_treePersonnels.insets = new Insets(0, 0, 5, 0);
		gbc_treePersonnels.gridx = 0;
		gbc_treePersonnels.gridy = 2;
		getContentPane().add(treePersonnels, gbc_treePersonnels);
		this.pack();
		this.setVisible(true);
		// this.setSize(617, 400);
		setTitle("Ani Form");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\ttourgis2017\\Documents\\GitHub\\ProjetClinique\\clinique\\icon\\ico_veto.png"));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				EcranMain.this.dispose();

			}
		});
		mnFichier.add(mntmFermer);
		
		JMenuItem mntmDeconecter = new JMenuItem("Deconnexion");
		mntmDeconecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				EcranMain.this.dispose();
				EcranLogin el = new EcranLogin();
				el.setVisible(true);

			}
		});
		mnFichier.add(mntmDeconecter);

		JMenu mnGestionClients = new JMenu("Gestion des clients");
		menuBar.add(mnGestionClients);

		JMenuItem mntmNewMenuItem = new JMenuItem("Gerer les clients");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (role.equals("AST")) {
					EcranGestionClients clients = new EcranGestionClients();
					clients.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
				}

			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionClients.add(mntmNewMenuItem);

		JMenu mnGestionPersonnels = new JMenu("Gestion du personnels");
		menuBar.add(mnGestionPersonnels);

		JMenuItem mntmGererPerso = new JMenuItem("Gerer le personnels");
		mntmGererPerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (role.equals("PDA")) {
					// Passage du role et du nom dans la vue Main
					EcranGestionPersonnels ecranPersonnels;
					try {
						ecranPersonnels = new EcranGestionPersonnels();
						ecranPersonnels.setVisible(true);
					} catch (DALException | BLLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
				}
			}
		});
		mnGestionPersonnels.add(mntmGererPerso);

		JTree treeClient = new JTree();
		treeClient.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Clients") {
				{
					add(new DefaultMutableTreeNode("Gerer les clients"));
					add(new DefaultMutableTreeNode("Ajouter un client"));
					add(new DefaultMutableTreeNode("Rechercher un client"));
				}
			}
		));

		treeClient.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeClient.getLastSelectedPathComponent();

				/* if nothing is selected */
				if (node == null)
					return;

				/* retrieve the node that was selected */
				Object nodeInfo = node.getUserObject();
				switch (nodeInfo.toString()) {
				case "Gerer les clients":
					EcranGestionClients EC;
					if (role.equals("AST")) {
						EC = new EcranGestionClients();
						EC.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
					}

					break;

				case "Ajouter un client":
					if (role.equals("AST")) {
						AjoutClient AC = new AjoutClient();
						AC.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Vous disposez pas des droits");
					}
					break;

				case "Rechercher un client":
					SearchClients SP = new SearchClients();
					SP.setVisible(true);

					break;
				}
			}
		});

		GridBagConstraints gbc_treeClient = new GridBagConstraints();
		gbc_treeClient.insets = new Insets(0, 0, 5, 0);
		gbc_treeClient.fill = GridBagConstraints.BOTH;
		gbc_treeClient.gridx = 0;
		gbc_treeClient.gridy = 1;
		getContentPane().add(treeClient, gbc_treeClient);

		JLabel lblNewLabel = new JLabel("Planning");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridx = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
	}
}
