package _functionales;

@FunctionalInterface
public interface _BiPredicate<T, U> {
	boolean test(T t, U u);
}
