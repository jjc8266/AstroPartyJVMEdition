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
import java.util.Scanner;

public class WinnerPanel extends JPanel
{
   private JButton back;
   
   private Container prevpanel;
   public WinnerPanel()
   {
      try{
         Scanner scan = new Scanner(new File("winner.txt"));
         JLabel backnd = new JLabel("");
         backnd.setIcon(new ImageIcon("AstroWinPanel.PNG"));
         add(backnd);
         backnd.setLayout(new GridLayout(3,3,1,1));
         back = new JButton(new ImageIcon("AstroBackButton.png"));
         back.addActionListener(new BackListener());
         JLabel winner = new JLabel(""+scan.nextLine());
         winner.setFont(new Font("Courier New",Font.BOLD,100));
         JLabel winnergif1 = new JLabel();
         winnergif1.setIcon(new ImageIcon("AstroDabbingGuy.gif"));
      //winnergif1.setHorizontalAlignment(backnd.RIGHT);
         JLabel winnergif2 = new JLabel();
         winnergif2.setIcon(new ImageIcon("AstroDabbingGuy.gif"));
      //winnergif2.setHorizontalAlignment(backnd.LEFT);
         System.out.println(winner.getText());
         winner.setForeground(Color.WHITE);
         winner.setOpaque(false);
         winner.setHorizontalAlignment(SwingConstants.CENTER);
         backnd.add(back);
         backnd.add(new JLabel(""));
         backnd.add(new JLabel(""));
         backnd.add(new JLabel(""));
         backnd.add(new JLabel(""));
         backnd.add(new JLabel(""));
         backnd.add(winnergif1);
         backnd.add(winner);
         backnd.add(winnergif2);
      //       backnd.add(winnergif1);
      //       backnd.add(new JLabel(""));
      //       backnd.add(winnergif2);
      //       backnd.add(back);
      //       backnd.add(winner);
      //       backnd.add(new JLabel(""));
         back.setOpaque(false);
         back.setContentAreaFilled(false);
         back.setBorderPainted(false);   
         back.setFocusPainted(false);
      } catch(Exception e)
      {
         System.out.println("AHHH");
      }
   }
   private class BackListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         prevpanel = AstroDriver.frame.getContentPane();
         prevpanel.removeAll();
         try{
            MenuPanel.playMusic("comealivebckgndmusic.wav",1);
         } catch(Exception f) {}             System.gc();
         JPanel newpanel = new MenuPanel();
            //newpanel.setPreferredSize(new Dimension(1920,1080));
            //prevpanel.add(newpanel);
         AstroDriver.frame.setContentPane(newpanel);
         AstroDriver.frame.repaint();
         AstroDriver.frame.validate();
         AstroDriver.frame.setVisible(true);
         prevpanel = null;
         System.gc();
      }
   }
}