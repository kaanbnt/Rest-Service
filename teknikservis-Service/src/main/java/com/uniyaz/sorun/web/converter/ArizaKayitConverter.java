package com.uniyaz.sorun.web.converter;

import com.uniyaz.sorun.domain.ArizaKayit;
import com.uniyaz.sorun.web.dto.ArizaKayitDto;

import java.util.ArrayList;
import java.util.List;

public class ArizaKayitConverter {
    public ArizaKayit convertToArizaKayit(ArizaKayitDto arizaKayitDto){

        ArizaKayit arizaKayit=new ArizaKayit();
        arizaKayit.setId(arizaKayitDto.getId());
        arizaKayit.setAd(arizaKayitDto.getAd());
        arizaKayit.setAriza(arizaKayitDto.getAriza());
        arizaKayit.setArizaİcerik(arizaKayit.getAriza());
        arizaKayit.setArizaTarih(arizaKayitDto.getArizaTarih());
        arizaKayit.setEnumArizaDurum(arizaKayitDto.getEnumArizaDurum());
        return arizaKayit;

    }

    public ArizaKayitDto convertToArizaKayitDto(ArizaKayit arizaKayit){
        ArizaKayitDto arizaKayitDto=new ArizaKayitDto();
        arizaKayitDto.setId(arizaKayit.getId());
        arizaKayitDto.setAd(arizaKayit.getAd());
        arizaKayitDto.setAriza(arizaKayit.getAriza());
        arizaKayitDto.setArizaİcerik(arizaKayit.getArizaİcerik());
        arizaKayitDto.setArizaTarih(arizaKayit.getArizaTarih());
        arizaKayitDto.setEnumArizaDurum(arizaKayit.getEnumArizaDurum());
        return arizaKayitDto;
    }

    public List<ArizaKayitDto> convertToArizaKayitDtoList(List<ArizaKayit> arizaKayitList) {

        List<ArizaKayitDto> arizaKayitDtoList = new ArrayList<>();
        for (ArizaKayit arizaKayit : arizaKayitList) {
            ArizaKayitDto arizaKayitDto = convertToArizaKayitDto(arizaKayit);
            arizaKayitDtoList.add(arizaKayitDto);
        }
        return arizaKayitDtoList;
    }
}
