
package com.hi.scsv.dao;

import com.hi.scsv.dao.base.BaseDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;


public class ExportDAO extends BaseDAO {
    
    public void exportTxt() throws IOException {
        String sql = "SELECT lbName AS NOME, \"ANIMAL\" AS CATEGORIA, origin AS ORIGEM, pawsQuantity AS NUM_PATAS, class AS CLASSE, NULL AS TAMANHO, NULL AS FRUTIFERA, reproduction AS REPRODUCAO FROM animal ";
        sql = sql + "UNION ";
        sql = sql + "SELECT lbName AS NOME, \"VEGETAL\" AS CATEGORIA, origin AS ORIGEM, NULL AS PATAS, NULL AS CLASSE, size AS TAMANHO, fruitful AS FRUTIFERA, reproduction AS REPRODUCAO from vegetable";       
        ResultSet rs = null;
        
        String d = LocalDateTime.now().toString(); 
        File file = new File("export_"+d+".txt");
        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);
                  
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            
            out.write("NOME,CATEGORIA,ORIGEM,NUM_PATAS,CLASSE,TAMANHO,FRUTIFERA,REPRODUCAO");
            out.newLine();
            while (rs.next()) {
                out.write(rs.getString("NOME") + ",");
                out.write(rs.getString("CATEGORIA") + ",");
                out.write(rs.getString("ORIGEM") + ",");
                out.write(Integer.toString(rs.getInt("NUM_PATAS")) + ",");
                out.write(rs.getString("CLASSE") + ",");
                out.write(rs.getString("TAMANHO") + ",");
                out.write(Boolean.toString(rs.getBoolean("FRUTIFERA")) + ",");
                out.write(rs.getString("REPRODUCAO") + ",");
                out.newLine();
            }
            out.close();
            JOptionPane.showMessageDialog(null, "Exportação realizada com sucesso!");
                                    
        } catch(SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
        }
    }
    
}
