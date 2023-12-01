package examenPSP;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LuciernagaR implements Runnable {

	String nombre;
	boolean encendido;
	int energia;
	static int milis = 500;

	public LuciernagaR (String nombre, int energia) {
		this.nombre = nombre;
		this.energia = energia < 1 ? 1 : energia > 50 ? 50 : energia;
		encendido = false;
	}

	void enciende() {
		if (energia >= 1 && encendido == false) {
			System.out.printf("La luciérnaga %s se ha encendido%n", nombre);
			encendido = true;
			while (energia > 0) {
				try {
					energia -= 1;
					System.out.printf(energia == 0 ? "La luciérnaga %s tiene %d de energia y se ha apagado%n": "La luciérnaga %s tiene %d de energia%n", nombre, energia);
					if (energia == 0) encendido = false;
					System.out.println(encendido);
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		LuciernagaR l1 = new LuciernagaR("Juana de Arco" , 20);
		LuciernagaR l2 = new LuciernagaR("Juana la Loca" , 30);
		LuciernagaR l3 = new LuciernagaR("Juana tu tia" , 50);
		Thread t1 = new Thread(l1);
		Thread t2 = new Thread(l2);
		Thread t3 = new Thread(l3);
		t1.start();
		t2.start();
		t3.start();
		
		Executor e1 = Executors.newFixedThreadPool(1);
		e1.execute(l1);
		e1.execute(l2);
		e1.execute(l3);
	}
	
	@Override
	public void run() {
		enciende();
	}

}
