
package controller;

import dao.yoneticiDao;

import entity.yonetici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped

public class yoneticiBean implements Serializable {

    private yoneticiDao yDao;
    private yonetici entity;

    public String create() {
        this.getyDao().create(entity);
        this.entity = new yonetici();
        return "/yonetici/list";
    }

    public String updateForm(yonetici c) {
        this.entity = c;
        return "/yonetici/update";
    }

    public String update() {
        this.getyDao().update(entity);
        this.entity = new yonetici();
        return "/yonetici/list";
    }

 
    public String delete() {
        this.getyDao().delete(this.getEntity());
        this.entity = new yonetici();
        return "/yonetici/list";
    }
    public String deleteConfirm(yonetici a){
        this.entity=a;
        return "/yonetici/confirmDelete";
    }

    public List<yonetici> getRead() {
        return this.getyDao().read();
    }

    public yoneticiDao getyDao() {
        if (this.yDao == null) {
            yDao = new yoneticiDao();
        }
        return yDao;
    }

    public yonetici getEntity() {
        if (this.entity == null) {
            entity = new yonetici();
        }
        return entity;
    }

    public void setyDao(yoneticiDao yDao) {
        this.yDao = yDao;
    }

    public void setEntity(yonetici entity) {
        this.entity = entity;
    }

}
