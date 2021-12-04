
package umrah;


public class Umrah {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void viewSchedule(Scanner input) {
        int Num = 0;
        LocalDate localDate;
        LocalDate[] localDate1 = new LocalDate[9];
        
        while (Num != 6) {
            System.out.println("Please choose a number from services list ");
            System.out.println("-----------------------------------------------");
            System.out.println("choose 1 to make a new appointment:");
            System.out.println("choose 2 to cancel an appointment:");
            System.out.println("choose 3 to edit you appointment:");
            System.out.println("choose 4 to display all the permits:");
            System.out.print("------> ");
            Num = input.nextInt();
      //--------------------------------------------------------------      
            if (Num == 1) {

                if (user.getAppointment() == null) {
                    
                  //--------------------------------------------------------------
                    System.out.println("The available dates are:");
                    for (int i = 0,k = 0; i < appointments.length; i = i + 6, k++) {
                        localDate1[k] = appointments[i].getDateTime().toLocalDate();
                        System.out.println((k+1) + " : " + localDate1[k]);
                    }
                    //--------------------------------------------------------------
                    System.out.println("choose the Date you want:");
                    Num = input.nextInt();
                    System.out.println("The available Times are:");
                    localDate=localDate1[Num-1];
                    for (int j = 0; j < appointments.length; j++) {
                        if (localDate.equals(appointments[j].getDateTime().toLocalDate())) {
                             System.out.println((j+1) + " : " + appointments[j].getDateTime());
                        }
                    }
                    //--------------------------------------------------------------
                    System.out.println("choose the Time you want:");
                    Num = input.nextInt();
                    Appointment A = appointments[Num-1];
                    user.make(A);
          //--------------------------------------------------------------          
                }else{
                    System.out.println("You can only make one reservation at a time\n"
                            + " please wait 15 day to make new umrah reservation");
                }
                    System.out.print("Enter 5 to more services or 6 to Exit: ");
                    Num = input.nextInt();
                
    //--------------------------------------------------------------                
                } else if (Num == 2) {
                    if (user.getAppointment() == null) {
                        System.out.println("No available appointment to cancel it ");
                    } else {
                        System.out.println(" your appointment info are: " + user.getAppointment().getDateTime()
                            + " ,are you sure to cancel this appointment ? enter Yes or No ");
                    String s = input.next();
                    if (s.equalsIgnoreCase("Yes")) {
                        user.cancel(appointments);
                        System.out.println("Appointment canceled successfully");
                    }
                }
                
                    System.out.print("Enter 5 to more services or 6 to Exit: ");
                    Num = input.nextInt();
                    
    //--------------------------------------------------------------           
            } else if (Num == 3) {
                if (user.getAppointment() == null) {
                    System.out.println("No available appointment to Edit it ");
                } else {
                    System.out.println("You can Edit only the Time of your appointment");
                    System.out.println("The available Times are:");
                    
                    for (int j = 0; j < appointments.length; j++) {
                        if (user.getAppointment().getDateTime().toLocalDate().equals(appointments[j].getDateTime().toLocalDate())) {
                            System.out.println((j + 1) + " : " + appointments[j].getDateTime());
                        }
                    }
                    System.out.println("choose the Time you want:");
                    Num = input.nextInt();
                    //--------------------------------------------------------------
//                    
                    user.edit(appointments[Num-1].getDateTime());
                    
                }
                System.out.print("Enter 5 to more services or 6 to Exit: ");
                Num = input.nextInt();
    //--------------------------------------------------------------
            } else if (Num == 4) {

                if (user.getAllPermits().isEmpty()) {
                    System.out.println("No Permits you have ");
                } else {
                    user.showAll();
                }

                System.out.print("Enter 5 to more services or 6 to Exit: ");
                Num = input.nextInt();
            }
        }
        System.exit(0);
    

}
    
}
