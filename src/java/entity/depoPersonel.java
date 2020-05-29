
package entity;

public class depoPersonel extends personel {

    private String sifre;
    private String tempTc;
    
    public depoPersonel() {
    }

     public depoPersonel(long tcNo, String adSoyad, String dogumTarihi, String cinsiyet, long telefon,String departman,float maas, adresler adresEntity) {
         super(departman, maas, adresEntity);
         super.setTcNo(tcNo);
         super.setAdSoyad(adSoyad);
         super.setDogumTarihi(dogumTarihi);
         super.setCinsiyet(cinsiyet);
         super.setTelefon(telefon);
      
    }
     
    public String getTempTc() {
        return tempTc;
    }

    public void setTempTc(String tempTc) {
        this.setTcNo(Long.valueOf(tempTc));
        this.tempTc = tempTc;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
     
     
 
}
