package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    public void registerClient(IClient client) throws RemoteException;
    public void broadcastMessage(Message msg) throws RemoteException;
}
