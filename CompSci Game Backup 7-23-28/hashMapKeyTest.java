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


public class hashMapKeyTest extends JPanel
{
   private static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   
   public hashMapKeyTest()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME,FRAME);
   }

   public static void doTheThing()
   {
      HashMap<Integer,Boolean> keyPressed = new HashMap<>();
      long START_TIME = System.currentTimeMillis();
      long time = 0;      
      while(time <= 10000){
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
            new KeyEventDispatcher() {
               @Override
               
               
               public boolean dispatchKeyEvent(KeyEvent e) 
               {
                  synchronized (KeyboardInput2.class)
                  {
                     switch (e.getID())
                     {
                        case KeyEvent.KEY_PRESSED:
                           keyPressed.put(e.getKeyCode(), true);
                           //System.out.println(e.getKeyCode());
                           break;
                        case KeyEvent.KEY_RELEASED:
                           keyPressed.remove(e.getKeyCode());
                           //System.out.println(e.getKeyCode());
                           break;
                     }
                     return false;
                  }
               }
            });
         time = System.currentTimeMillis()-START_TIME;
         System.out.println(keyPressed);
      }
         
      System.out.println(keyPressed);
      //doTheThing();
      
   
   }
}