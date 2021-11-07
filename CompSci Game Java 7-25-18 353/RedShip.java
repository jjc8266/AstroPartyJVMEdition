import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
public class RedShip extends Ship
{
   private double myX, myY, dX, dY, orientation, curaccel, curdeccel, dtheta;
   private int lives,check,lol;
   private boolean accel;
   private boolean boom,tick = false;
   private long sTime = System.currentTimeMillis();
   public int livesTemp;
   public RedShip()
   {
      //initialize to default, whatever default should be
   }
   //one to five arg constructors, used to regenerate from file.
   public RedShip(double x, double y)
   {
      myX = x;
      myY = y;
   }
   public RedShip(double x, double y, int life)
   {
      myX = x;
      myY = y;
      lives = life;
   }
   public RedShip(double x, double y, int life, double Orientation)
   {
      myX = x;
      myY = y;
      lives = livesTemp = life;
      orientation = Orientation;
   }
   public double getX()
   {
      return myX;
   }
   public double getY()
   {
      return myY;
   }
   public double getOrient()
   {
      return orientation;
   }
   public int getLives()
   {
      return lives;
   }
   public void setX(double x)
   {
      myX = x;
   }
   public void setY(double y)
   {
      myY = y;
   }
   public void setLives(int life)
   {
      lives = life;
   }
   public void setAccel(boolean b)
   {
      accel = b;
   }
   public void setOrient(double o)
   {
      orientation = o;
   }
   public void move()
   {
      myX = myX + dX;
      myY = myY + dX;
   }
   public void rotate(long xTime)
   {
      dtheta = -1*((-1/(0.5+Math.pow(Math.E,((7*xTime)/1000.0)-6.7)))+1.995)*450;
      if(dtheta>-0.01)
         dtheta = 0;
      //System.out.print("dTheta: "+dtheta);
   
   }
   public void accelerate(long xTime)
   {
      double velocity = ((-1/(0.5+Math.pow(Math.E,((7*xTime)/1000.0)-6.7)))+1.995)*350;
      if( velocity<0.1)
         velocity = 0;
      dX = -1*velocity * Math.cos(Math.toRadians(orientation-90+ 180));
      dY = -1*velocity * Math.sin(Math.toRadians(orientation-90+ 180));
      //System.out.println(" Velocity: "+velocity+" dX: "+dX+" dY: " +dY);
   }

   public void shoot()
   {
      //Jacob's physics
   }
   public boolean collideWidth(Map[] aaa)
   {
      for(int c = 0;c<aaa.length/2;c++){
         double nbx = ((NiceBlock)(aaa[c])).getX();
         double nby = ((NiceBlock)(aaa[c])).getY();
         double nbs = ((NiceBlock)(aaa[c])).getSize();
         int bottomEdge = 1080;
         int rightEdge = 1920;
         int offset = 125/8;
         if(
                  myX <= (nbx+offset-50)
                  && myX >= (nbx-nbs-offset-50)
                  && myY >= (nby-offset)
                  && myY <= (nby+nbs+offset))
         {
           // System.out.println("Collided");
            
            if(myX <= (nbx+nbs+offset)){
               setX(myX-(dX*1));
               //orientation +=180;
               //dX = 0;
               //dY = 0;
                        //setX(nbx+nbs+1);
                        //break;
            }
                  
            else if(myX >= (nbx-nbs-offset))
            {
               setX(myX-(dX*1));
               //orientation +=180;
               //dX = 0;
               //dY = 0;                       
                        //setX(nbx-nbs-1);
                        //break;
            }
         
            if(myY >= (nbx-nbs-offset))  //hit right edge
            {
               setY(myY-(dY*1)); 
               //orientation +=180;
               //dX = 0;
               //dY = 0;
                        //setY(nbx-nbs-1); 
                        //break;
            }
                  
            else if(myY<=(nby+nbs+offset))
            {
               setY(myY-(dY*1));
               //orientation +=180;
               //dX = 0;
               //dY = 0;
                        //setY(nby+nbs+1);
                        //break;
            }
            return true;
         }   
         
      
      
      }
      
      for(int c = 3;c<aaa.length;c++){
         double nbx = ((DeathBlock)(aaa[c])).getX();
         double nby = ((DeathBlock)(aaa[c])).getY();
         double nbs = ((DeathBlock)(aaa[c])).getSize();
         int bottomEdge = 1080;
         int rightEdge = 1920;
         int offset = 0;
         if(
                  myX <= (nbx+offset-50)
                  && myX >= (nbx-nbs-offset-50)
                  && myY >= (nby-offset)
                  && myY <= (nby+nbs+offset))
         {
            // System.out.println("Collided");
            
            if(myX <= (nbx+nbs+offset)){
               setX(myX-(dX*1));
               //orientation +=180;
               //dX = 0;
               //dY = 0;
                        //setX(nbx+nbs+1);
                        //break;
            }
                  
            else if(myX >= (nbx-nbs-offset))
            {
               setX(myX-(dX*1));
               //orientation +=180;
               //dX = 0;
               //dY = 0;                       
                        //setX(nbx-nbs-1);
                        //break;
            }
            
            if(myY >= (nbx-nbs-offset))  //hit right edge
            {
               setY(myY-(dY*1)); 
               //orientation +=180;
               //dX = 0;
               //dY = 0;
                        //setY(nbx-nbs-1); 
                        //break;
            }
                  
            else if(myY<=(nby+nbs+offset))
            {
               setY(myY-(dY*1));
               //orientation +=180;
               //dX = 0;
               //dY = 0;
                        //setY(nby+nbs+1);
                        //break;
            }
            reset();
            //lives --;
            playBoom();
            return true;
         }      
         
      }   
      return false;
   }
   
   public void reset(){
   
      myX = 1820;
      myY = 100;
      orientation = 225;
      dX=0;
      dY=0;
      GamePanel.xVelr = 0;
   
      
   }
   
   public void playBoom(){
      if(!tick){
         boom = true;
         tick = true;
         livesTemp = lives-1;
      }
   }
   public void explode()
   {
      //again, Jacob's physics
   }
   public void move(double rightEdge, double bottomEdge)
   {
      setX(getX()+ dX);    
      setY(getY()+ dY);       
      orientation += dtheta;
      if(orientation <-360){
         orientation = 0-(orientation%360);
      }
      
      //System.out.println(orientation);      
        
      if(getX() >= rightEdge-125/2)  //hit right edge
      {
         setX(125/2);
         dX = 0;
         dY = 0;
      }
         
      else if(getX() <= 125/2)  //hit left edge
      {
         setX(1920-125/2);
         dX = 0;
         dY = 0;
      }
      
      if(getY() >= bottomEdge-125/2)  //hit bottom edge
      {
         setY(+125/2); 
         dX = 0;
         dY = 0;
      }
      
      else if(getY() <= 125/2)//top
      {
         setY(1080-125/2);
         dX = 0;
         dY = 0;
      }
         
   }

   public void draw(Graphics myBuffer)
   {
      ImageIcon blueship; 
      ImageIcon thrusters = new ImageIcon("AstroFlames.gif");
      blueship = new ImageIcon("RS1.PNG");
      boolean resetter = false;
      
      if(boom&&tick){
       
         boom = false;
         sTime = System.currentTimeMillis();
      }
      if(!(System.currentTimeMillis()-sTime>500)){        
         blueship= new ImageIcon("AstroBreakingRed.gif");     
         lives = livesTemp;             
      }
      
      else if(tick && !boom) {resetter  = true; tick = false;}
      if(resetter){      
         reset();
         resetter = false;
      }
      Graphics2D g2d = (Graphics2D) myBuffer;
      AffineTransform backup = g2d.getTransform();
      AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(orientation), getX(), getY());
      g2d.setTransform(a);
      
      if(accel == true)
      {
         g2d.drawImage(thrusters.getImage(), (int)(getX() - 57),(int)(getY()+50), null);
      }
      g2d.drawImage(blueship.getImage(), (int)(getX() - 125/2),(int)(getY()-125/2), null);
    //Reset our graphics object so we can draw with it again.
      g2d.setTransform(backup);
      //myBuffer2d.drawImage(op.filter(redship,null),(int)(getX() - 125),(int)(getY() - 125),/*(int)getDiameter(),(int)getDiameter(),*/null);
      //myBuffer2d.rotate(Math.toRadians(dtheta),myX,myY);
      //myBuffer.drawImage(redship.getImage(),(int)(getX() - 125),(int)(getY() - 125),/*(int)getDiameter(),(int)getDiameter(),*/null);   public String toString()
   
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         check = 1;
      }
   }
}