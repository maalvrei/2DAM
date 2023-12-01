package examenPSP;

public class Deletrator implements Runnable {

	String palabra;
	static int milis = 1000;
	
	public Deletrator (String palabra) {
		this.palabra = palabra;
	}
	
	public String generaLetraYGuiones (int posicion) {
		String estadoDelDeletreo = "";
		char [] letrasDeLaPalabra = palabra.toCharArray();
		for (int i = 0 ; i < palabra.length() ; i++) {
			if (i  == posicion) estadoDelDeletreo += String.valueOf(letrasDeLaPalabra[i]);
			else estadoDelDeletreo += "-";
		}
		return estadoDelDeletreo;
	}
	
	@Override
	public void run() {
		for (int i = 0 ; i < palabra.length() ; i++) {
			try {
				System.out.printf("Deletrando \"%s\": [%s]%n", palabra, generaLetraYGuiones(i));
				Thread.sleep(milis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		Deletrator d1 = new Deletrator("Cobadonga");
		Thread t1 = new Thread(d1);
		t1.start();
	}
}
