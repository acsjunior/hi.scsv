
package com.hi.scsv.forms.tables;

import com.hi.scsv.models.Vegetable;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class VegetableTableModel extends AbstractTableModel {
    
    private final List<Vegetable> vegetables;
    private final String[] columns;
    
    public VegetableTableModel(List<Vegetable> v) {
        super();
        vegetables = v;
        columns = new String[]{"Id", "Nome", "Origem", "Tamanho", "Frutífera", "Reprodução"};
    }

    @Override
    public int getRowCount() {
        return vegetables.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vegetable vegetable = vegetables.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return vegetable.getId();
            case 1:
                return vegetable.getName();
            case 2:
                return vegetable.getOrigin();
            case 3:
                return vegetable.getSize();
            case 4:
                return vegetable.isFruitful();
            case 5:
                return vegetable.getReproduction();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
            
}
