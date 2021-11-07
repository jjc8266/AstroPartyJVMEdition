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
import java.util.Scanner;
import javax.sound.sampled.*;

public class GamePanel extends JPanel
{
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private static final int FRAME = 10000;
   public static long xVel,xVelr,thetaVel,thetaVelr;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private BlueShip blue;
   private RedShip red;
   private String redname;
   private String bluename;
   private NiceBlock nice;
   private NiceBlock nice2;
   private NiceBlock nice3;
   private DeathBlock death;
   private DeathBlock death2;
   private DeathBlock death3;
   private Timer t; 
   private ArrayList<PewPew> pews;
   public long redShootLast,blueShootLast;
   private Scanner scan;
   private boolean redShootable,blueShootable = true;
   private Map[] blocks;
   private int decider;
   private JButton mover;
   public Container prevpanel;
   private boolean blueCollision = false;
   private boolean redCollision = false;
   private int gointopanel = 0;
		//constructor   
   public GamePanel(int lives) throws Exception
   {
   //       JLabel thumb = new JLabel();
   //       thumb.setIcon(new ImageIcon("AstroBG1.png"));
   //       add(thumb);
      MenuPanel.playMusic("comealivebckgndmusic.wav",1);
      MenuPanel.playMusic("comealivebckgndmusic.wav",2);
      scan = new Scanner(new File("names.txt"));
      bluename = scan.nextLine();
      redname = scan.nextLine();
      decider = (int)(Math.random()*3+1);
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
      blue = new BlueShip(100,950,lives,45);
      red =  new RedShip(1820,100,lives,180+45);
      mover = new JButton();
      mover.setOpaque(false);
      mover.setContentAreaFilled(false);
      mover.setBorderPainted(false);   
      mover.setFocusPainted(false);
      add(mover);
      mover.addActionListener(new Changer()); 
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
      nice = new NiceBlock(array[0]*400+450,array1[0]*125+40);
      nice2 = new NiceBlock(array[1]*400+450,array1[1]*125+40);
      nice3 = new NiceBlock(array[2]*400+450,array1[2]*125+40);
      death = new DeathBlock(array[3]*400+450,array1[3]*125+40);
      death2 = new DeathBlock(array[4]*400+450,array1[4]*125+40);
      death3 = new DeathBlock(array[5]*400+450,array1[5]*125+40);
      
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
              
               if(!blueCollision){
                  blue.accelerate(xVel);
                  blue.setAccel(true);
                  xVel++;
               }
               else xVel = 100;
            }
         }  
         
         else{
            if((xVel <10000) && xVel > 0){
               xVel--;
               blue.accelerate(xVel);
               blue.setAccel(false);
            }
         }  
         
         if(keyPressed.containsKey(40)){
            if((xVelr <10000) && xVelr >= 0){
               if(!redCollision){
                  red.accelerate(xVelr);
                  red.setAccel(true);
                  xVelr++;
               }
               else xVelr = 100;
            }
         }  
         else{
            if((xVelr < 10000) && xVelr >0){
               xVelr--;
               red.accelerate(xVelr);
               red.setAccel(false);
            }
         }  
         
         
         if(keyPressed.containsKey(65)){
            if((thetaVel <10000) && thetaVel >= 0){
               thetaVel++;
               blue.rotate(thetaVel);}
            //blue.collideWidth(blocks);
            //blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         else{
            if((thetaVel <10000) && thetaVel > 1){
               thetaVel-=2;
               blue.rotate(thetaVel);}
            //blue.collideWidth(blocks);
            //blue.move(1920,1080);
            //blue.move(FRAME,FRAME);
         }  
         
         if(keyPressed.containsKey(37)){
            if((thetaVelr < 10000) && thetaVelr >= 0){
               thetaVelr++;
               red.rotate(thetaVelr);}
            //red.move(1920,1080);
            //red.move(FRAME,FRAME);
         }  
         else{
            if((thetaVelr < 10000) && thetaVelr > 1){
               thetaVelr-=2;
               red.rotate(thetaVelr);}
            //red.move(1920,1080);
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
      Clip sound = AudioSystem.getClip();
   
      sound.open(AudioSystem.getAudioInputStream(new File(soundfile)));
      sound.start();
   }
   private class Listener implements ActionListener
   {
      private int collision = 0;
      Key bob = new Key();
      public void actionPerformed(ActionEvent e)
      {
         if(decider == 1)
         {
            myBuffer.drawImage(new ImageIcon("AstroBG1.png").getImage(),0,0,null);
         }
         if(decider == 2)
         {
            myBuffer.drawImage(new ImageIcon("AstroBG2.png").getImage(),0,0,null);
         }
         if(decider == 3)
         {
            myBuffer.drawImage(new ImageIcon("AstroBG3.png").getImage(),0,0,null);
         }
         bob.keyPressed();
         myBuffer.setColor(Color.RED);
         
         red.move(1920,1080);
         redCollision  = red.collideWidth(blocks); 
         red.draw(myBuffer);
         
         blue.move(1920,1080);  
         blueCollision  = blue.collideWidth(blocks); 
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
            temp.collideWidth(blocks);
            switch(bobbo){
               case 0: 
                  break;
               case 1:  red.playBoom(); blue.reset(); 
                  try {playExplosion();} 
                  catch (Exception w) {}
                  break;
               case 2: blue.playBoom(); red.reset();
                  try {playExplosion();} 
                  catch (Exception y) {}
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
         
      //          for(int myX = 1;myX<=1920;myX++){
      //             for(int myY =1; myY<=1080;myY++){
      //                for(int c = 0;c<3;c++){
      //                   double nbx = ((NiceBlock)(blocks[c])).getX();
      //                   double nby = ((NiceBlock)(blocks[c])).getY();
      //                   double nbs = ((NiceBlock)(blocks[c])).getSize();
      //                   int bottomEdge = 1080;
      //                   int rightEdge = 1920;
      //                   int offset = 125/8;
      //                   if(
      //                   myX <= (nbx+offset-50)
      //                   && myX >= (nbx-nbs-offset-50)
      //                   && myY >= (nby-offset)
      //                   && myY <= (nby+nbs+offset))
      //                   {
      //                      myBuffer.setColor(Color.RED);
      //                      myBuffer.fillRect(myX,myY,1,1);
      //                   
      //                   }
      //                }
      //                
      //                for(int c = 3;c<6;c++){
      //                   double nbx = ((DeathBlock)(blocks[c])).getX();
      //                   double nby = ((DeathBlock)(blocks[c])).getY();
      //                   double nbs = ((DeathBlock)(blocks[c])).getSize();
      //                   int bottomEdge = 1080;
      //                   int rightEdge = 1920;
      //                   int offset = 0;
      //                   if(
      //                    myX <= (nbx+offset-50)
      //                   && myX >= (nbx-nbs-offset-50)
      //                   && myY >= (nby-offset)
      //                   && myY <= (nby+nbs+offset))
      //                   {
      //                      myBuffer.setColor(Color.RED);
      //                      myBuffer.fillRect(myX,myY,1,1);
      //                   
      //                   }
      //                }
      //                
      //             }
      //          }
      //          
      //          nice.draw(myBuffer,1920,1080);
      //          nice2.draw(myBuffer,1920,1080);
      //          nice3.draw(myBuffer,1920,1080);
//          death.draw(myBuffer,1920,1080);
//          death2.draw(myBuffer,1920,1080);
//          death3.draw(myBuffer,1920,1080);
         
         myBuffer.setColor(Color.WHITE);
         myBuffer.setFont(new Font("Courier New",Font.BOLD,25));
         myBuffer.drawString(redname + " has: "+red.getLives(), 1600,50); 
         myBuffer.drawString(bluename + " has: "+blue.getLives(), 50,50);
         if(red.getLives()<=0||blue.getLives()<=0)
            mover.doClick();
         else
            repaint();
      }
   }
   private class Changer implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try{
            read();
         } catch(Exception f) {
            System.out.println("hilarious");
         }
         if(red.getLives() <= 0 || blue.getLives() <= 0)
         {
            /*if(OptionButton.adsonoff == 1)
            {*/
               if(gointopanel == 0)
               {
                  red.setLives(1);
                  blue.setLives(1);
                  prevpanel = AstroDriver.frame.getContentPane();
                  prevpanel.removeAll();
               /*  AstroDriver.frame.setContentPane(new AdsPanel());
               AstroDriver.frame.repaint();
               AstroDriver.frame.setVisible(true);*/
                  JPanel newpanel = new AdsPanel();
                  prevpanel.add(newpanel);
                  AstroDriver.frame.repaint();
                  AstroDriver.frame.setVisible(true);
                  t.stop();
                  gointopanel = 1;
                  System.gc();
               }
            //}
            /*else {   
               red.setLives(1);
               blue.setLives(1);
               prevpanel = AstroDriver.frame.getContentPane();
               prevpanel.removeAll();
               JPanel newpanel = new WinnerPanel();
               prevpanel.add(newpanel);
               AstroDriver.frame.repaint();
               AstroDriver.frame.setVisible(true);
               System.gc();
            }*/
         }  
      }
      public void read() throws Exception
      {
         PrintStream outfile = new PrintStream( new FileOutputStream( "winner.txt" ) );
         if(red.getLives() <= 0)
            outfile.println(bluename);
         else if(blue.getLives() <= 0)
            outfile.println(redname);
      }
   }
   public void playExplosion() throws Exception
   {
      Clip effect = AudioSystem.getClip(); 
      effect.open(AudioSystem.getAudioInputStream(new File("explosion.wav")));
      effect.start();
   }

}