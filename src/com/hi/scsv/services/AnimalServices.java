
package com.hi.scsv.services;

import com.hi.scsv.models.Animal;
import com.hi.scsv.models.enums.AnimalClass;
import com.hi.scsv.dao.AnimalDAO;
import java.util.ArrayList;


public class AnimalServices {

    public String saveData(long id, String name, String origin, String paws, String animalClass) {

        Animal animal = new Animal();
        animal.setId(id);
        animal.setName(name);
        animal.setOrigin(origin);      
        animal.setPawsQantity(animal.validatePawsQuantity(paws));
        animal.setAnimalClass(AnimalClass.valueOf(animalClass));
        
        //validate fields
        String msg = animal.getValidationMessage();
        if (!msg.equals("OK")) {
            return msg;
        }
        
       if (animal.getId() == 0) {
           
        if (new AnimalDAO().insertData(animal)) {
            return "Registro incluído com sucesso!";
        }
                
       } else {
           if (new AnimalDAO().updateData(animal)) {
               return "Registro atualizado com sucesso!";
           }           
       } 
       return null;
    }
    
    public ArrayList<Animal> getData(String param) {
        ArrayList<Animal> animals = new AnimalDAO().readData(param);
        return animals;
    }
    
    public String removeData(long id) {
        if (new AnimalDAO().deleteData(id)) {
            return "Registro removido com sucesso!";
        };
        return null;
    }

}
