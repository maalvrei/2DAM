package books;

public abstract class Publicacion implements CanRead {

	protected String titulo;
	protected int numPags;
	private int pagInicial;
	private boolean formatoDigital;
	private double precio;
	protected int pagActual;
	protected boolean leido;
	private static long nextID;

	public Publicacion(String titulo, int numPags, int pagInicial, boolean formatoDigital, double precio) {
		this.titulo = titulo;
		this.numPags = numPags;
		this.pagInicial = pagInicial;
		this.formatoDigital = formatoDigital;
		this.precio = precio;
		this.pagActual = pagInicial;
		nextID++;
	}
	
	public static long getID () {
		return nextID;
	}

	public void setPagActual(int pagActual) {
		this.pagActual = pagActual;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	
	@Override
	public String toString() {
		return "Publicacion " + titulo + " con " + numPags + " paginas y precio " + precio + "€";
	}
	
	public String getTitulo() {
		return titulo;
	}

	public int getNumPags() {
		return numPags;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean isFormatoDigital() {
		return formatoDigital;
	}

	public int getPagInicial() {
		return pagInicial;
	}
	
	public boolean isLeido() {
		return leido;
	}
	
	public int getPagActual() {
		return pagActual;
	}

}
