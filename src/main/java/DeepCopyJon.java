public interface DeepCopyJon extends StreamJon {
	
	default int[] copy(int[] orig) { 
		return ints(0, orig.length).map(i->orig[i]).toArray(); 
	}
	default double[] copy(double[] orig) { 
		return ints(0, orig.length).mapToDouble(i->orig[i]).toArray(); 
	}
	default long[] copy(long[] orig) { 
		return ints(0, orig.length).mapToLong(i->orig[i]).toArray(); 
	}
}