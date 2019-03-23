import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface StreamJon {
	default IntStream ints(int begin, int end) { return IntStream.range(begin, end); }
	
	default Stream<IntStream> ints2(int begin, int end, int numStreams) {
		return ints(0, numStreams).mapToObj(x->ints(begin, end));
	}
	
	default Stream<String> strs(int[] arr) { return Arrays.stream(arr).mapToObj(i->String.valueOf(i)); }
	default Stream<String> strs(double[] arr) {
		return Arrays.stream(arr).mapToObj(i->String.valueOf(i)); 
	}
	default Stream<String> strs(long[] arr) { return Arrays.stream(arr).mapToObj(i->String.valueOf(i)); }

	
	default <T>Stream<String> strs(T[] arr) { return Arrays.stream(arr).map(t->String.valueOf(t)); }
//	default Stream<Stream<String>> strs(double[][] a2) { 
//		return Stream.of(ints(0, a2.length).mapToObj(i->strs(a2[i])).;
//	}
	
	default Stream<double[]> stream(double[][] dbl2arr) {
		return Arrays.stream(dbl2arr);
	}
	
//	default Stream<IntStream> ints(int begin, int end, int subnum) {
//		return IntStream.range(begin, end).mapToObj(i->Stream.of(ints(0, subnum))).collect(Collectors.)
//	}
}