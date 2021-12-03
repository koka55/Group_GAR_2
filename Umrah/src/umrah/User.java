/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umrah;


public class User extends Person {

    private Appointment appointment;
    private Permit currPermit;
    private ArrayList<Permit> prevPermits = new ArrayList<Permit>();

    public User(String Fname, String Lname, String Email, String Password, long PhoneNum, long National_ID) {
        super(Fname, Lname, Email, Password, PhoneNum, National_ID);
    }

    public User() {
        
    }
    
    //setters and getters
    //---------------------------------------------------------------------------------
    //return the array of Previous Permissions.
    public ArrayList<Permit> getPrevPermits() {
        return prevPermits;
    }

    //set one by one obj to prevPermits array list.
    public void setPrevPermits(Permit Permit) {
        this.prevPermits.add(Permit);
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

    //---------------------------------------------------------------------------------------

    public static User login(Long entered_id, String entered_password, Scanner input) {
        User user;
        user = isExist(Eatmrna.users, entered_id);
        if (user == null) {
            System.out.println("The User Not Authorized To Use This Service");
            System.exit(0);
        } else {
            while (true) {
                if (!user.getPassword().equals(entered_password)) {
                    System.out.println("Password Is Wrong, try another!!");
                    entered_password = input.next();
                } else {
                    System.out.println("log in success!!");
                    break;
                }
            }
        }

        return user;
    }

    public void make(Appointment app) {
        this.setAppointment(app);
        this.currPermit = new Permit(this.getNational_ID(), "Available", app.getDateTime());
        System.out.println("your Permit date&time is:");
        System.out.println(this.currPermit.dateTime);

    }

    public void edit(LocalDateTime dateTime) {
        this.getAppointment().setDateTime(dateTime);
        this.currPermit.setDateTime(dateTime);
        System.out.println("your Permit date&time is:");
        System.out.println(this.currPermit.dateTime);
    }

    public void cancel(Appointment[] appointments) {

        for (int i = 0; i < appointments.length; i++) {
            if (this.currPermit.dateTime == appointments[i].getDateTime()) {
                appointments[i].incCapacity();
            }
        }
        this.currPermit = null;
        this.appointment = null;

    }

    public void showPrev() {
        System.out.println("User ID: " + super.getNational_ID() + "\n"
                + "User Name: " + super.getFname() + " " + super.getLname());
        System.out.println("Previous Permissions:");
        for (int i = 0; i < prevPermits.size(); i++) {
            System.out.println("Time: " + prevPermits.get(i).dateTime + " State: " + prevPermits.get(i).getStatus());
        }
    }

//------------------- start main functions
    public static User isExist(User[] users, Long id) {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].National_ID == id) {
                user = users[i];
                break;
            }
        }
        return user;
    }
}
