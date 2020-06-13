import java.io.*;
import java.util.Scanner;

public class SpellChecker {
    public static void main(String[] args) {
        // Setup dictionary
        // Create Dictionary
        HashTableString dictionary = new HashTableString();
        // Connect to words file
        File dictionaryFile = new File("mostCommonWords.txt");
        Scanner dictionaryWords = null;
        if(dictionaryFile.exists() && dictionaryFile.isFile()){
            try {
                dictionaryWords = new Scanner(new FileInputStream(dictionaryFile));
            } catch (FileNotFoundException e) {
                System.out.println("Connection to mostCommonWords.txt failed.");
            }
        } else {
            System.out.println("mostCommonWords.txt not found.");
        }
        // Add words to dictionary
        while(dictionaryWords.hasNext()){
            String word = dictionaryWords.next();
            dictionary.put(word);
        }

        // Setup files
        File fileToCheck = null;
        Scanner fileInput= null;
        File fileToOutput = null;
        PrintWriter fileOutput = null;

        // Prompt for file name and create input stream
        boolean prompting = true;
        Scanner keyboard = new Scanner(System.in);
        while(prompting){
            System.out.println("Enter a file path to check spelling. (path must not contain spaces)");
            String filePath = keyboard.next();
            fileToCheck = new File(filePath);
            if(fileToCheck.exists() && fileToCheck.isFile()){
                try {
                    fileInput = new Scanner(new FileInputStream(filePath));
                    prompting = false;
                } catch (FileNotFoundException e) {
                    System.out.println("File connection failed. Would you like to exit? (y/n)");
                }
            } else {
                System.out.println("Invalid file name. Would you like to exit? (y/n)");
                String cont = keyboard.next();
                if (cont.equalsIgnoreCase("y")) {
                    prompting = false;
                }
            }
        }

        // Create output stream
        try {
            fileOutput = new PrintWriter(new FileOutputStream("Output.txt"));
        } catch (FileNotFoundException e){
            System.out.println("Output file connection failed.");
        }


        // Read words from a file check spelling in dictionary and add to output file
        while(fileInput.hasNextLine()){
            // Create a new line
            String newLine = "";
            // Take in a line
            String line = fileInput.nextLine();
            // Break up line into words array
            String[] words = line.split(" ");
            // Check each word
            for (String word : words){
                // periods and apostrophies will be removed for spell check this keeps track if they should be put back in
                boolean plural = false;
                String plurality = "";
                boolean period = false;
                boolean capital = false;
                // remove period
                if (word.contains(".")){
                    word = word.substring(0,word.length()-1);
                    period = true;
                }
                // remove plural
                if(word.contains("'")){
                    plurality = word.substring(word.length()-2);
                    word = word.substring(0,word.length()-2);
                    plural = true;
                }
                // check if capitalized
                if(word.substring(0,1).equals(word.substring(0,1).toUpperCase())){
                    capital = true;
                }
                // check if word is in the dictionary
                if(!dictionary.containsString(word.toLowerCase())){
                    word = word.toUpperCase();
                }
                // reconstruct word
                if(plural){
                    word += plurality;
                }
                if(period){
                    word += ".";
                }
                if(capital){
                    word = word.substring(0,1).toUpperCase() + word.substring(1);
                }
                word += " ";
                // add word to line
                newLine += word;
            }
            // Write new line to output file
            fileOutput.println(newLine);
        }

        // Close files
        fileInput.close();
        fileOutput.close();
    }
}