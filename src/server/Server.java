package server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        try {
            // create a new server listening on 9090
            server = new ServerSocket(9090);
            server.setReuseAddress(true);

            while(true) {
                // create client socket
                Socket client = server.accept();

                System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected");
                
                // handle the new connection
                ClientHandler clientSock = new ClientHandler(client);

                // create a new thread 
                new Thread(clientSock).start();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
         
    }

    private static class ClientHandler implements Runnable {
        private final Socket clienSocket;

        public ClientHandler(Socket socket) {
            this.clienSocket = socket;
        }

        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                out = new PrintWriter(clienSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.printf("Sent from the client: %s\n", line);
                    out.println(line);
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            } finally {
                try  {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}
