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
    private List<yonetici> aList;

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
        this.pageCount = (int) Math.ceil(this.yDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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

    public String deleteConfirm(yonetici a) {
        this.entity = a;
        return "/yonetici/confirmDelete";
    }

    public List<yonetici> getRead() {
        this.aList = this.getyDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<yonetici> aList) {
        this.aList = aList;
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
