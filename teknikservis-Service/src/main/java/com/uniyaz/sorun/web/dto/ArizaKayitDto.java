package com.uniyaz.sorun.web.dto;

import com.uniyaz.sorun.domain.EnumArizaDurum;

import java.util.Date;

public class ArizaKayitDto {
    private Long id;
    private String ad;
    private String ariza;
    private String arizaİcerik;
    private EnumArizaDurum enumArizaDurum;
    private Date arizaTarih;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAriza() {
        return ariza;
    }

    public void setAriza(String ariza) {
        this.ariza = ariza;
    }

    public String getArizaİcerik() {
        return arizaİcerik;
    }

    public void setArizaİcerik(String arizaİcerik) {
        this.arizaİcerik = arizaİcerik;
    }

    public EnumArizaDurum getEnumArizaDurum() {
        return enumArizaDurum;
    }

    public void setEnumArizaDurum(EnumArizaDurum enumArizaDurum) {
        this.enumArizaDurum = enumArizaDurum;
    }

    public Date getArizaTarih() {
        return arizaTarih;
    }

    public void setArizaTarih(Date arizaTarih) {
        this.arizaTarih = arizaTarih;
    }
}
