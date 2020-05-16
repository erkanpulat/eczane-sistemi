
package converter;

import dao.adreslerDao;
import entity.adresler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "adresConverter")
public class adreslerConverter implements Converter{

    private adreslerDao adresDao;

    public adreslerDao getAdresDao() {
        if(adresDao==null){
            adresDao=new adreslerDao();
        }
        return adresDao;
    }

    public void setAdresDao(adreslerDao adresDao) {
        this.adresDao = adresDao;
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getAdresDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        adresler a=(adresler) t;
        return String.valueOf(a.getAdresNo());
    }
    
}
