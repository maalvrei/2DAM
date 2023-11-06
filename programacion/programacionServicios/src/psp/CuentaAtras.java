package psp;

public class CuentaAtras implements Runnable {
	
	int valorInicial;
	String nombre;
	
	public CuentaAtras(int valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre = nombre;
	}
	
	public void arranca () {
		for (int i = valorInicial ; i >= 0 ; i-- ) {
			System.out.printf("%s: %d\n", nombre, i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CuentaAtras ca1 = new CuentaAtras(10, "Primera");
		CuentaAtras ca2 = new CuentaAtras(10, "Segunda");
		new Thread (ca1).start();
		new Thread (ca2).start();
	}

	@Override
	public void run() {
		arranca();
	}
	
} 
