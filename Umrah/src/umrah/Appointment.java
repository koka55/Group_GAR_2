/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umrah;


import java.util.Date;

/**
 *
 * @author light
 */
public class Appointment {
   
     private LocalDateTime dateTime;
    private int Capacity;

    public Appointment(LocalDateTime dateTime, int Capacity) {
        this.dateTime = dateTime;
    this.Capacity = Capacity;
    

}

    public Appointment() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    public void incCapacity() {
        this.Capacity++;
    }
}
    


