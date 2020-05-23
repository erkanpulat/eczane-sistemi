package entity;


public class hasta extends kisi {

    private adresler adresEntity;
    
    public hasta() {
        
    }

    public hasta(long tcNo, String adSoyad, String dogumTarihi, String cinsiyet, long telefon, adresler adresEntity ) {
        super(tcNo, adSoyad, dogumTarihi, cinsiyet, telefon);
        this.adresEntity = adresEntity;
    }

    public adresler getAdresEntity() {
        return adresEntity;
    }

    public void setAdresEntity(adresler adresEntity) {
        this.adresEntity = adresEntity;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
    
    
}
