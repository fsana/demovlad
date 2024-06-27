package client;

import java.io.*;
import java.net.*;
//import java.util.*;

// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9090)) {
            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            if (args.length > 0 && args[0] != null && args[0].length() > 0) {
                // read from file
                BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
                String line = fileReader.readLine();
                while (line != null) {
                    out.println(line);
                    line = fileReader.readLine();
                }

                // close the file reader
                fileReader.close();
                
                out.flush();
                out.close();
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }    
}
