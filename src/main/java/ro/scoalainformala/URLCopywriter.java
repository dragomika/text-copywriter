package ro.scoalainformala;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class URLCopywriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your URL: ");
        String urlLink = scanner.nextLine();

        try {
            URL url = new URL(urlLink);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            System.out.println("Please enter your output file path: ");
            String outputPath = scanner.nextLine();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

                String lineOfText;

                while ((lineOfText = br.readLine()) != null) {

                    String[] words = lineOfText.trim().split(" +");
                    int wordCount = words.length;

                    bw.write(wordCount + " " + lineOfText);
                    bw.newLine();
                }

                System.out.println("Done!");
            } catch (FileNotFoundException e) {
                System.err.println("The file was not found on disk.");
            }
        } catch (IOException e) {
            System.err.println("Could not read from the provided URL.");
        }
    }
}
