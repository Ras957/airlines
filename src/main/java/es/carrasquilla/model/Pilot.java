package es.carrasquilla.model;
// Generated 09-dic-2019 21:42:24 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pilot generated by hbm2java
 */
public class Pilot  implements java.io.Serializable {


     private int idEmployee;
     private Employee employee;
     private Date flighttime;

    public Pilot() {
    }

    public Pilot(Employee employee, Date flighttime) {
       this.employee = employee;
       this.flighttime = flighttime;
    }
   
    public int getIdEmployee() {
        return this.idEmployee;
    }
    
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Date getFlighttime() {
        return this.flighttime;
    }
    
    public void setFlighttime(Date flighttime) {
        this.flighttime = flighttime;
    }




}


