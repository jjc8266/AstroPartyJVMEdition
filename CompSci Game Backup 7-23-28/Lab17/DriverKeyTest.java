

   import javax.swing.JFrame;
    public class DriverKeyTest
   {
       public static void main(String[] args)
      { 
         JFrame frame = new JFrame("KeyTest");
         frame.setSize(400, 400);    
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         hashMapKeyTest p = new hashMapKeyTest();
         frame.setContentPane(p);
         p.requestFocus();
         frame.setVisible(true);
         hashMapKeyTest.doTheThing();
         
      }
   }
