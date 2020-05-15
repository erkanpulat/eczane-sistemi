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
public class firma {

    private long firmaId;
    private String firmaAdi;
    private long adresNo;
    private long telefon;

    public firma() {
    }

    public firma(long firmaId, String firmaAdi, long adresNo, long telefon) {
        this.firmaId = firmaId;
        this.firmaAdi = firmaAdi;
        this.adresNo = adresNo;
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

    public long getAdresNo() {
        return adresNo;
    }

    public void setAdresNo(long adresNo) {
        this.adresNo = adresNo;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }

  

}