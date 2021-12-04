/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umrah;

import java.time.LocalDateTime;

/**
 *
 * @author light
 */
public class Permits {
    
    long ID;
    String Status;
    LocalDateTime dateTime;

    public Permit(long ID, String Status, LocalDateTime dateTime) {
        this.ID = ID;
        this.Status = Status;
        this.dateTime = dateTime;
    }

    public Permit() {
    }

    public long getID() {
        return ID;
    }

    public String getStatus() {
        return Status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

   
}
        
}



