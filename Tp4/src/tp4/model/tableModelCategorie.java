package tp4.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class tableModelCategorie extends AbstractTableModel {
	List<categorie> lb;
	
	
	public tableModelCategorie(List<categorie> lc) {
		this.lb = lc;
	}
	
    public int getColumnCount() {
        return 2;
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
                return lb.get(row).getNom();
            default:
                return null;
        }
    }

}
