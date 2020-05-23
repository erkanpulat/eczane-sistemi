
package entity;

public class kisi {

    private long tcNo=0;
    private String adSoyad;
    private String dogumTarihi;
    private String cinsiyet;
    private long telefon;

    public kisi() {

    }

    public kisi(long tcNo, String adSoyad, String dogumTarihi, String cinsiyet, long telefon) {
        this.tcNo = tcNo;
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.cinsiyet = cinsiyet;
        this.telefon = telefon;
    }

    public long getTcNo() {
        return tcNo;
    }

    public void setTcNo(long tcNo) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.tcNo ^ (this.tcNo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final kisi other = (kisi) obj;
        if (this.tcNo != other.tcNo) {
            return false;
        }
        return true;
    }

    
}
