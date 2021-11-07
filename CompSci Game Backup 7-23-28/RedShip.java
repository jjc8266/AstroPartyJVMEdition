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
import java.awt.geom.AffineTransform;
public class RedShip
{
   private double myX, myY, dX, dY, lives, orientation, curaccel, curdeccel, dtheta;
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
   public RedShip(double x, double y, double life)
   {
      myX = x;
      myY = y;
      lives = life;
   }
   public RedShip(double x, double y, double life, double Orientation)
   {
      myX = x;
      myY = y;
      lives = life;
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
   public double getLives()
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
   public void setLives(double life)
   {
      lives = life;
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
      dtheta = -1*((-1/(0.5+Math.pow(Math.E,((4*xTime)/1000.0)-6.7)))+1.995)*250;
      if(dtheta>-0.01)
         dtheta = 0;
      //System.out.print("dTheta: "+dtheta);
   
   }
   public void accelerate(long xTime)
   {
      double velocity = ((-1/(0.5+Math.pow(Math.E,((4*xTime)/1000.0)-6.7)))+1.995)*150;
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
   public void collideWidth()
   {
      //Jacob's physics
   }
   public void move(double rightEdge, double bottomEdge)
   {
      setX(getX()+ dX);    
      setY(getY()+ dY);             
      orientation+=dtheta;
      if(orientation <-360)
      {
         orientation = 0 - (orientation%360);
      }
   //       if(getX() >= rightEdge-125/2)  //hit right edge
   //       {
   //          setX(rightEdge-125/2);
   //       }
   //          
   //       if(getX() <= 125/2)  //hit right edge
   //       {
   //          setX(125/2);
   //       }
   //       
   //       if(getY() >= bottomEdge-125/2)  //hit right edge
   //       {
   //          setY(bottomEdge-125/2); 
   //       }
   //       
   //       if(getY() <= 125/2)
   //       {
   //          setY(125/2);
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
   
        /* more code goes here  */
      
   
   }

   public void explode()
   {
      //again, Jacob's physics
   }
   public void draw(Graphics myBuffer)
   {
      ImageIcon redship = new ImageIcon("RS1.PNG");
      Graphics2D g2d = (Graphics2D) myBuffer;
      //myBuffer2d.translate(myX,myY);
      // double rotationRequired = Math.toRadians(dtheta);
   //       AffineTransform transform = AffineTransform.getRotateInstance(rotationRequired,getX(),getY());
   //       AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
      AffineTransform backup = g2d.getTransform();
    //rx is the x coordinate for rotation, ry is the y coordinate for rotation, and angle
    //is the angle to rotate the image. If you want to rotate around the center of an image,
    //use the image's center x and y coordinates for rx and ry.
      AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(orientation), getX(), getY());
    //Set our Graphics2D object to the transform
      g2d.setTransform(a);
    //Draw our image like normal
      g2d.drawImage(redship.getImage(), (int)(getX() - 125/2),(int)(getY()-125/2), null);
    //Reset our graphics object so we can draw with it again.
      g2d.setTransform(backup);
      //myBuffer2d.drawImage(op.filter(redship,null),(int)(getX() - 125),(int)(getY() - 125),/*(int)getDiameter(),(int)getDiameter(),*/null);
      //myBuffer2d.rotate(Math.toRadians(dtheta),myX,myY);
      //myBuffer.drawImage(redship.getImage(),(int)(getX() - 125),(int)(getY() - 125),/*(int)getDiameter(),(int)getDiameter(),*/null);
   }
   public String toString()
   {
      //used to write to file, decide on format
      return null;
   }
}