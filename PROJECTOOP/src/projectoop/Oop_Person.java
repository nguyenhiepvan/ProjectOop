/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.util.Date;

/**
 *
 * @author emzAd
 */
public class Oop_Person {
    private String name;
    private String adress;
    private String phonenumber;
    private String dateOfBirth;
    private boolean  sex;

    public Oop_Person(String name,String dateOfBirth,boolean sex, String adress, String phonenumber) {
        this.name = name;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
    
    public Oop_Person()
    {
        this.name = "NoName";
        this.adress = "NoAdress";
        this.phonenumber = "NoPhoneNumber";
        this.dateOfBirth = "01/01/2000";
        this.sex = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    
}
