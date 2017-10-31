/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author emzAd
 */
public class AdminInterface extends JFrame implements ActionListener {
    
    JLabel Oop_Dashboard;
    JLabel Oop_Create;
    JLabel Oop_Search;
    JButton Oop_Logout;
    JLabel Oop_Avatar;
    JLabel Oop_Title;
    
    public AdminInterface()
    {
        this.add(Oop_MainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public JPanel Oop_MainPanel()
    {
        JPanel Oop_Panel = new JPanel(new BorderLayout());
        Oop_Panel.add(Oop_CreateMenu(),BorderLayout.WEST);
        Oop_Panel.add(Oop_CreateDisplay(),BorderLayout.CENTER);
        return Oop_Panel;
    }
    
    public JPanel Oop_CreateMenu() throws IOException
    {
        JPanel Oop_Panel = new JPanel(new GridLayout(5, 1));
        Oop_Panel.add(Oop_Title = Oop_CreateLabel("MANAGER"));
        Oop_Title.setBackground(Color.BLUE);
        
        BufferedImage Oop_Image = ImageIO.read(new File("avatar.png"));
        Oop_Avatar = new JLabel(new ImageIcon(Oop_Image.getScaledInstance(20, 30, Image.SCALE_SMOOTH)));       
        Oop_Panel.add(Oop_Avatar);
        Oop_Avatar.setBackground(Color.BLACK);
        
        BufferedImage Oop_dashboardicon = ImageIO.read(new File("dashboard.png"));
        Oop_Panel.add(Oop_Dashboard = Oop_CreateLabel(Oop_dashboardicon,"Dashboard"));
        Oop_Dashboard.setBackground(Color.BLACK);
        
        BufferedImage Oop_CreateIcon = ImageIO.read(new File("create.png"));
        Oop_Panel.add(Oop_Create = Oop_CreateLabel(Oop_CreateIcon,"Create"));
        Oop_Create.setBackground(Color.BLACK);
        
        BufferedImage Oop_SearchIcon = ImageIO.read(new File("search.png"));
        Oop_Panel.add(Oop_Search = Oop_CreateLabel(Oop_SearchIcon,"Search"));
        Oop_Search.setBackground(Color.BLACK);
        
        return Oop_Panel;
                
    }
    
    public JPanel Oop_CreateDisplay()
    {
        JPanel Oop_JPanel = new JPanel(new BorderLayout());
        
        Oop_JPanel.add(Oop_CreateLabel("Welcome admin"),BorderLayout.NORTH);
        Oop_JPanel.add(Oop_Logout = Oop_CreateButton("Logout"),BorderLayout.NORTH);
        Oop_Logout.addActionListener(this);
        Oop_Logout.setBackground(Color.red);
        
        Oop_JPanel.add(Oop_Display());
        return Oop_JPanel;
    }
    
    public JLabel Oop_CreateLabel(String title)
    {
        JLabel Oop_Label = new JLabel(title);
        return Oop_Label;
    }
    
    public JLabel Oop_CreateLabe(ImageIO icon,String title)
    {
        JLabel Oop_Label = new JLabel(title, icon, LEFT_ALIGNMENT);
        return Oop_Label;
    }
    
    public
}
