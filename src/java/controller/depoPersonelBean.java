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
    private List<depoPersonel> aList;

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
        this.pageCount = (int) Math.ceil(this.dpDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public depoPersonelDao getDpDao() {
        return dpDao;
    }

    public void setDpDao(depoPersonelDao dpDao) {
        this.dpDao = dpDao;
    }

    public void setaList(List<depoPersonel> aList) {
        this.aList = aList;
    }

    public List<depoPersonel> getRead() {
        this.aList = this.getdpDao().read(page, pageSize);
        return aList;

    }

    public String create() {
        this.getdpDao().create(entity);
        this.entity = new depoPersonel();
        return "/secret/depopersonel/list";
    }

    public String updateForm(depoPersonel c) {
        this.entity = c;
        return "/secret/depopersonel/update";
    }

    public String update() {
        this.getdpDao().update(entity);
        this.entity = new depoPersonel();
        return "/secret/depopersonel/list";
    }

    public String delete() {
        this.getdpDao().delete(this.getEntity());
        this.entity = new depoPersonel();
        return "/secret/depopersonel/list";
    }

    public String deleteConfirm(depoPersonel a) {
        this.entity = a;
        return "/secret/depopersonel/confirmDelete";
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
