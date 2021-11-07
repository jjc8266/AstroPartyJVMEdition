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

public class AstroButton extends JPanel{
   private JButton options,play,credits;
   public Container prevpanel;
   public AstroButton()
   {
      setLayout(new GridLayout(3,1,5,2));
      setPreferredSize(new Dimension(480,270));
      setOpaque(false);
      JPanel upper = new JPanel();
      upper.setOpaque(false);
      upper.setLayout(new GridLayout(1,3,2,2));
      JLabel bobby = new JLabel("");
      bobby.setVisible(false);
      upper.add(bobby);
      
      ImageIcon Play = new ImageIcon("playbutton.PNG");
      ImageIcon Options = new ImageIcon("options.PNG");
      ImageIcon Credits = new ImageIcon("credits.PNG");
      
      play = new JButton(Play);
      play.addActionListener(new PlayListener());
      upper.add(play);
      
      JLabel bobbo = new JLabel("");
      upper.add(bobbo);    
      
      add(upper);
      
      JPanel lower = new JPanel();
      lower.setLayout(new GridLayout(1,3,2,2));
      options = new JButton(Options);
      options.addActionListener(new OptionListener());
      options.setVerticalAlignment(JLabel.TOP);
      lower.add(options);
      JLabel bobba = new JLabel("");
      lower.add(bobba);  
      credits = new JButton(Credits);
      credits.addActionListener(new CreditListener());
      credits.setVerticalAlignment(JLabel.TOP);
      lower.add(credits);
      lower.setOpaque(false);
      add(lower);
      
      JLabel bobbie = new JLabel("");
      add(bobbie);
      
      
   
      play.setOpaque(false);
      play.setContentAreaFilled(false);
      play.setBorderPainted(false);
      play.setFocusPainted(false);

      options.setOpaque(false);
      options.setContentAreaFilled(false);
      options.setBorderPainted(false);   
      options.setFocusPainted(false);
   
      credits.setOpaque(false);
      credits.setContentAreaFilled(false);
      credits.setBorderPainted(false);   
      credits.setFocusPainted(false);   
   }
   private class OptionListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         JPanel newpanel = new OptionsPanel();
         prevpanel.add(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.setVisible(true);
      }  
   }
   private class PlayListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         JPanel newpanel = new PlayPanel();
         prevpanel.add(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.setVisible(true);
      }
   }
   private class CreditListener implements ActionListener
   {
      public void actionPerformed(ActionEvent E)
      {
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         JPanel newpanel = new CreditsPanel();
         prevpanel.add(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.setVisible(true);
      }
   }
}