package expeciones;

public class MyClassJavi {

	public static void m1() throws MyCheckedException {
		System.out.println("Soy m1");
		m2();
	}
	
	public static void m2() throws MyCheckedException {
		System.out.println("Soy m2");
		int i = 1/0;
		String s = null;
		s.charAt(1);
		throw new MyCheckedException();
	}
	
}
