package com.uniyaz.sorun.domain;

import com.uniyaz.sorun.common.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "ARIZAKAYIT")
public class ArizaKayit extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String ad;

    @Column
    private String ariza;

    @Column
    private String arizaİcerik;

    @Enumerated(EnumType.STRING)
    @Column
    private EnumArizaDurum enumArizaDurum;

    @Temporal(TemporalType.DATE)
    private Date arizaTarih;


    @Override
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
