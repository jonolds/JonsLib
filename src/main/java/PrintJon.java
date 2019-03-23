import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public interface PrintJon extends StreamJon{
	default <T>void print(T t) { System.out.print(t); }
	default <T>void println(T t) { System.out.println(t); }
	
	default<T>void println(Collection<T> c) { println(c.stream().map(Object::toString).collect(Collectors.joining(", "))); }
	
/* SINGLE ARRAY*/
	default void print(int[] arr) { print(toStr(arr)); }
	default void print(double[] arr) { print(toStr(arr)); }
	default void print(long[] arr) { print(toStr(arr)); }
	default <T>void print(T[] a3) { ints(0, a3.length).forEach(r->println(toStr(a3))); }
	
	default void println(int[] arr) { println(toStr(arr)); }
	default void println(double[] arr) { println(toStr(arr)); }
	default void println(long[] arr) { println(toStr(arr)); }

/* DOUBLE ARRAY*/
	default void print(int[][] arr2) { ints(0, arr2.length).forEach(r->println(toStr(arr2[r]))); }
	default void print(double[][] arr2) { ints(0, arr2.length).forEach(r->println(toStr(arr2[r]))); }
	default void print(long[][] arr2) { ints(0, arr2.length).forEach(r->println(toStr(arr2[r]))); }

	default void println(int[][] arr) { println(toStr(arr)); }
	default void println(double[][] arr) { println(toStr(arr)); }
	default void println(long[][] arr) { println(toStr(arr)); }

/* TRIPLE ARRAY*/
	default void print(int[][][] a3) { ints(0, a3.length).forEach(r->println(toStr(a3[r]))); }
	default void print(double[][][] a3) { ints(0, a3.length).forEach(r->println(toStr(a3[r]))); }
	default void print(long[][][] a3) { ints(0, a3.length).forEach(r->println(toStr(a3[r]))); }
	default <T>void print(T[][][] a3) { ints(0, a3.length).forEach(r->println(toStr(a3[r]))); }

	
/* ARRAY TO STRING */
	default String toStr(int[] arr) { return "[" + strs(arr).collect(Collectors.joining(", ")) + "]"; }
	default String toStr(double[] arr) { return "[" + strs(arr).collect(Collectors.joining(", ")) + "]"; }
	default String toStr(long[] arr) { return "[" + strs(arr).collect(Collectors.joining(", ")) + "]"; }
	default <T>String toStr(T[] arr) { return "[" + strs(arr).collect(Collectors.joining(", ")) + "]"; }
	
	default String toStr(int[][] a2) { return "[" + ints(0, a2.length).mapToObj(i->toStr(a2[i])).collect(Collectors.joining(", ")) + "]"; }
	default String toStr(double[][] a2) { return "[" + ints(0, a2.length).mapToObj(i->toStr(a2[i])).collect(Collectors.joining(", ")) + "]"; }
	default String toStr(long[][] a2) { return "[" + ints(0, a2.length).mapToObj(i->toStr(a2[i])).collect(Collectors.joining(", ")) + "]"; }
	default <T>String toStr(T[][] a2) { return "[" + ints(0, a2.length).mapToObj(i->toStr(a2[i])).collect(Collectors.joining(", ")) + "]"; }
	
	default <T>void println(T[] Arr) { println(Arrays.stream(Arr).map(Object::toString).collect(Collectors.joining(", "))); }
	
	default void println() { System.out.println();}

//	default void print(double[][][] d3Arr) {
//	if(d3Arr.length > 0) {
//		final int s = d3Arr[0][0].length;
//		for(int r = 0; r < d3Arr.length; r++)
//			for(int c = 0; c < d3Arr[0].length; c++)
//			println("[" + (Arrays.stream(d3Arr[row])).mapToObj(String::valueOf).collect(Collectors.joining(", ")) + "]");
//	}
//}

//default String toStr(int[] arr) {
//	return "[" + Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")) + "]";
//}
}