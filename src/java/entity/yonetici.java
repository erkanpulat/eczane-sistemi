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
public class yonetici extends personel {

    private String sifre;

    public yonetici() {
    }

    public yonetici(long tcNo, String adSoyad, String dogumTarihi, String cinsiyet, long telefon, String departman, float maas, int adresNo) {
        super(departman, maas, adresNo);
        super.setTcNo(tcNo);
        super.setAdSoyad(adSoyad);
        super.setDogumTarihi(dogumTarihi);
        super.setCinsiyet(cinsiyet);
        super.setTelefon(telefon);

    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
