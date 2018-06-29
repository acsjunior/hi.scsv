
package com.hi.scsv.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnFactory {
    
    public Connection getConn() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/scsvDb","root","456");       
        }
        catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
