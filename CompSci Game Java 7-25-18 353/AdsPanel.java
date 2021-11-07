   //Name:    Date:
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
import java.applet.*;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AdsPanel extends JPanel
{
   private Timer t1;
   private Timer t2;
   private Timer t3;
   private JLabel first,second,third;
   private Container prevpanel;
   public AdsPanel()
   {
      setLayout(new GridLayout(1,1));
      first = new JLabel();
      first.setIcon(new ImageIcon("AstroAd1.PNG"));
      first.setHorizontalAlignment(SwingConstants.CENTER);
      add(first);
      t1 = new Timer(5000,new Listener1());
      t1.start();
      t2 = new Timer(10000,new Listener2());
      t2.start();
      t3 = new Timer(15000,new Listener3());
      t3.start();
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         first.setIcon(new ImageIcon("AstroAd2.png"));
         t1.stop();
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         first.setIcon(new ImageIcon("AstroAd3.png"));
         t1.stop();
         t2.stop();
      }
   }
   private class Listener3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         t1.stop();
         t2.stop();
         t3.stop();
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         JPanel newpanel = new WinnerPanel();
         //prevpanel.add(newpanel);
         AstroDriver.frame.setContentPane(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.setVisible(true);
         prevpanel = null;
         System.gc();
      }
   }
   
}