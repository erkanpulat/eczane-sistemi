/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yonetici;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author user
 */
public class yoneticiDao extends DbConnection{
    
    public void create(yonetici a) {      
        String query = "insert into yonetici(tcNo,adSoyad,dogumTarihi,cinsiyet,telefon,departman,maas,adresNo) VALUES("+a.getTcNo()+",'"+a.getAdSoyad()+"','"+a.getDogumTarihi()+"','"+
                a.getCinsiyet()+"',"+a.getTelefon()+",'"+a.getDepartman()+"',"+a.getMaas()+","+a.getAdresNo()+")";
        String query2="insert into yoneticigiris(tcno,sifre) VALUES("+a.getTcNo()+",'"+a.getSifre()+"')";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(yonetici a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from yoneticigiris where tcno="+a.getTcNo());
            st.executeUpdate("delete from yonetici where tcNo=" + a.getTcNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void update(yonetici a){
         String query="update yonetici set telefon="+a.getTelefon()+", departman='"+a.getDepartman()+"',maas="+a.getMaas()+", adresNo="+a.getAdresNo()+
                 " where tcNo="+a.getTcNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<yonetici> read(){
        List<yonetici> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from yonetici order by adresNo asc");
            while(rs.next()){
                yonetici h=new yonetici(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getLong(5), rs.getString(6),rs.getFloat(7),rs.getInt(8));
                aList.add(h);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    
}
