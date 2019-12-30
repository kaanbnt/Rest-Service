package com.uniyaz.service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uniyaz.service.dto.ArizaKayitDto;
import com.uniyaz.service.dto.EnumArizaDurum;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class RestClientArizaKayit {

    public ArizaKayitDto arizaKayitSave(Long id,String ad, String ariza, String arizaİcerik, EnumArizaDurum enumArizaDurum, Date arizaTarih) {
        ArizaKayitDto arizaKayitDto = new ArizaKayitDto();
        arizaKayitDto.setId(id);
        arizaKayitDto.setAd(ad);
        arizaKayitDto.setAriza(ariza);
        arizaKayitDto.setArizaİcerik(arizaİcerik);
        arizaKayitDto.setEnumArizaDurum(enumArizaDurum);
        arizaKayitDto.setArizaTarih(arizaTarih);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        String arizaKayitDtoJson = gson.toJson(arizaKayitDto);

        HttpPost post = new HttpPost("http://localhost:8080/rest/arizakayit/arizakaydet");
        HttpEntity httpEntity = new StringEntity(arizaKayitDtoJson, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            ArizaKayitDto savedCategory = gson.fromJson(dataAsJsonStr, ArizaKayitDto.class);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arizaKayitDto;
    }

    public  Collection<ArizaKayitDto> arizaKayitListele() {
        ArrayList<ArizaKayitDto> arizaKayitDtoList=new ArrayList<>();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

        HttpGet get = new HttpGet("http://localhost:8080/rest/arizakayit/findAll");
        get.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            Type collectionType = new TypeToken<Collection<ArizaKayitDto>>(){}.getType();
            Collection<ArizaKayitDto> arizaKayitDtoCollection = gson.fromJson(dataAsJsonStr, collectionType);
            return arizaKayitDtoCollection;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  List<ArizaKayitDto> arizaKayitBul(Long id) {
        List<ArizaKayitDto> arizaKayitDtoList=new ArrayList<>();
        ArizaKayitDto arizaKayitDto = new ArizaKayitDto();
        arizaKayitDto.setId(id);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        String arizaKayitDtoJson = gson.toJson(arizaKayitDto);

        HttpPost post = new HttpPost("http://localhost:8080/rest/arizakayit/findByIdPost");
        HttpEntity httpEntity = new StringEntity(arizaKayitDtoJson,Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            arizaKayitDtoList = gson.fromJson(dataAsJsonStr, arizaKayitDtoList.getClass());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arizaKayitDtoList;
    }
}
