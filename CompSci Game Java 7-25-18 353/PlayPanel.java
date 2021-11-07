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

public class PlayPanel extends JPanel
{
   private PlayButtons bob;
   public PlayPanel()
   {
      ImageIcon icon = new ImageIcon("AstroOptionsPanel.PNG"); 
      JLabel thumb = new JLabel();
      thumb.setIcon(icon);
      add(thumb);
      JPanel south = new JPanel();
      south.setLayout(new GridLayout(1,3,2,2));
      JLabel bo = new JLabel("");
      JLabel bobbie = new JLabel("");
      
      bob = new PlayButtons();
      thumb.setLayout(new BorderLayout());
      thumb.add(south,BorderLayout.SOUTH);
      south.add(bo);
      south.add(bob,BorderLayout.SOUTH);
      south.add(bobbie);
      south.setOpaque(false);
      thumb.add(bob);
   }
}