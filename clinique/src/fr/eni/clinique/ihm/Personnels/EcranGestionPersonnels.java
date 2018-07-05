package fr.eni.clinique.ihm.Personnels;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fr.eni.clinique.BO.Personnels;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.SingletonGestionPersonnels;
import fr.eni.clinique.bll.SingletonMain;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.clients.EcranGestionClients;
import fr.eni.clinique.ihm.login.EcranLogin;

import java.awt.Insets;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class EcranGestionPersonnels extends JFrame {
	JTable table;
	EcranGestionPersonnels ec = this;
	JFrame frame;

	public EcranGestionPersonnels() throws DALException, BLLException {
		getContentPane().setBackground(Color.WHITE);
		setSize(700, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(UIManager.getColor("Button.light"));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SingletonGestionPersonnels.getInstance().setEcran(ec);
				AjoutPersonnels ajout = new AjoutPersonnels();
				ajout.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.anchor = GridBagConstraints.WEST;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 0;
		gbc_btnAjouter.gridy = 0;
		getContentPane().add(btnAjouter, gbc_btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() != 0) {
					PersonnelsManager pm = new PersonnelsManager();
					try {
						Personnels perso = pm.SelectAll().get(table.getSelectedRow());
						pm.delete(perso);

						EcranGestionPersonnels.this.dispose();
						EcranGestionPersonnels ecranPersonnels = new EcranGestionPersonnels();
						ecranPersonnels.setVisible(true);
					} catch (DALException | BLLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

					JOptionPane.showMessageDialog(null, "Vous devez selectionner un membre du personnels",
							"Supprimer un membre du personnel", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 1;
		gbc_btnSupprimer.gridy = 0;

		getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		JButton btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonnelsManager pm = new PersonnelsManager();
				try {
					if (table.getSelectedRowCount() != 0) {
						Personnels perso = pm.SelectAll().get(table.getSelectedRow());
						perso.setMotPasse(JOptionPane.showInputDialog(null, "Saisissez le nouveau mot de passe :",
								"Modifier le mot de passe", JOptionPane.PLAIN_MESSAGE));
						pm.updatePass(perso);
					} else {

						JOptionPane.showMessageDialog(null, "Vous devez selectionner un membre du personnels",
								"Modifier le mot de passe", JOptionPane.PLAIN_MESSAGE);
					}

				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
			}
		});
		btnReinitialiser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnReinitialiser = new GridBagConstraints();
		gbc_btnReinitialiser.anchor = GridBagConstraints.WEST;
		gbc_btnReinitialiser.insets = new Insets(0, 0, 5, 0);
		gbc_btnReinitialiser.gridx = 2;
		gbc_btnReinitialiser.gridy = 0;
		getContentPane().add(btnReinitialiser, gbc_btnReinitialiser);

		table = new JTable(initTableModel());
		table.setBorder(null);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridheight = 4;
		gbc_table.gridwidth = 3;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		getContentPane().add(table, gbc_table);

		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mntmFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				EcranGestionPersonnels.this.dispose();
			}
		});
		mnFichier.add(mntmFermer);

		JMenuItem mntmDeconecter = new JMenuItem("Deconnexion");
		mntmDeconecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				SingletonMain.getInstance().getEcran().dispose();
				EcranGestionPersonnels.this.dispose();
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
				if (SingletonMain.getInstance().getEcran().role.equals("AST")) {
					EcranGestionClients client;
						client = new EcranGestionClients();
						client.setVisible(true);
					
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
				if (SingletonMain.getInstance().getEcran().role.equals("PDA")) {
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

	}

	public TableModel initTableModel() {
		String[] personnels = { "Nom", "Prenom", "Role", "Login" };
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 4;
			}

			public int getRowCount() {
				PersonnelsManager pm = new PersonnelsManager();
				int cnt = 0;
				try {
					cnt = pm.SelectAll().size();
				} catch (DALException | BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return cnt;
			}

			@Override
			public String getColumnName(int index) {
				return personnels[index];
			}

			public Object getValueAt(int row, int col) {
				PersonnelsManager pm = new PersonnelsManager();
				List<Personnels> lstPerso = new ArrayList<Personnels>();
				try {
					lstPerso = pm.SelectAll();
					switch (col) {
					case 0:
						return lstPerso.get(row).getNom();
					case 1:
						return lstPerso.get(row).getPrenom();
					case 2:
						return lstPerso.get(row).getRole();
					case 3:
						return lstPerso.get(row).getLogin();
					default:
						break;
					}
				} catch (DALException | BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "erreur";
			}
		};

		return dataModel;
	}

}
