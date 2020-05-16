
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
    
}
