/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author user
 */
public class satis {
    
    private int satisId;
    private hasta hastaEntity;
    private ilac ilacEntity;
    private Date satisTarih;
    private boolean popup;
    

    public satis() {
    }

    public satis(int satisId, hasta hastaEntity, ilac ilacEntity, Date satisTarih) {      
        this.satisId = satisId;
        this.hastaEntity = hastaEntity;
        this.ilacEntity = ilacEntity;
        this.satisTarih = satisTarih;
    }
    

    public int getSatisId() {
        return satisId;
    }

    public void setSatisId(int satisId) {
        this.satisId = satisId;
    }

    public ilac getIlacEntity() {
        return ilacEntity;
    }

    public void setIlacEntity(ilac ilacEntity) {
        this.ilacEntity = ilacEntity;
    }

    public Date getSatisTarih() {
        return satisTarih;
    }

    public void setSatisTarih(Date satisTarih) {
        this.satisTarih = satisTarih;
    }
    
    public boolean isPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public hasta getHastaEntity() {
        if(this.hastaEntity==null){
            hastaEntity=new hasta();
        }
        return hastaEntity;
    }

    public void setHastaEntity(hasta hastaEntity) {
        this.hastaEntity = hastaEntity;
    }

    
    
    

}
