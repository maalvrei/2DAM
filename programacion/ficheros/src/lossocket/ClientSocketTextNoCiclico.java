package lossocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ClientSocketTextNoCiclico {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String direccion;
	private int puerto;
	
	// Nuevas propiedades para soportar texto en la comunicación cliente  - servidor
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public ClientSocketTextNoCiclico(String direccion, int puerto) {
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
	
	public void abrirCanalesDeTexto () {
		System.out.printf("(Cliente - %s: %d) Abriendo canales de texto ...%n", direccion, puerto);
		pw = new PrintWriter(os, true); // El true es para que haga autoflush
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		System.out.printf("(Cliente - %s : %d) Canales de texto abiertos.%n", direccion, puerto);
	}
	
	public void cerrarCanalesDeTexto() throws IOException {
		System.out.printf("(Cliente - %s: %d) Cerrando canales de texto ...%n", direccion, puerto);
		pw.close();
		br.close();
		isr.close();
		System.out.printf("(Cliente - %s : %d) Canales de texto cerrados.%n", direccion, puerto);
	}

	public static void main(String[] args) {
		ClientSocketTextNoCiclico cliente = new ClientSocketTextNoCiclico("localhost", 8081);
		try {
			cliente.start();
			cliente.abrirCanalesDeTexto();
			String datoEnviado = "Hola";
			System.out.printf("(Cliente - %s: %d) Enviando: %s %n", cliente.direccion, cliente.puerto, datoEnviado);
			cliente.pw.println(datoEnviado);
			String datoRecibido = cliente.br.readLine();
			System.out.printf("(Cliente - %s: %d) Recibido: %s %n", cliente.direccion, cliente.puerto, datoRecibido);
			cliente.cerrarCanalesDeTexto();
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}