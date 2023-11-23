package psp;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CocheRunnable implements Runnable {

	private int x;
	private static int longitud = 100;
	private String nombre;
	private int velocidad;
	static Random r = new Random();
	
	public CocheRunnable(String nombre) {
		this.x = r.nextInt(0 , longitud/2);
		this.nombre = nombre;
		this.velocidad = r.nextInt(5, 16);
		
	}
	
	public static void main(String[] args) {
		CocheRunnable c1 = new CocheRunnable("Fernando Alonso");
		CocheRunnable c2 = new CocheRunnable("El Bares");
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		//t1.start();
		//t2.start();
		
		// Crear hilo con un método run en su constructor
		
		Thread t3 = new Thread(
				() -> {
					for (int i = 0 ; i<10 ; i+=2) {
						System.out.printf("El coche %s esta en %d de %d%n", "fantasma", i, 10);
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.printf("El coche %s ha llegado a la meta%n", "fantasma");
				}
		
				);
		//t3.start();
		
		ExecutorService executor1 = Executors.newFixedThreadPool(6);
		executor1.execute(new CocheRunnable("exec1-c1"));
		executor1.execute(new CocheRunnable("exec1-c2"));
		executor1.execute(new CocheRunnable("exec1-c3"));
		executor1.execute(new CocheRunnable("exec1-c4"));
		executor1.execute(new CocheRunnable("exec1-c5"));
		executor1.execute(new CocheRunnable("exec1-c6"));
		executor1.execute(new CocheRunnable("exec1-c7"));
		
		
	}
	
	@Override
	public void run() {
		for (int i = x ; i<longitud ; i += velocidad) {
			x = i;
			System.out.printf("El coche %s está en %d de %d%n", nombre, x, longitud);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("El coche %s ha llegado a la meta%n", nombre);
		
	}
	
}
