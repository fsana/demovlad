package client;

import java.io.*;
import java.net.*;
import java.util.*;

// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9090)) {
            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // read from System.ineibccbdvlrkigefgjuchcddncfdeblkkcdulgdulkbbi
            
            Scanner scanner = new Scanner(System.in);
            String line = null;

            while(!"exit".equalsIgnoreCase(line)) {
                // reading line using scanner
                line = scanner.nextLine();

                // sending the line to the server
                out.println(line);
                out.flush();

                // display server response
                System.out.println("Server:" + in.readLine());
            }

            // closing the scanner
            scanner.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }    
}
