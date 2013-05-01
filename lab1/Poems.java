//Outputs two classic poems, domonstrating how two methods can help avoid redundancy.
public class Poems
{
  //Prints out the MAry peom and the Old Man poem.
  public static void main(String args[])
  {
    System.out.println("Lab 1 written by Devin Tuchsen.\n");
    printMary();
    printOldMan();
  }
  
  //Prints the title and contents of the Mary Had a Little Lamb poem.
  private static void printMary()
  {
    System.out.println("Mary Had a Little Lamb");
    System.out.println("======================");
    printLine1();
    printLine2();
    printLine1();
    printLine4();
  }
  
  //Prints the title and contents of the This Old Man poem.
  private static void printOldMan()
  {
    System.out.println("This Old Man");
    System.out.println("============");
    printVerse1();
    printVerse2();
    printVerse3();
  }
  
  //Prints to the console the first line of the Mary poem.
  private static void printLine1()
  {
    System.out.println("Mary had a little lamb,");
  }
  
  //Prints to the console the second line of the Mary poem.
  private static void printLine2()
  {
    System.out.println("Little lamb, little lamb,");
  }
  
  //Prints to the console the fourth line of the Mary poem.
  private static void printLine4()
  {
    System.out.println("Its fleece was white as snow\n");
  }
  
  //Prints the first verse of the Old Man poem.
  private static void printVerse1()
  {
    printLine5("one");
    printLine6("thumb");
    printRefrain();
  }
  
  //Prints the second verse of the Old Man poem.
  private static void printVerse2()
  {
    printLine5("two");
    printLine6("shoe");
    printRefrain();
  }
  
  //Prints the third verse of the Old Man poem.
  private static void printVerse3()
  {
    printLine5("three");
    printLine6("knee");
    printRefrain();
  }
  
  //Prints to the console the first line of each verse in the Old Man poem.
  private static void printLine5(String x)
  {
    System.out.println("This old man, he played " + x);
  }
  
  //Prints to the console the second line of each verse in the Old Man poem.
  private static void printLine6(String x)
  {
    System.out.println("He played knick-knack on my " + x);
  }
  
  //Prints to the console the refain of the Old Man poem.
  private static void printRefrain()
  {
    System.out.println("With a knick-knack patty-whack, give a dog a bone");
    System.out.println("This old man came rolling home\n");
  }
}