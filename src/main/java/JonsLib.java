public class JonsLib implements StreamJon, PrintJon, ConversionJon, DeepCopyJon {

	public static void error(String description) {
		throw new IllegalArgumentException("!!ERROR: " +description);
	}
//
//	public static void main(String[] args) {
//		(new JonsLib()).testing();
//	}
}
