package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.UUID;

public class Client extends UnicastRemoteObject implements IClient, Runnable {

    private static final long serialVersionUID = 1L;

    private IServer server;
    private String name = null;
    private UUID id;

    public Client(String name, IServer server) throws RemoteException {
        this.name = name;
        this.server = server;
        this.id = UUID.randomUUID();
        server.registerClient(this);
    }

    public void retrieveMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String message;
        Message msg = new Message(this.name, "", this.id);
        while(true) {
            message = sc.nextLine();
            msg.setMessage(message);
            try {
                server.broadcastMessage(msg);
            }  catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public UUID getId() throws RemoteException {
        return this.id;
    }
    
}
