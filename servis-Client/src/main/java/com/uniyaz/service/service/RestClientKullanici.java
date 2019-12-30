package com.uniyaz.service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uniyaz.service.dto.KullaniciDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RestClientKullanici {

    public KullaniciDto kullaniciGetir(Long id, String sifre){

        Gson gson=new GsonBuilder().create();
        String kullaniciIdSifreJson="id="+id+"&sifre="+sifre;

        HttpPost httpPost=new HttpPost("http://localhost:8080/rest/kullanici/findByIdPost");
        HttpEntity httpEntity=new StringEntity(kullaniciIdSifreJson, Charset.forName("utf-8"));

        httpPost.setEntity(httpEntity);
        httpPost.addHeader("content-type","application/json");

        try(CloseableHttpClient httpClient= HttpClients.createDefault();
            CloseableHttpResponse response=httpClient.execute(httpPost)){

            HttpEntity entity=response.getEntity();
            String dataAsJsonStr= EntityUtils.toString(entity);

            KullaniciDto currentKullanici=gson.fromJson(dataAsJsonStr, KullaniciDto.class);
            return currentKullanici;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            return null;
        }
        return null;
    }
}
