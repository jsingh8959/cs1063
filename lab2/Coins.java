/* This program prompts the user to input the number of quarters, dimes, nickels, and pennies he or she has,
 * adds them together, and prints the results to the console. It then prompts the user for a value in
 * cents, splits that into quarters, dimes, nickels, and pennies, and outputs that to the console.
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class Coins
{
  public static Scanner input = new Scanner(System.in);
  public static final DecimalFormat money = new DecimalFormat("$###,###,##0.00");
  public static final DecimalFormat value = new DecimalFormat("###,###,###,###");
  
  public static void main(String args[])
  { 
    System.out.println("Lab 2 written by Devin Tuchsen\n");
    addCoins();
    splitChange();
  }
  
  /* This method prompts the user for the number of quarters, dimes, nickels, and pennies and prints the
   * total number of coins and their value in dollars to the console.
   */
  private static void addCoins()
  {
    boolean cont = true;
    int quarters;
    int dimes;
    int nickels;
    int pennies;
    int totalCoins;
    double totalValue;
    
    while(cont)
    {
      try
      {
        System.out.println("Enter the number of…");
        
        System.out.print("Quarters: ");
        quarters = input.nextInt();
        if(quarters < 0)
          throw new Exception();
        totalCoins = quarters;
        totalValue = 0.25 * quarters;
        
        System.out.print("Dimes: ");
        dimes = input.nextInt();
        if(dimes < 0)
          throw new Exception();
        totalCoins += dimes;
        totalValue += 0.1 * dimes;
        
        System.out.print("Nickels: ");
        nickels = input.nextInt();
        if(nickels < 0)
          throw new Exception();
        totalCoins += nickels;
        totalValue += 0.05 * nickels;
        
        System.out.print("Pennies: ");
        pennies = input.nextInt();
        if(pennies < 0)
          throw new Exception();
        totalCoins += pennies;
        totalValue += 0.01 * pennies;
        
        System.out.println("Total Coins: " + value.format(totalCoins));
        System.out.println("Value: " + money.format(totalValue) + "\n");
        cont = false;
      } catch(Exception e)
      {
        System.out.println("ERROR: Input must be an integer value not less than zero.\n");
        input = new Scanner(System.in);
      }
    }
  }
  
  /* This method prompts the user for the number of cents and prints the number of quarters, dimes, nickels,
   * and pennies to add up to that number.
   */
  private static void splitChange()
  {
    boolean cont = true;
    int cents;
    int quarters;
    int dimes;
    int nickels;
    
    while(cont)
    {
      try
      {
        System.out.print("Enter the number of cents: $0.");
        cents = input.nextInt();
        if(cents > 99 || cents < 0)
          throw new Exception();
        
        quarters = cents / 25;
        cents %= 25;
        dimes = cents / 10;
        cents %= 10;
        nickels = cents / 5;
        cents %= 5;
        
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + cents);
        cont = false;
      } catch(Exception e)
      {
        System.out.println("ERROR: Input must be an integer value not less than 0 or more than 99.\n");
        input = new Scanner(System.in);
      }
    }
  }
}