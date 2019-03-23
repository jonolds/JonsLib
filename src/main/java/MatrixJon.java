import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixJon extends JonsLib{
	
	void test() {
	
		List<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 4, 5));
		int[] intArr = toIntArr(list);
		println(intArr);
	}

}
