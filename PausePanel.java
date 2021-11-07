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

public class PausePanel extends JPanel
{
   private JButton resume,quit;
   //private Contanier prevpanel;
   public PausePanel()
   {
      JLabel bkgnd = new JLabel("");
      bkgnd.setIcon(new ImageIcon("AstroOptionsPanel.png"));
      add(bkgnd);
      bkgnd.setLayout(new GridLayout(3,3,2,2));
      JLabel filler1 = new JLabel("");
      bkgnd.add(filler1);
      JLabel filler2 = new JLabel("");
      bkgnd.add(filler2);
      JLabel filler3 = new JLabel("");
      bkgnd.add(filler3);
      JLabel filler4 = new JLabel("");
      bkgnd.add(filler4);
      resume = new JButton(new ImageIcon("AstroResumeButton.png"));
      resume.addActionListener(new ResumeListener());
      bkgnd.add(resume);
      JLabel filler5 = new JLabel("");
      bkgnd.add(filler5);
      JLabel filler6 = new JLabel("");
      bkgnd.add(filler5);
      quit = new JButton(new ImageIcon("AstroQuitWithoutSavingButton.png"));
      quit.addActionListener(new QuitListener());
      bkgnd.add(quit);
   }
   private class ResumeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //read and instantiate a new game panel with the given args
      }
   }
   private class QuitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}