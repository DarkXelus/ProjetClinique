package fr.eni.clinique.ihm.clients;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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
	private JFrame frame;

	public SearchClients() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
			}
		});
		btnSearch.setIcon(new ImageIcon("C:\\Users\\rduclos2017\\Documents\\ressources\\Java\\MDI\\ProjetClinique\\clinique\\icon\\search.png"));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 11;
		gbc_btnSearch.gridy = 1;
		getContentPane().add(btnSearch, gbc_btnSearch);
		
		Jtable = new JTable();
		GridBagConstraints gbc_Jtable = new GridBagConstraints();
		gbc_Jtable.gridwidth = 10;
		gbc_Jtable.insets = new Insets(0, 0, 0, 5);
		gbc_Jtable.fill = GridBagConstraints.BOTH;
		gbc_Jtable.gridx = 1;
		gbc_Jtable.gridy = 3;
		getContentPane().add(Jtable, gbc_Jtable);
	}
	
	private TableModel initTableModel(String txtSearch) {
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 5;
			}

			public int getRowCount() {
				ClientsManager cm = new ClientsManager();
				int cnt = 0;
				try {
					cnt = cm.search(txtSearch).size();
				} catch (DALException | BLLException e) {
					e.printStackTrace();
				}
				return cnt;
			}

			public Object getValueAt(int row, int col) {
				ClientsManager cm = new ClientsManager();
				List<Clients> lstClient = new ArrayList<Clients>();
				JOptionPane.showMessageDialog(frame, "LALA VALUE");
				try {
					lstClient = cm.search(txtSearch);
					switch (col) {
					case 0:
						return lstClient.get(row).getNomClient();
					case 1:
						return lstClient.get(row).getPrenomClient();
					case 2:
						return lstClient.get(row).getNumTel();
					case 3:
						return lstClient.get(row).getEmail();
					case 4:
						return lstClient.get(row).getAssurance();
					default:
						break;
					}
				} catch (DALException | BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ("erreur");
			}
		};
		return dataModel;
	}



}
