/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliantais
 */
public class DBUtil {
    public static void closeStatement(Statement s) {
        if (s != null)
            try {
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closePreparedStatement(Statement ps) {
        if (ps != null)
            try {
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeResultSet(ResultSet rs) {
        if (rs != null)
            try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
