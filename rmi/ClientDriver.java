package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientDriver {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        String serverURL = "rmi://localhost:1099/RMIServer";
        IServer server = (IServer) Naming.lookup(serverURL);
        Client client = new Client(args[0], server);
        client.run();
        System.exit(0);
    }
}
