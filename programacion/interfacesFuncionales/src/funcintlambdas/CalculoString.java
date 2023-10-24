package funcintlambdas;

public class CalculoString {
	
	@FunctionalInterface
	interface UsaUnStringDevuelveBoolean {
		boolean m(String s);
	}
	
	@FunctionalInterface
	interface UsaDosStringDevuelveBoolean {
		boolean m(String s, String c);
	}
	
	@FunctionalInterface
	interface UsaStringYCharDevuelveBoolean {
		boolean m(String s, char c);
	}
	
	@FunctionalInterface
	interface UsaStringYIntDevuelveBoolean {
		boolean m(String s, int n);
	}
	
	public static void main(String[] args) {
		String s = "hola";
		String c = "hola";
		UsaDosStringDevuelveBoolean iguales = (s1, c1) -> s1.equals(c1);
		System.out.println(iguales.m(s, c));
		UsaDosStringDevuelveBoolean contiene = (s1, c1) -> s1.contains(c1);
		System.out.println(contiene.m(s, c));
		UsaUnStringDevuelveBoolean esMenorQueTres = s1 -> s1.length() < 3;
		System.out.println(esMenorQueTres.m(s));
		UsaStringYCharDevuelveBoolean empiezaPor = (s1 , c1) -> s1.charAt(0) == c1 ? true : false;
		System.out.println(empiezaPor.m(c, 'a'));
		UsaStringYCharDevuelveBoolean terminaEn = (s1 , c1) -> s1.charAt(s1.length() - 1) == c1 ? true : false;
		System.out.println(terminaEn.m(s, 'a'));
		UsaStringYIntDevuelveBoolean verificaLongitudFlexible = (String s1, int n) -> s1.length() < n;
		System.out.println(verificaLongitudFlexible.m(s, 1));
	}
	
	
	
}
