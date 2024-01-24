package lossocket.multihilo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import lossocket.ClientSocketNumsNoCiclico;

public class ClienteSocketTCP {

	private InputStream is;
	private Socket socket;
	private int serverPort;
	private String serverIp;
	
	public ClienteSocketTCP(int serverPort, String serverIp) {
		this.serverPort = serverPort;
		this.serverIp = serverIp;
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.println("(Cliente) Lanzando petición socket ...");
		socket = new Socket(serverIp, serverPort);
		System.out.printf("(Cliente - %s: %d) Lanzando petición socket ...%n", serverIp, serverPort);
		is = socket.getInputStream();
	}

	public void stop() throws IOException {
		System.out.printf("(Cliente - %s: %d) Conexión socket cerrándose ...%n", serverIp, serverPort);
		is.close();
		socket.close();
		System.out.printf("(Cliente - %s: %d) Conexión socket cerrada.%n", serverIp, serverPort);
	}
	
	public static void main(String[] args) {
		ClienteSocketTCP cliente = new ClienteSocketTCP(49171, "localhost");
		try {
			cliente.start();
			int datoRecibido = cliente.is.read();
			System.out.printf("(Cliente - %s: %d) Recibido: %d %n", cliente.serverIp, cliente.serverPort, datoRecibido);
			cliente.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
