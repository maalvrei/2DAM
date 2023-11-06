package psp;

import java.util.Random;

public class CarreraCoche implements Runnable {
	
	static int distancia = 10;
	String nombre;
	static boolean hayGanador = false;
	int velocidad;
	
	public CarreraCoche (String nombre) {
		this.nombre = nombre;
		velocidad = new Random().nextInt(0,1001);
	}
	
	public void arranca() {
			for (int i = distancia ; i >= 0 ; i--) {
				System.out.printf("%s: %d\n", nombre, i);
				if (i == 0) {
					detener();
					System.out.println("Ha ganado la carrera " + nombre);
				}
				try {
					Thread.sleep(velocidad);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	public void detener() {
		hayGanador = true;
	}
	
	public static void main(String[] args) {
		CarreraCoche cc1 = new CarreraCoche("San Fernando");
		CarreraCoche cc2 = new CarreraCoche("San Miguel");
		new Thread(cc1).start();
		new Thread(cc2).start();
		
	}
	
	@Override
	public void run() {
		while (hayGanador == false) {
			arranca();
		}
	}
}
