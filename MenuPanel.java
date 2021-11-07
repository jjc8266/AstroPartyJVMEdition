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
import java.util.concurrent.TimeUnit;
import java.io.*;
import javax.sound.sampled.*;

public class MenuPanel extends JPanel 
{
   private AstroButton bob;
   private int count = 0;
   private static Clip bcknd;
   private static FloatControl gainControl;
   private ImageIcon icon = new ImageIcon("AstroPartyAnimatedTitle.GIF"); 
   private JLabel thumb;
   public MenuPanel(){
      thumb = new JLabel();
      
      thumb.setIcon(icon);
      add(thumb);
      JPanel south = new JPanel();
      south.setLayout(new GridLayout(1,3,2,2));
      JLabel bo = new JLabel("");
      JLabel bobbie = new JLabel("");
      Timer time = new Timer(1600,new Listener());
      time.start();
      try{
         if(count==0)
            playMusic("comealivebckgndmusic.wav",0);
      } catch(Exception e)
      {
         System.out.println("oopS");
      }
      count++;
      try{     
         bob = new AstroButton();
         thumb.setLayout(new BorderLayout());
         thumb.add(south,BorderLayout.SOUTH);
         south.add(bo);
         south.add(bob,BorderLayout.SOUTH);
         south.add(bobbie);
         south.setOpaque(false);
         //animate();
      }
      
      catch(Exception e){}
   }
   public MenuPanel(int lol){
      thumb = new JLabel();
      
      thumb.setIcon(icon);
      add(thumb);
      JPanel south = new JPanel();
      south.setLayout(new GridLayout(1,3,2,2));
      JLabel bo = new JLabel("");
      JLabel bobbie = new JLabel("");
      Timer time = new Timer(1600,new Listener());
      time.start();
      /*try{
         if(count==0)
            playMusic("comealivebckgndmusic.wav");
      } catch(Exception e)
      {
         System.out.println("oopS");
      }*/
      count++;
      try{    
         bob = new AstroButton();
         thumb.setLayout(new BorderLayout());
         thumb.add(south,BorderLayout.SOUTH);
         south.add(bo);
         south.add(bob,BorderLayout.SOUTH);
         south.add(bobbie);
         south.setOpaque(false);
         //animate();
      }
      
      catch(Exception e){}
   }

   
//    public void animate() throws Exception{ 
//       long startTime = System.currentTimeMillis();
//       long currentTime = System.currentTimeMillis();
//       while(currentTime-startTime<1600){
//          currentTime = System.currentTimeMillis();
//          
//       }
//       thumb.setIcon(icon);
//    
//       thumb.setIcon(new ImageIcon("AstroTitleBackground.gif"));
//       
//    }
   public static void playMusic(String bckndfile,int decide) throws Exception
   {
      if(decide == 0) {
         bcknd = AudioSystem.getClip(); 
      
         bcknd.open(AudioSystem.getAudioInputStream(new File(bckndfile))); }
      if(decide == 0)
         bcknd.start();
      if(decide == 1)
         bcknd.stop();
      if(decide == 2) {
         FloatControl gainControl = (FloatControl) bcknd.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(-20.0f); 
         bcknd.start();
      if(decide == 3) {
         bcknd.stop();
         bcknd.open(AudioSystem.getAudioInputStream(new File(bckndfile)));
         bcknd.start();
      }
      }
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         thumb.setIcon(new ImageIcon("AstroTitleBackground.gif"));
      }
   }  

}
