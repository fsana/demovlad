package server;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {

    public static List<House> houses = new ArrayList<House>();
    public static UnitPrices currentPrices = null;

    public static void main(String[] args) throws IOException {
        Server instance = new Server();

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
                    if (line.startsWith("#")) {
                        // the line is a comment 
                        System.out.println("Comment: " + line);
                    } else {
                         String[] elements  = line.split(",");

                        // now check if a house or unit prices
                        if (elements.length == 8) {
                            // house 
                            House house = new House(elements[0],
                                                    elements[1],
                                                    elements[2],
                                                    new Water(Double.parseDouble(elements[3]), Double.parseDouble(elements[4])),
                                                    new Waste(Double.parseDouble(elements[5]), Double.parseDouble(elements[6])), 
                                                    Double.parseDouble(elements[7]),
                                                    currentPrices);
                            Server.houses.add(house);
                            Collections.sort(Server.houses, Comparator.comparing(s -> s.getTotalExpenses()));
                            System.out.println(Server.houses);
                        } else if (elements.length == 5) {
                            // unit prices
                            Server.currentPrices = new UnitPrices(Double.parseDouble(elements[0]),
                                                           Double.parseDouble(elements[1]),
                                                           Double.parseDouble(elements[2]),
                                                           Double.parseDouble(elements[3]),
                                                           Double.parseDouble(elements[4]));
                            System.out.println("Updated prices");
                        }
                    }        
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
