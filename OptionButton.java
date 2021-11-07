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
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.sound.sampled.*;
public class OptionButton extends JPanel{
   private JButton backbutton,soundoff,soundon,soundscool,soundslame,adson,adsoff;
   private ImageIcon back, sOn, sOff, sCool, sLame, aOn, aOff, theme1, theme2;
   public static int soundonoff = 0;
   public static int adsonoff = 1;
   private Container prevpanel;
   public OptionButton()
   {
      setLayout(new GridLayout(5,3,5,2));
      setPreferredSize(new Dimension(480,270));
      setOpaque(false);
      //JPanel upper = new JPanel();
      //upper.setOpaque(false);
      //upper.setLayout(new GridLayout(1,3,2,2));
      back = new ImageIcon("AstroBackButton.PNG");
      sOn = new ImageIcon("AstroSoundOnButton.PNG");
      sOff = new ImageIcon("AstroSoundOffButton.PNG");
      theme1 = new ImageIcon("AstroTheme1.PNG");
      theme2 = new ImageIcon("AstroTheme2.PNG");
      aOn = new ImageIcon("AstroAdsOnButton.PNG");
      aOff = new ImageIcon("AstroAdsOffButton.PNG");
      
      
      backbutton = new JButton(back);
      backbutton.addActionListener(new BackListener());
      add(backbutton);
      JLabel bobby = new JLabel("");
      bobby.setVisible(false);
      add(bobby);
      JLabel bobby1 = new JLabel("");
      bobby1.setVisible(false);
      add(bobby1);
   
   
      JLabel bobby4 = new JLabel("");
      bobby4.setVisible(false);
      add(bobby4);
      
      soundon = new JButton(sOn);
      soundon.addActionListener(new SoundOnListener());
      add(soundon);
      
      JLabel bobby2 = new JLabel("");
      bobby2.setVisible(false);
      add(bobby2);
      
   
      JLabel bobby5 = new JLabel("");
      bobby5.setVisible(false);
      add(bobby5);
   
   
      
      soundscool = new JButton(theme1);
      soundscool.addActionListener(new SoundCoolListener());
      add(soundscool);
      
      JLabel bobby6 = new JLabel("");
      bobby6.setVisible(false);
      add(bobby6);
      
      JLabel bobby7 = new JLabel("");
      bobby7.setVisible(false);
      add(bobby7);
      
   
      
      adson = new JButton(aOn);
      adson.addActionListener(new AdsOnListener());
      add(adson);
      
      JLabel bobby8 = new JLabel("");
      bobby7.setVisible(false);
      add(bobby8);
      
      JLabel bobby9 = new JLabel("");
      bobby9.setVisible(false);
      add(bobby9);
      bobby9.setPreferredSize(new Dimension(40,20));// Width, Height 
      JLabel bobby10 = new JLabel("");
      bobby10.setVisible(false);
      add(bobby10);
      bobby10.setPreferredSize(new Dimension(40,20));// Width, Height 
      JLabel bobby11 = new JLabel("");
      bobby11.setVisible(false);
      add(bobby11); 
      bobby11.setPreferredSize(new Dimension(40,20));// Width, Height
     
      backbutton.setOpaque(false);
      backbutton.setContentAreaFilled(false);
      backbutton.setBorderPainted(false);
      backbutton.setFocusPainted(false);
   
      soundon.setOpaque(false);
      soundon.setContentAreaFilled(false);
      soundon.setBorderPainted(false);   
      soundon.setFocusPainted(false);
   
      soundscool.setOpaque(false);
      soundscool.setContentAreaFilled(false);
      soundscool.setBorderPainted(false);   
      soundscool.setFocusPainted(false);
   
      adson.setOpaque(false);
      adson.setContentAreaFilled(false);
      adson.setBorderPainted(false);   
      adson.setFocusPainted(false);       
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
   private class SoundOnListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (soundon.getIcon() == sOn) {
            soundon.setIcon(sOff);
            soundonoff = 1;
            try{
            MenuPanel.playMusic("comealivebckgndmusic.wav",1);
            } catch(Exception whoops) {
               System.out.println("oops");
            }
         } else {
            soundon.setIcon(sOn);
           try{
            MenuPanel.playMusic("comealivebckgndmusic.wav",0);
            } catch(Exception whoops) {
               System.out.println("oops");
            }
            soundonoff = 0;
         }
      }
   }

   private class SoundCoolListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (soundscool.getIcon() == theme1) {
            soundscool.setIcon(theme2);
            try {MenuPanel.playMusic("comealivebckgndmusic.wav",1);} catch(Exception f) {System.out.println("nope");}
            try {MenuPanel.playMusic("eternaleclipsebckgrndmusic.wav",0);} catch(Exception g) {System.out.println("nope");}
         } else {
            soundscool.setIcon(theme1);
            try {MenuPanel.playMusic("eternaleclipsebckgrndmusic.wav",1);} catch(Exception f) {System.out.println("nope");}
            try {MenuPanel.playMusic("comealivebckgndmusic.wav",0);} catch(Exception g) {System.out.println("nope");}
         }
      }
   }
   private class AdsOnListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (adson.getIcon() == aOn) {
            adson.setIcon(aOn);
            adsonoff = 1;
         } else {
            adson.setIcon(aOn);
         }
      }
   }
}