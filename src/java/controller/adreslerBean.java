package controller;

import dao.adreslerDao;
import entity.adresler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped

public class adreslerBean implements Serializable {

    private adreslerDao aDao;
    private adresler entity;
    private List<adresler> adreslerList;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.aDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() {
        this.getaDao().create(entity);
        this.entity = new adresler();
        return "/secret/adresler/list";
    }

    public String updateForm(adresler c) {
        this.entity = c;
        return "/secret/adresler/update";
    }

    public String update() {
        this.getaDao().update(entity);
        this.entity = new adresler();
        return "/secret/adresler/list";
    }

    public String delete() {
        this.getaDao().delete(this.getEntity());
        this.entity = new adresler();
        return "/secret/adresler/list";
    }

    public String deleteConfirm(adresler a) {
        this.entity = a;
        return "/secret/adresler/confirmDelete";
    }

    public List<adresler> getRead() {
        this.adreslerList = this.getaDao().read(page, pageSize);
        return adreslerList;
    }
    public List<adresler> getRead2() {
        this.adreslerList = this.getaDao().read2();
        return adreslerList;
    }

    public void setAdreslerList(List<adresler> adreslerList) {
        this.adreslerList = adreslerList;
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
