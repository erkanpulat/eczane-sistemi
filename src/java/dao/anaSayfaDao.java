
package dao;

import entity.anaSayfa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class anaSayfaDao extends DbConnection {

   
     public List<anaSayfa> read(){
         
        List<anaSayfa> aList = new ArrayList<>();     
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from anasayfa order by id asc");
            while(rs.next()){
                anaSayfa a = new anaSayfa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    
   
}
