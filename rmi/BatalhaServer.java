package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BatalhaServer extends UnicastRemoteObject implements IServer {
    
    public static final long serialVersionUID = 1L;

    private List<IClient> clients;
    
    protected BatalhaServer() throws RemoteException {
        this.clients = new ArrayList<>();
    }

    public synchronized void registerClient(IClient client) throws RemoteException {
        this.clients.add(client);
    }

    public synchronized void broadcastMessage(Message message) throws RemoteException {
        for(IClient client : this.clients) {
            if(!client.getId().equals(message.getId())) {
                client.retrieveMessage(message.getNome() + ": " + message.getMessage());
            }
        }
    }
    
}
