package lossocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ClientSocketNumsCiclico {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String direccion;
	private int puerto;

	public ClientSocketNumsCiclico(String direccion, int puerto) {
		this.direccion = direccion;
		this.puerto = puerto;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("(Cliente) Lanzando petición socket ...");
		socket = new Socket(direccion, puerto);
		System.out.printf("(Cliente - %s: %d) Lanzando petición socket ...%n", direccion, puerto);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.printf("(Cliente - %s: %d) Conexión socket cerrándose ...%n", direccion, puerto);
		os.close();
		is.close();
		socket.close();
		System.out.printf("(Cliente - %s: %d) Conexión socket cerrada.%n", direccion, puerto);
	}

	public static void main(String[] args) {
		ClientSocketNumsCiclico cliente = new ClientSocketNumsCiclico("localhost", 8081);
		try {
			cliente.start();
			for (int i = 0 ; i < 255 ; i++) {
				System.out.printf("(Cliente - %s: %d) Enviando: %d %n", cliente.direccion, cliente.puerto, i);
				cliente.os.write(i);
				int datoRecibido = cliente.is.read();
				System.out.printf("(Cliente - %s: %d) Recibido: %d %n", cliente.direccion, cliente.puerto,
						datoRecibido);
			}
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
