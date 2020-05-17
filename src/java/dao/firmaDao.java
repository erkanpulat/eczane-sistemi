package dao;

import entity.adresler;
import entity.firma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        String query = "insert into firma(firmaAdi,adresNo,telefon) VALUES('" + a.getFirmaAdi() + "'," + a.getAdresEntity().getAdresNo() + "," + a.getTelefon() + ")";
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public firma getById(long id) {
        firma f = null;

        String query = "select * from firma where firmaId=" + id;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery(query);
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
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from firma where firmaId=" + a.getFirmaId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(firma a) {
        String query = "update firma set firmaAdi='" + a.getFirmaAdi() + "', adresNo=" + a.getAdresEntity().getAdresNo() + ",telefon=" + a.getTelefon()
                + " where firmaId=" + a.getFirmaId();
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<firma> read() {
        List<firma> aList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select *from firma order by firmaId asc");
            while (rs.next()) {
                adresler b = this.getaDao().getById(rs.getInt(3));
                firma a = new firma(rs.getLong(1), rs.getString(2), b, rs.getLong(4));
                aList.add(a);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

}
