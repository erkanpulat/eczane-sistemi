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