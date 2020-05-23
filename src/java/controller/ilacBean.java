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

    public String delete() {
        File f = new File(uploadTo+this.getEntity().getFileName());        
        f.delete();
        this.getiDao().delete(this.getEntity());
        this.entity = new ilac();
        return "/ilac/list";
    }

    public String deleteConfirm(ilac a) {
        this.entity = a;
        return "/ilac/confirmDelete";
    }

    public List<ilac> getRead() {
        return this.getiDao().read();
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
