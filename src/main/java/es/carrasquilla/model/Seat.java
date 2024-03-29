package es.carrasquilla.model;

/**
 * Seat generated by hbm2java
 */
public class Seat  implements java.io.Serializable {


     private Integer id;
     private Plane plane;
     private int row;
     private char letter;
     private boolean vip;

    public Seat() {
    }

    public Seat(Plane plane, int row, char letter, boolean vip) {
       this.plane = plane;
       this.row = row;
       this.letter = letter;
       this.vip = vip;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Plane getPlane() {
        return this.plane;
    }
    
    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    public int getRow() {
        return this.row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    public char getLetter() {
        return this.letter;
    }
    
    public void setLetter(char letter) {
        this.letter = letter;
    }
    public boolean isVip() {
        return this.vip;
    }
    
    public void setVip(boolean vip) {
        this.vip = vip;
    }




}


