
package com.hi.scsv.dao.base;

import com.hi.scsv.dao.factory.ConnFactory;
import java.sql.Connection;


public abstract class BaseDAO {
    
    public final Connection conn;
    
    public BaseDAO() {
        this.conn = new ConnFactory().getConn();
    }
    
}
