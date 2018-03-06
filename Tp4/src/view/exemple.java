package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tp4.controleur.controleurMetier;




public class exemple extends JFrame {
	
	// boolean qui représente True le produit et false categorie
	boolean t = true;
	
	
	private JPanel contentPane;
	private JTextField TextFPName;
	private JTextField textFPPrix;
	private JTextField textFPQuantite;
	private JTextField textFCName;
	private JTable table;
	
	
	controleurMetier cbt;

	    /**
	     *
	     */
	public exemple() {
	    	run();
	        cbt = new controleurMetier(this);
	        cbt.isiTableP();
	}
	
	

	/**
	 * Create the frame.
	 */
	public void run() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Produit = new JPanel();
		panel_Produit.setVisible(t);
		panel_Produit.setBackground(Color.ORANGE);
		panel_Produit.setBounds(10, 11, 764, 310);
		contentPane.add(panel_Produit);
		panel_Produit.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 58, 68, 14);
		panel_Produit.add(lblNom);
		
		JLabel lblNewLabel = new JLabel("Produit");
		lblNewLabel.setBounds(254, 11, 142, 14);
		panel_Produit.add(lblNewLabel);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setBounds(10, 103, 100, 40);
		panel_Produit.add(lblPrix);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		lblQuantit.setBounds(10, 163, 100, 40);
		panel_Produit.add(lblQuantit);
		
		TextFPName = new JTextField();
		TextFPName.setBounds(138, 55, 96, 20);
		panel_Produit.add(TextFPName);
		TextFPName.setColumns(10);
		
		textFPPrix = new JTextField();
		textFPPrix.setColumns(10);
		textFPPrix.setBounds(138, 113, 96, 20);
		panel_Produit.add(textFPPrix);
		
		textFPQuantite = new JTextField();
		textFPQuantite.setColumns(10);
		textFPQuantite.setBounds(138, 173, 96, 20);
		panel_Produit.add(textFPQuantite);
		
		JButton btnPUpdate = new JButton("Update");
		btnPUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cbt.isiTableP();
			}
		});
		btnPUpdate.setBounds(372, 54, 89, 23);
		panel_Produit.add(btnPUpdate);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				cbt.deleteP();
			}
		});
		
		btnSupprimer.setBounds(373, 112, 89, 23);
		panel_Produit.add(btnSupprimer);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(373, 172, 89, 23);
		panel_Produit.add(btnAjouter);
		
		JPanel panel_Categorie = new JPanel();
		panel_Categorie.setBounds(10, 11, 764, 310);
		contentPane.add(panel_Categorie);
		panel_Categorie.setVisible(!t);
		panel_Categorie.setLayout(null);
		
		JLabel label = new JLabel("Nom :");
		label.setBounds(10, 58, 68, 14);
		panel_Categorie.add(label);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setBounds(254, 11, 142, 14);
		panel_Categorie.add(lblCatgorie);
		
		JButton btnCUptade = new JButton("Update");
		btnCUptade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cbt.isiTableC();
			}
		});
		btnCUptade.setBounds(372, 54, 89, 23);
		panel_Categorie.add(btnCUptade);
		
		JButton btnCSupprimer = new JButton("Supprimer");
		btnCSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				cbt.deleteC();
			}
		});
		btnCSupprimer.setBounds(372, 112, 89, 23);
		panel_Categorie.add(btnCSupprimer);
		
		JButton btnCAjouter = new JButton("Ajouter");
		btnCAjouter.setBounds(372, 172, 89, 23);
		panel_Categorie.add(btnCAjouter);
		
		textFCName = new JTextField();
		textFCName.setColumns(10);
		textFCName.setBounds(138, 55, 96, 20);
		panel_Categorie.add(textFCName);
		
		JButton btnChange = new JButton("Change");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				t = !t;
				panel_Produit.setVisible(t);
				panel_Categorie.setVisible(!t);
			}
		});
		btnChange.setBounds(685, 320, 89, 23);
		contentPane.add(btnChange);
		
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        ));
		table.setBounds(20, 336, 655, 215);
		contentPane.add(table);
	}
	
	
	public JTable getTableData(){
        return table;
    }
	
}
