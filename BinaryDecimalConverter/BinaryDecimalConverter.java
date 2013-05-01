import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class BinaryDecimalConverter {
  //These must be global or final in order for the Actions to handle them
  private static JFrame frame = new JFrame("Binary and Decimal Converter");
  private static JTextField textField1 = new JTextField("Enter Binary Number", 45);
  private static JTextField textField2 = new JTextField("Enter Decimal Number", 45);
  
  public static void main(String args[]) {
    
    //Binary to decimal action; performed when the user hits return or clicks "Convert"
    Action action1 = new AbstractAction("Convert") {
      public void actionPerformed(ActionEvent evt) {
        String str = new String();
        long dec = 0;
        
        //Get rid of anything that is not a '1' or a '0'
        for(int i = 0; i < textField1.getText().length(); i++) {
          if(textField1.getText().charAt(i) == '0' || textField1.getText().charAt(i) == '1')
            str += textField1.getText().charAt(i);
        }  
        textField1.setText(str);
        
        //Perform the conversion
        boolean cont = true;
        for(int x = 0; x < str.length(); x++) {
          if(str.charAt(x) == '1') {
            if(cont)
              cont = false;
            dec += Math.pow(2,str.length() - 1 -x);
          }
        }
        
        //Display the results
        if(str.length() > 0) {
          JLabel label = new JLabel("Decimal: " + dec);
          try {frame.getContentPane().remove(1);}catch(Exception e){};
          frame.getContentPane().add(label, "South");
          frame.pack();
        }
      }
    };
    
    //Decimal to Binary action; performed when the user hits return or clicks "Convert"
    Action action2 = new AbstractAction("Convert") {
      public void actionPerformed(ActionEvent evt) {
        String str = new String();
        
        //Get rid of any non digit or '-' characters
        for(int i = 0; i < textField2.getText().length(); i++)
          if(Character.isDigit(textField2.getText().charAt(i)) || textField2.getText().charAt(i) == '-' )
          str += textField2.getText().charAt(i);
        textField2.setText(str);
        
        //Perform the conversion (toBinaryString makes it easy :D)
        try {
          if(str.length() > 0) {
            JLabel label = new JLabel("Binary: " + Long.toBinaryString(Long.parseLong(str)));
            try {frame.getContentPane().remove(1);}catch(Exception e){};
            frame.getContentPane().add(label, "South");
            frame.pack();
          }
        }
        //Display an error if the user enters a value that is too large
        catch (Exception e) {
          JLabel label = new JLabel("ERROR: Value too large!");
          try {frame.getContentPane().remove(1);}catch(Exception exc){};
          frame.getContentPane().add(label, "South");
          frame.pack();
        }
      }
    };
    
    //Prevent the user from entering in a binary number longer than 63 characters
    KeyAdapter listener1 = new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        if(textField1.getText().length() > 63)
          textField1.setText(textField1.getText().substring(0,63));
      }
    };
    
    //Prevent the user from entering in a decimal number longer than 20 characters
    KeyAdapter listener2 = new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        if(textField2.getText().length() > 20)
          textField2.setText(textField2.getText().substring(0,20));
      }
    };
   
    //Declare our GUI objects
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel binToDec = new JPanel();
    JPanel decToBin = new JPanel();
    JButton button1 = new JButton(action1);
    JButton button2 = new JButton(action2);
    
    //Set up the binary to decimal text field
    textField1.setFocusable(true);
    textField1.setAction(action1);
    textField1.addKeyListener(listener1);
   
    //Set up the decimal to binary text field
    textField2.setFocusable(true);
    textField2.setAction(action2);
    textField2.addKeyListener(listener2);
    
    //Add the text field and button for tab 1
    binToDec.add(textField1);
    binToDec.add(button1);
    
    //Add the text field and button for tab 2
    decToBin.add(textField2);
    decToBin.add(button2);
    
    //Add our tabs
    tabbedPane.addTab("Binary to Decimal", binToDec);
    tabbedPane.addTab("Decimal to Binary", decToBin);
    
    //Set up and display the window (JFrame)
    frame.getContentPane().add(tabbedPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
  }
}