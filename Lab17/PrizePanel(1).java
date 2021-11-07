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
public class PrizePanel extends JPanel
{
   private static final int FRAME = 1000;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Polkadot pd;
   private Timer t; 
   

		//constructor   
   public PrizePanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME,FRAME);
      int xPos = (int)(Math.random()*(FRAME-100) + 50);
      int yPos = (int)(Math.random()*(FRAME-100)+ 50);
      ball = new Ball(xPos, yPos, 50, Color.BLACK);
      pd = new Polkadot();
      //addKeyListener(new Key());
      //setFocusable(true);
      
      t = new Timer(5, new Listener());
      t.start();
   
   }
   
   private class Key extends KeyAdapter
   {
      HashMap<Integer,Boolean> keyPressed = new HashMap<Integer,Boolean>();
      private int sN = 5;
      public void keyPressed()
      {
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
            new KeyEventDispatcher() {
               @Override
               public boolean dispatchKeyEvent(KeyEvent e) 
               {
                  synchronized (PrizePanel.class)
                  {
                     switch (e.getID())
                     {
                        case KeyEvent.KEY_PRESSED:
                           keyPressed.put(e.getKeyCode(), true);
                           break;
                        case KeyEvent.KEY_RELEASED:
                           keyPressed.remove(e.getKeyCode());
                           break;
                     }
                     return false;
                  }
               }
            });
      //          switch(keyPressed)
      //          {
      //             case keyPressed.containsKey(87)&&keyPressed.containsKey(65): pd.setY(pd.getY()+1);pd.setX(pd.getX()-1);//w+a
      //                break;
      //             case keyPressed.containsKey(87)&&keyPressed.containsKey(68):pd.setY(pd.getY()+1);pd.setX(pd.getX()+1);//w+d
      //                break;
      //             case keyPressed.containsKey(83)&&keyPressed.containsKey(65):pd.setY(pd.getY()-1);pd.setX(pd.getX()-1);//s+a
      //                break;
      //             case keyPressed.containsKey(83)&&keyPressed.containsKey(68):pd.setY(pd.getY()-1);pd.setX(pd.getX()+1);//s+d
      //                break;
      //             case keyPressed.containsKey(87):pd.setY(pd.getY()+1);//w
      //                break;
      //             case keyPressed.containsKey(65):pd.setX(pd.getX()-1);//a
      //                break;
      //             case keyPressed.containsKey(83):pd.setY(pd.getY()-1);//s
      //                break;
      //             case keyPressed.containsKey(68):pd.setX(pd.getX()+1);//d
      //                break;
      //          
      //              
      //          }
         System.out.println(keyPressed);
         if(keyPressed.containsKey(87)&&keyPressed.containsKey(65))
         {
            pd.setY(pd.getY()-sN);pd.setX(pd.getX()-sN);
         }
         else if(keyPressed.containsKey(87)&&keyPressed.containsKey(68))
         {
            pd.setY(pd.getY()-sN);pd.setX(pd.getX()+sN);
         }
         else if(keyPressed.containsKey(83)&&keyPressed.containsKey(65))
         {
            pd.setY(pd.getY()+sN);pd.setX(pd.getX()-sN);
         }
         else if(keyPressed.containsKey(83)&&keyPressed.containsKey(68))
         {
            pd.setY(pd.getY()+sN);pd.setX(pd.getX()+sN);
         }
         else if(keyPressed.containsKey(87))
         {
            pd.setY(pd.getY()-sN);//w
         }         
         else if(keyPressed.containsKey(65))
         {
            pd.setX(pd.getX()-sN);//a
         }
         else if (keyPressed.containsKey(83))
         {
            pd.setY(pd.getY()+sN);//s
         
         }
         else if (keyPressed.containsKey(68))
         {
            pd.setX(pd.getX()+sN);//d
         
         }
         
      
      }
         
         
         
   }
   
   
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   private class Listener implements ActionListener
   {
      private int collision = 0;
      Key bob = new Key();
      public void actionPerformed(ActionEvent e)
      {
         bob.keyPressed();
         myBuffer.setColor(BACKGROUND);    //cover the 
         myBuffer.fillRect(0,0,FRAME,FRAME);
         myBuffer.setColor(Color.RED);
         pd.draw(myBuffer);   //old ball
         ball.move(FRAME,FRAME);
         ball.draw(myBuffer);
         
         if(collide(ball,pd))
         {
            myBuffer.setColor(Color.RED);
            pd.jump(FRAME,FRAME);
            pd.draw(myBuffer); 
            collision++;
         }
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Comic Sans MS",Font.ITALIC,25));
         myBuffer.drawString("Collisions: "+collision, FRAME/2,50);   
         repaint();
      }
   }   
   private boolean collide(Ball b, Polkadot pd)
   {
      double d = Math.sqrt(Math.pow(ball.getX()-pd.getX(),2)+Math.pow(ball.getY()-pd.getY(),2));  
      if(d<=ball.getRadius()+pd.getRadius())
         return true;
      else
         return false;
   	  
   }
//    private double distance(double x1, double y1, double x2, double y2)
//    {
//       return ; 	 // enter the calculation here.
//    }
}