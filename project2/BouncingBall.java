/* This program prompts the user for a color and a diameter (pixels) and displays an animated bouncing ball
 * matching those (and other) parameters.
 */

//Import the Scanner and awt bejesus packages
import java.util.Scanner;
import java.awt.*;

public class BouncingBall {
  //Global variables (can be changed to alter program behavior)
  private static final int WIDTH = 500;
  private static final int HEIGHT = 500;
  private static final int START_X = 250;
  private static final int START_Y = 250;
  private static final int DX = 5;
  private static final int DY = 3;
  private static final int DURATION = 10000;
  private static final int PAUSE = 10;
  
  public static void main(String args[]) {
    //Declare our variables
    boolean cont = true;
    int tries = 0;
    String colorStr = new String();
    int size = 0;
    Color color = new Color(0,0,0);
    
    System.out.println("Project 2 written by Devin Tuchsen");
    //Gather input from the user
    while(cont) {
      try {
        colorStr = promptString("Enter a color for the ball (red or blue): ").toLowerCase().trim();
        if(!colorStr.equals("red") && !colorStr.equals("blue"))
          throw new Exception();
        cont = false;
      } catch (Exception e) {
        System.out.println("ERROR: Invalid input.");
        tries++;
        if(tries >= 2) {
          System.out.println("Too many attempts. Exiting.");
          System.exit(1);
        }
      }
    }
    System.out.println("The bouncing ball will be " + colorStr + ".");
    
    cont = true;
    tries = 0;
    while(cont) {
      try {
        size = promptInt("Enter the diameter of the ball (3 to 200): ");
        if(size < 3 || size > 200)
          throw new Exception();
        cont = false;
      } catch (Exception e) {
        System.out.println("ERROR: Invalid input.");
        tries++;
        if(tries >= 2) {
          System.out.println("Too many attempts. Exiting.");
          System.exit(1);
        }
      }
    }
    System.out.println("The size of the ball will be " + size + " pixels in diameter.");
    
    //Create our drawing panel and get its graphics
    DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
    Graphics g = panel.getGraphics();
    
    if(colorStr.equals("red"))
      color = Color.RED;
    else
      color = Color.BLUE;
    
    //Start the main loop!
    bounceLoop(panel, g, color, size, START_X, START_Y, DX, DY);  
  }
  
  //The main loop of the program. This is what actually causes the ball to animate.
  public static void bounceLoop(DrawingPanel panel, Graphics g, Color c, int size, int x, int y, int dx, int dy) {
    //Start things off
    int dir = 0;
    g.setColor(c);
    g.fillOval(x,y,size,size);
    //Keep things going (for DURATION)
    for(int i = DURATION; i > 0; i--){
      switch(dir) {
        case 0:
          moveBall(g, size, x, y, x + dx, y + dy);
          i-=PAUSE;
          panel.sleep(PAUSE);
          x+=dx;
          y+=dy;
          break;
        case 1:
          moveBall(g, size, x, y, x - dx, y + dy);
          i-=PAUSE;
          panel.sleep(PAUSE);
          x-=dx;
          y+=dy;
          break;
        case 2:
          moveBall(g, size, x, y, x - dx, y - dy);
          i-=PAUSE;
          panel.sleep(PAUSE);
          x-=dx;
          y-=dy;
          break;
        case 3:
          moveBall(g, size, x, y, x + dx, y - dy);
          i-=PAUSE;
          panel.sleep(PAUSE);
          x+=dx;
          y-=dy;
          break;
      }
      //Always be watching for the ball to hit a side, and if it does, change its diection (dir) accordingly
      if(x + size >= WIDTH && dir == 0)
        dir = 1;
      if(x + size >= WIDTH && dir == 3)
        dir = 2;
      if(y + size >= HEIGHT && dir == 1)
        dir = 2;
      if(y + size >= HEIGHT && dir == 0)
        dir = 3;
      if(x <= 0 && dir == 2)
        dir = 3;
      if(x <= 0 && dir == 1)
        dir = 0;
      if(y <= 0 && dir == 3)
        dir = 0;
      if(y <= 0 && dir == 2)
        dir = 1;
    }
  }
  
  //This method will move the ball from old position (x0,y0) to new position (x1,y1)
  private static void moveBall(Graphics g, int size, int x0, int y0, int x1, int y1) {
    Color color = g.getColor();
    g.setColor(Color.WHITE);
    g.fillOval(x0,y0,size,size);
    g.setColor(color);
    g.fillOval(x1,y1,size,size);
  }
  
  //Method that prompts the user with "prompt" and returns his or her String input
  private static String promptString(String prompt) {
    Scanner input = new Scanner(System.in);
    System.out.print(prompt);
    return input.nextLine();
  }
  
  //Method that prompts the user with "prompt" and returns his or her int input
  private static int promptInt(String prompt) {
    Scanner input = new Scanner(System.in);
    System.out.print(prompt);
    return input.nextInt();
  }
} 