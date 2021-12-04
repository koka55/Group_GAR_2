package group_gar_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author light
 */
public class Database {

    public static int currAp = 0;
    public static int currUser = 0;

    public static boolean start(User[] users, Appointment[] appointment) {
        boolean flag = false;
        try {
            // TODO code application logic here
            File file = new File("users.txt");
            File file2 = new File("appointments.txt");
            File file3 = new File("Permit.txt");
            Scanner read = new Scanner(file);
            intializeArray(users, read, "User");
            read = new Scanner(file2);
            intializeArray(appointment, read, "Appointment");
            read = new Scanner(file3);
            intializeArray(users, read, "Permit");
            flag = true;
        } catch (FileNotFoundException ex) {
            ex.toString();
        }
        return flag;
    }

    public static void intializeArray(Object[] array, Scanner read, String command) {

        do {
            //String sr = read.next();
            if (command.equals("User")) {
                add_user(read, (User[]) array);
            } else if (command.equals("Appointment")) {
                add_appointment(read, (Appointment[]) array);
            } else if (command.equals("Permit")) {
                Prev_appointment(read, (User[]) array);
            }

        } while (read.hasNext());
        read.close();

    }//end initializearray method

    public static void add_appointment(Scanner read, Appointment[] appointment) {
        Appointment appOb;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        //Date date = null;
        LocalDateTime dateTime = LocalDateTime.parse(read.next(), format);
        int capacity = read.nextInt();
        appOb = new Appointment(dateTime, capacity);
        appointment[currAp] = appOb;
        currAp++;
    }

    public static void add_user(Scanner read, User[] users) {
        User userOb;
        String Fname = read.next().trim();
        String Lname = read.next().trim();
        String Email = read.next().trim();
        String Password = read.next().trim();
        long PhoneNum = read.nextLong();
        long National_ID = read.nextLong();
        userOb = new User(Fname, Lname, Email, Password, PhoneNum, National_ID);
        users[currUser] = userOb;
        currUser++;
        
    }

    public static void Prev_appointment(Scanner read, User[] users) {
        Permit PPermit;
        long National_ID = read.nextLong();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(read.next(), format);

        for (int i = 0; i < users.length; i++) {

            if (National_ID == users[i].getNational_ID()) {
                do {
                    PPermit = new Permit(National_ID, "Unavailable", LocalDateTime.parse(read.next(), format));
                    users[i].setAllPermits(PPermit);
                } while (read.hasNext());
                break;
            }
        }
    }
}
