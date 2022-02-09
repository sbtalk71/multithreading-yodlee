package networks;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 2010);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		System.out.println("Client sent :Server Ji Aap kaun Ho?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		dos.writeUTF(str);
		dos.close();
		s.close();

	}

}
