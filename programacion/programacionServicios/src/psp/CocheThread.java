package psp;

import java.util.Random;

public class CocheThread extends Thread {

	private int x;
	private static int longitud = 100;
	private String nombre;
	private int velocidad;
	static Random r = new Random();
	
	public CocheThread(String nombre) {
		this.x = r.nextInt(0 , longitud/2);
		this.nombre = nombre;
		this.velocidad = r.nextInt(5, 16);
		
	}
	
	public static void main(String[] args) {
		CocheThread c1 = new CocheThread("Fernando Alonso");
		CocheThread c2 = new CocheThread("El Bares");
		c1.start();
		c2.start();
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
