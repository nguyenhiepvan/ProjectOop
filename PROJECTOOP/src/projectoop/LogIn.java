/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.Serializable;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author emzAd
 */
public class LogIn extends JFrame  implements ActionListener, Serializable {
    
    JTextField Oop_Usernametf;
    JPasswordField Oop_Passwordtf;
    JButton Oop_Login;
    JButton Oop_CreateNew;
    String Oop_ActionLogIn = "Login";
    JLabel Oop_Usernamelb;
    JLabel Oop_Passwordlb;
    
   
    public LogIn() throws FileNotFoundException, IOException
    {
        add(CreateMainPanel());
        setTitle("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);// đưa giao diện ra giữa màn hình
       
    }
    
    public JPanel CreateMainPanel() throws IOException
    {
        JPanel Oop_panel = new JPanel(new BorderLayout());
        Oop_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Oop_panel.add(Oop_CreateInputPanel(),BorderLayout.CENTER);
        Oop_panel.add(Oop_CreateButtonPanel(),BorderLayout.PAGE_END);
        
        return Oop_panel;
        
    }
    
    public JPanel Oop_CreateInputPanel() throws IOException
    {
        int Oop_col = 15;
        JPanel Oop_panel = new JPanel(new GridLayout(2, 2));
        
        BufferedImage Oop_Image = ImageIO.read(new File("usericon.png"));
        Oop_panel.add(Oop_Usernamelb = new JLabel(new ImageIcon(Oop_Image.getScaledInstance(35, 35, Image.SCALE_SMOOTH))));
        Oop_panel.add(Oop_Usernametf = Oop_CreateTextField(Oop_col));
        Oop_Usernametf.setUI(new JTextFieldHintUI("Username", Color.gray));
        
        BufferedImage Oop_Icon = ImageIO.read(new File("passwordicon.png"));     
        Oop_panel.add(Oop_Passwordlb = new JLabel(new ImageIcon(Oop_Icon.getScaledInstance(35, 35, Image.SCALE_SMOOTH))));
        Oop_panel.add(Oop_Passwordtf = Oop_CreatePasswordField(Oop_ActionLogIn,Oop_col));
        Oop_Passwordtf.setUI(new JTextFieldHintUI("Password", Color.gray));
        
        return Oop_panel;
    }
    
    public JPanel Oop_CreateButtonPanel()
    {
        JPanel Oop_panel = new JPanel();
        
        Oop_panel.add(Oop_Login = Oop_CreateButton("Log In"));
        Oop_Login.addActionListener(this);
        Oop_Login.setActionCommand(Oop_ActionLogIn);
        
        Oop_panel.add(Oop_CreateLabel("or"));
        
        Oop_panel.add(Oop_CreateNew = Oop_CreateButton("Create new Account"));
        Oop_CreateNew.addActionListener(this);
        Oop_CreateNew.setActionCommand("Create New Account");
        
        return Oop_panel;
    }
    
    public JLabel  Oop_CreateLabel(String title)
    {
        JLabel Oop_Label = new JLabel(title);
        return Oop_Label;
    }
    
    public JTextField Oop_CreateTextField(int col)
    {
        JTextField Oop_TextField = new JTextField(col);
        return Oop_TextField;
    }
    
    public JPasswordField Oop_CreatePasswordField(String action,int col)
    {
        JPasswordField Oop_password = new JPasswordField(col);
        
        Oop_password.setActionCommand(action);
        
        Oop_password.addActionListener(this);
        return Oop_password;
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

    
  private static boolean Oop_CheckData(String inptun, char[] inputpw)
   {
       Vector Oop_Data = Oop_Data();
       
       
       Enumeration Vnum = Oop_Data.elements();
       
       boolean Oop_isCorrect = true;
       
          while(Vnum.hasMoreElements())
          {
              Account Oop_temp = (Account)Vnum.nextElement();
              char[] Oop_password = Oop_temp.getOop_Password().toCharArray();
              
              if(Oop_temp.getOop_Username().equals(inptun))
              {
                  if(Oop_password.length != inputpw.length)
                  {
                      Oop_isCorrect = false;
                  }
                  else
                  {
                      Oop_isCorrect = Arrays.equals(Oop_password, inputpw);
                  }
              }
              else
              {
                  Oop_isCorrect = false;
              }
          }
          
       return Oop_isCorrect;
   }
   

    @Override
    public void actionPerformed(ActionEvent e){
    
        String Oop_command = e.getActionCommand();
        if(Oop_ActionLogIn.equals(Oop_command))
        {
            String Oop_UserName = Oop_Usernametf.getText();
            char[] Oop_PassWord = Oop_Passwordtf.getPassword();
            
               
                if(Oop_CheckData(Oop_UserName,Oop_PassWord))
               {
                   JOptionPane.showMessageDialog(null, "LogIn success!", "Login", JOptionPane.INFORMATION_MESSAGE);
                
               }
               
               else
               {
                   JOptionPane.showMessageDialog(null, "LogIn Faild!", "Error", JOptionPane.ERROR_MESSAGE);
                
               }
        }
        else
            if(Oop_command == "Create New Account")
            {
                new NewAccount();
                this.dispose();
            }
              
        
    }
    }
    
    

