
package ss.week7.cmdline;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }

        String name = args[0];
        int port = 0;
        ServerSocket serverSock = null;
        Socket clientSock = null;

        // parse args[1] - the port
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1]
                + " is not an integer");
            System.exit(0);
        }


        // try to open a Socket to the server
        try {
            serverSock = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("ERROR: could not create a server socket on port " + port);
        }

        // create Peer object and start the two-way communication
        try {
            //wait for client to connect
            clientSock = serverSock.accept(); // client connected
            Peer server = new Peer(name, clientSock);
            Thread streamInputHandler = new Thread(server);
            streamInputHandler.start();
            server.handleTerminalInput();
            server.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} // end of class Server
