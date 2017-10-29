/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author emzAd
 */
public class AdminInterface extends JFrame implements ActionListener, MouseListener {
    JLabel Oop_Infomation;
    JMenu Oop_Product;
    JMenu Oop_Staff;
    JMenu Oop_Customer;
    JTextArea Oop_Display;
    JButton Oop_LogOut;
    JTextField Oop_Searchtf;
    JButton Oop_Searchbt;
    
    JMenuItem Oop_View,Oop_add,Oop_edit,Oop_delete,Oop_salary;
    
    public AdminInterface() throws IOException
    {
        setTitle("Management");
        add(Oop_MainInterface());
        setSize(500, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JPanel Oop_MainInterface() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new BorderLayout());
        
        Oop_Panel.setBorder(new EmptyBorder(5, 10, 5, 10));
        Oop_Panel.add(Oop_Search(),BorderLayout.NORTH);
        Oop_Panel.add(Oop_MainMenu(),BorderLayout.WEST);
        Oop_Panel.add(Oop_display(),BorderLayout.CENTER);
        Oop_Panel.add(Oop_Logout(),BorderLayout.SOUTH);
        
        return Oop_Panel;
    }
    
    public JPanel Oop_Search() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new FlowLayout());
        
        Oop_Panel.add(Oop_Searchtf = new JTextField(22));
        GhostText ghost = new GhostText(Oop_Searchtf, "search something....");
              
        BufferedImage Oop_Image = ImageIO.read(new File("searchicon.png"));
        Oop_Panel.add(Oop_Searchbt = new JButton(new ImageIcon(Oop_Image.getScaledInstance(15, 15, Image.SCALE_SMOOTH)) ));
        Oop_Searchbt.addActionListener(this);
        
        return Oop_Panel;
    }
    
    public JPanel Oop_MainMenu()
    {
        JPanel Oop_JPanel = new JPanel(new GridLayout(4, 1));
        
        Oop_JPanel.setBorder( new EmptyBorder(5, 5, 5, 5));
        
        Oop_JPanel.add(Oop_Infomation = new JLabel("Information"));
        Oop_Infomation.addMouseListener(this);
        
        Oop_JPanel.add(Oop_Product = Oop_CreateMenu("Product"));
        Oop_Product.addMouseListener(this);
        
        Oop_JPanel.add(Oop_Staff = Oop_CreateMenu("Staff"));
        Oop_Staff.addMouseListener(this);
        
        Oop_JPanel.add(Oop_Customer = Oop_CreateMenu("Customer"));
        Oop_Customer.addMouseListener(this);
        
        return Oop_JPanel;
        
    }
    
    public JPanel Oop_display()
    {
        JPanel Oop_Panel = new JPanel(new BorderLayout());
        Oop_Panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Oop_Panel.add(Oop_Display = new JTextArea(),BorderLayout.CENTER);
        Oop_Display.setEditable(false);       
        return Oop_Panel;
        
    }
    
    public JPanel Oop_Logout()
    {
        JPanel Oop_Panel = new JPanel(new FlowLayout());
        Oop_Panel.add(Oop_LogOut = Oop_CreateButton("Log out"));
        Oop_LogOut.addActionListener(this);
        return Oop_Panel;
    }
    
    public JMenu Oop_CreateMenu(String title)
    {
        JMenu Oop_Menu = new JMenu(title);
        
        Oop_View = new JMenuItem("View");
        Oop_View.addActionListener(this);
        Oop_Menu.add(Oop_View);
        
        Oop_add = new JMenuItem("Add");
        Oop_add.addActionListener(this);
        Oop_Menu.add(Oop_add);
        
        return Oop_Menu;
    }
    
    public JButton Oop_CreateButton(String title)
    {
        JButton Oop_Button = new JButton(title);
        return Oop_Button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
