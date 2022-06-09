
// Madusha Thumbowita
// w1790818 , 20191207

//package arrays;

import java.util.Scanner;

public class Room {
    /* Method to add customers */
    public static void Addcustomer() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number (0-7) or 8 to stop:");
            Main.roomNum = input.nextInt();
            if (Main.roomNum!=8){

                /* if condition to check the rooms that are already occupied */
                if (Main.hotel[Main.roomNum][0].equals("e")) {

                    System.out.println("Enter first name for room " + Main.roomNum + " :");
                    Main.roomName = input.next();
                    Main.hotel[Main.roomNum][0]= Main.roomName;
                    Person.person();


                } else {
                    System.out.println("| Room is occupied |");
                }
                System.out.println();
            }
            else {
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println("| Enter a valid room number |");
            System.out.println();

        }
    }

    /* Method to delete a customer name from a name */
    public static void DeleteRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of the customer you want to delete ? ");
        String Delname = input.next();

        for (int y = 0; (y < Main.hotel.length); y++) {

            for (int z = 0; z <= 4; z++) {

                if (Main.hotel[y][0].equals(Delname)) {
                    Main.hotel[y][0] = "e";
                }
            }
        }
    }
    /* Method to find the room of a customer */
    public static void FindRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name you want to find out ? ");
        String findname = input.next();

        for (int y = 0; (y < Main.hotel.length); y++) {

            if (Main.hotel[y][0].equals(findname)) {
                System.out.println("The room number is " + y);
                System.out.println("The surname is " + Main.hotel[y][1]);
                System.out.println("Credit card number is " + Main.hotel[y][2]);
                System.out.println("Guest amount is " + Main.hotel[y][3]);
            }
        }
        System.out.println();
    }

    /* Method to display available room numbers */
    public static void DisplayEmptyRoom() {
        for (int x = 0; x < 8; x++) {
            if (Main.hotel[x][0].equals("e")) System.out.println("Room " + x + " is empty ");
        }
        System.out.println("...................................................");
    }

}
