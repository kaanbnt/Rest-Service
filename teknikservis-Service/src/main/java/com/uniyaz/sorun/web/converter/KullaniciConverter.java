package com.uniyaz.sorun.web.converter;

import com.uniyaz.sorun.domain.Kullanici;
import com.uniyaz.sorun.web.dto.KullaniciDto;

import java.util.ArrayList;
import java.util.List;

public class KullaniciConverter {
    public KullaniciDto convertToKullaniciDto(Kullanici kullanici){
        KullaniciDto kullaniciDto=new KullaniciDto();
        kullaniciDto.setId(kullanici.getId());
        kullaniciDto.setAdiSoyadi(kullanici.getAdiSoyadi());
        kullaniciDto.setEmail(kullanici.getEmail());
        kullaniciDto.setSifre(kullanici.getSifre());
        return kullaniciDto;
    }

    public Kullanici convertToKullanici(KullaniciDto kullaniciDto){
        Kullanici kullanici=new Kullanici();
        kullanici.setId(kullaniciDto.getId());
        kullanici.setAdiSoyadi(kullaniciDto.getAdiSoyadi());
        kullanici.setEmail(kullaniciDto.getEmail());
        kullanici.setSifre(kullaniciDto.getSifre());
        return kullanici;
    }

    public List<KullaniciDto> convertToKullaniciDtoList(List<Kullanici> kullaniciList) {

        List<KullaniciDto> categoryDtoList = new ArrayList<>();
        for (Kullanici kullanici : kullaniciList) {
            KullaniciDto kullaniciDto = convertToKullaniciDto(kullanici);
            categoryDtoList.add(kullaniciDto);
        }
        return categoryDtoList;
    }
}
