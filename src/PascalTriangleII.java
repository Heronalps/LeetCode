import java.util.List;
import java.util.ArrayList;

public class PascalTriangleII{
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		while(rowIndex > 0){
			row.add(0, 1);
			for (int i = 1; i < row.size() - 1; i++) {
				row.set(i, row.get(i) + row.get(i + 1));
			}
			rowIndex--;
		}
		return row;
	}

	public static List<Integer> getRow2(int rowIndex) {

		ArrayList<Integer> list = new ArrayList<Integer>(rowIndex+1);
		if(rowIndex <0)
			return list;
		list.add(1);
		int count = (rowIndex+1)%2 ==0? (rowIndex+1)/2: (rowIndex+1)/2+1;
		for(int i =1; i<count; i++){
			long val =1;
			int k=i;
			for(int j=rowIndex; j> rowIndex-i; j--){
				val *= j;
				while(k>0 && val% k==0){
					val /=k;
					k--;
				}
			}
			list.add((int)val);
		}
		for(int i =rowIndex - count; i >=0; i--){
			list.add(list.get(i));
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(getRow2(6));
	}
}