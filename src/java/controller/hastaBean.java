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
    private List<hasta> aList;

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
        this.pageCount = (int) Math.ceil(this.hDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() {
        this.gethDao().create(entity);
        this.entity = new hasta();
        return "/secret/hasta/list";
    }

    public String updateForm(hasta c) {
        this.entity = c;
        return "/secret/hasta/update";
    }

    public String update() {
        this.gethDao().update(entity);
        this.entity = new hasta();
        return "/secret/hasta/list";
    }

    public String delete() {
        this.gethDao().delete(this.getEntity());
        this.entity = new hasta();
        return "/secret/hasta/list";
    }

    public String deleteConfirm(hasta a) {
        this.entity = a;
        return "/secret/hasta/confirmDelete";
    }

    public List<hasta> getRead() {
        this.aList = this.gethDao().read(page, pageSize);
        return aList;
    }
    public List<hasta> getRead2() {
        this.aList = this.gethDao().read2();
        return aList;
    }
    public void setaList(List<hasta> aList) {
        this.aList = aList;
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
