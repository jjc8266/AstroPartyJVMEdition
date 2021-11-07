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
public class PewPew
{
   private double myX, myY, dX, dY, orientation, curaccel, curdeccel,decay;
   private boolean collision = false;
   public PewPew()
   {
      //initialize to default, whatever default should be
   }
   //one to five arg constructors, used to regenerate from file.
   public PewPew(double x, double y)
   {
      myX = x;
      myY = y;
   }

   public PewPew(double x, double y, double Orientation)
   {
      myX = x+(Math.cos(Math.toRadians(Orientation+90+180))*200);
      myY = y+(Math.sin(Math.toRadians(Orientation+90+180))*200);
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
   
   public double getDecay(){
      return decay;
   }

   public void setDecay(double d){
      decay = d;
   }
   public void setX(double x)
   {
      myX = x;
   }
   public void setY(double y)
   {
      myY = y;
   }

   public void setOrient(double o)
   {
      orientation = o;
   }


   public void accelerate()
   {
      int xTime = 1000-(int)(decay);
      double velocity = ((-1/(0.5+Math.pow(Math.E,((10*xTime)/1000.0)-6.7)))+1.995)*10;
      if( velocity<0.1)
         velocity = 0;
      dX = -1*velocity * Math.cos(Math.toRadians(orientation-90+ 180));
      dY = -1*velocity * Math.sin(Math.toRadians(orientation-90+ 180));
      //System.out.println(" Velocity: "+velocity+" dX: "+dX+" dY: " +dY);
   }


   public int collideWidth(RedShip red, BlueShip blue) // 0 = none, 1 = redship, 2 = blue ship
   {
      if((myX<(red.getX()+75) && myX>(red.getX()-75))&&(myY<(red.getY()+75) && myY>(red.getY()-75))){
         collision = true;
         return 1;
      }
      
      if((myX<(blue.getX()+75) && myX>(blue.getX()-75))&&(myY<(blue.getY()+75) && myY>(blue.getY()-75))){
         collision = true;
         return 2;
      }
      
      return 0;
   }
   public boolean explode()
   {
      if(decay == 75 || collision)
         return true;
      decay++;
      return false;
   }
   public void move(double rightEdge, double bottomEdge)
   {
      accelerate();
      setX(getX()+ dX);    
      setY(getY()+ dY);       
      
      
      //System.out.println(orientation);      
        
   //       if(getX() >= rightEdge-10)  //hit right edge
   //       {
   //          setX(rightEdge-10);
   //          collision = true;
   //       }
   //          
   //       if(getX() <= 10)  //hit right edge
   //       {
   //          setX(10);
   //          collision = true;
   //       }
   //       
   //       if(getY() >= bottomEdge-10)  //hit right edge
   //       {
   //          setY(bottomEdge-10);
   //          collision = true; 
   //       }
   //       
   //       if(getY() <= 10)
   //       {
   //          setY(10);
   //          collision = true;
   //       }
   
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
      ImageIcon blueship = new ImageIcon("AstroBullet.PNG");
      Graphics2D g2d = (Graphics2D) myBuffer;
      AffineTransform backup = g2d.getTransform();
      AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(orientation), getX(), getY());
      g2d.setTransform(a);
      g2d.drawImage(blueship.getImage(), (int)(getX() - 10),(int)(getY()-10), null);
      g2d.setTransform(backup);   
   }
}