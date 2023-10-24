package genericos;

public class Test {

	public static void main(String[] args) {
		Box b = new Box(3);
		BoxDeString bs = new BoxDeString("Hola" , 7);
		BoxDeCosa bc = new BoxDeCosa(new Cosa("Verde"), 8);
		Cosa c = new Cosa("Amarillo");
		
		Caja<String> cs = new Caja<>("Hola", 7);
		Caja<Cosa> cc = new Caja<>(new Cosa("Rojo"), 7);
		Caja <Object> co1 = new Caja<>(c, 7);
		Caja <Object> co2 = new Caja<>("Adios", 7);
		Caja <Object> co3 = new Caja<>(new Cosa("Verde"),7);
	}
	
}
