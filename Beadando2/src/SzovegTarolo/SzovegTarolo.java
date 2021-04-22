package SzovegTarolo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;

public class SzovegTarolo {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		while(true) {
			Socket s= ss.accept();
			
			BufferedReader bf= new BufferedReader(new InputStreamReader(s.getInputStream()));
			String bemenoszoveg=bf.readLine();
			
			Date datum = new Date();
			String taroltszoveg = "A tarolt szöveg: " + bemenoszoveg +"\n"+" A mentés ideje"+ datum;


			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println(taroltszoveg);
			
			pw.flush();
			bf.close();
			pw.close();
			
			s.close();
		}
	}

}
