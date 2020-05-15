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
public class kisi {

    private long tcNo;
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

}
