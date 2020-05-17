
package entity;

public class ilac {
    private long barkodNo;
    private String ilacAdi;
    private float fiyat;
    private int adet;
    private String uretimTarihi;
    private String sonKullanmaTarihi;
    private firma firma;

    public ilac() {
    }

    public ilac(long barkodNo, String ilacAdi, float fiyat, int adet, String uretimTarihi, String sonKullanmaTarihi, firma firma) {
        this.barkodNo = barkodNo;
        this.ilacAdi = ilacAdi;
        this.fiyat = fiyat;
        this.adet = adet;
        this.uretimTarihi = uretimTarihi;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.firma = firma;
    }

    public long getBarkodNo() {
        return barkodNo;
    }

    public void setBarkodNo(long barkodNo) {
        this.barkodNo = barkodNo;
    }

    public String getIlacAdi() {
        return ilacAdi;
    }

    public void setIlacAdi(String ilacAdi) {
        this.ilacAdi = ilacAdi;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public String getUretimTarihi() {
        return uretimTarihi;
    }

    public void setUretimTarihi(String uretimTarihi) {
        this.uretimTarihi = uretimTarihi;
    }

    public String getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public firma getFirma() {
        return firma;
    }

    public void setFirma(firma firma) {
        this.firma = firma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.barkodNo ^ (this.barkodNo >>> 32));
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
        final ilac other = (ilac) obj;
        if (this.barkodNo != other.barkodNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ilac{" + "barkodNo=" + barkodNo + ", ilacAdi=" + ilacAdi + ", fiyat=" + fiyat + ", adet=" + adet + ", uretimTarihi=" + uretimTarihi + ", sonKullanmaTarihi=" + sonKullanmaTarihi + ", firma=" + firma + '}';
    }

    
    
    

    
}
