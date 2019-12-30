package com.uniyaz.sorun.web.rest;

import com.uniyaz.sorun.dao.ArizaKayitDao;
import com.uniyaz.sorun.dao.KullaniciDao;
import com.uniyaz.sorun.domain.ArizaKayit;
import com.uniyaz.sorun.domain.EnumArizaDurum;
import com.uniyaz.sorun.domain.Kullanici;
import com.uniyaz.sorun.web.converter.ArizaKayitConverter;
import com.uniyaz.sorun.web.converter.KullaniciConverter;
import com.uniyaz.sorun.web.dto.ArizaKayitDto;
import com.uniyaz.sorun.web.dto.KullaniciDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/kullanici")
public class KullaniciRestService {
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        KullaniciDao kullaniciDao=new KullaniciDao();
        List<Kullanici> kullaniciList=kullaniciDao.findAllKullanici();

        KullaniciConverter kullaniciConverter=new KullaniciConverter();
        List<KullaniciDto> kullaniciDtoList=kullaniciConverter.convertToKullaniciDtoList(kullaniciList);
        return Response.ok().entity(kullaniciDtoList).build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        KullaniciDao  kullaniciDao = new KullaniciDao();
        Kullanici kullanici = kullaniciDao.findAllById(id);

        KullaniciConverter kullaniciConverter = new KullaniciConverter();
        KullaniciDto kullaniciDto = kullaniciConverter.convertToKullaniciDto(kullanici);
        return Response.ok().entity(kullaniciDto).build();
    }

    @POST
    @Path("/findByIdPost")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByIdPost(@FormParam("id") Long id,@FormParam("sifre") String sifre) {
        KullaniciDao kullaniciDao = new KullaniciDao();
        Kullanici kullanici = kullaniciDao.kullaniciyiGetir(id,sifre);

        KullaniciConverter kullaniciConverter = new KullaniciConverter();
        KullaniciDto kullaniciDto = kullaniciConverter.convertToKullaniciDto(kullanici);
        return Response.ok().entity(kullaniciDto).build();
    }
}
