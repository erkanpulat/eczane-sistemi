/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author user
 */
public class adresler {

    private int adresNo;
    private String sehir;
    private String ilce;
    private String mahalle;
    private String sokakCadde;
    private int binaNo;
    private int kapiNo;

    public adresler() {
    }

    public adresler(int adresNo, String sehir, String ilce, String mahalle, String sokakCadde, int binaNo, int kapiNo) {
        this.adresNo = adresNo;
        this.sehir = sehir;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.sokakCadde = sokakCadde;
        this.binaNo = binaNo;
        this.kapiNo = kapiNo;
    }

    public int getAdresNo() {
        return adresNo;
    }

    public void setAdresNo(int adresNo) {
        this.adresNo = adresNo;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getSokakCadde() {
        return sokakCadde;
    }

    public void setSokakCadde(String sokakCadde) {
        this.sokakCadde = sokakCadde;
    }

    public int getBinaNo() {
        return binaNo;
    }

    public void setBinaNo( int binaNo) {
        this.binaNo = binaNo;
    }

    public int getKapiNo() {
        return kapiNo;
    }

    public void setKapiNo(int kapiNo) {
        this.kapiNo = kapiNo;
    }

}
