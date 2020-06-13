import java.io.*;
import java.util.Scanner;
import java.util.HashSet;

public class SpellChecker {
    public static void main(String[] args) {
        // Prompt for file name
        boolean prompting = true;
        Scanner keyboard = new Scanner(System.in);
        while(prompting){
            System.out.println("Enter a file path to check spelling. (path must not contain spaces)");
            String filePath = keyboard.next();
            File fileToCheck = new File(filePath);
            Scanner fileInput= null;
            if(fileToCheck.exists() && fileToCheck.isFile()){
                try {
                    fileInput = new Scanner(new FileInputStream("girlnames.txt"));
                } catch (FileNotFoundException e) {
                    System.out.println("File connection failed. Would you like to exit? (y/n)");
                }
            } else {
                System.out.println("File not found. Would you like to exit? (y/n)");
                String cont = keyboard.next();
                if (cont.equalsIgnoreCase("y")) {
                    prompting = false;
                }
            }
        }

        // Get stuff setup
        File boyNames = new File("boynames.txt");
        File girlNames = new File("girlnames.txt");
        Scanner girlNamesInput = null;
        Scanner boyNamesInput = null;

        // Establish connection with girl names file.
        if (girlNames.exists() && girlNames.isFile()) {
            try {
                girlNamesInput = new Scanner(new FileInputStream("girlnames.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("The girlnames.txt file was not found.");
            }
        }
    }
}