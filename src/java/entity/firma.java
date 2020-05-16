
package entity;

public class firma {

    private long firmaId;
    private String firmaAdi;
    private adresler adresEntity;
    private long telefon;

    public firma() {
    }

    public firma(long firmaId, String firmaAdi, adresler adresEntity, long telefon) {
        this.firmaId = firmaId;
        this.firmaAdi = firmaAdi;
        this.adresEntity = adresEntity;
        this.telefon = telefon;
    }

    public long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(long firmaId) {
        this.firmaId = firmaId;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public adresler getAdresEntity() {
        return adresEntity;
    }

    public void setAdresEntity(adresler adresEntity) {
        this.adresEntity = adresEntity;
    }
    
    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.firmaId ^ (this.firmaId >>> 32));
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
        final firma other = (firma) obj;
        if (this.firmaId != other.firmaId) {
            return false;
        }
        return true;
    }

  

}