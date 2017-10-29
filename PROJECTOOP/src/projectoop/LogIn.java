/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author emzAd
 */
public class LogIn extends JFrame  implements ActionListener, Serializable, ItemListener {
    
    static JTextField Oop_Usernametf;
    static JPasswordField Oop_Passwordtf;
    JButton Oop_Login;
    JButton Oop_CreateNew;
    String Oop_ActionLogIn = "Login";
    JLabel Oop_Usernamelb;
    JLabel Oop_Passwordlb;
    JLabel Oop_Titlelb;
    JCheckBox Oop_RemembermeCx;
    static Account Oop_RememberAccount = null;
    
   //giao diện chính
    public LogIn() throws FileNotFoundException, IOException
    {
        add(Oop_CreateMainPanel());
        setTitle("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        //Oop_LoginRememberAccount();
        setLocationRelativeTo(null);// đưa giao diện ra giữa màn hình
       
    }
    
    //main panel
    public JPanel Oop_CreateMainPanel() throws IOException
    {
        JPanel Oop_panel = new JPanel(new BorderLayout());
        Oop_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Oop_panel.add(Oop_CreateTitle(), BorderLayout.NORTH);
        Oop_panel.add(Oop_CreateInputPanel(),BorderLayout.CENTER);
        Oop_panel.add(Oop_CreateButtonPanel(),BorderLayout.PAGE_END);
        
        return Oop_panel;
        
    }
    
    public JPanel Oop_CreateTitle() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new FlowLayout());
        BufferedImage Oop_Image = ImageIO.read(new File("loginicon.png"));
        Oop_Titlelb = new JLabel(new ImageIcon(Oop_Image.getScaledInstance(250, 70, Image.SCALE_SMOOTH)));
        Oop_Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        Oop_Panel.add(Oop_cereateItemPanel(FlowLayout.CENTER, Oop_Titlelb));
        
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateInputPanel() throws IOException
    {
        int Oop_col = 15;
        int size = 30;
        JPanel Oop_panel = new JPanel(new GridLayout(3, 2));
        Oop_panel.setBorder(new EmptyBorder(0, 0, 0, 45));
        
        BufferedImage Oop_Image = ImageIO.read(new File("usericon.png"));
        Oop_Usernamelb = new JLabel(new ImageIcon(Oop_Image.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        Oop_panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        Oop_panel.add(Oop_cereateItemPanel(FlowLayout.CENTER, Oop_Usernamelb));
        
        Oop_panel.add(Oop_Usernametf = Oop_CreateTextField(Oop_col));
        Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Oop_Usernametf.setBorder(raisedEtched);
       GhostText ghosttextun = new GhostText(Oop_Usernametf, "Username");
        
        BufferedImage Oop_Icon = ImageIO.read(new File("passwordicon.png"));     
        Oop_Passwordlb = new JLabel(new ImageIcon(Oop_Icon.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        Oop_panel.add(Oop_cereateItemPanel(FlowLayout.CENTER, Oop_Passwordlb));
        Oop_panel.add(Oop_Passwordtf = Oop_CreatePasswordField(Oop_ActionLogIn,Oop_col));
        Oop_Passwordtf.setBorder(raisedEtched);
       
       GhostText ghostTextpd = new GhostText(Oop_Passwordtf, "please pess Password");
        Oop_panel.add(Oop_RemembermeCx = new JCheckBox("Remember Me"),false);
        Oop_RemembermeCx.addItemListener(this);
        Oop_RemembermeCx.setBorder(new EmptyBorder(0, 75, 0, 0));
        
        
        return Oop_panel;
    }
    
    public JPanel Oop_CreateButtonPanel() throws IOException
    {
        JPanel Oop_panel = new JPanel();
        
        
        BufferedImage Oop_Image = ImageIO.read(new File("arrow.png"));
        ImageIcon icon = new ImageIcon(Oop_Image.getScaledInstance(35, 25, Image.SCALE_SMOOTH));
        Oop_panel.add(Oop_Login = Oop_CreateButton("Log In",icon));
        Oop_Login.addActionListener(this);
        Oop_Login.setActionCommand(Oop_ActionLogIn);
        Oop_Login.setBackground(Color.green);
        
        Oop_panel.add(Oop_CreateLabel("or"));
        
        Oop_panel.add(Oop_CreateNew = new JButton("Register now"));
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
    
    public JButton Oop_CreateButton(String title,ImageIcon icon)
    {
        JButton Oop_Button = new JButton(title, icon);
        return Oop_Button;
    }
    
    public JPanel Oop_cereateItemPanel(int Oop_align, JLabel Oop_label) {
        // create JPanel
        JPanel Oop_panel = new JPanel(Oop_createFlowLayout(Oop_align));
        // set Component Orientation
        Oop_panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        // add JLabel
        Oop_panel.add(Oop_label);
        return Oop_panel;
    }
 
    // create FlowLayout with align
    public FlowLayout Oop_createFlowLayout(int Oop_algin) {
        FlowLayout Oop_layout = new FlowLayout();
        Oop_layout.setAlignment(Oop_algin);
        return Oop_layout;
    }
    
  public static Vector Oop_Data()
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
               
               if(Oop_temp.getOop_Email().equals("Remember me"))
               {
                   Oop_RememberAccount = Oop_temp;
               }
               
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
  
  private static void Oop_LoginRememberAccount()
  {
      if(Oop_RememberAccount.getOop_Sex().equals("1"))
      {
          Oop_Usernametf.setText(Oop_RememberAccount.getOop_Username());
          Oop_Passwordtf.setText(Oop_RememberAccount.getOop_Password());      
          
      }
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

    @Override
    public void itemStateChanged(ItemEvent e) {
    // nếu tích vào ô remember me
    
    Account Oop_RememberAccount = null;
    
    try {
        FileInputStream Oop_RAccount = new FileInputStream("AccountData.dat");
        ObjectInputStream Oop_read = new ObjectInputStream(new BufferedInputStream(Oop_RAccount));
        
        Oop_RememberAccount = (Account)Oop_read.readObject();
        
        Oop_read.close();

    } catch (Exception ex) {
    }
    
    if(e.equals(true))
    {
        Oop_RememberAccount.setOop_Username(Oop_Usernametf.getText());
        Oop_RememberAccount.setOop_Password(Oop_Passwordtf.getText());
        Oop_RememberAccount.setOop_Sex("1");
    }
    
    if(e.equals(false)) Oop_RememberAccount.setOop_Sex("0");
    
    try {
        FileOutputStream Oop_RAccount = new FileOutputStream("AccountData.dat");
        ObjectOutputStream Oop_Write = new ObjectOutputStream(new BufferedOutputStream(Oop_RAccount));
        
        Oop_Write.writeObject(Oop_RememberAccount);
        Oop_Write.close();

    } catch (Exception ey) {
    }
   
    }
    }
    
 