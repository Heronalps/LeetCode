import java.util.Arrays;
import java.lang.String;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();

        Arrays.sort(ransom);
        Arrays.sort(maga);

        int i = 0, j = 0;
        while(i < ransom.length && j < maga.length){
        	if (ransom[i] == maga[j]) {
        		i++;
        		j++;
        	} else {
        		j++;
        	}
        }

        if (i == ransom.length) {
        	return true;
        } else {
        	return false;
        }
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            counter[magazine.charAt(i) - 'a']++;
        }
        for (int j = 0; j < ransomNote.length() ; j++) {
            counter[ransomNote.charAt(j) - 'a']--;
            if (counter[ransomNote.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	String ransomNote = "aabbv";
    	String magazine = "abcdba";
    	System.out.println(canConstruct1(ransomNote, magazine));
    }
}