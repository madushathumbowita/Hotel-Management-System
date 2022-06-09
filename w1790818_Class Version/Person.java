
// Madusha Thumbowita
// w1790818 , 20191207

//package arrays;

import java.util.Scanner;

public class Person {
    /* Method to add customers */
    public static void person() {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter surname for room " + Main.roomNum + " :");
                    Main.roomsurname = input.next();

                    System.out.println("Credit card number : " );
                    Main.cardnum = input.next();

                    System.out.println(" Enter the number of guests for room " + Main.roomNum + " :");
                    Main.guestnum = input.nextInt();
                    String guestnum2 = java.lang.String.valueOf(Main.guestnum);

                    Main.hotel[Main.roomNum][1]= Main.roomsurname;
                    Main.hotel[Main.roomNum][2]= Main.cardnum;
                    Main.hotel[Main.roomNum][3]= guestnum2;

    }

}
