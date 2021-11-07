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
public class TestPanel extends JPanel
{
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private static final int FRAME = 10000;
   private long xVel,xVelr,thetaVel,thetaVelr = 0;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private BlueShip blue;
   private RedShip red;
   private Timer t; 
   

		//constructor   
   public TestPanel()
   {
      myImage =  new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
      //myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, 1920,1080);
      //myBuffer.fillRect(0, 0, FRAME,FRAME);
      /*int xPos = (int)(Math.random()*(FRAME-100) + 50);
      int yPos = (int)(Math.random()*(FRAME-100)+ 50);
      ball = new Ball(xPos, yPos, 50, Color.BLACK);
      pd = new Polkadot();*/
      blue = new BlueShip(0,1080,lives);
         red =  new RedShip(1920,0,lives);
      // blue = new BlueShip(FRAME,FRAME,lives);
//       red = new RedShip(FRAME,FRAME,lives);
   
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
                  synchronized (GamePanel.class)
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
      
         //System.out.println(keyPressed);
         
         if(keyPressed.containsKey(83)){
            if(!(xVel == 10000) || xVel != 0)
               xVel++;
            blue.accelerate(xVel);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         else{
            if(!(xVel == 10000) || xVel != 0)
               xVel--;
            blue.accelerate(xVel);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         if(keyPressed.containsKey(40)){
            if(!(xVelr == 10000) || xVelr != 0)
               xVel++;
            red.accelerate(xVelr);
            red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         else{
            if(!(xVelr == 10000) || xVelr != 0)
               xVelr--;
            red.accelerate(xVelr);
            red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         
         
         if(keyPressed.containsKey(65)){
            if(!(thetaVel == 10000) || thetaVel != 0)
               thetaVel++;
            blue.rotate(thetaVel);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         else{
            if(!(thetaVel == 10000) || thetaVel != 0)
               thetaVel--;
            blue.rotate(thetaVel);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         
         if(keyPressed.containsKey(37)){
            if(!(thetaVelr == 10000) || thetaVelr != 0)
               thetaVelr++;
            red.rotate(thetaVelr);
            red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         else{
            if(!(thetaVelr == 10000) || thetaVelr != 0)
               thetaVelr--;
            red.rotate(thetaVelr);
            red.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
             
             
      }       
   }
   
   
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, 1920, 1080, null);
      //g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   private class Listener implements ActionListener
   {
      private int collision = 0;
      Key bob = new Key();
      public void actionPerformed(ActionEvent e)
      {
         bob.keyPressed();
         myBuffer.setColor(BACKGROUND);    //cover the 
         myBuffer.fillRect(0,0,1920,1080);
         //myBuffer.fillRect(0,0,FRAME,FRAME);
         myBuffer.setColor(Color.RED);
         red.move(1920,1080);
         //red.move(FRAME,FRAME);
         red.draw(myBuffer);
         blue.move(1920,1080);   //old ball
         //blue.move(FRAME,FRAME);
         blue.draw(myBuffer);
         
         /*if(collide(red,blue))
         {
            /*myBuffer.setColor(Color.RED);
            pd.jump(FRAME,FRAME);
            pd.draw(myBuffer); 
            collision++;
         }*/
      
         repaint();
      }
   }   
  /* private boolean collide(RedShip b, Blue r)
   {
      double d = Math.sqrt(Math.pow(ball.getX()-pd.getX(),2)+Math.pow(ball.getY()-pd.getY(),2));  
      if(d<=ball.getRadius()+pd.getRadius())
         return true;
      else
         return false;
   	  
   } */
//    private double distance(double x1, double y1, double x2, double y2)
//    {
//       return ; 	 // enter the calculation here.
//    }
}