package controller;

import dao.ilacDao;
import entity.ilac;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@SessionScoped
public class ilacBean implements Serializable {

    private ilacDao iDao;
    private ilac entity;

    private Part doc;

    private final String uploadTo = "/upload/";
    private List<ilac> aList;

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
        this.pageCount = (int) Math.ceil(this.iDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() throws IOException {

        InputStream input = doc.getInputStream();
        Files.createDirectories(Paths.get(uploadTo));
        File f = new File(uploadTo + doc.getSubmittedFileName());
        f.getParentFile();
        Files.copy(input, f.toPath());
        this.entity.setFilePath(uploadTo);
        this.entity.setFileName(f.getName());
        this.entity.setFileType(doc.getContentType());

        this.getiDao().create(this.getEntity());

        this.entity = new ilac();
        return "/secret/ilac/list";
    }

    public String updateForm(ilac c) {
        this.entity = c;
        return "/secret/ilac/update";
    }

    public String update() {
        this.getiDao().update(entity);
        this.entity = new ilac();
        return "/secret/ilac/list";
    }

    public String delete() {
        if (this.getiDao().delete(this.getEntity())) {
            File f = new File(uploadTo + this.getEntity().getFileName());
            f.delete();
        }
        this.entity = new ilac();
        return "/secret/ilac/list";
    }

    public String deleteConfirm(ilac a) {
        this.entity = a;
        return "/secret/ilac/confirmDelete";
    }

    public List<ilac> getRead() {
        this.aList = this.getiDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<ilac> aList) {
        this.aList = aList;
    }

    public List<ilac> getReadwithStok() {

        return this.getiDao().readwithStok();
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

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }

}
