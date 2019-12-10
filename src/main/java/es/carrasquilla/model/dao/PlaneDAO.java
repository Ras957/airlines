/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.model.dao;

import es.carrasquilla.model.Plane;
import es.carrasquilla.utilities.HibernateUtilities_5;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
 * <afcarrasquilla@iesfranciscodelosrios.es>
 */
public class PlaneDAO {
    
    static Session session;

    
    public static Plane get(Integer id) {
        
        SessionFactory sf = HibernateUtilities_5.getSessionFactory();
        session = sf.openSession();
        session.beginTransaction();
        Plane a = (Plane) session.get(Plane.class, id);
        session.getTransaction().commit();  //session.getTransaction().rollback();        
        session.close();         
        sf.close();
        return a;
    }
    
    public static List<Plane> getAll() {
        
        SessionFactory sf = HibernateUtilities_5.getSessionFactory();
        session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Plane");
        List list = query.list(); 
        session.getTransaction().commit();  //session.getTransaction().rollback();        
        session.close();         
        sf.close();
        return list;
    }
}







