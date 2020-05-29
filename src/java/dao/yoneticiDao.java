package dao;

import entity.adresler;
import entity.yonetici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class yoneticiDao extends DbConnection {

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

    public void create(yonetici a) {
        try {
            PreparedStatement pst1 = this.connect().prepareStatement("insert into yonetici VALUES(?,?,?,?,?,?,?,?)");
            pst1.setLong(1, a.getTcNo());
            pst1.setString(2, a.getAdSoyad());
            pst1.setString(3, a.getDogumTarihi());
            pst1.setString(4, a.getCinsiyet());
            pst1.setLong(5, a.getTelefon());
            pst1.setString(6, a.getDepartman());
            pst1.setFloat(7, a.getMaas());
            pst1.setInt(8, a.getAdresEntity().getAdresNo());

            PreparedStatement pst2 = this.connect().prepareStatement("insert into yoneticigiris VALUES(?,?)");
            pst2.setLong(1, a.getTcNo());
            pst2.setString(2, a.getSifre());

            pst1.executeUpdate();
            pst2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(yonetici a) {
        try {
            PreparedStatement pst1 = this.connect().prepareStatement("delete from yoneticigiris where tcno=?");
            pst1.setLong(1, a.getTcNo());
            PreparedStatement pst2 = this.connect().prepareStatement("delete from yonetici where tcno=?");
            pst2.setLong(1, a.getTcNo());
            pst1.executeUpdate();
            pst2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(yonetici a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("update yonetici set telefon= ? , departman= ?, maas= ? , adresNo= ?  where tcno= ?");
            pst.setLong(1, a.getTelefon());
            pst.setString(2, a.getDepartman());
            pst.setFloat(3, a.getMaas());
            pst.setInt(4, a.getAdresEntity().getAdresNo());
            pst.setLong(5, a.getTcNo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<yonetici> read(int page, int pageSize) {
        List<yonetici> aList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from yonetici order by adsoyad asc limit ?, ?");

            pst.setInt(1, start);
            pst.setInt(2, pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                adresler a = this.getaDao().getById(rs.getInt(8));
                yonetici h = new yonetici(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getLong(5), rs.getString(6), rs.getFloat(7), a);
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
            PreparedStatement pst = this.connect().prepareStatement("select  count(tcNo) as count from yonetici");

            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
            public yonetici girisYap(long tcNo,String sifre) {
        yonetici tmp = null;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from yoneticigiris where tcNo = ? and sifre = ?");
            pst.setLong(1, tcNo);
            pst.setString(2, sifre);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                tmp = new yonetici();
                tmp.setTcNo(rs.getLong("tcNo"));
                tmp.setSifre(rs.getString("sifre"));
               

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

}
