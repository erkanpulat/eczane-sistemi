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
    private long tcNo=0;
    private ilac ilacEntity;
    private Date satisTarih;

    public satis() {
    }

    public satis(int satisId, long tcNo, ilac ilacEntity, Date satisTarih) {
        this.satisId = satisId;
        this.tcNo = tcNo;
        this.ilacEntity = ilacEntity;
        this.satisTarih = satisTarih;
    }
    

    public int getSatisId() {
        return satisId;
    }

    public void setSatisId(int satisId) {
        this.satisId = satisId;
    }

    public long getTcNo() {
        return tcNo;
    }

    public void setTcNo(long tcNo) {
        this.tcNo = tcNo;
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
    
    
    
}
