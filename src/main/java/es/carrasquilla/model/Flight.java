package es.carrasquilla.model;
// Generated 09-dic-2019 21:42:24 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Flight generated by hbm2java
 */
public class Flight  implements java.io.Serializable {


     private Integer id;
     private Airport airportByIdAirportExit;
     private Airport airportByIdAirportArrival;
     private Date duration;
     private Set flightEmployees = new HashSet(0);
     private Set flightPlanes = new HashSet(0);

    public Flight() {
    }

	
    public Flight(Airport airportByIdAirportExit, Airport airportByIdAirportArrival, Date duration) {
        this.airportByIdAirportExit = airportByIdAirportExit;
        this.airportByIdAirportArrival = airportByIdAirportArrival;
        this.duration = duration;
    }
    public Flight(Airport airportByIdAirportExit, Airport airportByIdAirportArrival, Date duration, Set flightEmployees, Set flightPlanes) {
       this.airportByIdAirportExit = airportByIdAirportExit;
       this.airportByIdAirportArrival = airportByIdAirportArrival;
       this.duration = duration;
       this.flightEmployees = flightEmployees;
       this.flightPlanes = flightPlanes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Airport getAirportByIdAirportExit() {
        return this.airportByIdAirportExit;
    }
    
    public void setAirportByIdAirportExit(Airport airportByIdAirportExit) {
        this.airportByIdAirportExit = airportByIdAirportExit;
    }
    public Airport getAirportByIdAirportArrival() {
        return this.airportByIdAirportArrival;
    }
    
    public void setAirportByIdAirportArrival(Airport airportByIdAirportArrival) {
        this.airportByIdAirportArrival = airportByIdAirportArrival;
    }
    public Date getDuration() {
        return this.duration;
    }
    
    public void setDuration(Date duration) {
        this.duration = duration;
    }
    public Set getFlightEmployees() {
        return this.flightEmployees;
    }
    
    public void setFlightEmployees(Set flightEmployees) {
        this.flightEmployees = flightEmployees;
    }
    public Set getFlightPlanes() {
        return this.flightPlanes;
    }
    
    public void setFlightPlanes(Set flightPlanes) {
        this.flightPlanes = flightPlanes;
    }




}


