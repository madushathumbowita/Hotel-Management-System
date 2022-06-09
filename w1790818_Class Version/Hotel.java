
// Madusha Thumbowita
// w1790818 , 20191207

//package arrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hotel {
    public static void initialise(String hotelRef[][]) {
        for (int x = 0; x < hotelRef.length; x++) {

            for (int y = 0; y < hotelRef[x].length; y++) {
                hotelRef[x][y] = "e";
            }

            System.out.println("initialise ");

        }
    }
    /* Method to save details to a file */
    public static void StoreRoom(String[][] hotel) throws IOException {

        FileWriter store = new FileWriter("Store.txt");
        for (int x = 0; x < 8; x++) {

            store.write("\n" + "Name: " + hotel[x][0] + "|" + "Room: " + x + "|" + "Surname :" + hotel[x][1] +
                    "|"+" Credit card num :" + hotel[x][2] + "|" +  " Guest amount :" + hotel[x][3] );

        }

        System.out.println("File Saved ♦ ");
        store.close();
        System.out.println();
    }

    /* Method load details from the file */
    public static void LoadRoom() throws FileNotFoundException {

        FileReader store = new FileReader("Store.txt");
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
