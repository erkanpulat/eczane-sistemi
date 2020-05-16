/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.firmaDao;
import entity.firma;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author Hanifi
 */
@Named
@SessionScoped
public class firmaBean implements Serializable {
     private firmaDao fDao;
    private firma entity;

    public String create() {
        this.getfDao().create(entity);
        this.entity = new firma();
        return "/firma/list";
    }

    public String updateForm(firma c) {
        this.entity = c;
        return "/firma/update";
    }

    public String update() {
        this.getfDao().update(entity);
        this.entity = new firma();
        return "/firma/list";
    }

    public void delete(firma c) {
        this.getfDao().delete(c);
    }

    public List<firma> getRead() {
        return this.getfDao().read();
    }

    public firmaDao getfDao() {
        if (this.fDao == null) {
            fDao = new firmaDao();
        }
        return fDao;
    }

    public firma getEntity() {
        if (this.entity == null) {
            entity = new firma();
        }
        return entity;
    }

    public void setfDao(firmaDao fDao) {
        this.fDao = fDao;
    }

    public void setEntity(firma entity) {
        this.entity = entity;
    }
  


  public List<String> getFirmaReadNo() {
        return this.getfDao().firmanoRead();
    }
}
