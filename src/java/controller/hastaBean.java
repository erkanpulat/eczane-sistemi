
package controller;

import dao.hastaDao;
import entity.hasta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
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
    
    public String delete() {
        this.gethDao().delete(this.getEntity());
        this.entity = new hasta();
        return "/hasta/list";
    }
    public String deleteConfirm(hasta a){
        this.entity=a;
        return "/hasta/confirmDelete";
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
