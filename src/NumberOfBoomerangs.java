import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class NumberOfBoomerangs{
	public static int numberOfBoomerangs(int[][] points) {
		int result = 0;
		HashMap<Double, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length ; i++) {	
			for (int j = 0; j < points.length ; j++) {
				if (i == j) continue;	
				double distance = Math.hypot((points[i][0] - points[j][0]), 
											 (points[i][1] - points[j][1])); 
				map.put(distance, map.getOrDefault(distance, 0) + 1);
				for (int val: map.values() ) {
					if (val > 1) {
						result += val * (val - 1);
					}
				}
			}
			map.clear();
			//Traverse hashmap and result += Integer * (Integer - 1)

		}
		return result;
	}

	public static void main(String[] args) {
		/*int num = 10;
		int[][] points = new int[num][2];
		*/

		int[][] points = {{0 ,0},
						  {1, 0},
						  {2, 0}};
		System.out.println(numberOfBoomerangs(points)); // 2
	}
}