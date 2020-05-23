package dao;

import entity.adresler;
import entity.hasta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class hastaDao extends DbConnection {

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

    public void create(hasta a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into hasta VALUES(?,?,?,?,?,?)");
            pst.setLong(1, a.getTcNo());
            pst.setString(2, a.getAdSoyad());
            pst.setString(3, a.getDogumTarihi());
            pst.setString(4, a.getCinsiyet());
            pst.setLong(5, a.getTelefon());
            pst.setInt(6, a.getAdresEntity().getAdresNo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(hasta a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from hasta where tcno=?");
            pst.setLong(1, a.getTcNo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(hasta a) {

        try {
            PreparedStatement pst = this.connect().prepareStatement("update hasta set telefon= ? , adresNo= ?  where tcno= ?");
            pst.setLong(1, a.getTelefon());
            pst.setInt(2, a.getAdresEntity().getAdresNo());
            pst.setLong(3, a.getTcNo());

            pst.executeUpdate();

            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<hasta> read() {
        List<hasta> aList = new ArrayList<>();
        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from hasta order by adsoyad asc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                adresler a = this.getaDao().getById(rs.getInt(6));
                hasta h = new hasta(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getLong(5), a);
                aList.add(h);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public hasta getById(long tcno) {
        hasta h = null;
        try {
            
            if (tcno != 0) {
                PreparedStatement pst = this.connect().prepareStatement("select *from hasta where tcno=?");
                pst.setLong(1, tcno);

                ResultSet rs = pst.executeQuery();
                rs.next();
                adresler a = this.getaDao().getById(rs.getInt(6));
                h = new hasta(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getLong(5), a);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return h;
    }

}
