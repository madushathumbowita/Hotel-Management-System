

// Madusha Thumbowita
// w1790818 , 20191207

//package arrays;
import java.io.*;
import java.util.*;

public class HotelExample {
    static String roomName,roomsurname,cardnum;
    static int roomNum = 0;
    static int guestnum;
    static String[][] hotel = new String[8][4];  /* 2d array */
    static int n;

    /* Main method */
    public static void main(String[] args) {

        /* Initializing variables */
        Scanner input = new Scanner(System.in);
        boolean T = true;
        initialise(hotel);
        System.out.println();
        menu();
        System.out.println();

        /* try catch inside the while true loop */
        while (T) {
            try {
                System.out.println("Enter the Letter :  "); /* taking the user input */
                String character = input.next();

                switch (character) {
                    case "A":
                        Addcustomer(); /* instantiating */
                        break;
                    case "E":
                        DisplayEmptyRoom(); /* instantiating */
                        break;
                    case "D":
                        DeleteRoom(); /* instantiating */
                        break;
                    case "F":
                        FindRoom(); /* instantiating */
                        break;
                    case "S":
                        StoreRoom(hotel); /* instantiating */
                        break;
                    case "L":
                        LoadRoom(); /* instantiating */
                        break;
                    case "V":
                        ViewRoom(); /* instantiating */
                        break;
                    case "8":
                        T = false;
                        break;
                    default:
                        System.out.println("| Incorrect input |"); /* to stop the program when user input number 8 */
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


    /*  Method to initialise */
    public static void initialise(String hotelRef[][]) {
        for (int x = 0; x < hotelRef.length; x++) {

            for (int y = 0; y < hotelRef[x].length; y++) {
                hotelRef[x][y] = "e";
            }

            System.out.println("initialise ");

        }
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
        }


    /* Method to add customers */
    public static void Addcustomer() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number (0-7) or 8 to stop:");
            roomNum = input.nextInt();
            if (roomNum!=8){

                /* if condition to check the rooms that are already occupied */
                if (hotel[roomNum][0].equals("e")) {

                    System.out.println("Enter first name for room " + roomNum + " :");
                    roomName = input.next();

                    System.out.println("Enter surname for room " + roomNum + " :");
                    roomsurname = input.next();

                    System.out.println("Credit card number : " );
                    cardnum = input.next();

                    System.out.println("Enter the number of guests for room " + roomNum + " :");
                    guestnum = input.nextInt();
                    String guestnum2 = java.lang.String.valueOf(guestnum);


                    hotel[roomNum][0]= roomName;
                    hotel[roomNum][1]= roomsurname;
                    hotel[roomNum][2]= cardnum;
                    hotel[roomNum][3]= guestnum2;

                } else {
                    System.out.println("| Room is occupied |"); /* if user inputs same room name again */
                }
                System.out.println();
            }
            else {
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println("| Enter a valid room number |"); /* if the room number is not between 0 - 7 */
            System.out.println();

        }
    }


    /* Method to delete a customer name from a name */
    public static void DeleteRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of the customer you want to delete ? ");
        String Delname = input.next();

        for (int y = 0; (y < hotel.length); y++) {

            for (int z = 0; z <= 4; z++) {

                if (hotel[y][0].equals(Delname)) {
                    hotel[y][0] = "e";
                }
            }
        }
    }


    /* Method to find the room of a customer */
    public static void FindRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name you want to find out ? ");
        String findname = input.next();

        for (int y = 0; (y < hotel.length); y++) {

            if (hotel[y][0].equals(findname)) {
                System.out.println("The room number is " + y);
                System.out.println("The surname is " + hotel[y][1]);
                System.out.println("Credit card number is " + hotel[y][2]);
                System.out.println("Guest amount is " + hotel[y][3]);
            }
        }
        System.out.println();
    }

    /* Method to display available room numbers */
    public static void DisplayEmptyRoom() {
        for (int x = 0; x < 8; x++) {
            if (hotel[x][0].equals("e")) System.out.println("Room " + x + " is empty ");
        }
        System.out.println("...................................................");
    }

    /* Method to save details to a file */
    public static void StoreRoom(String[][] hotel) throws IOException {

        FileWriter store = new FileWriter("Store.txt");
        for (int x = 0; x < 8; x++) {

                store.write("\n" + "Name: " + hotel[x][0] + "|" + "Room: " + x + "|" + "Surname :" + hotel[x][1] +
                        "|"+" Credit card num :" + hotel[x][2] + "|" +  " Guest amount :" + hotel[x][3] );

        }

        System.out.println("File Saved.");
        store.close();
        System.out.println();
    }

    /* Method load details from the file */
    public static void LoadRoom() throws FileNotFoundException {

        FileReader store = new FileReader("Store.txt");   /* read the file which saved the
                                                                      details in Store room */
        Scanner readermy = new Scanner(store);
        while (readermy.hasNextLine()) {
            String data = readermy.nextLine();
            System.out.println(data);

        }
        System.out.println("...................................................");
        readermy.close();

        System.out.println();


    }
}

