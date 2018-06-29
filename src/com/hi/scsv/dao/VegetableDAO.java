
package com.hi.scsv.dao;

import com.hi.scsv.dao.base.BaseDAO;
import com.hi.scsv.models.Vegetable;
import com.hi.scsv.models.enums.VegetableSize;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VegetableDAO extends BaseDAO {
        
    public boolean insertData(Vegetable vegetable) {
        
        String sql = "INSERT INTO vegetable(lbName, origin, size, fruitful, reproduction) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, vegetable.getName());
            pstat.setString(2, vegetable.getOrigin());
            pstat.setString(3, vegetable.getSize().toString());
            pstat.setBoolean(4, vegetable.isFruitful());
            pstat.setString(5, vegetable.getReproduction());
            pstat.execute();
            pstat.close();
        }
        catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
        return true;
    }
    
    public ArrayList<Vegetable> readData(String param) {
        String sql = "SELECT * FROM vegetable WHERE lbName like ? OR origin like ? OR size like ?";
        ArrayList<Vegetable> vegetables = new ArrayList<>();        
        ResultSet rs = null;
                  
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, param + "%");
            pstat.setString(2, param + "%");
            pstat.setString(3, param + "%");
            rs = pstat.executeQuery();
            
            while (rs.next()) {
                Vegetable vegetable = new Vegetable();
                vegetable.setId(rs.getLong("id"));
                vegetable.setName(rs.getString("lbName"));
                vegetable.setOrigin(rs.getString("origin"));
                vegetable.setSize(VegetableSize.valueOf(rs.getString("size")));
                vegetable.setFruitful(rs.getBoolean("fruitful"));
                vegetable.setReproduction();                
                vegetables.add(vegetable);
            }
                                    
        } catch(SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
        return vegetables;
    }
    
    public boolean updateData(Vegetable vegetable) {
        String sql = "UPDATE vegetable SET lbName = ?, origin = ?, size = ?, fruitful = ? WHERE id = ?";
        
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vegetable.getName());
            pstat.setString(2, vegetable.getOrigin());
            pstat.setString(3, vegetable.getSize().toString());
            pstat.setBoolean(4, vegetable.isFruitful());
            pstat.setLong(5, vegetable.getId());
            pstat.execute();
            pstat.close();
            
        } catch(SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
        return true;
    }
    
    public boolean deleteData(long id) {
        String sql = "DELETE from vegetable WHERE id = ?";
        
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
