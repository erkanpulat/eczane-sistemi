
package dao;

import entity.adresler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class adreslerDao extends DbConnection {

    public void create(adresler a) {
       
        try {  
             String query = "insert into adresler(adres)"+ "values(?)";
                  
            PreparedStatement pst = this.connect().prepareStatement(query );
            pst.setString(1, a.getAdres());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
    

    public void delete(adresler a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from adresler where adresno=?" );
            pst.setInt(1, a.getAdresNo());
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
    }
    
    
     public void update(adresler a){
         String query="update adresler set adres=? where adresno=?";
        try {
           PreparedStatement pst = this.connect().prepareStatement(query);
           pst.setString(1, a.getAdres());
           pst.setInt(2, a.getAdresNo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
      public List<adresler> read(){
         
        List<adresler> aList = new ArrayList<>();     
        try {
             PreparedStatement pst = this.connect().prepareStatement("select *from adresler order by adresno asc");
           
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                adresler a=new adresler(rs.getInt("adresNo"),rs.getString(2));
                
                aList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
     
    public adresler getById(int adresNo) {
        adresler a = null;
        try {

            PreparedStatement pst = this.connect().prepareStatement("select *from adresler where adresno=?");
            pst.setInt(1, adresNo);

            ResultSet rs = pst.executeQuery();
            rs.next();
            a = new adresler(rs.getInt(1), rs.getString(2));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

}
