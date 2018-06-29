
package com.hi.scsv.models.base;


public abstract class LivingBeing {    
    private long id;
    private String name;
    private String origin;
    private String reproduction;
        
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origem) {
        this.origin = origem;
    }
    
    public abstract String getReproduction();

    public void setReproduction() {
        this.reproduction = getReproduction();
    }
    
    
    public abstract String getValidationMessage();

}
    