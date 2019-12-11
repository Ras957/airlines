/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.model.dao;

import es.carrasquilla.model.Flight;
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
public class FlightDAO {
    
    static Session session;
    
    public static void create(Flight f){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            session.save(f);
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
    
    public static void update(Integer id, Flight flight){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            Flight f = (Flight) session.get(Flight.class, id);
            f.setAirportByIdAirportExit(flight.getAirportByIdAirportExit());
            f.setAirportByIdAirportArrival(flight.getAirportByIdAirportArrival());
            f.setDuration(flight.getDuration());
            //f.setFlightEmployees(flight.getFlightEmployees());
            //f.setFlightPlanes(flight.getFlightPlanes());
            session.update(f);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public static Flight get(Integer id) {
        Flight a = null;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            a = (Flight) session.get(Flight.class, id);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return a;
    }
    
    public static List<Flight> getAll() {
        List<Flight> list;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            TypedQuery<Flight> query = session.createQuery("from Flight");
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





