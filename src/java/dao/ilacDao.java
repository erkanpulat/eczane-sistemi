/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ilac;
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
public class ilacDao extends DbConnection{
    
    
    public void create(ilac a) {
        
        String query = "insert into ilac VALUES("+a.getBarkodNo()+",'"+a.getIlacAdi()+"',"+a.getFiyat()+","+
                a.getAdet()+",'"+a.getUretimTarihi()+"','"+a.getSonKullanmaTarihi()+"',"+a.getUreticiFirma()+")";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   public void delete(ilac a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ilac where barkodno=" + a.getBarkodNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void update(ilac a){
         String query="update ilac set barkodno="+a.getBarkodNo()+", ilacadi='"+a.getIlacAdi()+
                 "',fiyat="+a.getFiyat()+",adet="+a.getAdet()+",uretimtarihi='"+a.getUretimTarihi()+"',sonkullanmatarihi='"+a.getSonKullanmaTarihi()+"',ureticifirma='"+a.getUreticiFirma()+"' where barkodno="+a.getBarkodNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
      public long ilacFirma(String a){
         long firmaid=0;
         try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select firmaid from firma where firmaadi='"+a+"'");
            while(rs.next()){
                firmaid=rs.getLong(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }     
        return firmaid;
     }
      public String ilacFirmaId(long a){
         String firmaadi="";
         try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select firmaadi from firma where firmaid="+a);
            while(rs.next()){
                firmaadi=rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }     
        return firmaadi;
     }
      
     public List<ilac> read(){
        List<ilac> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from ilac ");
            while(rs.next()){
                ilac h=new ilac(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6),rs.getLong(7));
                aList.add(h);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
    
}
