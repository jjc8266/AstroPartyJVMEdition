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
import javax.sound.sampled.*;

public class GamePanel extends JPanel
{
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private static final int FRAME = 10000;
   private long xVel,xVelr,thetaVel,thetaVelr;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private BlueShip blue;
   private RedShip red;
   private NiceBlock nice;
   private NiceBlock nice2;
   private NiceBlock nice3;
   private DeathBlock death;
   private DeathBlock death2;
   private DeathBlock death3;
   private Timer t; 
   private ArrayList<PewPew> pews;
   public long redShootLast,blueShootLast;
   private boolean redShootable,blueShootable = true;
   private Map[] blocks;

		//constructor   
   public GamePanel(int lives)
   {
   //       JLabel thumb = new JLabel();
   //       thumb.setIcon(new ImageIcon("AstroBG1.png"));
   //       add(thumb);
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
      red =  new RedShip(1920,0,lives,225);
      int[] array = new int[6];
      for(int k = 0; k < array.length; k++)
      {
         array[k] = (int)(Math.random()*4);
      }
      int[] array1 = new int[6];
      for(int k = 0; k < array1.length; k++)
      {
         array1[k] = (int)(Math.random()*7);
      }
      nice = new NiceBlock(array[0]*550+150,array1[0]*175+40);
      nice2 = new NiceBlock(array[1]*550+150,array1[1]*175+40);
      nice3 = new NiceBlock(array[2]*550+150,array1[2]*175+40);
      death = new DeathBlock(array[3]*550+150,array1[3]*175+40);
      death2 = new DeathBlock(array[4]*550+150,array1[4]*175+40);
      death3 = new DeathBlock(array[5]*550+150,array1[5]*175+40);
      
      blocks = new Map[6];
      blocks[0] = nice;
      blocks[1] = nice2;
      blocks[2] = nice3;
      blocks[3] = death;
      blocks[4] = death2;
      blocks[5] = death3;
      xVel = 0;
      thetaVel = 0;
      xVelr = 0;
      thetaVelr = 0;
      redShootLast = System.currentTimeMillis();
      blueShootLast = System.currentTimeMillis();
      pews = new ArrayList<PewPew>();
      // blue = new BlueShip(FRAME,FRAME,lives);
   //       red = new RedShip(FRAME,FRAME,lives);
   
            //addKeyListener(new Key());
      //setFocusable(true);
      
      t = new Timer(1, new Listener());
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
            if((xVel <10000) && xVel >= 0){
               xVel++;
               blue.accelerate(xVel);
               blue.collideWidth(blocks);
            }
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         else{
            if((xVel <10000) && xVel > 0){
               xVel--;
               blue.accelerate(xVel);}
            blue.collideWidth(blocks);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         if(keyPressed.containsKey(40)){
            if((xVelr <10000) && xVelr >= 0){
               xVelr++;
               red.accelerate(xVelr);}
            red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         else{
            if((xVelr < 10000) && xVelr >0){
               xVelr--;
               red.accelerate(xVelr);}
            red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         
         
         if(keyPressed.containsKey(65)){
            if((thetaVel <10000) && thetaVel >= 0){
               thetaVel++;
               blue.rotate(thetaVel);}
            blue.collideWidth(blocks);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         else{
            if((thetaVel <10000) && thetaVel > 1){
               thetaVel-=2;
               blue.rotate(thetaVel);}
            blue.collideWidth(blocks);
            blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         
         if(keyPressed.containsKey(37)){
            if((thetaVelr < 10000) && thetaVelr >= 0){
               thetaVelr++;
               red.rotate(thetaVelr);}
            red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         else{
            if((thetaVelr < 10000) && thetaVelr > 1){
               thetaVelr-=2;
               red.rotate(thetaVelr);}
            red.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         
         if(keyPressed.containsKey(39)){//This is for shooting RED
            PewPew bob = new PewPew(red.getX(),red.getY(),red.getOrient());
            if(redShootable){
               
               pews.add(bob);
               try{
                  if(OptionButton.soundonoff == 0)
                     playSound("pewpew.wav");
               } catch(Exception e)
               {
                  System.out.println("oopS");
               }
               redShootable = false;
            }
         }
         else
            redShootable = true;
         
         if(keyPressed.containsKey(68)){//This is for shooting BLUE
            PewPew bob = new PewPew(blue.getX(),blue.getY(),blue.getOrient());
            if(blueShootable){               
               pews.add(bob);
               blueShootLast = System.currentTimeMillis();
               try{
                  if(OptionButton.soundonoff == 0)
                     playSound("pewpew.wav");
               } catch(Exception e)
               {
                  System.out.println("oopS");
               }
               blueShootable = false;
               System.out.println(pews+"");
            }
            
         }
         else{
            blueShootable = true;
         }
        
             
         //System.out.println("Blue xVel: " + xVel + "Blue thetaVel: " + thetaVel);    
      }       
   }
   
   
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, 1920, 1080, null);
      //g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   public void playSound(String soundfile) throws Exception
   {
      Clip sound = new AudioSystem.getClip();
      sound.open(AudioSystem.getAudioInputStream(new File(soundfile)));
      sound.start();
   }
   private class Listener implements ActionListener
   {
      private int collision = 0;
      Key bob = new Key();
      public void actionPerformed(ActionEvent e)
      {
         bob.keyPressed();
         myBuffer.drawImage(new ImageIcon("AstroBG1.png").getImage(),0,0,null);
         myBuffer.setColor(BACKGROUND);    //cover the 
         myBuffer.fillRect(0,0,1920,1080);
         myBuffer.fillRect(0,0,FRAME,FRAME);
         myBuffer.setColor(Color.RED);
         red.move(1920,1080);
         //red.move(FRAME,FRAME);
         red.draw(myBuffer);
         blue.collideWidth(blocks);
         blue.move(1920,1080);   //old ball
         //blue.move(FRAME,FRAME);
         blue.draw(myBuffer);
         
         nice.draw(myBuffer,1920,1080);
         nice2.draw(myBuffer,1920,1080);
         nice3.draw(myBuffer,1920,1080);
         death.draw(myBuffer,1920,1080);
         death2.draw(myBuffer,1920,1080);
         death3.draw(myBuffer,1920,1080);
         
         for(int c = 0;c<pews.size();c++){
            PewPew temp = pews.get(c);
            temp.draw(myBuffer);
            temp.move(1920,1080);
            int bobbo = temp.collideWidth(red,blue);
            switch(bobbo){
               case 0: 
                  break;
               case 1: System.out.println("RED DIED"); red.setLives(red.getLives()-1);
                  break;
               case 2: System.out.println("BLUE DIED"); blue.setLives(blue.getLives()-1);
                  break;
            }
            if(temp.explode())
               pews.remove(c);
         }
         
         
         
         /*if(collide(red,blue))
         {
            /*myBuffer.setColor(Color.RED);
            pd.jump(FRAME,FRAME);
            pd.draw(myBuffer); 
            collision++;
         }*/
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Comic Sans MS",Font.ITALIC,25));
         myBuffer.drawString("Red has: "+red.getLives(), 1700,50); 
         myBuffer.drawString("Blue has: "+blue.getLives(), 50,50);
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