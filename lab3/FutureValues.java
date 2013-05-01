/* This program performs two tasks. First, it prompts the user for the present value and interest rate of an account gaining
 * compound interest, as well as the number of years that the interest will accrue. It then outputs the final value of the
 * account to the console. Second, it prompts the user for the monthly payment, interest rate, and number of years on an
 * annuity. It then outputs the final value of the annuity to the console.
 */

import static java.lang.System.out;

public class FutureValues {
  public static void main(String args[]) {
    java.text.DecimalFormat money = new java.text.DecimalFormat("$,##0.00");
    
    out.println("Lab 3 written by Devin Tuchsen");
    out.println();
    
    out.println("Enter values to calculate compound interest:");
    double pv = promptDouble("Present account value (dollars): ");
    double ir = promptDouble("Interest rate (% percentage): ");
    double y = promptDouble("Number of years: ");
    double compInterest = compInterest(pv, ir, y);
    out.println("Future value of the account: " + money.format(compInterest));
    out.println();
    
    out.println("Enter values to calculate the future value of an annuity:");
    double yp = promptDouble("Yearly payment (dollars): ");
    ir = promptDouble("Interest rate (% percentage): ");
    y = promptDouble("Number of years: ");
    double annuity = annuity(yp, ir, y);
    out.println("Future value of the annuity: " + money.format(annuity));
  }
  
  //This method takes three arguments and uses them to return the final value of an account gaining compound interest.
  private static double compInterest(double presentValue, double iRate, double years) {
    return presentValue * Math.pow((1 + iRate/100),years);
  }
  
  //This method takes three arguments and uses them to return the final value of an annuity.
  private static double annuity(double payment, double iRate, double years){
    return payment * ((Math.pow(1+(iRate/100),years)-1) / (iRate/100));
  }
  
  //This method displays a prompt, then accepts one double value inputted by the user.
  private static double promptDouble(String prompt) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    out.print(prompt);
    return input.nextDouble();
  }
}