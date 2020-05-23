package dao;

import entity.hasta;
import entity.ilac;
import entity.satis;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class satisDao extends DbConnection {

    private ilacDao iDao;
    private hastaDao hDao;

    public ilacDao getiDao() {
        if (iDao == null) {
            iDao = new ilacDao();
        }
        return iDao;
    }

    public void setiDao(ilacDao iDao) {
        this.iDao = iDao;
    }

    public hastaDao gethDao() {
        if (hDao == null) {
            hDao = new hastaDao();
        }
        return hDao;
    }

    public void sethDao(hastaDao hDao) {
        this.hDao = hDao;
    }

    public void create(satis a) {

        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into satis(tcno,barkodno) VALUES(?,?)");
            PreparedStatement pst2 = this.connect().prepareStatement("update ilac set adet=adet-1 where barkodno=?");
            pst.setLong(1, a.getHastaEntity().getTcNo());
            pst.setLong(2, a.getIlacEntity().getBarkodNo());
            pst2.setLong(1, a.getIlacEntity().getBarkodNo());

            pst.executeUpdate();
            pst2.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(satis a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from satis where satisid=?");
            pst.setInt(1, a.getSatisId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(satis a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("update satis set tcno= ? , barkodno= ? "
                    + " where satisid= ?");

            pst.setLong(1, a.getHastaEntity().getTcNo());
            pst.setLong(2, a.getIlacEntity().getBarkodNo());
            pst.setInt(3, a.getSatisId());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<satis> read() {
        List<satis> aList = new ArrayList<>();

        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from satis order by satisId desc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ilac i = this.getiDao().getById(rs.getLong(3));
                hasta hst = this.gethDao().getById(rs.getLong(2));
                satis h = new satis(rs.getInt(1), hst, i, rs.getDate(4));
                aList.add(h);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public List<satis> readWithTcNo(long tcNo) {
        List<satis> aList = new ArrayList<>();
        if (tcNo != 0) {
            try {
                PreparedStatement pst = this.connect().prepareStatement("select *from satis where tcno=? order by satisId desc");
                pst.setLong(1, tcNo);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    ilac i = this.getiDao().getById(rs.getLong(3));
                    hasta hst = this.gethDao().getById(rs.getLong(2));
                    satis h = new satis(rs.getInt(1), hst, i, rs.getDate(4));
                    aList.add(h);

                }
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return aList;
    }

}
