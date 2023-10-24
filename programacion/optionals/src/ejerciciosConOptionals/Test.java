package ejerciciosConOptionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test {
	
	static Optional<Double> media (Integer... nums) {
		if (nums.length == 0) return Optional.empty();
		
		double suma = 0;
		int numEfectivos = 0;
		
		for (Integer valor : nums) {
			if (valor != null) {
				suma += valor;
				numEfectivos++;
			}
		}
		
		return numEfectivos == 0 ? Optional.empty() : Optional.of(suma /= numEfectivos);
	}
	
	public static void main(String[] args) {
		/*Optional<Double> o1 = media(1,2,3,4,5,6);
		Optional<Double> o2 = media(1,2,3,null,null);
		System.out.println(o1);
		System.out.println(o2); */
		media(1,2,4,5,6).ifPresent(s -> System.out.println(s));
		media().orElse(-99.);
		List<Integer> arrL = new ArrayList<>();
		arrL.add(1);
		arrL.add(2);
		//arrL.stream().
	}
	
}
