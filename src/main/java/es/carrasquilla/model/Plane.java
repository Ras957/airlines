package es.carrasquilla.model;
// Generated 09-dic-2019 21:42:24 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Plane generated by hbm2java
 */
public class Plane  implements java.io.Serializable {


     private Integer id;
     private Date acquisitionDate;
     private double price;
     private float autonomy;
     private float consumption;
     private int capacity;
     private Set seats = new HashSet(0);
     private Set flightPlanes = new HashSet(0);

    public Plane() {
    }

	
    public Plane(Date acquisitionDate, double price, float autonomy, float consumption, int capacity) {
        this.acquisitionDate = acquisitionDate;
        this.price = price;
        this.autonomy = autonomy;
        this.consumption = consumption;
        this.capacity = capacity;
    }
    public Plane(Date acquisitionDate, double price, float autonomy, float consumption, int capacity, Set seats, Set flightPlanes) {
       this.acquisitionDate = acquisitionDate;
       this.price = price;
       this.autonomy = autonomy;
       this.consumption = consumption;
       this.capacity = capacity;
       this.seats = seats;
       this.flightPlanes = flightPlanes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getAcquisitionDate() {
        return this.acquisitionDate;
    }
    
    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public float getAutonomy() {
        return this.autonomy;
    }
    
    public void setAutonomy(float autonomy) {
        this.autonomy = autonomy;
    }
    public float getConsumption() {
        return this.consumption;
    }
    
    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }
    public int getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Set getSeats() {
        return this.seats;
    }
    
    public void setSeats(Set seats) {
        this.seats = seats;
    }
    public Set getFlightPlanes() {
        return this.flightPlanes;
    }
    
    public void setFlightPlanes(Set flightPlanes) {
        this.flightPlanes = flightPlanes;
    }

    @Override
    public String toString() {
        return "Plane{" + "id=" + id + ", acquisitionDate=" + acquisitionDate + 
                ", price=" + price + ", autonomy=" + autonomy + ", consumption=" 
                + consumption + ", capacity=" + capacity + ", seats=" + seats + 
                ", flightPlanes=" + flightPlanes + '}';
    }

    


}


