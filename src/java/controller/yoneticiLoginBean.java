package controller;

import dao.yoneticiDao;
import entity.yonetici;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class yoneticiLoginBean implements Serializable {

    private yonetici uyeyonetici;
    private yoneticiDao yDao;

    public String login() {
        
        uyeyonetici = getyDao().girisYap(this.uyeyonetici.getTcNo(), this.uyeyonetici.getSifre());

        if (this.uyeyonetici != null) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uyeyonetici);
            return "/secret/secret?faces-redirect=true";
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hatalı Giriş", "Hatalı Giriş"));

            return "/login";
        }
       
    }

    
    public yonetici getUyeyonetici() {
        
        return uyeyonetici == null ? uyeyonetici = new yonetici() : uyeyonetici;
    }

    public void setUyeyonetici(yonetici uyeyonetici) {
        this.uyeyonetici = uyeyonetici;
    }

    public yoneticiDao getyDao() {
        return yDao == null ? yDao = new yoneticiDao() : yDao;
    }

}
