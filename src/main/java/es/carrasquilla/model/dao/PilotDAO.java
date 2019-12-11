/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.model.dao;

import es.carrasquilla.model.Pilot;
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
public class PilotDAO {
    
    static Session session;
    
    public static void create(Pilot p){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            session.save(p);
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
    
    public static void update(Integer id, Pilot pilot){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            Pilot p = (Pilot) session.get(Pilot.class, id);
            p.setName(pilot.getName());
            p.setLastname(pilot.getLastname());
            p.setDni(pilot.getDni());
            p.setNationality(pilot.getNationality());
            p.setBirthdate(pilot.getBirthdate());
            p.setSalary(pilot.getSalary());
            p.setNumFlights(pilot.getNumFlights());
            session.update(p);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public static Pilot get(Integer id) {
        Pilot a = null;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            a = (Pilot) session.get(Pilot.class, id);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return a;
    }
    
    public static List<Pilot> getAll() {
        List<Pilot> list;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            TypedQuery<Pilot> query = session.createQuery("from Pilot");
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




