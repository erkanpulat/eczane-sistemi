
package entity;

public class kisi {

    private Long tcNo;
    private String adSoyad;
    private String dogumTarihi;
    private String cinsiyet;
    private long telefon;

    public kisi() {

    }

    public kisi(Long tcNo, String adSoyad, String dogumTarihi, String cinsiyet, long telefon) {
        this.tcNo = tcNo;
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.cinsiyet = cinsiyet;
        this.telefon = telefon;
    }

    public Long getTcNo() {
        return tcNo;
    }

    public void setTcNo(Long tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {

        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

}
