
package com.hi.scsv.forms.tables;

import com.hi.scsv.models.Animal;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AnimalTableModel extends AbstractTableModel {
    
    private final List<Animal> animals;
    private final String[] columns;
    
    public AnimalTableModel(List<Animal> a) {
        super();
        animals = a;
        columns = new String[]{"Id", "Nome", "Origem", "Qtd. Patas", "Classe", "Reprodução"};
    }

    @Override
    public int getRowCount() {
        return animals.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = animals.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return animal.getId();
            case 1:
                return animal.getName();
            case 2:
                return animal.getOrigin();
            case 3:
                return animal.getPawsQantity();
            case 4:
                return animal.getAnimalClass();
            case 5:
                return animal.getReproduction();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
            
}
