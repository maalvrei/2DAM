package examenPSP;

public class LuciernagaT extends Thread {

	String nombre;
	boolean encendido;
	int energia;
	static int milis = 500;

	public LuciernagaT (String nombre, int energia) {
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
		LuciernagaT l1 = new LuciernagaT("Juana de Arco" , 20);
		LuciernagaT l2 = new LuciernagaT("Juana la Loca" , 30);
		LuciernagaT l3 = new LuciernagaT("Juana tu tia" , 50);
		l1.start();
		l2.start();
		l3.start();
	}
	
	@Override
	public void run() {
		enciende();
	}

}
