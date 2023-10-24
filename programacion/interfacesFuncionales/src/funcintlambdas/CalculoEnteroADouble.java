package funcintlambdas;

public class CalculoEnteroADouble {
	
	@FunctionalInterface
	interface UsaIntDevuelveDouble {
		double m(int i);
	}
	
	@FunctionalInterface
	interface UsaDosIntDevuelveDouble {
		double m(int i, int x);
	}
	
	public static void main(String[] args) {
		int i = 10;
		int n = 6;
		UsaIntDevuelveDouble mitad = s -> s/2.;
		UsaIntDevuelveDouble cuartaParte = s -> s/4.;
		UsaIntDevuelveDouble decimaParte = s -> s/10.;
		UsaDosIntDevuelveDouble nParte = (int i1, int n1) -> (double) i1/n1;
		
		System.out.println(mitad.m(i));
		System.out.println(cuartaParte.m(i));
		System.out.println(decimaParte.m(i));
		System.out.println(nParte.m(i,n));
	}
	
}
