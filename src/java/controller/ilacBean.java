/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ilacDao;
import entity.ilac;
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
public class ilacBean implements Serializable {
     private ilacDao iDao;
     private ilac entity;

    public String create() {
        this.getiDao().create(entity);
        this.entity = new ilac();
        return "/ilac/list";
    }

    public String updateForm(ilac c) {
        this.entity = c;
        return "/ilac/update";
    }

   public String update() {
        this.getiDao().update(entity);
        this.entity = new ilac();
        return "/ilac/list";
    }

    public void delete(ilac c) {
        this.getiDao().delete(c);
    }
    
    public String ilacIsmiDondur(long a){    
        return this.getiDao().ilacFirmaId(a);
    }

    public List<ilac> getRead() {
        return this.getiDao().read();
    }

    public ilacDao getiDao() {
        if (this.iDao == null) {
            iDao = new ilacDao();
        }
        return iDao;
    }

    public ilac getEntity() {
        if (this.entity == null) {
            entity = new ilac();
        }
        return entity;
    }

    public void setiDao(ilacDao iDao) {
        this.iDao = iDao;
    }

    public void setEntity(ilac entity) {
        this.entity = entity;
    }
  
}
