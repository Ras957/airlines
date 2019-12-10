/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.carrasquilla.test;

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
public class NewMain {

    static Session session;

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtilities_5.getSessionFactory();
        session = sf.openSession();
        session.beginTransaction();

        CRUD();

        session.getTransaction().commit();  //session.getTransaction().rollback();         session.close();         sf.close(); 

    }

    static void CRUD() {
        CREATE();
        READ();
        UPDATE();
        DELETE();

    }

    static void CREATE() {
        _createAutor("Carlos Serrano", "Carlos III", "Cordoba", "Cordoba", "España");
        _createAutor("Marta Serrano", "Pintor Moreno", "Fernan Núñez", "Cordoba", "España");

    }

    static void _createAutor(String n, String calle, String loc, String ciu, String pais) {
        Direccion d1 = new Direccion(calle, loc, ciu, pais);
        session.save(d1);
        Autor a1 = new Autor(n, d1.getIdDireccion());
        session.save(a1);

        /*Query query = session.createQuery("insert into Stock(stock_code, stock_name)" +       
    "select stock_code, stock_name from backup_stock");         
    int result = query.executeUpdate();          */    }

    static void READ() {
        Autor a = (Autor) session.get(Autor.class, 6);         
//Añadir toString a autor -> alt+insert(windows) o CTRL+i (macos)         
        System.out.println(a);

        List<Autor> list = _read("Carlos Serrano");
        list.forEach(autor -> {
            System.out.print(autor + " -> ");
            System.out.println((Direccion) session.get(Direccion.class, autor.getIdDireccion()));
        });

    }

    static List<Autor> _read(String nombre) {
        System.out.println("Consultamos todos los " + nombre);
        Query query = session.createQuery("from Autor where nombre = :nombre ");
        query.setParameter("nombre", nombre);
        return query.list();
    }

    static List<Autor> _readAll() {
        Query query = session.createQuery("from Autor");
        return query.list();
    }

    static void UPDATE() {
        Autor a = (Autor) session.get(Autor.class, 6);
        a.setNombre("Anónimo");
        session.update(a);

        Query query = session.createQuery("update Direccion set pais = :pais" + " where localidad = :ciudad");
        query.setParameter("pais", "Argentina");
        query.setParameter("ciudad", "Cordoba");
        int result = query.executeUpdate();

        query = session.createQuery("from Direccion");
        List list = query.list();
        list.forEach(dir -> {
            System.out.println(dir);
        });
    }

    static void DELETE() {
//session.delete(profesor);        
        /*Query query = session.createQuery("delete Stock where stockCode = :stockCode");         
    query.setParameter("stockCode", "7277");         int result = query.executeUpdate();          
         */    }
}

