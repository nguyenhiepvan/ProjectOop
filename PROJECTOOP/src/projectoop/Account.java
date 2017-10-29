/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.io.Serializable;
/**
 *
 * @author emzAd
 */
public class Account implements Serializable{
    private String Oop_FullName;
    private String Oop_Sex;
    private String Oop_DateOfBirth;
    private String Oop_Adress;
    private String Oop_PhoneNumber;
    private String Oop_Email;
    private String Oop_Username;
    private String Oop_Password;

    public Account(String Oop_FullName, String Oop_Sex, String Oop_DateOfBirth, String Oop_Adress, String Oop_PhoneNumber, String Oop_Email, String Oop_Username, String Oop_Password) {
        this.Oop_FullName = Oop_FullName;
        this.Oop_Sex = Oop_Sex;
        this.Oop_DateOfBirth = Oop_DateOfBirth;
        this.Oop_Adress = Oop_Adress;
        this.Oop_PhoneNumber = Oop_PhoneNumber;
        this.Oop_Email = Oop_Email;
        this.Oop_Username = Oop_Username;
        this.Oop_Password = Oop_Password;
    }
    
    public Account()
    {
        this.Oop_FullName = "NONAME";
        this.Oop_Sex = "UNKNOWN";
        this.Oop_DateOfBirth = "01/01/2000";
        this.Oop_Adress = "NOADRESS";
        this.Oop_PhoneNumber = "NOPHONENUMBER";
        this.Oop_Email="NOEMAIL";
        this.Oop_Username="NOUSERNAME";
        this.Oop_Password="123";
    }

    public String getOop_Sex() {
        return Oop_Sex;
    }

    public void setOop_Sex(String Oop_Sex) {
        this.Oop_Sex = Oop_Sex;
    }

    public void setOop_Username(String Oop_Username) {
        this.Oop_Username = Oop_Username;
    }

    public void setOop_Password(String Oop_Password) {
        this.Oop_Password = Oop_Password;
    }

    public String getOop_Username() {
        return Oop_Username;
    }

    public String getOop_Password() {
        return Oop_Password;
    }
    
}
