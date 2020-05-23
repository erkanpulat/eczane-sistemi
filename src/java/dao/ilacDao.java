package dao;

import entity.firma;
import entity.ilac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class ilacDao extends DbConnection {

    private firmaDao fDao;

    public firmaDao getfDao() {
        if (fDao == null) {
            this.fDao = new firmaDao();
        }
        return fDao;
    }

    public void setfDao(firmaDao fDao) {
        this.fDao = fDao;
    }

    public void create(ilac a) {
        
        try {
            PreparedStatement pst=this.connect().prepareStatement("insert into ilac VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setLong(1, a.getBarkodNo());
            pst.setString(2, a.getIlacAdi());
            pst.setFloat(3, a.getFiyat());
            pst.setInt(4, a.getAdet());
            pst.setString(5, a.getUretimTarihi());
            pst.setString(6, a.getSonKullanmaTarihi()); 
            pst.setLong(7, a.getFirma().getFirmaId());  
            pst.setString(8, a.getFilePath());
            pst.setString(9, a.getFileName());
            pst.setString(10, a.getFileType());
            
            pst.executeUpdate();        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(ilac a) {
        try {          
            PreparedStatement pst=this.connect().prepareStatement("delete from ilac where barkodno=?");
            pst.setLong(1, a.getBarkodNo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ilac getById(long barkodno) {
        ilac i = null;
        try {            
            PreparedStatement pst=this.connect().prepareStatement("select *from ilac where barkodno= ? order by ilacadi asc");
            pst.setLong(1, barkodno);
            ResultSet rs= pst.executeQuery();
            rs.next();
            firma f = this.getfDao().getById(rs.getLong(7));
            i=new ilac(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5),
                    rs.getString(6), f , rs.getString(8),rs.getString(9),rs.getString(10));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }
      
    public void update(ilac a) {
        
        try {
            PreparedStatement pst=this.connect().prepareStatement("update ilac set fiyat= ? , adet = ? , uretimtarihi= ? , sonkullanmatarihi= ? , ureticifirma= ?  where barkodno= ?");
            pst.setFloat(1, a.getFiyat());
            pst.setInt(2, a.getAdet());
            pst.setString(3, a.getUretimTarihi());
            pst.setString(4, a.getSonKullanmaTarihi());
            pst.setLong(5, a.getFirma().getFirmaId());
            pst.setLong(6, a.getBarkodNo());
            
            pst.executeUpdate();
            
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<ilac> read(int page, int pageSize) {
        List<ilac> aList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst=this.connect().prepareStatement("select *from ilac order by ilacadi asc limit ? , ?");
             pst.setInt(1, start);
            pst.setInt(2, pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                firma f = this.getfDao().getById(rs.getLong(7));
                ilac h = new ilac(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), f,
                rs.getString(8),rs.getString(9),rs.getString(10));
                
                aList.add(h);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }
    
    
  
    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select  count(barkodNo) as count from ilac");

            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public List<ilac> readwithStok() {
        List<ilac> aList = new ArrayList<>();

        try {
            PreparedStatement pst=this.connect().prepareStatement("select *from ilac order by ilacadi asc");
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                firma f = this.getfDao().getById(rs.getLong(7));
                ilac h = new ilac(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), f,
                rs.getString(8),rs.getString(9),rs.getString(10));
                if(rs.getInt(4)>0){
                    aList.add(h);
                }              
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

}
