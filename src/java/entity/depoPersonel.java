
package entity;

public class depoPersonel extends personel {

    private String sifre;
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

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
     
     
 
}
