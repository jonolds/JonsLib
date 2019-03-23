import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface ConversionJon extends StreamJon{
	
	default <T>void testReflect(List<T> list) {
		Class<? extends Object> c = list.get(0).getClass();
		System.out.println(c.getSimpleName());
	}
	
	@SuppressWarnings("unchecked")
	default <T> T[] toArray(List<T> list) {
		if(!list.isEmpty()) {
			T[] arr = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
			for(int i = 0; i < list.size(); i++)
				arr[i] = list.get(i);
			return arr;
		} else return null;
	}
	
	default int[] dblArr2IntArr(double[] dbl) {
		return Arrays.stream(dbl).mapToInt(e->(int)e).toArray();
	}
	
//	default double[] chArr2DblArr(char[] chArr) {
//		double[] dblArr = new double[chArr.length];
//		
//	}
	
	default int[] toIntArr(Collection<Integer> c) { return c.stream().mapToInt(e->e.intValue()).toArray(); }
	default double[] toDblArr(Collection<Double> c) { return c.stream().mapToDouble(e->e.doubleValue()).toArray(); }
	default long[] toLngArr(Collection<Long> c) { return c.stream().mapToLong(e->e.longValue()).toArray(); }
	
	default <T>Object[] toPrimArr(Collection<T> c) {
		return null;
		
	}
	

}
