
package com.hi.scsv.models;

import com.hi.scsv.models.base.LivingBeing;
import com.hi.scsv.models.enums.AnimalClass;


public class Animal extends LivingBeing {

 
    private int pawsQantity;
    private AnimalClass animalClass; 
       
    public int getPawsQantity() {
        return pawsQantity;
    }

    public void setPawsQantity(int pawsQantity) {
        this.pawsQantity = pawsQantity;
    }
    
    public AnimalClass getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(AnimalClass animalClass) {
        this.animalClass = animalClass;
    }

    
    @Override
    public String getReproduction( ) {
        return "sexuada";
    }
    
    @Override
    public String getValidationMessage() {
        
        if (this.getName().isEmpty()) {
            return "Por favor preencha o nome do animal!";           
        } else if (this.getPawsQantity() == 999) {
            return "O campo Qtd. de Patas deve ser preenchido com um valor numérico!";
        } else {
            return "OK";
        }
    }
    
    public int validatePawsQuantity(String qty) {
        try {
            int paws = Integer.parseInt(qty);
            return paws;
        } catch (NumberFormatException ex) {
            return 999;
        }
    }
    
}
