/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adreslerDao;
import entity.adresler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped

public class adreslerBean implements Serializable{
    private adreslerDao aDao;
    private adresler entity;
    private boolean showPopup;
    private long no;

    public String create() {
        this.getaDao().create(entity);
        this.entity = new adresler();
        return "/adresler/list";
    }

    public String updateForm(adresler c) {
        this.entity = c;
        return "/adresler/update";
    }

    public String update() {
        this.getaDao().update(entity);
        this.entity = new adresler();
        return "/adresler/list";
    }

    public void delete(adresler c) {
        this.getaDao().delete(c);
    }
    public String adresBilgisiGoster(int a){
        return this.getaDao().adresBilgiDondur(a);
    }
    public List<Integer> getReadNo() {
        return this.getaDao().adresnoRead();
    }
    public List<adresler> getRead() {
        return this.getaDao().read();
    }

    public adreslerDao getaDao() {
        if (this.aDao == null) {
            aDao = new adreslerDao();
        }
        return aDao;
    }

    public adresler getEntity() {
        if (this.entity == null) {
            entity = new adresler();
        }
        return entity;
    }

    public void setaDao(adreslerDao aDao) {
        this.aDao = aDao;
    }

    public void setEntity(adresler entity) {
        this.entity = entity;
    }
        
    public void show(long a){
        this.setNo(a);
        showPopup=true;
    }
    public void hide(){
        showPopup=false;
    }

    public boolean isShowPopup() {
        return showPopup;
    }

    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }
    
    

}
