/* This program demonstrates the Sieve of Eratosthenes, an algorithm for finding prime numbers. It first asks the
 * user for a number n, and the algorithm will find all prime numbers from 1 to n. An animation is presented to show
 * the algorithm at work.
 */
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Sieve {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    
    System.out.printf("Lab 9 Written by Devin Tuchsen%n%n");
    
    //Gain user input
    int n = -1;
    boolean cont = true;
    while(cont) {
      System.out.print("Please enter a value for n: ");
      try {
        n = input.nextInt();
        if(n < 10)
          throw new Exception();
        cont = false;
      } catch (Exception e) {
        System.err.println("ERROR: Invalid input.");
        input = new Scanner(System.in);
      }
    }
    
    //Initialize the panel
    int size = (int) Math.ceil(Math.sqrt(n));
    DrawingPanel panel = new DrawingPanel(60 * size, 60 * ((n + (size - 1)) / size));
    
    //Fill the panel with numbers
    for(int p = 1; p <= n; p++)
      drawNumber(p, n, panel);
    
    //Initialize variables
    boolean[] primes = new boolean[n+1];
    int lastPrime = -1;
    primes[0] = primes[1] = true;
    
    //Start marking numbers
    flashNumber(1, n, panel, Color.RED);
    System.out.print("Primes: ");
    for (int p = 2; p * p <= n; p++)
      if(!primes[p]) {
      int m = p + p;
      flashNumber(p, n, panel, Color.GREEN);
      System.out.print(p + " ");
      lastPrime = p;
      while(m <= n) {
        if(!primes[m]) {
          primes[m] = true;
          flashNumber(m, n, panel, Color.RED);
        }
        m += p;
      }
    }
    
    //Mark and print the rest of the primes
    for(int p = lastPrime + 1; p <= n; p++)
      if(!primes[p]) {
      flashNumber(p, n, panel, Color.GREEN);
      System.out.print(p + " ");
    }
    System.out.println();
  }
  
  // flash the number p, which will end in the given color
  // n is the maximum value of p over all calls to flashNumber
  private static void flashNumber(int p, int n, DrawingPanel panel, Color color) {
    if (p < 1) {
      throw new IllegalArgumentException(p + " is not positive");
    } else if (p > n) {
      throw new IllegalArgumentException(p + " is larger than " + n);
    }
    Graphics g = panel.getGraphics();
    g.setColor(Color.WHITE);
    drawNumber(p, n, panel);
    panel.sleep(100);
    g.setColor(Color.BLACK);
    drawNumber(p, n, panel);
    panel.sleep(100);
    g.setColor(color);
    drawNumber(p, n, panel);
    panel.sleep(100);
  }
  
  // draws the number p at a particular location on the panel
  // n is the maximum value of p over all calls to drawNumber
  private static void drawNumber(int p, int n, DrawingPanel panel) {
    if (p < 1) {
      throw new IllegalArgumentException(p + " is not positive");
    } else if (p > n) {
      throw new IllegalArgumentException(p + " is larger than " + n);
    }
    Graphics g = panel.getGraphics();
    Font font = new Font("SansSerif", Font.BOLD, 24);
    g.setFont(font);
    int size = (int) Math.ceil(Math.sqrt(n));
    int xPosition = 5 + 60 * ((p - 1) % size);
    int yPosition = 30 + 60 * ((p - 1) / size);
    String s = "" + p;
    g.drawString(s, xPosition, yPosition);
  }
}