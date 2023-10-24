package _functionales;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
	
	public static void main(String[] args) {
		_Predicate<String> p1 = s -> s.contains("d");
		System.out.println(p1.test("Holad"));
		Predicate<String> p2 = s -> s.contains("d");
		System.out.println(p1.test("Holad"));
		_Supplier<String> s1 = () -> "Hola";
		System.out.println(s1.get());
		Supplier<String> s2 = () -> "Hola";
		System.out.println(s2.get());
		_Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = s -> System.out.println(s);
		_BiConsumer<String, Integer> bc1 = (String s, Integer i) -> System.out.println(s + " " + i);
		BiConsumer<String, Integer> bc2 = (String s, Integer i) -> System.out.println(s + " " + i);
		_BiPredicate<Integer, Integer> bp1 = (Integer i, Integer j) -> i < j;
		BiPredicate<Integer, Integer> bp2 = (Integer i, Integer j) -> i < j;
		List<String> lista = new ArrayList<>();
		lista.add("Hola");
		lista.add("Adios");
		lista.add("Banana");
		lista.forEach(s -> System.out.println(s));
	}
	
}
