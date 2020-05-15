/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.depoPersonel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author hanifi
 */
public class depoPersonelDao extends DbConnection{
    
    public void create(depoPersonel a) {
        
        String query = "insert into depopersonel(tcNo,adSoyad,dogumTarihi,cinsiyet,telefon,departman,maas,adresNo) VALUES("+a.getTcNo()+",'"+a.getAdSoyad()+"','"+a.getDogumTarihi()+"','"+
                a.getCinsiyet()+"',"+a.getTelefon()+",'"+a.getDepartman()+"',"+a.getMaas()+","+a.getAdresNo()+")";
        String query2="insert into depogiris(tcno,sifre) VALUES("+a.getTcNo()+",'"+a.getSifre()+"')";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(depoPersonel a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from depogiris where tcno="+a.getTcNo());
            st.executeUpdate("delete from depopersonel where tcNo=" + a.getTcNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void update(depoPersonel a){
         String query="update depopersonel set telefon="+a.getTelefon()+", departman='"+a.getDepartman()+"',maas="+a.getMaas()+", adresNo="+a.getAdresNo()+
                 " where tcNo="+a.getTcNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<depoPersonel> read(){
        List<depoPersonel> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from depopersonel order by adresNo asc");
            while(rs.next()){
                depoPersonel h=new depoPersonel(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getLong(5), rs.getString(6),rs.getFloat(7),rs.getInt(8));
                aList.add(h);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    
}
