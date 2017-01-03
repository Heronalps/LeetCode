import java.util.ArrayList;
import java.util.List;

public class PascalTriangle{
	public static List<List<Integer>> generate (int numRows) {
		ArrayList<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			if (i == 0) {
				ArrayList<Integer> level = new ArrayList<>();
				level.add(1);
				result.add(level);
			} else {
				List<Integer> level = result.get(i - 1);
				ArrayList<Integer> newLevel = new ArrayList<>();
				newLevel.add(1);
				for (int j = 0; j < level.size() - 1; j++) {
					newLevel.add(level.get(j) + level.get(j + 1));
				}
				newLevel.add(1);
				result.add(newLevel);
			}
		}
		return result;
	}

	public static List<List<Integer>> generate2(int numRows) {
		if (numRows == 0) {
			ArrayList<List<Integer>> result = new ArrayList<>();
			return result;
		}

		if (numRows == 1) {
			List<Integer> newLevel = new ArrayList<Integer>();
			ArrayList<List<Integer>> result = new ArrayList<>();
			newLevel.add(1);
			result.add(newLevel);
			return result;
		}

		List<List<Integer>> result = generate2(numRows - 1);
		List<Integer> newLevel = new ArrayList<Integer>();
		List<Integer> higherLevel = result.get(result.size() - 1);
		newLevel.add(1);
		for (int i = 0; i < higherLevel.size() - 1; i++) {
			newLevel.add(higherLevel.get(i) + higherLevel.get(i + 1));
		}
		newLevel.add(1);
		result.add(newLevel);
		return result;
	}

	public static List<List<Integer>> generate3(int numRows)
	{
	List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	ArrayList<Integer> row = new ArrayList<Integer>();
	for(int i=0;i<numRows;i++)
	{
		row.add(0, 1);
		for(int j=1;j<row.size()-1;j++)
			row.set(j, row.get(j)+row.get(j+1));
		allrows.add(new ArrayList<Integer>(row));
	}
	return allrows;
	
	}


	public static void main(String[] args) {
		System.out.println(generate3(5));

	}
}