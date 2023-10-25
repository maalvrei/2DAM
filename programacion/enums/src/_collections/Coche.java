package _collections;

import java.util.Objects;

public class Coche {

	Color color;
	Marca marca;
	
	public Coche(Color color, Marca marca) {
		this.color = color;
		this.marca = marca;
	}
	
	public Coche() {
		color = Color.ColorAleatorio();
		marca = Marca.MarcaAleatoria();
	}
	
	@Override
	public String toString() {
		return String.format("Coche: %s %s", marca, color);
	}

	public Color getColor() {
		return color;
	}

	public Marca getMarca() {
		return marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return color == other.color && marca == other.marca;
	}
	
}
