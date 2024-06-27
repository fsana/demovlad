package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line

public class FileReaderTest {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
