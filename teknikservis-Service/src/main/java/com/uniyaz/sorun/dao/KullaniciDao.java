package com.uniyaz.sorun.dao;

import com.uniyaz.sorun.domain.ArizaKayit;
import com.uniyaz.sorun.domain.Kullanici;
import com.uniyaz.sorun.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KullaniciDao {
    public Kullanici saveKullanici(Kullanici kullanici){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            kullanici = (Kullanici) session.merge(kullanici);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullanici;
    }

    public List<Kullanici> findAllKullanici(){
        List<Kullanici> kullaniciList = null;
        Map<String, Kullanici> kullaniciMap = new HashMap();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici From Kullanici kullanici";
            Query query = session.createQuery(hql);
            kullaniciList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullaniciList;
    }

//    public Kullanici findAllById(Long kullaniciId) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        try (Session session = sessionFactory.openSession();) {
//            String hql = "Select kullanici From Kullanici kullanici Where kullanici.id = :kullaniciId";
//            Query query = session.createQuery(hql);
//            query.setParameter("kullaniciId", kullaniciId);
//            return  (Kullanici) query.uniqueResult();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }

    public Kullanici kullaniciyiGetir(Long id, String sifre){
        Kullanici kullanici = null;
         SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici From Kullanici kullanici where  kullanici.id =:id and kullanici.sifre=:sifre";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.setParameter("sifre", sifre);
            kullanici = (Kullanici) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullanici;
    }

    public Kullanici findAllById(Long kullaniciId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici From Kullanici kullanici Where kullanici.id = :kullaniciId";
            Query query = session.createQuery(hql);
            query.setParameter("kullaniciId", kullaniciId);
            return  (Kullanici) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
