package SzovegTarolo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class SzovegTaroloMultiKiszolgalo implements Runnable {
	private Socket s;

	public SzovegTaroloMultiKiszolgalo(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader bf;
		try {
			bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String bemenoszoveg=bf.readLine();
			
			String taroltszoveg = "A tárolt szöveg: " + bemenoszoveg +"\n";

			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println(taroltszoveg);
			
			pw.flush();
			bf.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
		
		
		
	
	