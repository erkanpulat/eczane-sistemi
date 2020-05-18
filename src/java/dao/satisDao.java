package dao;

import entity.ilac;
import entity.satis;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class satisDao extends DbConnection {

    private ilacDao iDao;

    public ilacDao getiDao() {
        if (iDao == null) {
            iDao = new ilacDao();
        }
        return iDao;
    }

    public void setiDao(ilacDao iDao) {
        this.iDao = iDao;
    }

    public void create(satis a) {
        String query = "insert into satis(tcno,barkodno) VALUES(" + a.getTcNo() + "," + a.getIlacEntity().getBarkodNo() + ")";
        String query2="update ilac set adet=adet-1 where barkodno="+a.getIlacEntity().getBarkodNo();
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(satis a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from satis where satisId=" + a.getSatisId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(satis a) {
        String query = "update satis set tcno=" + a.getTcNo() + " , barkodno=" + a.getIlacEntity().getBarkodNo() + " where satisId= " + a.getSatisId();
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<satis> read() {
        List<satis> aList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select *from satis order by satisId desc");
            while (rs.next()) {
                ilac i = this.getiDao().getById(rs.getLong(3));
                satis h = new satis(rs.getInt(1), rs.getLong(2), i, rs.getDate(4));
                aList.add(h);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public List<satis> readWithTcNo(long tcNo) {
        List<satis> aList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select *from satis where tcno=" + tcNo);
            while (rs.next()) {
                if (tcNo != 0) {
                              
                    ilac i= this.getiDao().getById(rs.getLong(3));
                    satis h = new satis(rs.getInt(1), rs.getLong(2), i, rs.getDate(4));
                    aList.add(h);
                }
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

}
