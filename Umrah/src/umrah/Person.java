/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umrah;

/**
 *
 * @author light
 */
public class Person {
      this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.Password = Password;
        this.PhoneNum = PhoneNum;
        this.National_ID = National_ID;
    
    
    public Person(String Fname, String Lname, String Email, String Password, long PhoneNum, long National_ID) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.Password = Password;
        this.PhoneNum = PhoneNum;
        this.National_ID = National_ID;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setPhoneNum(long PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public void setNational_ID(long National_ID) {
        this.National_ID = National_ID;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public long getPhoneNum() {
        return PhoneNum;
    }

    public long getNational_ID() {
        return National_ID;
    }}
}
