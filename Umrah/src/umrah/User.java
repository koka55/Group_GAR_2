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

    public Permit getPermit() {
        return currPermit;
    }

    public void setPermit(Permit permits) {
        this.currPermit = permits;
    }

    public ArrayList<Permit> getPrevPermits() {
        return prevPermits;
    }

    public void setPrevPermits(ArrayList<Permit> prevPermits) {
        this.prevPermits = prevPermits;
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

    public static void reserve(User user, LocalDateTime dateTime) {

    }

    public static void edit(User user, LocalDateTime dateTime) {
//just use the time
    }

    public static void cancel(User user, Appointment[] appointments) {
        LocalDateTime dateTime = user.currPermit.dateTime;
        for (int i = 0; i < appointments.length; i++) {
            if (dateTime == appointments[i].getDateTime()) {
                appointments[i].incCapacity();
            }
        }

        user.currPermit = null;

    }

    public void showPrev(LocalDateTime dateTime) {
        System.out.print(prevPermits.toString());
    }

//------------------- start main functions
    public void viewSchedule() {
//help in printing the schedule to user
    }

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
    
    public void bookAppointment() {

    }

    public void CancelAppointment() {

    }

    public void editAppointment() {

    }

    public void SearchAppointment() {

    }

    public void ShowperviousAppointment() {

    }
}
