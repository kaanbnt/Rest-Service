package com.uniyaz.sorun.dao;

import com.uniyaz.sorun.domain.ArizaKayit;
import com.uniyaz.sorun.domain.EnumArizaDurum;
import com.uniyaz.sorun.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ArizaKayitDao {

    public ArizaKayit saveAriza(ArizaKayit arizaKayit) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            arizaKayit = (ArizaKayit) session.merge(arizaKayit);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaKayit;
    }

    public List<ArizaKayit> findAllArizaKayit() {
        List<ArizaKayit> arizaKayitList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select arizakayit From ArizaKayit arizakayit";
            Query query = session.createQuery(hql);
            arizaKayitList= query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaKayitList;
    }

    public ArizaKayit findAllById(Long arizaKayitId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select arizakayit From ArizaKayit arizakayit Where arizakayit.id = :arizaKayitId";
            Query query = session.createQuery(hql);
            query.setParameter("arizaKayitId",arizaKayitId);
            return  (ArizaKayit) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
