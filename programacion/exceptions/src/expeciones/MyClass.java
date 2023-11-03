package expeciones;

public class MyClass {

	public static void m1() {
		try {
			m2(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Se ha capturado el error");
		} catch (RuntimeException ex) {
			System.out.println("Se ha intentado divir entre cero");
		} finally {
			System.out.println("Soy m1");
		}
	}

	public static void m2(int i) throws ArrayIndexOutOfBoundsException, RuntimeException {
		int[] arr = { 1, 2, 3, 4 };
		switch (i) {
		case 0:
			System.out.println(arr[5]);
			break;
		case 1:
			System.out.println(arr[1] / 0);
			break;
		}
		System.out.println(arr[5]);
		System.out.println(arr[1] / 0);
		System.out.println("Soy m2");
	}

	public static void main(String[] args) throws Exception {
		m1();
	}

}
