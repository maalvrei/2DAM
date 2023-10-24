package funcintlambdas;

@FunctionalInterface
interface UsaIntDevuelveInt {
	int m(int i);
}

@FunctionalInterface
interface Usa4IntDevuelveInt {
	int m(int i, int y, int z, int p);
}

public class CalculoEntero {
	
	public int cuadrado (int i) {
		return i*i;
	}
	
	public int cubo (int i) {
		return i*i*i;
	}
	
	public int doble (int i) {
		return i*2;
	}
	
	public int triple (int i) {
		return i*3;
	}
	
	public int polinomio (int x) {
		return 5*(x*x*x)+7*(x*x)+9 ;
	}
	
	public int polinomioVariable (int a, int b, int c, int x) {
		return a*(x*x*x)+b*(x*x)+c;
	}
	
	public static void main(String[] args) {
		int x = 10;
		int a = 20;
		int b = 12;
		int c = 9;
		
		CalculoEntero ce = new CalculoEntero();
		System.out.println(ce.cuadrado(x));
		System.out.println(ce.cubo(x));
		System.out.println(ce.doble(x));
		System.out.println(ce.triple(x));
		System.out.println(ce.polinomio(x));
		System.out.println(ce.polinomioVariable(a, b, c, x));
		
		System.out.println("Interfaz funcional");
		UsaIntDevuelveInt cuadrado = s-> s*s;
		UsaIntDevuelveInt cubo = s -> s*s*s;
		UsaIntDevuelveInt doble = s -> s*2;
		UsaIntDevuelveInt triple = s -> s*3;
		UsaIntDevuelveInt polinomio = s -> 5*(s*s*s)+7*(s*s)+9;
		System.out.println(cuadrado.m(x));
		System.out.println(cubo.m(x));
		System.out.println(doble.m(x));
		System.out.println(triple.m(x));
		System.out.println(polinomio.m(x));
		
		Usa4IntDevuelveInt polinomioVariable = (int a1, int b1, int c1, int x1) -> a1*(x1*x1*x1)+b1*(x1*x1)+c1;
		System.out.println(polinomioVariable.m(a,b,c,x));
		
		
	}
	
}
