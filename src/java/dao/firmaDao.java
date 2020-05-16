
package dao;

import entity.firma;
import entity.firma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author Hanifi
 */
public class firmaDao extends DbConnection{
    
    public void create(firma a) {
        
        String query = "insert into firma(firmaAdi,adresNo,telefon) VALUES('"+a.getFirmaAdi()+"',"+a.getAdresNo()+","+a.getTelefon()+")";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public firma getById(long id) {
        firma f=null;
        
        String query = "select * from firma where firmaId="+id;
        try {           
            Statement st = this.connect().createStatement();
            ResultSet rs= st.executeQuery(query);
            rs.next();
            f=new firma(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getLong(4));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return f;
    }

    public void delete(firma a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from firma where firmaId=" + a.getFirmaId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void update(firma a){
         String query="update firma set firmaAdi='"+a.getFirmaAdi()+"', adresNo="+a.getAdresNo()+",telefon="+a.getTelefon()+
                 " where firmaId="+a.getFirmaId();
         System.out.println("******************\n"+query);
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<firma> read(){
        List<firma> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from firma order by firmaId asc");
            while(rs.next()){
                firma a=new firma(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getLong(4));
                aList.add(a);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    


    public List<String> firmanoRead() {
        List<String> aList = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select firmaAdi from firma order by firmaId asc");
            while (rs.next()) {
                aList.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }
}
