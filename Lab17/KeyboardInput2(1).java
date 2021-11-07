import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class KeyboardInput2 {
   private static HashMap<Integer, Boolean> pressed = new HashMap<Integer, Boolean>();
   public static boolean isPressed(int key) {
      synchronized (KeyboardInput2.class) {
         return pressed.get(key);
      }
   }

   public static void allPressed() {
      final Set<Integer> templist = pressed.keySet();
      if (templist.size() > 0) {
         System.out.println("Key(s) logged: ");
      }
      for (int key : templist) {
         System.out.println(KeyEvent.getKeyText(key));
      }
   }

   public static void main(String[] args) {
      KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
         new KeyEventDispatcher() {
         
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
               synchronized (KeyboardInput2.class) {
                  switch (ke.getID()) {
                     case KeyEvent.KEY_PRESSED:
                        pressed.put(ke.getKeyCode(), true);
                        break;
                     case KeyEvent.KEY_RELEASED:
                        pressed.remove(ke.getKeyCode());
                        break;
                  }
                  return false;
               }
            }
         });
         
         KeyboardInput2.allPressed();
   }
}