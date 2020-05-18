
package controller;

import dao.satisDao;
import entity.satis;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped

public class satisBean implements Serializable{
    private satisDao aDao;
    private satis entity;
    
    public String create() {
        this.getaDao().create(entity);
        this.entity=new satis();
        this.getEntity().setPopup(true);
        return "/satis/create";
    }
    
    public String listForm(){
        this.entity=new satis();
        return "/satis/list";
    }

    public String updateForm(satis c) {
        this.entity = c;
        return "/satis/update";
    }

    public String update() {
        this.getaDao().update(entity);
        this.entity = new satis();
        return "/satis/list";
    }

  
    public String delete() {
        this.getaDao().delete(this.getEntity());
        this.entity = new satis();
        return "/satis/list";
    }
    public String deleteConfirm(satis a){
        this.entity=a;
        return "/satis/confirmDelete";
    }
    
    public List<satis> getRead() {     
        return this.getaDao().read();
    }
    
    public List<satis> getReadwithtcno(satis s) {   
        return this.getaDao().readWithTcNo(s.getTcNo());
    }

    public satisDao getaDao() {
        if (this.aDao == null) {
            aDao = new satisDao();
        }
        return aDao;
    }

    public satis getEntity() {
        if (this.entity == null) {
            entity = new satis();
        }
        return entity;
    }

    public void setaDao(satisDao aDao) {
        this.aDao = aDao;
    }

    public void setEntity(satis entity) {
        this.entity = entity;
    }
    
}
