package lossocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketNumsCiclico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;

	public ServerSocketNumsCiclico(int puerto) throws IOException {
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
		ServerSocketNumsCiclico server;
		try {
			server = new ServerSocketNumsCiclico(8081);
			server.start();
			while (true) {
				int datoLeido = server.is.read();
				System.out.printf("(Servidor) Leido: %d%n", datoLeido);
				if (datoLeido == -1) break;
				int datoAMandar = datoLeido + 1;
				server.os.write(datoAMandar);
				System.out.printf("(Servidor) Mandado: %d%n", datoAMandar);
			}
			server.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
