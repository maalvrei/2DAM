package psp;

public class CuentaAtrasThread extends Thread {
	
	int valorInicial;
	String nombre;
	
	public CuentaAtrasThread(int valorInicial, String nombre) {
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
		CuentaAtrasThread ca1 = new CuentaAtrasThread(10, "Primera");
		CuentaAtrasThread ca2 = new CuentaAtrasThread(10, "Segunda");
		ca1.start();
		ca2.start();
	}

	@Override
	public void run() {
		arranca();
	}
}
