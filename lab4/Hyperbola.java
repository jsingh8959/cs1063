/* This program draws two parabolas with grid lengths defined by LOWER_GRID_LENGTH and UPPER_GRID_LENGTH inside a
 * DrawingPanel with dimensions defined by PANEL_SIZE.
 */

import java.awt.*;

public class Hyperbola {
  private static final int PANEL_SIZE = 512;
  private static final int LOWER_GRID_LENGTH = 32;
  private static final int UPPER_GRID_LENGTH = 8;
  
  public static void main(String[] args) {
    System.out.println("Lab 4 written by Devin Tuchsen");
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics();
    for(int i = 0; i <= PANEL_SIZE; i+=LOWER_GRID_LENGTH)
      g.drawLine(0, i, i, PANEL_SIZE);
    for(int i = PANEL_SIZE; i >= 0; i-=UPPER_GRID_LENGTH)
      g.drawLine(PANEL_SIZE, i, i, 0);
  }
}