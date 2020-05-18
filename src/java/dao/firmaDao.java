package dao;

import entity.adresler;
import entity.firma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class firmaDao extends DbConnection {

    adreslerDao aDao;

    public adreslerDao getaDao() {
        if (aDao == null) {
            aDao = new adreslerDao();
        }
        return aDao;
    }

    public void setaDao(adreslerDao aDao) {
        this.aDao = aDao;
    }

    
    
    public void create(firma a) {

        
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into firma(firmaAdi,adresNo,telefon) VALUES(?,?,?)");
            pst.setString(1, a.getFirmaAdi());
            pst.setInt(2, a.getAdresEntity().getAdresNo());
            pst.setLong(3, a.getTelefon());
          
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
    
    
    public firma getById(long id) {
        firma f = null;

       
        try {
            
            PreparedStatement pst = this.connect().prepareStatement("select *from firma where firmaId=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            adresler a = this.getaDao().getById(rs.getInt(3));
            f = new firma(rs.getLong(1), rs.getString(2), a, rs.getLong(4));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return f;
    }

    
    
    
  
    
    public void delete(firma a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from firma where firmaId=?" );
           pst.setLong(1, a.getFirmaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    public void update(firma a) {
      
        try {
           PreparedStatement pst = this.connect().prepareStatement("update firma set firmaAdi=?,adresNo=?,telefon=? where firmaId=?");
           pst.setString(1, a.getFirmaAdi());
           pst.setInt(2, a.getAdresEntity().getAdresNo());
            pst.setLong(3, a.getTelefon());
            pst.setLong(4, a.getFirmaId());
          
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<firma> read() {
        List<firma> aList = new ArrayList<>();

        try {
          PreparedStatement pst=this.connect().prepareStatement("select *from firma order by firmaId asc");
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                adresler b = this.getaDao().getById(rs.getInt(3));
                firma a = new firma(rs.getLong(1), rs.getString(2), b, rs.getLong(4));
                aList.add(a);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }
    
  

}
