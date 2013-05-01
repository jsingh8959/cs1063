/* This program first prompts the user to enter the range for a table that converts kilograms to pounds, then prints that table.
 * It then prints a table that converts feet and inches to meters, ranging from 0 feet to 9 feet, 11 inches.
 */
import static java.lang.System.out;
import java.util.Scanner;

public class Tables {
  public static void main(String args[]) {
    out.println("Project 1 Written by Devin Tuchsen");
    out.println();
    
    kgToLb();
    ftInToMeters();
  }
  
  
  /*This method prompts the user to enter the range for a table that converts kilograms to pounds, then prints that table to
   * the console.
   */
  private static void kgToLb() {
    Scanner input = new Scanner(System.in);
    int start;
    int end;
    
    out.println("Please enter the range of the conversion table to be printed (in kilograms):");
    out.print("Start: ");
    start = input.nextInt();
    out.print("End: ");
    end = input.nextInt();
    
    out.println("Conversion from Kilograms to Pounds");
    out.println("===================================");
    out.println();
    out.println(" Kilograms | Pounds");
    
    for(int x = start; x <= end; x++) {
      out.printf("%10d | %f%n", x, x/0.45359237);
    }
    out.println();
  }
  
  /* This method prints a table to the console that converts feet and inches to meters, ranging from 0 feet to 9 feet, 11 inches.
   */
  private static void ftInToMeters() {
    double feet;
    out.println("Conversion from Feet and Inches to Meters");
    out.println("=========================================");
    out.println();
    out.println("\tInches");
    out.println("Feet\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11");
    
    for(int f = 0; f <= 9; f++) {
      out.print(f);
      for(int i = 0; i <= 11; i++) {
        feet = f + (double) i/12;
        out.printf("\t%.4f", feet * 0.3048);
      }
      out.println();
    }
  }
}