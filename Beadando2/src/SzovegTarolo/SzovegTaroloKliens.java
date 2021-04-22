package SzovegTarolo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class SzovegTaroloKliens {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s= new Socket("127.0.0.1", 1234);
		BufferedReader be =new BufferedReader(new FileReader("log.txt"));
		String bemenoszoveg = be.readLine();
		
		System.out.println("A tárolando szöveg: "+bemenoszoveg+"\n");
		

		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println(bemenoszoveg);
		pw.flush();
		
		Date datum = new Date();
		BufferedReader bf= new BufferedReader(new InputStreamReader(s.getInputStream()));
		String taroltszoveg = bf.readLine()+"\n"+" Mentés ideje: "+datum;
	
		
		System.out.println(taroltszoveg+"\n");
		pw.close();
		be.close();
		bf.close();
		
		
		s.close();
	}

}
