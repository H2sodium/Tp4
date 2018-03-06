package tp4.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class tableModelProduit  extends AbstractTableModel {
	List<produit> lb;
	
	
	public tableModelProduit(List<produit> lb) {
		this.lb = lb;
	}
	
    public int getColumnCount() {
        return 4;
    }


    public int getRowCount() {
        return lb.size();
    }
    
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nom";
            case 2:
                return "Prix";
            case 3:
                return "Quantité";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getName();
            case 2:
                return lb.get(row).getPrix();
            case 3:
                return lb.get(row).getQuantité();
            default:
                return null;
        }
    }
}
