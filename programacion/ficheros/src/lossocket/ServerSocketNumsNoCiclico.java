package lossocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketNumsNoCiclico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;

	public ServerSocketNumsNoCiclico(int puerto) throws IOException {
		serverSocket = new ServerSocket(puerto);
	}

	public void start() throws IOException {
		System.out.println("(Servidor) Esperando conexión ...");
		socket = serverSocket.accept();
		System.out.println("(Servidor) Conexión establecida.");
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.println("(Servidor) Cerrando conexión ...");
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println("(Servidor) Conexión cerrada.");
	}

	public static void main(String[] args) {
		ServerSocketNumsNoCiclico server;
		try {
			server = new ServerSocketNumsNoCiclico(8081);
			server.start();
			int datoLeido = server.is.read();
			System.out.printf("(Servidor) Leido: %d%n", datoLeido);
			int datoAMandar = datoLeido + 1;
			server.os.write(datoAMandar);
			System.out.printf("(Servidor) Mandado: %d%n", datoAMandar);
			server.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
