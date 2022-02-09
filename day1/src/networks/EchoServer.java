package networks;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(2010);
		System.out.println("Server is waiting ....");
		int counter=0;
		while (true) {
			Socket socket = ss.accept();
			Thread t = new Thread(new ClientHandler(socket));
			t.start();
			System.out.println("Client No: "+(counter++)+" Client Hash : "+socket.hashCode());
		}

	}

static class ClientHandler implements Runnable {
		Socket s = null;

		public ClientHandler(Socket s) {
			this.s = s;
		}

		public void run() {

			try {
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println("Client sent : " + dis.readUTF());

				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
