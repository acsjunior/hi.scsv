
package com.hi.scsv.dao;

import com.hi.scsv.dao.base.BaseDAO;
import com.hi.scsv.models.Animal;
import com.hi.scsv.models.enums.AnimalClass;
import java.util.ArrayList;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AnimalDAO extends BaseDAO {
    
    public boolean insertData(Animal animal) {
        
        String sql = "INSERT INTO animal(lbName, origin, pawsQuantity, class, reproduction) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, animal.getName());
            pstat.setString(2, animal.getOrigin());
            pstat.setInt(3, animal.getPawsQantity());
            pstat.setString(4, animal.getAnimalClass().toString());
            pstat.setString(5, animal.getReproduction());
            pstat.execute();
            pstat.close();
        }
        catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
        return true;
    }
    
    public ArrayList<Animal> readData(String param) {
        String sql = "SELECT * FROM animal WHERE lbName like ? OR origin like ? OR class like ?";
        ArrayList<Animal> animals = new ArrayList<>();        
        ResultSet rs = null;
                  
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, param + "%");
            pstat.setString(2, param + "%");
            pstat.setString(3, param + "%");
            rs = pstat.executeQuery();
            
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getLong("id"));
                animal.setName(rs.getString("lbName"));
                animal.setOrigin(rs.getString("origin"));
                animal.setPawsQantity(rs.getInt("pawsQuantity"));
                animal.setAnimalClass(AnimalClass.valueOf(rs.getString("class")));
                animal.setReproduction();                
                animals.add(animal);
            }
                                    
        } catch(SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        return animals;
    }
    
    public boolean updateData(Animal animal) {
        String sql = "UPDATE animal SET lbName = ?, origin = ?, pawsQuantity = ?, class = ? WHERE id = ?";
        
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, animal.getName());
            pstat.setString(2, animal.getOrigin());
            pstat.setInt(3, animal.getPawsQantity());
            pstat.setString(4, animal.getAnimalClass().toString());
            pstat.setLong(5, animal.getId());
            pstat.execute();
            pstat.close();
            
        } catch(SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
        return true;
    }
    
    public boolean deleteData(long id) {
        String sql = "DELETE from animal WHERE id = ?";
        
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setLong(1, id);
            pstat.execute();
            pstat.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
        
        return true;
    }
    
}
