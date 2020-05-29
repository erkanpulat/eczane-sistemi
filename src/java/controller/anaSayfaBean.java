
package controller;

import dao.anaSayfaDao;
import entity.anaSayfa;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class anaSayfaBean implements Serializable{
   
    private anaSayfaDao aDao;

    
    public anaSayfa getReadYonetici() {     
        return this.getaDao().read().get(1);
    }
    public anaSayfa getReadDepoPersonel() {     
        return this.getaDao().read().get(0);
    }

    public anaSayfaDao getaDao() {
        if(this.aDao==null){
            aDao=new anaSayfaDao();
        }
        return aDao;
    }

    public void setaDao(anaSayfaDao aDao) {
        this.aDao = aDao;
    }
    
    
}
