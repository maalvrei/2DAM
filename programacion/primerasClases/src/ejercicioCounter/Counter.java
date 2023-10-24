package ejercicioCounter;

public class Counter {

	int value;
	int maxValue;
	String model;
	
	private Counter(int value, int maxValue, String model) {
		this.value = value;
		this.maxValue = maxValue <= 10 ? 10: maxValue;
		this.model = model;
	}
	
	public Counter(int maxValue, String model) {
		this(0, maxValue, model);
	}
	
	public Counter(int maxValue) {
		this(maxValue, "N-COUNTER");
	}
	
	public Counter() {
		this(100_000, "N-COUNTER");
	}
	
	public Counter(Counter c) {
		this(c.value, c.maxValue, c.model);
	}

	public boolean increment() {
		boolean resultado;
		value = (resultado = value < maxValue) ? value + 1 : value;
		return resultado;
	}

	public boolean increment (int cantidad) {
		value = value == maxValue ? value : cantidad + value;
		return value < maxValue ? true : false;
	}
	
	public boolean reset () {
		if (value == maxValue) {
			value = 0;
			return true;
		} else
			return false;
	}
	
	public void show () {
		System.out.println("Contador: modelo " + model + " y valor " + value + " de " + maxValue);
	}
	
	public static void main(String[] args) {
		Counter c1 = new Counter();
		c1.show();
		c1.increment();
		c1.show();
		c1.increment(100_000);
		c1.show();
		
	}
	
}
