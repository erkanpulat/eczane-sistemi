package dao;

import entity.adresler;
import entity.depoPersonel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class depoPersonelDao extends DbConnection {

    adreslerDao aDao;

    public adreslerDao getaDao() {
        if (aDao == null) {
            aDao = new adreslerDao();
        }
        return aDao;
    }

    public void create(depoPersonel a) {

        try {
            PreparedStatement pst1 = this.connect().prepareStatement("insert into depoPersonel VALUES(?,?,?,?,?,?,?,?)");
            pst1.setLong(1, a.getTcNo());
            pst1.setString(2, a.getAdSoyad());
            pst1.setString(3, a.getDogumTarihi());
            pst1.setString(4, a.getCinsiyet());
            pst1.setLong(5, a.getTelefon());
            pst1.setString(6, a.getDepartman());
            pst1.setFloat(7, a.getMaas());
            pst1.setInt(8, a.getAdresEntity().getAdresNo());

            PreparedStatement pst2 = this.connect().prepareStatement("insert into depogiris VALUES(?,?)");
            pst2.setLong(1, a.getTcNo());
            pst2.setString(2, a.getSifre());

            pst1.executeUpdate();
            pst2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(depoPersonel a) {
        try {
            PreparedStatement pst1 = this.connect().prepareStatement("delete from depogiris where tcno=?");
            pst1.setLong(1, a.getTcNo());
            PreparedStatement pst2 = this.connect().prepareStatement("delete from depopersonel where tcno=?");
            pst2.setLong(1, a.getTcNo());
            pst1.executeUpdate();
            pst2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(depoPersonel a) {

        try {
            PreparedStatement pst = this.connect().prepareStatement("update depopersonel set telefon= ? , departman= ?, maas= ? , adresNo= ?  where tcno= ?");
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

    public List<depoPersonel> read() {
        List<depoPersonel> aList = new ArrayList<>();

        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from depopersonel order by adsoyad asc");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                adresler a = this.getaDao().getById(rs.getInt(8));
                depoPersonel h = new depoPersonel(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
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

}
