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

public class CreditsPanel extends JPanel
{
   public Container prevpanel;  
   public CreditsPanel()
   {
      ImageIcon icon = new ImageIcon("AstroCreditsPanel.PNG"); 
      JLabel thumb = new JLabel();
      thumb.setLayout(new GridLayout(3,3,2,2));
      thumb.setIcon(icon);
      add(thumb);
      JButton back = new JButton(new ImageIcon("AstroBackButton.PNG"));
      back.setVerticalAlignment(JLabel.TOP);
      back.setHorizontalAlignment(JLabel.LEFT);
      back.addActionListener(new BackListener());
      JLabel bo = new JLabel("");
      JLabel bobbie = new JLabel("");
      thumb.add(back);
      thumb.add(bo);
      thumb.add(bobbie);
      JLabel bobby = new JLabel("");
      JLabel hi = new JLabel("");
      JLabel bobbyhi = new JLabel("");
      JLabel hihi = new JLabel("");
      JLabel bobbyhello = new JLabel("");
      JLabel hello = new JLabel("");
      thumb.add(bobby);
      thumb.add(hi);
      thumb.add(bobbyhi);
      thumb.add(hihi);
      thumb.add(bobbyhello);
      thumb.add(hello);
      back.setOpaque(false);
      back.setContentAreaFilled(false);
      back.setBorderPainted(false);
      back.setFocusPainted(false);
      
      
      
   }
   private class BackListener implements ActionListener
   {
      public void actionPerformed(ActionEvent E)
      {
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         JPanel newpanel = new MenuPanel(1);
         prevpanel.add(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.setVisible(true);
      }
   }
}