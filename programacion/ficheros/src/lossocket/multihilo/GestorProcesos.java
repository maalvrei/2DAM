package lossocket.multihilo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GestorProcesos extends Thread {
	
	private Socket  socket;
	private OutputStream os;
	
	public GestorProcesos (Socket socket) {
		this.socket = socket;
	}
	
	public void lanzarProceso () throws IOException {
		os = socket.getOutputStream();
		int tiempoDeEspera = new Random().nextInt(10) + 1;
		try {
			TimeUnit.SECONDS.sleep(tiempoDeEspera);
			System.out.println("Enviando desde gestor de proceso: " + tiempoDeEspera);
			os.write(tiempoDeEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			os.close();
		}
	}
	
	@Override
	public void run() {
		try {
			lanzarProceso();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
