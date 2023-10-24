package generics;

public class Box<T> {
	
	private T contenido;
	
	private Box(T contenido) {
		this.contenido = contenido;
	}

	public static <T> Box<T> of (T contenido) {
		return new Box<T>(contenido);
	}
	
	public static <T> Box<T> empty() {
		return new Box<>(null);
	}
	
	public boolean isPresent() {
		return contenido != null;
	}

	public T getContenido() {
		return contenido;
	}
	
}
