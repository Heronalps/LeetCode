import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
    	int output = 0;
    	if (g.length == 0 || s.length == 0) {
    		return output;
    	}

        Arrays.sort(g);
        Arrays.sort(s);

        int i= 0, j = 0;
        while ( i < g.length && j < s.length ) {
           	if (g[i] > s[s.length - 1]) {
        		break;
        	}
    		if (g[i] <= s[j]) {
    			output++;
    			i++;
    			j++;
    		} else {
    			j++;
    		}

        }
        return output;
    }

    public static int findContentChildren2(int[] g, int[] s) {
    	Arrays.sort(g);
    	Arrays.sort(s);

    	int i = 0;
    	for (int j = 0; i < g.length && j < s.length; j++) {
    		if (g[i] <= s[j]) {
    			i++;
    		}
    	}
    	return i;
    }

    public static void main(String[] args) {
    	int[] greed = {1, 2 ,3, 6, 9, 10};
    	int[] size = {1, 2, 5, 9, 13};

    	System.out.println(findContentChildren2(greed, size));
    }
}