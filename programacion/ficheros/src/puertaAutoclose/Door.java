package puertaAutoclose;

public class Door implements AutoCloseable {

	public void open() {
		System.out.println("Se ha abierto la puerta.");
	}
	
	@Override
	public void close() {
		System.out.println("Se ha cerrado la puerta automáticamente.");
	}
	
	public static void main(String[] args) {
		Door puerta =  new Door();
		try (puerta) {
			puerta.open();
		}
	}

}
