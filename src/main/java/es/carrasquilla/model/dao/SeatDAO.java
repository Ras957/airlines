/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.model.dao;

import es.carrasquilla.model.Plane;
import es.carrasquilla.model.Seat;
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
public class SeatDAO {
    
    static Session session;
    
    public static void create(Seat s){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            session.save(s);
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
    
    public static void update(Integer id, Seat seat){
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            Seat s = (Seat) session.get(Seat.class, id);
            s.setPlane(seat.getPlane());
            s.setRow(seat.getRow());
            s.setLetter(seat.getLetter());
            s.setVip(seat.isVip());
            session.update(s);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public static Seat get(Integer id) {
        Seat a = null;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            a = (Seat) session.get(Seat.class, id);
            session.getTransaction().commit();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return a;
    }
    
    public static List<Seat> getAll() {
        List<Seat> list;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            TypedQuery<Seat> query = session.createQuery("from Seat");
            list = query.getResultList();
            session.getTransaction().commit();  //session.getTransaction().rollback();        
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
    
    public static List<Seat> getAllByPlane(Plane p) {
        List<Seat> list;
        try (SessionFactory sf = HibernateUtilities_5.getSessionFactory()) {
            session = sf.openSession();
            session.beginTransaction();
            TypedQuery<Seat> query = session.createQuery("from Seat where plane := p");
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



