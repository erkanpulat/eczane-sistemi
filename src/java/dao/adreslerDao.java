
package dao;

import entity.adresler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class adreslerDao extends DbConnection {

    public void create(adresler a) {
        String query = "insert into adresler(adres) VALUES('"+a.getAdres()+"')";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(adresler a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from adresler where adresno=" + a.getAdresNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
    }
     public void update(adresler a){
         String query="update adresler set adres='"+a.getAdres()+"' where adresno="+a.getAdresNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<adresler> read(){
         
        List<adresler> aList = new ArrayList<>();     
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from adresler order by adresno asc");
            while(rs.next()){
                adresler a=new adresler(rs.getInt("adresNo"),rs.getString(2));
                
                aList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
     
     public adresler getById(int adresNo){
         adresler a=null;
         try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from adresler where adresno="+adresNo);
            rs.next();
            a=new adresler(rs.getInt(1), rs.getString(2));           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }       
         return a;
     }
   
}
