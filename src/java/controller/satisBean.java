
package controller;

import dao.satisDao;
import entity.satis;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped

public class satisBean implements Serializable{
    private satisDao aDao;
    private satis entity;
    private List<satis> aList;
    private static ArrayList<satis> satisArrayList;
    private static float toplamFiyat;
    
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

    public void addList(){
        satisArrayList.add(entity);
        this.getaDao().stokDus(this.entity);
        this.entity=new satis();      
    }
    public void deleteList(satis s){
        this.getaDao().stokArttir(s);
        satisArrayList.remove(s);
    }
    public String create() {
        this.getaDao().create(satisArrayList);
        this.satisArrayList=new ArrayList<>();
        this.setToplamFiyat(0);
        this.getEntity().setPopup(true);
        return "/secret/satis/create";
    }
    
    public String listForm(){
        this.entity=new satis();
        return "/secret/satis/list";
    }

    public String updateForm(satis c) {
        this.entity = c;
        return "/secret/satis/update";
    }

    public String update() {
        this.getaDao().update(entity);
        this.entity = new satis();
        return "/secret/satis/list";
    }

  
    public String delete() {
        this.getaDao().delete(this.getEntity());
        this.entity = new satis();
        return "/secret/satis/list";
    }
    public String deleteConfirm(satis a){
        this.entity=a;
        return "/secret/satis/confirmDelete";
    } 
    
     public List<satis> getRead() {
        this.aList = this.getaDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<satis> aList) {
        this.aList = aList;
    }

    public List<satis> getReadwithtcno(satis s) {   
        System.out.println("************"+s.getHastaEntity());
        return this.getaDao().readWithTcNo(s.getHastaEntity().getTcNo());
    }

    public satisDao getaDao() {
        if (this.aDao == null) {
            aDao = new satisDao();
        }
        return aDao;
    }

    public satis getEntity() {
        if (this.entity == null) {
            entity = new satis();
        }
        return entity;
    }

    public void setaDao(satisDao aDao) {
        this.aDao = aDao;
    }

    public void setEntity(satis entity) {
        this.entity = entity;
    }

    public ArrayList<satis> getSatisArrayList() {
        if(this.satisArrayList==null){
            satisArrayList= new ArrayList<>();
        }
        return satisArrayList;
    }

    public void setSatisArrayList(ArrayList<satis> satisArrayList) {
        this.satisArrayList = satisArrayList;
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
        this.pageCount = (int) Math.ceil(this.aDao.count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public float getToplamFiyat() {
        toplamFiyat=0;
        for(int i =0;i<this.getSatisArrayList().size();i++){
            toplamFiyat+=this.getSatisArrayList().get(i).getIlacEntity().getFiyat();
        }
        return toplamFiyat;
    }

    public static void setToplamFiyat(float toplamFiyat) {
        satisBean.toplamFiyat = toplamFiyat;
    }
    
    

}
