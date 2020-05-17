package controller;


import dao.depoPersonelDao;
import entity.depoPersonel;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
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

    public String delete() {
        this.getdpDao().delete(this.getEntity());
        this.entity = new depoPersonel();
        return "/depopersonel/list";
    }
    
    public String deleteConfirm(depoPersonel a){
        this.entity=a;
        return "/depopersonel/confirmDelete";
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
