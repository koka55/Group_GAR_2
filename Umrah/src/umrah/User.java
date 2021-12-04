/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umrah;


public class User extends Person {

    Appointment appointment = new Appointment();
    Permit currPermit = new Permit();
    ArrayList<Permit> prevPermits = new ArrayList<Permit>();

    public User(String Fname, String Lname, String Email, String Password, long PhoneNum, long National_ID) {
        super(Fname, Lname, Email, Password, PhoneNum, National_ID);
    }

   
//setters and getters
    //---------------------------------------------------------------------------------
    //return the array of all the Permissions.
    public ArrayList<Permit> getAllPermits() {
        return allPermits;
    }

    //set one by one obj to allPermits array list.
    public void setAllPermits(Permit Permit) {
        this.allPermits.add(Permit);
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Permit getCurrPermit() {
        return currPermit;
    }

    public void setCurrPermit(Permit currPermit) {
        this.currPermit = currPermit;
    }
    

    public static User login(Long entered_id, String entered_password, Scanner input) {
        User user = null;
        user = user.isExist(Eatmrna.users, entered_id);
        while (user == null || (user != null) && (!user.getPassword().equals(entered_password))) {
            if ((user != null) && (!user.getPassword().equals(entered_password))) {
                System.out.println("Password Is Wrong, try another!!");
                entered_password = input.next();
            } else {
                System.out.println("The User Not Authorized To Use This Service");
                System.exit(0);
            }
        }
        if ((user != null) && (user.getPassword().equals(entered_password))) {
            System.out.println("log in success!!");

        }
        return user;
    }
//------------------- start main functions

   

   

    public static void cancel(User user, Appointment[] appointments) {
        LocalDateTime dateTime = user.currPermit.dateTime;
        for (int i = 0; i < appointments.length; i++) {
            if (dateTime == appointments[i].getDateTime()) {
                appointments[i].incCapacity();
            }
        }

        user.currPermit = null;

    }

   

//------------------- start main functions
   

    public User isExist(User[] users, Long id) {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].National_ID == id) {
                user = users[i];
                break;
            }
        }
        return user;
    }
    
        public void makeAppointment(Appointment app) {
        this.setAppointment(app);
        this.currPermit = new Permit(this.getNational_ID(), "Available", app.getDateTime());
        this.allPermits.add(currPermit);
        System.out.println("your Permit date&time is:");
        System.out.println(this.currPermit.dateTime);
    }

    public void cancelAppointment(Appointment[] appointments) {

        for (int i = 0; i < appointments.length; i++) {
            if (this.currPermit.dateTime == appointments[i].getDateTime()) {
                appointments[i].incCapacity();
            }
        }
        this.currPermit.setStatus("Canceled");
        this.allPermits.set(this.allPermits.size()-1, this.getCurrPermit());
        this.currPermit = null;
        this.appointment = null;
        

    }

      public void editAppointment(LocalDateTime dateTime) {
          
        this.appointment.incCapacity();
        this.getAppointment().setDateTime(dateTime);
        this.appointment.setCapacity(this.appointment.getCapacity()-1);
        this.currPermit.setDateTime(dateTime);
        this.allPermits.set(this.allPermits.size()-1, this.getCurrPermit());
        System.out.println("your Permit date&time is:");
        System.out.println(this.currPermit.dateTime);
    }
    

   
        public void DisplayAllPermits() {
        System.out.println("User ID: " + super.getNational_ID() + "\n"
                + "User Name: " + super.getFname() + " " + super.getLname());
        System.out.println("The all Permits :");
        for (int i = 0; i < allPermits.size(); i++) {
            System.out.println("Time: " + allPermits.get(i).dateTime + " State: " + allPermits.get(i).getStatus());
        }
    }
    
 
    
    
    
}
