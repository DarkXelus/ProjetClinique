package fr.eni.clinique.ihm.clients;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import fr.eni.clinique.BO.Clients;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.dal.DALException;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SearchClients extends JFrame {
	private JTextField txtSearch;
	private JTable Jtable;

	public SearchClients() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		txtSearch = new JTextField();
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.gridwidth = 9;
		gbc_txtSearch.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 1;
		gbc_txtSearch.gridy = 1;
		getContentPane().add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Rechercher");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		btnSearch.setIcon(new ImageIcon(
				"C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\search.png"));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 11;
		gbc_btnSearch.gridy = 1;
		getContentPane().add(btnSearch, gbc_btnSearch);

		Jtable = new JTable();
		Jtable.setModel(new DefaultTableModel(new Object[][] {

		},

				new String[] { "Nom Client", "Prenom Client", "Ville", "Code Postal" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

		});
		Jtable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String nomClient = Jtable.getValueAt(Jtable.getSelectedRow(), 0).toString();
				String prenomClient = Jtable.getValueAt(Jtable.getSelectedRow(), 1).toString();
				Long id = null;
				ClientsManager cm = new ClientsManager();
				try {
					id = cm.GetID(nomClient, prenomClient);
					if(id != null){
						Clients cli = cm.read(id);
						EcranGestionClients gestion = new EcranGestionClients(cli);
						gestion.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Erreur",
								"Le client n'est pas trouv�", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (DALException e1) {
					e1.printStackTrace();
				} catch (BLLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_Jtable = new GridBagConstraints();
		gbc_Jtable.gridwidth = 10;
		gbc_Jtable.insets = new Insets(0, 0, 0, 5);
		gbc_Jtable.fill = GridBagConstraints.BOTH;
		gbc_Jtable.gridx = 1;
		gbc_Jtable.gridy = 3;
		getContentPane().add(Jtable, gbc_Jtable);
	}

	public void updateData() {
		String recherche = txtSearch.getText();
		ClientsManager cm = new ClientsManager();
		List<Clients> cli = new ArrayList<Clients>();
		try {
			cli = cm.search(recherche);
			DefaultTableModel tableModel = (DefaultTableModel) Jtable.getModel();
			tableModel.setRowCount(0);
			for (Clients clients : cli) {
				tableModel.addRow(new Object[] { clients.getNomClient(), clients.getPrenomClient(), clients.getVille(),
						clients.getCodePostal() });
			}
		} catch (DALException | BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
