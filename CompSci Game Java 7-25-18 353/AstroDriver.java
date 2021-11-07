import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
 
public class AstroDriver
{
   public static JFrame frame;
   public static void main(String[] args)
   { 
      frame = new JFrame("Astro BOB");
      frame.setSize(1920, 1080);    
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MenuPanel p = new MenuPanel();
      frame.setContentPane(p);
      p.requestFocus();
      frame.setVisible(true);
      
   }
}
//2163 lines + ads and collisions x3dd + explosion animations