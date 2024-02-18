package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */

    public void TopBottom_Borders(int size) {
        // определили конец нашего рисунка на координате size * 2 + 1
        for (int i = 0; i < size * 2 + 2; i++) {
            
            if (i == 0 || i == size * 2 + 1) {
                mOut.print("+");
            } 
            else {
                mOut.print("-");
            }
        }
        mOut.println();
    }

    public void process(int size) {

        // TODO -- add your code here
        
        TopBottom_Borders(size);
        
        int spaces = size - 1;
        int count = 0;
        char znak;
        
        for (int i = 0; i <= size * 2 - 2; i++) {
            if (i % 2 == 1) {
                znak = '-';
            } else {
                znak = '=';
            }
            
            // строим ромб
            if (i == size - 1) {
                System.out.println("|" + "<" + String.valueOf(znak).repeat(i * 2) + ">" + "|");
                spaces++;
            } else if (i < size) {
                System.out.println("|" + " ".repeat(spaces) + "/" + String.valueOf(znak).repeat(i + i) + "\\" + " ".repeat(spaces) + "|");
                spaces--;
                
                // последнее вхождение в данное условие определит число знаков, от которого будем отталкиваться при создании второй части ромба
                count = i;
            } else {
                System.out.println("|" + " ".repeat(spaces) + "\\" + String.valueOf(znak).repeat(count + count) + "/" + " ".repeat(spaces) + "|");
                spaces++;
                count--;
            }
        }
        TopBottom_Borders(size);
    }

}
