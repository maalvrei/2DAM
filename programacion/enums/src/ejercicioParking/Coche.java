package ejercicioParking;

public class Coche {
	
	Marca marca;
	Color color;
	
	public Coche(Marca marca, Color color) {
		this.marca = marca;
		this.color = color;
	}
	
	public Coche() {
		color = Color.obtieneColorAleatorio();
		marca = Marca.obtieneMarcaAleatoria();
	}
	
	@Override
	public String toString() {
		return "Coche: " + marca + " " + color;
	}
	
	@Override
	public boolean equals (Object obj) {
		Coche c = (Coche) obj;
		if( this == c)
			return true;
		if (this.color.equals(c.color) && this.marca.equals(c.marca))
			return false;
		else
			return false;
	}
	
}
