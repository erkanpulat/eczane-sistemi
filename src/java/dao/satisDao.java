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

    public void create(ArrayList<satis> list) {

        for (int i = 0; i < list.size(); i++) {
            try {
                
                PreparedStatement pst = this.connect().prepareStatement("insert into satis(tcno,barkodno) VALUES(?,?)");
                pst.setLong(1, list.get(i).getHastaEntity().getTcNo());
                pst.setLong(2, list.get(i).getIlacEntity().getBarkodNo());

                pst.executeUpdate();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
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

    public List<satis> read(int page, int pageSize) {
        List<satis> aList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from satis order by satisId desc limit ? , ?");
            pst.setInt(1, start);
            pst.setInt(2, pageSize);
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

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select  count(satisid) as count from satis");

            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
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

    public void stokDus(satis a) {

        try {

            PreparedStatement pst2 = this.connect().prepareStatement("update ilac set adet=adet-1 where barkodno=?");
            pst2.setLong(1, a.getIlacEntity().getBarkodNo());

            pst2.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void stokArttir(satis a) {

        try {

            PreparedStatement pst2 = this.connect().prepareStatement("update ilac set adet=adet+1 where barkodno=?");
            pst2.setLong(1, a.getIlacEntity().getBarkodNo());

            pst2.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
