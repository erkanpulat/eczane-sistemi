/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.adresler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class adreslerDao extends DbConnection {

    public void create(adresler a) {
        String query = "insert into adresler(sehir,ilce,mahalle,sokakcadde,binano,kapino) VALUES('"
                    + a.getSehir() + "','" + a.getIlce() + "','"
                    + a.getMahalle() + "','" + a.getSokakCadde() + "','" + a.getBinaNo() + "','" + a.getKapiNo() + "')";
        try {           
            Statement st = this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(adresler a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from adresler where adresno=" + a.getAdresNo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
    }
     public void update(adresler a){
         String query="update adresler set sehir='"+a.getSehir()+"',ilce='"+a.getIlce()+"',mahalle='"+a.getMahalle()+"',"
                 + " sokakcadde='"+a.getSokakCadde()+"',binano="+a.getBinaNo()+",kapino="+a.getKapiNo()+
                 " where adresno="+a.getAdresNo();
        try {
            Statement st=this.connect().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
    }
     public List<adresler> read(){
        List<adresler> aList = new ArrayList<>();
        
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from adresler order by adresno asc");
            while(rs.next()){
                adresler a=new adresler(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                        , rs.getInt(6),rs.getInt(7));
                aList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
    }
     public String adresBilgiDondur(int a){
         String adres="";
         try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select *from adresler where adresno="+a);
            while(rs.next()){
                adres= rs.getString(2) +" "+ rs.getString(3) +" "+ rs.getString(4) +" Mahallesi "+ rs.getString(5)
                        +" Sokak  No:"+ rs.getInt(6)+" Daire:  "+rs.getInt(7);            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }     
        return adres;
     }
    
     public List<Integer> adresnoRead(){
        List<Integer> aList = new ArrayList<>();      
        try {
            Statement st=this.connect().createStatement();
            ResultSet rs= st.executeQuery("select adresno from adresler order by adresno asc");
            while(rs.next()){
                aList.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }      
        return aList;
     }
   
}
