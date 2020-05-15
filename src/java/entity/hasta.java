package entity;


public class hasta extends kisi {

    private int adresNo;

    public hasta() {
    }

    public hasta(long tcNo, String adSoyad, String dogumTarihi, String cinsiyet, long telefon, int adresNo ) {
        super(tcNo, adSoyad, dogumTarihi, cinsiyet, telefon);
        this.adresNo = adresNo;
    }

    public int getAdresNo() {
        return adresNo;
    }

    public void setAdresNo(int adresNo) {
        this.adresNo = adresNo;
    }
    
}
