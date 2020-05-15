/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.depoPersonelDao;
import entity.depoPersonel;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hanifi
 */
@ManagedBean
@SessionScoped
public class depoPersonelBean implements Serializable {
    private depoPersonelDao dpDao;
    private depoPersonel entity;

    public String create() {
        this.getdpDao().create(entity);
        this.entity = new depoPersonel();
        return "/depopersonel/list";
    }

    public String updateForm(depoPersonel c) {
        this.entity = c;
        return "/depopersonel/update";
    }

    public String update() {
        this.getdpDao().update(entity);
        this.entity = new depoPersonel();
        return "/depopersonel/list";
    }

    public void delete(depoPersonel c) {
        this.getdpDao().delete(c);
    }

    public List<depoPersonel> getRead() {
        return this.getdpDao().read();
    }

    public depoPersonelDao getdpDao() {
        if (this.dpDao == null) {
            dpDao = new depoPersonelDao();
        }
        return dpDao;
    }

    public depoPersonel getEntity() {
        if (this.entity == null) {
            entity = new depoPersonel();
        }
        return entity;
    }

    public void setdpDao(depoPersonelDao dpDao) {
        this.dpDao = dpDao;
    }

    public void setEntity(depoPersonel entity) {
        this.entity = entity;
    }
  
}
