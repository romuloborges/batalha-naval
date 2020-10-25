package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.UUID;

public class Client extends UnicastRemoteObject implements IClient {

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
        System.out.println("Para sair digite: exit");
        Scanner sc = new Scanner(System.in);
        String message;
        Message msg = new Message(this.name, "", this.id);
        boolean continuar = true;
        while(continuar) {
            message = sc.nextLine();
            if(!message.equals("exit")) {
                msg.setMessage(message);
                try {
                    server.broadcastMessage(msg);
                }  catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                msg.setMessage("saindo!");
                try {
                    server.broadcastMessage(msg);
                    server.disconectClient(this);
                }  catch (RemoteException e) {
                    e.printStackTrace();
                }
                System.out.println("Saindo ...");
                continuar = false;
            }
        }
        sc.close();
    }

    public UUID getId() throws RemoteException {
        return this.id;
    }
    
}
