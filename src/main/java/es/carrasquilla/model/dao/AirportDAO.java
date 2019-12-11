/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.model.dao;

import es.carrasquilla.model.Airport;
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
public class AirportDAO {
    
    static Session session;

    public static void create(Airport a){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            session.save(a);
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
    
    public static void update(Integer id, Airport airport){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            Airport a = (Airport) session.get(Airport.class, id);
            a.setName(airport.getName());
            a.setCity(airport.getCity());
            a.setCountry(airport.getCountry());
            //a.setFlightsForIdAirportExit(airport.getFlightsForIdAirportExit());
            //a.setFlightsForIdAirportArrival(airport.getFlightsForIdAirportArrival());
            session.update(a);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }
    
    public static Airport get(Integer id) {
        Airport a = null;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            a = (Airport) session.get(Airport.class, id);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return a;
    }
    
    public static List<Airport> getAll() {
        List<Airport> list;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            TypedQuery<Airport> query = session.createQuery("from Airport");
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





