package examenPSP;

public class Luciernaga {

	String nombre;
	boolean encendido;
	int energia;
	static int milis = 100;

	public Luciernaga(String nombre, int energia) {
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
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Luciernaga l1 = new Luciernaga("Juana de Arco" , 20);
		Luciernaga l2 = new Luciernaga("Juana la Loca" , 30);
		Luciernaga l3 = new Luciernaga("Juana tu tia" , 50);
		l1.enciende();
		l2.enciende();
		l3.enciende();
	}

}
