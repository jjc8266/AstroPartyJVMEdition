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

public class OptionButton extends JPanel{
   private JButton backbutton,soundoff,soundon,soundscool,soundslame,adson,adsoff;
   private ImageIcon back, sOn, sOff, sCool, sLame, aOn, aOff;
   public static int soundonoff = 0;
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
      sCool = new ImageIcon("AstroSoundsCoolButton.PNG");
      sLame = new ImageIcon("AstroSoundsLameButton.PNG");
      aOn = new ImageIcon("AstroAdsOffButton.PNG");
      aOff = new ImageIcon("AstroAdsOnButton.PNG");
      
      
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
   
   
      
      soundscool = new JButton(sCool);
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
         JPanel newpanel = new MenuPanel();
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
         } else {
            soundon.setIcon(sOn);
            soundonoff = 0;
         }
      }
   }

   private class SoundCoolListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (soundscool.getIcon() == sCool) {
            soundscool.setIcon(sLame);
         } else {
            soundscool.setIcon(sCool);
         }
      }
   }
   private class AdsOnListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (adson.getIcon() == aOn) {
            adson.setIcon(aOff);
         } else {
            adson.setIcon(aOn);
         }
      }
   }
}