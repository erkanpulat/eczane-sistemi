
package entity;

public class personel extends kisi{
    private String departman;
    private float maas;
    private adresler adresEntity;

    public personel(String departman, float maas, adresler adresEntity) {
        this.departman = departman;
        this.maas = maas;
        this.adresEntity=adresEntity;
    }

    public personel() {
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public float getMaas() {
        return maas;
    }

    public void setMaas(float maas) {
        this.maas = maas;
    }

    public adresler getAdresEntity() {
        return adresEntity;
    }

    public void setAdresEntity(adresler adresEntity) {
        this.adresEntity = adresEntity;
    } 
    
}
