package books;

public class Revista extends Publicacion {

	private String mensajeCabecera = "\nDATOS REVISTA\n=============\n";
	private long revistaID;

	public Revista(String titulo, int numPags, int pagInicial, boolean formatoDigital, double precio) {
		super(titulo, numPags, pagInicial, formatoDigital, precio);
		revistaID = Publicacion.getID();
	}

	public void show() {
		System.out.println(mensajeCabecera);
		System.out.println("Titulo " + getTitulo() + "\nID:" + revistaID + "\nPaginas: " + getNumPags()
				+ "\nPagina actual: " + getPagActual() + "\nPrecio: " + getPrecio() + "\nFormato digital: "
				+ isFormatoDigital() + "\nLeido: " + isLeido());
	}

	public static void showStatic(Revista r) {
		r.show();
	}

	public void leePagina(boolean silenciosamente) {
		if (pagActual + 1 == numPags) {
			System.out.println("Ultima pagina " + pagActual + " leida de la revista titulada " + titulo);
			pagActual = numPags;
			leido = true;
		} else if (pagActual != numPags) {
			pagActual += 1;
			if (!silenciosamente)
				System.out.println("Pagina " + pagActual + " leida de la revista titulada " + titulo);
		} else if (pagActual == numPags) {
			System.out.println("Revista titulada " + titulo + " ya ha sido leida");
		}
	}

	public static void leePaginaStatic(Revista r) {
		r.leePagina(false);
	}

	public long getRevistaID() {
		return revistaID;
	}
}
