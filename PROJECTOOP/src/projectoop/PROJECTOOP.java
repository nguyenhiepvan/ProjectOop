/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author emzAd
 */
public class PROJECTOOP implements Serializable {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException  {
        // TODO code application logic here
      // new NewAccount();

      FileOutputStream Oop_DataAccount = new FileOutputStream("Oop_AccountData.dat", true);
      
        try {
            
            ObjectOutputStream Oop_WriteData = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Oop_AccountData.dat")));
            
            Account Oop_Admin = new Account();
            Oop_Admin.setOop_Password("admin");
            Oop_Admin.setOop_Username("admin");
       
/*             Account demo1 = new Account();
            demo1.setOop_Password("demo 1");
            demo1.setOop_Username("demo 1");
       
             Account demo2 = new Account();
            demo2.setOop_Password("demo 2");
            demo2.setOop_Username("demo 2");
       
            Oop_WriteData.writeObject(demo1);
            Oop_WriteData.writeObject(demo2); */
            Oop_WriteData.writeObject(Oop_Admin);
            
            Oop_WriteData.close();
            
        } catch (IOException e) {
            System.out.println("Error write file");
        }
 //     new AdminInterface();
            new LogIn();
        
    }
    
}
