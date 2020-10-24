package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IClient extends Remote {
    public void retrieveMessage(String message) throws RemoteException;
    public UUID getId() throws RemoteException;
}
