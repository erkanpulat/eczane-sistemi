/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author hanifi
 */
public class personel extends kisi{
    private String departman;
    private float maas;
    private int adresNo;

    public personel(String departman, float maas, int adresNo) {
        this.departman = departman;
        this.maas = maas;
        this.adresNo = adresNo;
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

    public int getAdresNo() {
        return  adresNo;
    }

    public void setAdresNo(int adresNo) {
        this.adresNo = adresNo;
    }
    
    
}
