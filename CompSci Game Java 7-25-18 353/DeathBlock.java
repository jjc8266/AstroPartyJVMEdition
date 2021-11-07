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
import java.util.concurrent.TimeUnit;

public class DeathBlock extends Map
{
   private double myX, myY, size;
   public DeathBlock(double x,double y)
   {
      myX = x;
      myY = y;
      size = 200;
   }
   public DeathBlock(double x, double y, double s)
   {
      myX = x;
      myY = y;
      size = s;
   }
   public void function()
   {
   
   }
   public void collision()
   {
      
   }
   public double getX()
   {
      return myX;
   }
   public double getY()
   {
      return myY;
   }
   public double getSize()
   {
      return size;
   }
   public void setX(double x)
   {
      myX = x;
   }
   public void setY(double y)
   {
      myY = y;
   }
   public void setSize(double s)
   {
      size = s;
   }
   public void draw(Graphics myBuffer,int bottom, int right)
   {
      ImageIcon block = new ImageIcon("AstroDeathBlock.PNG");
      /*if(myY+250 > bottom)
         myBuffer.drawImage(block.getImage(),(int)getX(),(int)(getY())-250,null);
      else if(myX+250 > right)  
         myBuffer.drawImage(block.getImage(),(int)(getX())-250,(int)getY(),null);
      else if(myY+250 > bottom && myX+250 > right)
         myBuffer.drawImage(block.getImage(),(int)(getX())-250,(int)(getY())-250,null);
      else
         myBuffer.drawImage(block.getImage(),(int)getX(),(int)getY(),null);*/
         myBuffer.drawImage(block.getImage(),(int)(getX())-250,(int)(getY()),null);
   }
}