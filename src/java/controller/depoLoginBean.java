package controller;

import dao.depoPersonelDao;
import entity.depoPersonel;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class depoLoginBean implements Serializable {

    private depoPersonel uyeyonetici;
    private depoPersonelDao yDao;

    public String login() {

        uyeyonetici = getyDao().girisYap(this.uyeyonetici.getTcNo(), this.uyeyonetici.getSifre());

        if (this.uyeyonetici != null) {
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uyeyonetici);
            return "/secret/secret?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hatalı Giriş", "Hatalı Giriş"));

            return "/login2";
        }
    }

    public depoPersonel getUyeyonetici() {
        return uyeyonetici == null ? uyeyonetici = new depoPersonel() : uyeyonetici;
    }

    public void setUyeyonetici(depoPersonel uyeyonetici) {
        this.uyeyonetici = uyeyonetici;
    }

    public depoPersonelDao getyDao() {
        return yDao == null ? yDao = new depoPersonelDao() : yDao;
    }

}
