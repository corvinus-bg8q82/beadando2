package SzovegTarolo;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SzovegTaroloMulti {

	public static void main(String[] args) throws IOException {
		ServerSocket ss= new ServerSocket(1234);
		
		while(true) {
			new Thread(new SzovegTaroloMultiKiszolgalo(ss.accept())).start();

			
		}
		

	}

}


