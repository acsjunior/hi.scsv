
package com.hi.scsv.services;

import com.hi.scsv.dao.VegetableDAO;
import com.hi.scsv.models.Vegetable;
import com.hi.scsv.models.enums.VegetableSize;
import java.util.ArrayList;


public class VegetableServices {
    
    public String saveData(long id, String name, String origin, String size, boolean fruitful) {

        Vegetable vegetable = new Vegetable();
        vegetable.setId(id);
        vegetable.setName(name);
        vegetable.setOrigin(origin); 
        vegetable.setSize(VegetableSize.valueOf(size));
        vegetable.setFruitful(fruitful);
        
        //validate fields
        String msg = vegetable.getValidationMessage();
        if (!msg.equals("OK")) {
            return msg;
        }
        
       if (vegetable.getId() == 0) {
           
        if (new VegetableDAO().insertData(vegetable)) {
            return "Registro incluído com sucesso!";
        }
                
       } else {
           if (new VegetableDAO().updateData(vegetable)) {
               return "Registro atualizado com sucesso!";
           }           
       } 
       return null;
    }

    public ArrayList<Vegetable> getData(String param) {
        ArrayList<Vegetable> vegetables = new VegetableDAO().readData(param);
        return vegetables;
    }
    
    public String removeData(long id) {
        if (new VegetableDAO().deleteData(id)) {
            return "Registro removido com sucesso!";
        };
        return null;
    }
}
