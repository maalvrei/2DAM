package psp;

import java.util.concurrent.atomic.AtomicLong;

public class CuentaAtrasConConcurrencia implements Runnable{

	private int valorInicial;
	private String nombre;
	private static AtomicLong ejecuciones = new AtomicLong(0);
	private AtomicLong ejecucionesInstancia = new AtomicLong(0);
	private final static int milis = 1;
	
	private CuentaAtrasConConcurrencia (int valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre =  nombre;
	}
	
	private void arranca() {
		for (int i = valorInicial ; i >= 0 ; i--) {
			System.out.printf("%s: %d%n", nombre, i);
			ejecuciones.getAndIncrement();
			ejecucionesInstancia.getAndIncrement();
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CuentaAtrasConConcurrencia ca1 = new CuentaAtrasConConcurrencia(4,"C1");
		int veces = 100_000;
		
		for (int i = 0 ; i < veces ; i++) {
			new Thread(ca1).start();
		}
		
		try {
			Thread.sleep(milis * veces / 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Ejecuiones : %d%n" , ejecuciones.get());
		System.out.printf("Ejecuciones de instancia: %d%n", ca1.ejecucionesInstancia.get());
	}
	
	@Override
	public void run() {
		arranca();
		
	}

}
