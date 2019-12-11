/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.model.dao;

import es.carrasquilla.model.Aircrew;
import es.carrasquilla.utilities.HibernateUtilities_5;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
 * <afcarrasquilla@iesfranciscodelosrios.es>
 */
public class AircrewDAO {
    
    static Session session;
    
    public static void create(Aircrew ac){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            session.save(ac);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }
    
    public static void delete(Integer id){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            session.delete(id);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }
    
    public static void update(Integer id, Aircrew aircrew){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            Aircrew ac = (Aircrew) session.get(Aircrew.class, id);
            ac.setName(aircrew.getName());
            ac.setLastname(aircrew.getLastname());
            ac.setDni(aircrew.getDni());
            ac.setNationality(aircrew.getNationality());
            ac.setBirthdate(aircrew.getBirthdate());
            ac.setSalary(aircrew.getSalary());
            ac.setNumFlights(aircrew.getNumFlights());
            session.update(ac);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public static Aircrew get(Integer id) {
        Aircrew a = null;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            a = (Aircrew) session.get(Aircrew.class, id);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return a;
    }
    
    public static List<Aircrew> getAll() {
        List<Aircrew> list;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            TypedQuery<Aircrew> query = session.createQuery("from Aircrew");
            list = query.getResultList();
            session.getTransaction().commit();  //session.getTransaction().rollback();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}





