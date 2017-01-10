import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern{
	public static boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		for (int i = len / 2; i > 0; i--) { // i is the length of pattern
			if (len % i == 0) {
				String sub = str.substring(0, i);
				for (int j = 1; j < len / i; j++) { //len / i is the frequency
					if (!sub.equals(str.substring(j * i, j * i + i))) {
						break;
					}

					if(j == len / i - 1){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean repeatedSubstringPattern2(String str) {
        if (str == null || str.length() == 0) {
        	return false;
	    }
	    
	    int len = str.length();
	    
	    for (int l = len / 2; l >= 1; l --) { // len of substrings
	        if (len % l != 0) { // str cannot be divided into substrings with same length l
	            continue;
	        }
	        Set<String> set = new HashSet<>();
	        int i;
	        for (i = 0; i < len / l; i ++) {
	            String substr = str.substring(i * l, (i + 1) * l);
	            if (!set.isEmpty() & set.add(substr)) break;
	        }
	        if (i == len / l) return true;
	    }
	    return false;
    }

    public static boolean repeatedSubstringPattern3(String str) {
        return str.matches("^([a-z]+)\\1+$");
    }

    public static boolean repeatedSubstringPattern4(String str) {
    	int[] lps = kmp(str);
    	int len = str.length();
    	return (lps[len - 1] > 0 && len % (len - lps[len - 1]) == 0); 

    }

    public static int[] kmp(String str) {
    	int len = str.length();
    	char[] charArray = str.toCharArray();
    	int[] lps = new int[len]; // Longest Prefix Sequence
    	int slow = 0, fast = 1;
    	while (slow < len && fast < len){
    		if (charArray[slow] == charArray[fast]) {
    			lps[fast] = slow + 1;
    			slow++;
    			fast++;
    		} else {
    			if (slow != 0) {
    				slow = lps[slow - 1];	
    			} else {
    				lps[fast] = 0;
    				fast++;
    			}
    		}
    	}
    	return lps;
    }

	public static void main(String[] args) {

		System.out.println(repeatedSubstringPattern("abab"));
	}
}
























