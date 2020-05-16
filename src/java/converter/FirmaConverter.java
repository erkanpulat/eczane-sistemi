/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.firmaDao;
import entity.firma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author LENOVO
 */
@FacesConverter(value="firmaConverter")
public class FirmaConverter implements Converter{

    private firmaDao fDao;

    public firmaDao getfDao() {
        if(this.fDao==null){
            this.fDao=new firmaDao();
        }
        return fDao;
    }

    public void setfDao(firmaDao fDao) {
        this.fDao = fDao;
    }
    
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getfDao().getById(Integer.valueOf(string));

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {

        firma f=(firma)t;
        return String.valueOf(f.getFirmaId());
    }
    
}
