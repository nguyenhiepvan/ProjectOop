/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author emzAd
 */
public class AdminInterface extends JFrame implements ActionListener {
    
    JButton Oop_Dashboard;
    JButton Oop_Create;
    JButton Oop_Search;
    JButton Oop_Logout;
    JLabel Oop_Avatar;
    JLabel Oop_Title;
    JLabel Oop_Greeting;
    
    public AdminInterface() throws IOException
    {
        this.add(Oop_MainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 550);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public JPanel Oop_MainPanel() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new BorderLayout());
        Oop_Panel.add(Oop_CreateMenu(),BorderLayout.LINE_START);
        Oop_Panel.add(Oop_CreateDisplay(),BorderLayout.CENTER);
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateMenu() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new BorderLayout());
        
        Oop_Panel.setPreferredSize(new Dimension(183, 500));
        Oop_Panel.setBackground(Color.decode("#202020"));
        
        Oop_Panel.add(Oop_CreateTitle(),BorderLayout.PAGE_START);
        Oop_Panel.add(Oop_CreateMainMenu(),BorderLayout.CENTER);
        
          
        return Oop_Panel;
                
    }
    
    public JPanel Oop_CreateTitle()
    {
        JPanel Oop_Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Oop_Panel.setPreferredSize(new Dimension(183, 46));
        
        Oop_Panel.add(Oop_Title = new JLabel("MANAGER"));
        Oop_Title.setHorizontalAlignment(JLabel.CENTER);
        Oop_Title.setBorder(new EmptyBorder(5, 0, 0, 0));
        Oop_Title.setForeground(Color.WHITE);
        Oop_Title.setFont(new Font("Copperplate", Font.PLAIN, 20));
        
        Oop_Panel.add(Oop_Title);
        Oop_Panel.setBackground(Color.decode("#16B3FD"));
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateMainMenu() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new GridLayout(3, 1));
        Oop_Panel.setBackground(Color.decode("#202020"));
        
        Oop_Panel.add(Oop_CreateAvatar());
        Oop_Panel.add(Oop_CreateTool());
      
        return Oop_Panel;
    }
    
    
    public JPanel Oop_CreateAvatar() throws IOException
    {
        
        JPanel Oop_Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Oop_Panel.setBackground(Color.decode("#202020"));
        
        
        BufferedImage Oop_Image = ImageIO.read(new File("avatar.png"));
        Oop_Avatar = new JLabel(new ImageIcon(Oop_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));       
        Oop_Panel.add(Oop_Avatar);
        Oop_Avatar.setBackground(Color.BLACK);
        Oop_Avatar.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateTool() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new GridLayout(3, 1));
        Oop_Panel.setBackground(Color.decode("#202020"));
        int Oop_sizeicon = 25;
        
        
        BufferedImage Oop_dashboardimage = ImageIO.read(new File("dashboard.png"));
        ImageIcon Oop_dashboardicon = new ImageIcon(Oop_dashboardimage.getScaledInstance(Oop_sizeicon, Oop_sizeicon, Image.SCALE_SMOOTH));
        Oop_Panel.add(Oop_Dashboard = Oop_CreateButton(Oop_dashboardicon,"Dashboard"));
        Oop_Dashboard.setBackground(Color.BLACK);
        
        BufferedImage Oop_CreateImage = ImageIO.read(new File("create.png"));
        ImageIcon Oop_CreateIcon = new ImageIcon(Oop_CreateImage.getScaledInstance(Oop_sizeicon, Oop_sizeicon, Image.SCALE_SMOOTH));
        Oop_Panel.add(Oop_Create = Oop_CreateButton(Oop_CreateIcon,"Create     "));
        Oop_Create.setBackground(Color.BLACK);
        
        BufferedImage Oop_SearchImage = ImageIO.read(new File("search.png"));
        ImageIcon Oop_SearchIcon = new ImageIcon(Oop_SearchImage.getScaledInstance(Oop_sizeicon, Oop_sizeicon, Image.SCALE_SMOOTH));
        Oop_Panel.add(Oop_Search = Oop_CreateButton(Oop_SearchIcon,"Search     "));
        Oop_Search.setBackground(Color.BLACK);
      
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateDisplay()
    {
        JPanel Oop_JPanel = new JPanel(new BorderLayout());
        
        Oop_JPanel.add(Oop_startTitle(),BorderLayout.NORTH);
         
        
        Oop_JPanel.add(Oop_Display());
        return Oop_JPanel;
    }
    
    public JPanel Oop_startTitle()
    {
        JPanel Oop_Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        Oop_Panel.add(Oop_Greeting = new JLabel("Welcome admin"));
        Oop_Greeting.setForeground(Color.white);
       
        Oop_Panel.add(Oop_Logout = new JButton("Logout"));
        Oop_Logout.setForeground(Color.white);
        Oop_Panel.setBorder(new EmptyBorder(10, 2, 2, 10));
        Oop_Logout.addActionListener(this);
        Oop_Logout.setBackground(Color.decode("#D9534F"));
        
        Color Oop_background = Color.decode("#4D4D4D");
        Oop_Panel.setBackground(Oop_background);
        
       
        return Oop_Panel;
    }
    
    
   
    public JButton Oop_CreateButton(ImageIcon icon,String title)
    {
        JButton Oop_Button = new JButton(title,icon);
        Oop_Button.setForeground(Color.white);
        Oop_Button.setBackground(Color.decode("#202020"));
        Oop_Button.addActionListener(this);
        return Oop_Button;
    }
    
    public JPanel Oop_Display()
    {
        JPanel Oop_Panel = new JPanel();
        return Oop_Panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
