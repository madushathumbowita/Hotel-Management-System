
// Madusha Thumbowita
// w1790818 , 20191207

//package arrays;
import java.io.*;
import java.util.*;

public class Main {
    static String roomName,roomsurname,cardnum;
    static int roomNum = 0;
    static int guestnum;
    static String[][] hotel = new String[8][4];
    static int n;

    /* Main method */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean T = true;
        Hotel.initialise(hotel);
        System.out.println();
        menu();
        System.out.println();
        while (T) {
            try {
                System.out.println("Enter the Letter :  ");
                String character = input.next();

                switch (character) {
                    case "A":
                        Room.Addcustomer(); /* instantiating the */
                        break;
                    case "E":
                        Room.DisplayEmptyRoom(); /* instantiating */
                        break;
                    case "D":
                        Room.DeleteRoom();  /* instantiating */
                        break;
                    case "F":
                        Room.FindRoom();    /* instantiating */
                        break;
                    case "S":
                        Hotel.StoreRoom(hotel); /* instantiating */
                        break;
                    case "L":
                        Hotel.LoadRoom(); /* instantiating */
                        break;
                    case "V":
                        ViewRoom(); /* instantiating */
                        break;
                    case "8":      /* to stop the program when user input number 8 */
                        T = false;
                        break;
                    default:
                        System.out.println("| Incorrect input |"); /* If user gives different inputs than these */
                        System.out.println();
                }
            } catch (Exception e) {
                System.out.println("| Letter is incorrect |");

            }

        }
        System.out.println();
    }


    /* Method to display the menu */
    public static void menu() {
        System.out.println("````````````````````````````````````````````````````");
        System.out.println("A: Add customer name");
        System.out.println("E: Empty rooms");
        System.out.println("D: Delete customer name");
        System.out.println("F: Find room");
        System.out.println("S: Store program data into file");
        System.out.println("L: Load program data from file");
        System.out.println("V: View guests");
        System.out.println("O: Sort names ");
        System.out.println("8: Stop ");
        System.out.println();
        System.out.println("```````````````````````````````````````````````````");
    }





        /* Method to view already taken rooms */
        public static void ViewRoom () {
            for (int x = 0; x < hotel.length; x++) {
                if (hotel[x][0].equals("e")) {
                    System.out.println("Room " + x + " is empty ");
                } else {
                    System.out.println("Room " + x + " occupied by " + hotel[x][0]);

                }
            }
            System.out.println("...................................................");
            for (int x = 0; x < hotel.length; x++) {
                if (!hotel[x][0].equals("e")) {
                    System.out.println("Room " + x);
                    System.out.println("...................................................");
                    System.out.println("First Name:" + hotel[x][0]);
                    System.out.println("Surname:" + hotel[x][1]);
                    System.out.println("Credit Card Number:" + hotel[x][2]);
                    System.out.println("Number of Guest in the Room:" + hotel[x][3]);

                }
            }
        }
}

