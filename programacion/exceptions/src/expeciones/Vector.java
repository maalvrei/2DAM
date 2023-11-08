package expeciones;

public class Vector {

	int x;
	int y;
	private static final int xMax = 7;
	private static final int yMax = 5;
	
	public Vector (int x, int y) {
		this.x = x < 0 ? 0 : x > xMax ? xMax : x;
		this.y = y < 0 ? 0 : y > yMax ? yMax : y;
	}
	
	public Vector (int v) {
		this(v, v);
	}
	
	public Vector suma (Vector v) throws VectorOutOfBoundsException {
		if (x + v.x > xMax || y + v.y > yMax)
			throw new VectorOutOfBoundsException("El numero no está en el rango permitido");
		else
			return new Vector(x + v.x, y + v.y);
	}
	
	public static void main(String[] args) {
		Vector v1 = new Vector(xMax, yMax);
		Vector v2 = new Vector(xMax, yMax);
		try {
			v1.suma(v2);
			System.out.println("hola");
		} catch (VectorOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
