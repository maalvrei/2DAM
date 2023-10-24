package genericos;

public class Caja<T> {

	private T contenido;
	private double precio;
	
	public Caja(T contenido, double precio) {
		this.contenido = contenido;
		this.precio = precio;
	}
	
	
	
}
