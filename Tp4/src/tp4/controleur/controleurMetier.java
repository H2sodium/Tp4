package tp4.controleur;

import java.util.List;

import javax.swing.JOptionPane;

import tp4.dao.IMetier;
import tp4.dao.doaMetier;
import tp4.model.categorie;
import tp4.model.produit;
import tp4.model.tableModelCategorie;
import tp4.model.tableModelProduit;
import view.exemple;

public class controleurMetier {
	
	
	exemple frame;
	IMetier metier;
	List<produit> lb;
	List<categorie> lc;
	
	 public controleurMetier(exemple frame) {
	        this.frame = frame;
	        metier = new doaMetier();
	        lc = metier.getALLC();
	        lb = metier.getALLP();
	 }
	
	 
	public void run() {
		try {
			exemple frame = new exemple();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    public void isiTableP() {
        lb = metier.getALLP();
        tableModelProduit tmb = new tableModelProduit(lb);
        frame.getTableData().setModel(tmb);
    }

	
    public void isiTableC() {
        lc = metier.getALLC();
        tableModelCategorie tmb = new tableModelCategorie(lc);
        frame.getTableData().setModel(tmb);
    }
	
    public void deleteC() {
        if (!false) {//frame.getTxtID().getText().trim().isEmpty()) {
        	
            int id =  frame.getTableData().getSelectedRow();
            metier.supprimerCategorie(id);
            System.out.print("EE");
        } else {
            JOptionPane.showMessageDialog(frame, "Sélectionnez les données à supprimer");
        }
    }
    
    public void deleteP() {
        if (!false) {//frame.getTxtID().getText().trim().isEmpty()) {
        	
            int id =  frame.getTableData().getSelectedRow();
            metier.supprimerCategorie(id);
            System.out.print("EE");
        } else {
            JOptionPane.showMessageDialog(frame, "Sélectionnez les données à supprimer");
        }
    }
    
}
