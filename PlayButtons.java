import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class PlayButtons extends JPanel{
   private JButton backbutton,quickPlay,standardMatch,longMatch,marathon,startt,adson;
   private JTextField play1,play2;
   private ImageIcon back, qPlay, standard, Long, Marathon,start;
   private Container prevpanel;
   private int livespassed = 1;
   public PlayButtons()
   {
      setLayout(new GridLayout(4,3,5,2));
      setPreferredSize(new Dimension(480,270));
      setOpaque(false);
      //JPanel upper = new JPanel();
      //upper.setOpaque(false);
      //upper.setLayout(new GridLayout(1,3,2,2));
      back = new ImageIcon("AstroBackButton.PNG");
      qPlay = new ImageIcon("quickPlay.PNG");
      standard = new ImageIcon("standard.PNG");
      Long = new ImageIcon("longImage.PNG");
      Marathon = new ImageIcon("marathon.PNG");
      start = new ImageIcon("AstroStartButton.PNG");
   
      
      
      backbutton = new JButton(back);//////////////////////////////////////////////////////////
      backbutton.addActionListener(new BackListener());
      JLabel bobby = new JLabel("");
      bobby.setVisible(false);
     
      JLabel bobby1 = new JLabel("");
      bobby1.setVisible(false);
      
      JLabel bobby2 = new JLabel("");
      bobby2.setVisible(false);
      
   
      JLabel bobby4 = new JLabel("");
      bobby4.setVisible(false);
      
      
      quickPlay = new JButton(qPlay);////////////////////////////////////////////////////////////
      quickPlay.addActionListener(new QPListener());
      
      
      JLabel bobby10 = new JLabel("");
      bobby10.setVisible(false);
      
   //             JLabel bobby20 = new JLabel("");
   //       bobby20.setVisible(false);
   //       add(bobby20);
   
      JLabel names = new JLabel("");
      names.setIcon(new ImageIcon("AstroNamesLabelActual.PNG"));
      names.setVisible(true);
      
      
      play1 = new JTextField("Player1: ",3);
      play1.setFont(new Font("Monospaced", Font.BOLD, 50));
      play1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      play1.setForeground(Color.WHITE);
      play1.setOpaque(false);
      
      play2 = new JTextField("Player2: ",3);
      play2.setFont(new Font("Monospaced", Font.BOLD, 50));
      play2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      play2.setForeground(Color.WHITE);
      play2.setOpaque(false); 
   
   
      
      startt = new JButton(start);///////////////////////////////////////////////////////////////////
      startt.addActionListener(new StarttListener());
      
      
      JLabel bobby6 = new JLabel("");
      bobby6.setVisible(false);
      
      
      
      JLabel bobby7 = new JLabel("");
      bobby7.setVisible(false);
      
      
      
   
      
   //       adson = new JButton("");///////////////////////////////////////////////////////////////////
   //       //adson.addActionListener(new AdsOnListener());
   //       add(adson);
   //       
   //       
   //       JLabel bobby8 = new JLabel("");
   //       bobby8.setVisible(false);
   //       add(bobby8);
   //       
   //       
   //       JLabel bobby9 = new JLabel("");
   //       bobby9.setVisible(false);
   //       add(bobby9);
   //       bobby9.setPreferredSize(new Dimension(40,20));// Width, Height 
   //    //       JLabel bobby15 = new JLabel("");
   //    //       bobby10.setVisible(false);
   //       add(bobby10);
   //       bobby10.setPreferredSize(new Dimension(40,20));// Width, Height 
   //       JLabel bobby11 = new JLabel("");
   //       bobby11.setVisible(false);
   //       add(bobby11); 
   //       bobby11.setPreferredSize(new Dimension(40,20));// Width, Height
     
      quickPlay.setOpaque(false);
      quickPlay.setContentAreaFilled(false);
      quickPlay.setBorderPainted(false);
      quickPlay.setFocusPainted(false);
   
      startt.setOpaque(false);
      startt.setContentAreaFilled(false);
      startt.setBorderPainted(false);   
      startt.setFocusPainted(false);
   
      backbutton.setOpaque(false);
      backbutton.setContentAreaFilled(false);
      backbutton.setBorderPainted(false);   
      backbutton.setFocusPainted(false);
   
   //       adson.setOpaque(false);
   //       adson.setContentAreaFilled(false);
   //       adson.setBorderPainted(false);   
   //       adson.setFocusPainted(false);   
   //       
      
      add(backbutton);   add(bobby); add(bobby4);
             
      add(bobby2); add(quickPlay);  add(names);  
       
      add(bobby1); add(bobby7);   add(play1);
      
      add(bobby10); add(startt);  add(play2);
      
   }
   private class BackListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         JPanel newpanel = new MenuPanel(1);
         prevpanel.add(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.setVisible(true);
      }  
   }
   private class QPListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (quickPlay.getIcon() == qPlay) 
         {
            quickPlay.setIcon(standard);
            livespassed = 3;
         }
            
         else if (quickPlay.getIcon() == standard) 
         {
            quickPlay.setIcon(Long);
            livespassed = 5;
         }
            
         else if (quickPlay.getIcon() == Long) {
            quickPlay.setIcon(Marathon);
            livespassed = 7;
         }
            
         else if (quickPlay.getIcon() == Marathon) {
            quickPlay.setIcon(qPlay);
            livespassed = 1;
         }
      
      
      }
   }

   private class StarttListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try{
            PrintStream outfile = new PrintStream(new FileOutputStream("names.txt"));
            outfile.println(play1.getText());
            outfile.println(play2.getText());
         } catch (Exception f)
         {
            System.out.println("OOPS!");
         }
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         try{
            JPanel newpanel = new GamePanel(livespassed);
            newpanel.setPreferredSize(new Dimension(1920,1080));
            prevpanel.add(newpanel);
            AstroDriver.frame.repaint();
            AstroDriver.frame.setVisible(true);
         } catch(Exception h) {
            System.out.println("rip");
         }
      }
   }

}