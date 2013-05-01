/* This program prompts the user for their first and last name as well as his or her mother's maiden name, the city 
 * in which he or she was born, and the make of the first car he or she drove. It then generates and outputs their
 * Star Wars first and last name as well as his or her Star Wars planet.
 */

import java.util.Scanner;
import static java.lang.System.out;

public class StarWarsName {
  private static final Scanner INPUT = new Scanner(System.in);
  
  public static void main(String args[]) {
    out.println("Lab 4 written by Devin Tuchsen");
    out.println();
    out.println("Star Wars Name Generator");
    String firstName = promptString("Enter your first name: ");
    String lastName = promptString("Enter your last name: ");
    String maiden = promptString("Enter your mother's maiden name: "); 
    String city = promptString("Enter the city in which you were born: ");
    String car = promptString("Enter the make of the first car you drove: ");
    while(firstName.length() < 3)
      firstName += firstName;
    while(lastName.length() < 2)
      lastName += lastName;
    while(maiden.length() < 2)
      maiden += maiden;
    while(city.length() < 3)
      city += city;
    String swFirstName = (firstName.substring(0,3) + lastName.substring(0,2)).toUpperCase();
    String swLastName = (maiden.substring(0,2) + city.substring(0,3)).toUpperCase();
    String swPlanet = (lastName.substring(lastName.length() - 2, lastName.length()) + car).toUpperCase();
    out.println("You are " + swFirstName + " " + swLastName + " of " + swPlanet);
  }
  
  //This method prompts the user with a given prompt and returns his or her input (String).
  private static String promptString(String prompt) {
    out.print(prompt);
    return INPUT.nextLine().trim();
  }
}