package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ServerDriver {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Naming.rebind("RMIServer", new BatalhaServer());
        System.out.println("Aperte ENTER para sair");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
        System.exit(0);
    }
}
