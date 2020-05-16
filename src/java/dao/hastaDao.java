
package dao;

import entity.adresler;
import entity.hasta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;


public class hastaDao extends DbConnection{
    adreslerDao aDao;

    public adreslerDao getaDao() {
        if(aDao==null){
            aDao=new adreslerDao();
        }
        return aDao;
    }

    public void setaDao(adreslerDao aDao) {
        this.aDao = aDao;
    }
    
    
    public void create(hasta a) {
        
        String query = "insert into hasta"
                + " VALUES("+a.getTcNo()+",'"+a.getAdSoyad()+"','"+a.getDogumTarihi()+"','"+
                a.getCinsiyet()+"',"+a.getTelefon()+","+a.getAdresEntity().getAdresNo()+")";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(hasta a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hasta where tcno=" + a.getTcNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void update(hasta a){
         String query="update hasta set telefon="+a.getTelefon()+", adresNo="+a.getAdresEntity().getAdresNo()+
                 " where tcno="+a.getTcNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<hasta> read(){
        List<hasta> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from hasta order by adresNo asc");
            while(rs.next()){
                adresler a=this.getaDao().getById(rs.getInt(6));
                hasta h=new hasta(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getLong(5), a);
                aList.add(h);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    
}
