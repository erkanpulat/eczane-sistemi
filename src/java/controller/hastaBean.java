/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hastaDao;
import entity.hasta;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class hastaBean implements Serializable {
     private hastaDao hDao;
    private hasta entity;

    public String create() {
        this.gethDao().create(entity);
        this.entity = new hasta();
        return "/hasta/list";
    }

    public String updateForm(hasta c) {
        this.entity = c;
        return "/hasta/update";
    }

    public String update() {
        this.gethDao().update(entity);
        this.entity = new hasta();
        return "/hasta/list";
    }

    public void delete(hasta c) {
        this.gethDao().delete(c);
    }

    public List<hasta> getRead() {
        return this.gethDao().read();
    }

    public hastaDao gethDao() {
        if (this.hDao == null) {
            hDao = new hastaDao();
        }
        return hDao;
    }

    public hasta getEntity() {
        if (this.entity == null) {
            entity = new hasta();
        }
        return entity;
    }

    public void sethDao(hastaDao hDao) {
        this.hDao = hDao;
    }

    public void setEntity(hasta entity) {
        this.entity = entity;
    }
  
}
