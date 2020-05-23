
package converter;

import dao.hastaDao;
import entity.hasta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="hastaConverter")
public class hastaConverter implements Converter{

    private hastaDao hDao;

    public hastaDao gethDao() {
        if(this.hDao==null){
            this.hDao=new hastaDao();
        }
        return hDao;
    }

    public void sethDao(hastaDao hDao) {
        this.hDao = hDao;
    }
    
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.gethDao().getById(Long.valueOf(string));

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {

        hasta f=(hasta)t;
        return String.valueOf(f.getTcNo()
        );
    }
    
}
