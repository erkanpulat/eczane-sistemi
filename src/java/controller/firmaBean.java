package controller;

import dao.firmaDao;
import entity.firma;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped
public class firmaBean implements Serializable {

    private firmaDao fDao;
    private firma entity;
    private List<firma> aList;

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
        this.pageCount = (int) Math.ceil(this.fDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() {
        this.getfDao().create(entity);
        this.entity = new firma();
        return "/secret/firma/list";
    }

    public String updateForm(firma c) {
        this.entity = c;
        return "/secret/firma/update";
    }

    public String update() {
        this.getfDao().update(entity);
        this.entity = new firma();
        return "/secret/firma/list";
    }

    public String delete() {
        this.getfDao().delete(this.getEntity());
        this.entity = new firma();
        return "/secret/firma/list";
    }

    public String deleteConfirm(firma a) {
        this.entity = a;
        return "/secret/firma/confirmDelete";
    }

    public List<firma> getRead() {
        this.aList = this.getfDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<firma> aList) {
        this.aList = aList;
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
}
