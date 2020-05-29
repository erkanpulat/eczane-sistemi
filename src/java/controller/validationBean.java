/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author LENOVO
 */
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.lang.Long;

@Named
@SessionScoped
public class validationBean implements Serializable {

    public void uzunlukValidate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = value.toString();
        if (str.length() < 8) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "En az 8 karakter olmalıdır.", "En az 8 karakter olmalıdır."));
        }
        if (str.length() > 20) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "En fazla 20 Karakter Olmalıdır", "En fazla 20 Karakter Olmalıdır"));
        }

    }

    public void bosMuValidate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = value.toString();
        if (str.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Boş bırakılamaz!", "Boş bırakılamaz!"));

        }
    }
     public void bosMuValidate2(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if (value==null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Boş bırakılamaz!", "Boş bırakılamaz!"));

        }
    }

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part part = (Part) value;
        if (part == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dosya seçilmedi!", "Dosya seçilmedi!"));
        }
        if (("image/jpeg".equals(part.getContentType()))) {

        } else if (("image/png".equals(part.getContentType()))) {

        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resim dosyası değil!", "Resim dosyası değil!"));
        }
    }

}
