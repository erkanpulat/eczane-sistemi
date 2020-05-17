
package converter;

import dao.ilacDao;
import entity.ilac;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ilacConverter")
public class ilacConverter implements Converter{
    public ilacDao iDao;

    public ilacDao getiDao() {
        if(iDao==null){
            iDao=new ilacDao();
        }
        return iDao;
    }

    public void setiDao(ilacDao iDao) {
        this.iDao = iDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getiDao().getById(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        ilac i=(ilac) t;
        return String.valueOf(i.getBarkodNo());
    }
    
    
}
