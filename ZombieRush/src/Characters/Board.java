package Characters;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {

   public static Bullet bullet;

   private Thread loop; // the loop
   private Character character;
   private ArrayList bullets;
   private int tmpAngle, sx, sy, reload, numToShoot, spread, bWidth,
         bHeight;
   private boolean moveForward, canForward, canBackward, moveBackward, left,
         right, fire, special;

   // constructor
   public Board() {
      init();
      addKeyListener(new Controll());
      addMouseListener(new Mouse());
      setFocusable(true);
      setBackground(new Color(0, 0, 0));
      setDoubleBuffered(true);
      setFocusable(true);

   }

   // initialisation
   private void init() 
   {
      character = new Character(400, 300, 0, 50, 30);
      tmpAngle = 0;
      special = fire = left = right = moveForward = moveBackward = false;
      canForward = canBackward = true;
      sx = sy = 2;

      bullet = new Bullet(0, 0, 0, 0, 0);
      bullets = character.getBullets();
      reload = 30;
      numToShoot = 1;
      spread = 0;

      loop = new Thread(this);
      loop.start();
   }

   public void paint(Graphics g) {
      super.paint(g);

      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      AffineTransform old = g2d.getTransform();

      // rotating the hero, rotation point is the middle of the square
      g2d.rotate(character.getA(), character.getX() + character.getW(),
            character.getY() + character.getH() / 2);
      // draw the image
      g2d.drawImage(character.getI(), (int) character.getX(), (int) character.getY(),
            character.getW(), character.getH(), this);
      g2d.setTransform(old);

      // drawing the bullets
      ArrayList bullets = character.getBullets();
      for (int i = 0; i < bullets.size(); i++) {
         Bullet tmpB = (Bullet) bullets.get(i);
                        //playing with bullet colors
         if (i % 2 == 0) {
            g2d.setColor(new Color(150, 130, 100));
         } else {
            g2d.setColor(new Color(60, 20, 120));
         }
         g2d.fillRect((int) tmpB.getX(), (int) tmpB.getY(), tmpB.getW(),
               tmpB.getH());
      }
      // in case you have other things to rotate
      g2d.setTransform(old);

   }

   public void play() {

      // if the hero get off the screen
      // we make it appear from the opposite side of the screen
      if (character.getX() > 800) {
         character.setX(0);
      } else if (character.getX() < -100) {
         character.setX(800);
      }

      if (character.getY() > 600) {
         character.setY(0);
      } else if (character.getY() < -100) {
         character.setY(600);
      }

      // moving bullets
      ArrayList tmpBs = character.getBullets();
      for (int i = 0; i < tmpBs.size(); i++) {
         Bullet tmpB = (Bullet) tmpBs.get(i);

         tmpB.moveForward(3);

         if (tmpB.getX() > Map.WIDTH || tmpB.getX() < 0
               || tmpB.getY() > Map.HEIGHT || tmpB.getY() < 0) {
            tmpBs.remove(i);
         }

      }

      // check if shooting
      if (fire) {
         character.fire(reload, numToShoot, spread);
      }
      if (special) {
         character.fire(5, 3, 2);
      }

      // changing the hero angle
      if (left) {
         tmpAngle -= 1;
      }
      if (right) {
         tmpAngle += 1;
      }

      // setting the hero angle
      character.setA(tmpAngle);

      // this is just to keep the angle between 0 and 360
      if (tmpAngle > 360) {
         tmpAngle = 0;
      } else if (tmpAngle < 0) {
         tmpAngle = 360;

      }
   }

   // game key controll
   // (my keyboard is AZERTY so ignore the multiple key in
   // the if statement
   private class Controll extends KeyAdapter {

      public void keyPressed(KeyEvent e) {

         if (e.getKeyCode() == e.VK_UP || e.getKeyCode() == e.VK_Z
               || e.getKeyCode() == e.VK_W) {
            moveForward = true;

         }
         if (e.getKeyCode() == e.VK_DOWN || e.getKeyCode() == e.VK_S) {
            moveBackward = true;

         }
         if (e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_Q
               || e.getKeyCode() == e.VK_A) {
            left = true;
         }
         if (e.getKeyCode() == e.VK_RIGHT || e.getKeyCode() == e.VK_D) {
            right = true;
         }
         if (e.getKeyCode() == e.VK_SHIFT) {
            fire = true;
         }

      }

      public void keyReleased(KeyEvent e) {

         if (e.getKeyCode() == e.VK_UP || e.getKeyCode() == e.VK_Z
               || e.getKeyCode() == e.VK_W) {
            moveForward = false;
         }
         if (e.getKeyCode() == e.VK_DOWN || e.getKeyCode() == e.VK_S) {
            moveBackward = false;
         }
         if (e.getKeyCode() == e.VK_LEFT || e.getKeyCode() == e.VK_Q
               || e.getKeyCode() == e.VK_A) {

            left = false;
         }
         if (e.getKeyCode() == e.VK_RIGHT || e.getKeyCode() == e.VK_D) {
            right = false;
         }
         if (e.getKeyCode() == e.VK_SHIFT) {
            fire = false;
         }
      }
   }

   // mouse control
   private class Mouse extends MouseAdapter {

      public void mousePressed(MouseEvent e) {
         if (e.getButton() == e.BUTTON1) {
            fire = true;
         }
         if (e.getButton() == e.BUTTON3) {
            special = true;
         }
      }

      public void mouseReleased(MouseEvent e) {
         if (e.getButton() == e.BUTTON1) {
            fire = false;
         }
         if (e.getButton() == e.BUTTON3) {
            special = false;

         }

      }
   }

   // the wors game loop ever
   @Override
   public void run() {

      while (true) {
         repaint();
         play();
         try {
            Thread.sleep(5);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      }

   }

}