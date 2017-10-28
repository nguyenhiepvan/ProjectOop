/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

/**
 *
 * @author emzAd
 */
public class Oop_Staff extends  Oop_Person{
    private String Id;
    private int SogioLam;
    
    public Oop_Staff()
    {
        super();
        this.Id = "0000";
        this.SogioLam =0;
    }

    public Oop_Staff(String Id,String name,String dateOfBirth, boolean sex, String adress, String phonenumber, int SogioLam) {
        super(name, dateOfBirth, sex, adress, phonenumber);
        this.Id = Id;
        this.SogioLam = SogioLam;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getSogioLam() {
        return SogioLam;
    }

    public void setSogioLam(int SogioLam) {
        this.SogioLam = SogioLam;
    }
    
    
}
