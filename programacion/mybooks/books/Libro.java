package books;

public class Libro extends Publicacion {

	private String autor;
	private long libroID;
	private String mensajeCabecera = "\nDATOS LIBRO\n===========\n";

	public Libro(String titulo, String autor, int numPags, int pagInicial, double precio, boolean formatoDigital) {
		super(titulo, numPags, pagInicial, formatoDigital, precio);
		this.autor = autor;
		libroID = Publicacion.getID();
	}

	public void show() {
		System.out.println(mensajeCabecera);
		System.out.println("Titulo " + getTitulo() + "\nAutor: " + autor + "\nID:" + libroID + "\nPaginas: "
				+ getNumPags() + "\nPagina inicial: " + getPagInicial() + "\nPagina actual: " + getPagActual()
				+ "\nPrecio: " + getPrecio() + "\nFormato digital: " + isFormatoDigital() + "\nLeido: " + isLeido());
	}

	public static void showStatic(Libro l) {
		l.show();
	}

	public void leePagina(boolean silenciosamente) {
		if (pagActual + 1 == numPags) {
			System.out.println(
					"Ultima pagina " + pagActual + " leida del libro titulado " + titulo + " del autor " + autor);
			pagActual = numPags;
			leido = true;
		} else if (pagActual != numPags) {
			if (!silenciosamente)
				System.out.println("Pagina " + pagActual + " leida del libro titulado " + titulo + " del autor " + autor);
			pagActual += 1;
		} else if (pagActual == numPags) {
			System.out.println("Libro titulado " + titulo + " del autor " + autor + "ya ha sido leido");
		}
	}

	public static void leePaginaStatic(Libro l) {
		l.leePagina(false);
	}

	public long getLibroID() {
		return libroID;
	}

}
