/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.hasta;
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
public class hastaDao extends DbConnection{
    
    public void create(hasta a) {
        
        String query = "insert into hasta(tcno,adsoyad,dogumTarihi,cinsiyet,telefon,adresno) VALUES("+a.getTcNo()+",'"+a.getAdSoyad()+"','"+a.getDogumTarihi()+"','"+
                a.getCinsiyet()+"',"+a.getTelefon()+","+a.getAdresNo()+")";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(hasta a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hasta where tcno=" + a.getTcNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void update(hasta a){
         String query="update hasta set telefon="+a.getTelefon()+", adresNo="+a.getAdresNo()+
                 " where tcno="+a.getTcNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<hasta> read(){
        List<hasta> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from hasta order by adresNo asc");
            while(rs.next()){
                hasta h=new hasta(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getLong(5), rs.getInt(6));
                aList.add(h);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    
}
