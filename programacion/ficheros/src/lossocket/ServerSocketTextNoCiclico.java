package lossocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTextNoCiclico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	// Nuevas propiedades para soportar texto en la comunicación cliente  - servidor
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public ServerSocketTextNoCiclico(int puerto) throws IOException {
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
	
	public void abrirCanalesDeTexto () {
		System.out.println("(Servidor) Abriendo canales de texto ...");
		pw = new PrintWriter(os, true); // El true es para que haga autoflush
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		System.out.println("(Servidor) Canales de texto abiertos.");
	}
	
	public void cerrarCanalesDeTexto() throws IOException {
		System.out.println("(Servidor) Cerrando canales de texto ...");
		pw.close();
		br.close();
		isr.close();
		System.out.println("(Servidor) Canales de texto cerrados.");
	}

	public static void main(String[] args) {
		ServerSocketTextNoCiclico server;
		try {
			server = new ServerSocketTextNoCiclico(8081);
			server.start();
			server.abrirCanalesDeTexto();
			String datoLeido = server.br.readLine();
			System.out.printf("(Servidor) Leido: %s%n", datoLeido);
			String datoAMandar = datoLeido.toUpperCase();
			server.pw.println(datoAMandar);
			System.out.printf("(Servidor) Mandado: %s%n", datoAMandar);
			server.cerrarCanalesDeTexto();
			server.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}