
package com.hi.scsv.models;

import com.hi.scsv.models.base.LivingBeing;
import com.hi.scsv.models.enums.VegetableSize;


public class Vegetable extends LivingBeing {
    
    private VegetableSize size;
    private boolean fruitful;

    
    public VegetableSize getSize() {
        return size;
    }

    public void setSize(VegetableSize size) {
        this.size = size;
    }    
   
    public boolean isFruitful() {
        return fruitful;
    }

    public void setFruitful(boolean fruitful) {
        this.fruitful = fruitful;
    }

    
    @Override
    public String getReproduction() {
        if (this.isFruitful()) {
            return "sexuada";
        } else {
            return "assexuada";
        }
    }
    
    @Override
    public String getValidationMessage() {
        
        if (this.getName().isEmpty()) {
            return "Por favor preencha o nome do vegetal!";           
        } else {
            return "OK";
        }
    }
    
}
