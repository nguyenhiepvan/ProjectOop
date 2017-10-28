/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emzAd
 */
public class NewAccount extends JFrame implements ActionListener, ItemListener, Serializable {
    JTextField Oop_FullName;
    JComboBox Oop_Sex;
    JTextField Oop_DateOfBirth;
    JTextField Oop_Adress;
    JTextField Oop_PhoneNumber;
    JTextField Oop_Email;
    JTextField Oop_Username;
    JPasswordField Oop_Password;
    JPasswordField Oop_RePassword;
    JButton Oop_Ok;
    JButton Oop_Cancel;
    String Oop_Sexoutput;
    
    
    public NewAccount()
    {
        add(Oop_CreateMainPanel());
        setTitle("Create Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    public JPanel Oop_CreateMainPanel()
    {
        JPanel Oop_Panel = new JPanel(new BorderLayout());
        Oop_Panel.setBorder(new EmptyBorder(20, 10, 10, 20));
        Oop_Panel.add(Oop_CreateInputPanel(),BorderLayout.CENTER);
        Oop_Panel.add(Oop_CreateButtonPanel(),BorderLayout.PAGE_END);
        
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateInputPanel()
    {
        int col = 15;
        
        JPanel Oop_Panel = new JPanel(new GridLayout(12,2,5,5));
        
        Oop_Panel.add(Oop_CreateLabel("Full Name: "));
        Oop_Panel.add(Oop_FullName = new JTextField());
        
        Oop_Panel.add(Oop_CreateLabel("Sex: "));
        Oop_Panel.add(Oop_Sex = new JComboBox());
        Oop_Sex.addItem("Male");
        Oop_Sex.addItem("Female");
        Oop_Sex.addItem("Unknown");
        Oop_Sex.addItemListener(this);
        
        Oop_Panel.add(Oop_CreateLabel("Date of birth: "));
        Oop_Panel.add(Oop_DateOfBirth = Oop_CreateDate());
        
        Oop_Panel.add(Oop_CreateLabel("Adress: "));
        Oop_Panel.add(Oop_Adress = new JTextField());
        
        
        Oop_Panel.add(Oop_CreateLabel("Phone Number: "));
        Oop_Panel.add(Oop_PhoneNumber = new JTextField());
        
        Oop_Panel.add(Oop_CreateLabel("Email: "));
        Oop_Panel.add(Oop_Email = new JTextField());
        
        Oop_Panel.add(Oop_CreateLabel("Username: "));
        Oop_Panel.add(Oop_Username = Oop_CreateUsername(col));
        
        Oop_Panel.add(Oop_CreateLabel("Password: "));
        Oop_Panel.add(Oop_Password = Oop_CreatePassword(col));
        
        Oop_Panel.add(Oop_CreateLabel("RE-Password: "));
        Oop_Panel.add(Oop_RePassword = Oop_CreatePassword(col));
        
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateButtonPanel()
    {
        JPanel Oop_Panel = new JPanel(new FlowLayout());
        Oop_Panel.add(Oop_Ok = Oop_CreateButton("Ok"));
        Oop_Ok.addActionListener(this);
        
        Oop_Panel.add(Oop_Cancel = Oop_CreateButton("Cancel"));
        Oop_Cancel.addActionListener(this);
        
        return Oop_Panel;
    }
    
    public JTextField Oop_CreateDate()
    {
        DateFormat Oop_df = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField Oop_date = new JFormattedTextField(Oop_df);
        return Oop_date;
    }
    
    public JTextField Oop_CreateUsername(int col)
    {
        JTextField Oop_Text = new JTextField(col);
        return Oop_Text;
    }
    
    public JPasswordField Oop_CreatePassword(int col)
    {
        JPasswordField Oop_Password = new JPasswordField(col);
        return Oop_Password;
    }
    
    public JLabel Oop_CreateLabel(String title)
    {
        JLabel Oop_Label = new JLabel(title);
        return Oop_Label;
    }
    
    public JButton Oop_CreateButton(String title)
    {
        JButton Oop_Button = new JButton(title);
        return Oop_Button;
    }
    
    private static Vector Oop_Data()
   {
       Vector Oop_List = new Vector();
       Account Oop_temp = null;
       try {
           FileInputStream Oop_Account =new FileInputStream("Oop_AccountData.dat");
           ObjectInputStream Oop_DataAccount = new ObjectInputStream(new BufferedInputStream(Oop_Account));
           Oop_temp = (Account) Oop_DataAccount.readObject();
           
           while(true)
           {
               Oop_List.add(Oop_temp);
               
               Oop_temp = (Account) Oop_DataAccount.readObject();
               if(Oop_temp==null) break;
           }
           
           Oop_DataAccount.close();
           
       } catch (Exception e) {
           e.getMessage();
       }
       
       return Oop_List;
   }
    
    public boolean  Oop_CheckAccount(String Oop_username) 
    {
        Vector Oop_AccountData = Oop_Data();
        
        Enumeration Vnum = Oop_AccountData.elements();
        
        while(Vnum.hasMoreElements())
        {
            Account Oop_temp = (Account) Vnum.nextElement();
            if(Oop_temp.getOop_Username().equals(Oop_username))
                return true;
        }
        
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        String Oop_command = e.getActionCommand();
        
        if(Oop_command.equals("Cancel"))
        {
            this.dispose();
        }
        
        else
        {
            if(Oop_FullName.getText().equals("")||Oop_DateOfBirth.getText().equals("")||
                    Oop_Adress.getText().equals("")||Oop_PhoneNumber.getText().equals("")||
                    Oop_Email.getText().equals("")||Oop_Username.getText().equals("")||
                    Oop_Password.getText().equals("")||Oop_RePassword.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "all input fields were required", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
                //phone regex
                String Oop_Phonereg = "^[0-9]{11,}";
                String Oop_Phonereg1 = "^[0-9]{10}$";
                boolean Oop_CheckPhone = Oop_PhoneNumber.getText().matches(Oop_Phonereg);
                boolean Oop_CheckPhone1 = Oop_PhoneNumber.getText().matches(Oop_Phonereg1);
                if((!Oop_CheckPhone)&&(!Oop_CheckPhone1))
                {
                   JOptionPane.showMessageDialog(null, "invalid phone number", "ERROR", JOptionPane.ERROR_MESSAGE);
             
                }
                
                //email regex
                else
                {
                    String Oop_Emailreg = "^[\\w- ]+@([\\w- ]+\\.)+[\\w-]+$";
                    boolean Oop_CheckMail = Oop_Email.getText().matches(Oop_Emailreg);
                    if(Oop_CheckMail==false)
                    JOptionPane.showMessageDialog(null, "invalid Email Adress", "ERROR", JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        //password maches repassword?
                       if(!Oop_Password.getText().equals(Oop_RePassword.getText()))
                        JOptionPane.showMessageDialog(null, "password does not match", "ERROR", JOptionPane.ERROR_MESSAGE);
                       
                       else
                       {
                           
                        //tạo tài khoản mới
                        Account Oop_NewAccount = new Account(Oop_FullName.getText(), Oop_Sexoutput, Oop_DateOfBirth.getText(),
                                    Oop_Adress.getText(), Oop_PhoneNumber.getText(), Oop_Email.getText(), Oop_Username.getText(),
                                    Oop_Password.getText());
                        
                               if(Oop_CheckAccount(Oop_NewAccount.getOop_Username()))
                               {
                                   JOptionPane.showMessageDialog(null, "Account allready exit", "ERROR", JOptionPane.ERROR_MESSAGE);
                               }
                               
                               else
                                   try {
                                      FileOutputStream Oop_WriteData = new FileOutputStream("Oop_AccountData.dat");
                                      ObjectOutputStream Oop_write = new ObjectOutputStream(new BufferedOutputStream(Oop_WriteData));
                                      Oop_write.writeObject(Oop_NewAccount);
                                      Oop_write.close();
                                      
                                      JOptionPane.showMessageDialog(null, "Create Successfull!", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
                                      this.dispose();
                               
                                   } catch (Exception ex) {
                                       ex.getMessage();
                                   }
                           }
                       }
                 
                    }
                }
                
                
            }
        }

    @Override
    public void itemStateChanged(ItemEvent e) {
    
        int Oop_index = Oop_Sex.getSelectedIndex();
        if(Oop_index == 0)
        {
            Oop_Sexoutput = "Male";
        }
        
        else if(Oop_index == 1) Oop_Sexoutput = "Female";
        else Oop_Sexoutput = "Unknown";
        
    }
    
}
