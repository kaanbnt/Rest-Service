package com.uniyaz.sorun.web.rest;

import com.uniyaz.sorun.dao.ArizaKayitDao;
import com.uniyaz.sorun.domain.ArizaKayit;
import com.uniyaz.sorun.domain.EnumArizaDurum;
import com.uniyaz.sorun.web.converter.ArizaKayitConverter;
import com.uniyaz.sorun.web.dto.ArizaKayitDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.Date;
import java.util.List;

@Path("/arizakayit")
@Provider
public class ArizaKayitRestService {
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArizaKayitDao arizaKayitDao = new ArizaKayitDao();
        List<ArizaKayit> arizaKayitList = arizaKayitDao.findAllArizaKayit();

        ArizaKayitConverter arizaKayitConverter = new ArizaKayitConverter();
        List<ArizaKayitDto> arizaKayitDtoListDtoList = arizaKayitConverter.convertToArizaKayitDtoList(arizaKayitList);
        return Response.ok().entity(arizaKayitDtoListDtoList).build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        ArizaKayitDao arizaKayitDao = new ArizaKayitDao();
        ArizaKayit arizaKayit = arizaKayitDao.findAllById(id);

        ArizaKayitConverter arizaKayitConverter = new ArizaKayitConverter();
        ArizaKayitDto arizaKayitDto = arizaKayitConverter.convertToArizaKayitDto(arizaKayit);
        return Response.ok().entity(arizaKayitDto).build();
    }

    @POST
    @Path("/findByIdPost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdPost(ArizaKayitDto arizaKayitDto2) {
        ArizaKayitDao arizaKayitDao = new ArizaKayitDao();
        ArizaKayit arizaKayit = arizaKayitDao.findAllById(arizaKayitDto2.getId());

        ArizaKayitConverter arizaKayitConverter = new ArizaKayitConverter();
        arizaKayitDto2 = arizaKayitConverter.convertToArizaKayitDto(arizaKayit);
        return Response.ok().entity(arizaKayitDto2).build();
    }

    @POST
    @Path("/arizakaydet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveAriza(ArizaKayitDto arizaKayitDto) {

        ArizaKayitConverter arizaKayitConverter = new ArizaKayitConverter();
        ArizaKayit arizaKayit = arizaKayitConverter.convertToArizaKayit(arizaKayitDto);

        ArizaKayitDao arizaKayitDao = new ArizaKayitDao();
        arizaKayit = arizaKayitDao.saveAriza(arizaKayit);

        arizaKayitDto = arizaKayitConverter.convertToArizaKayitDto(arizaKayit);
        return Response.ok().entity(arizaKayitDto).build();
    }
}
