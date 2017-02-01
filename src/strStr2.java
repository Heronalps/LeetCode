public class strStr2 { 
    public static int strStr2(String source, String target) {
        // Rabin-Karp
        if (source == null || target == null) {
            return -1;
        }
        
        if (target == "") {
            return 0;
        }
        
        int BASE = 1000000;
        int power = 1;
        int targetLen = target.length();
        
        for (int i = 0; i < targetLen; i++) {
            power = (power * 31) % BASE; 
        }

        int targetCode = 0;
        for (int i = 0; i < targetLen; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int sourceCode = 0;

        for (int i = 0; i < source.length(); i++) {
            sourceCode = (sourceCode * 31 + source.charAt(i)) % BASE;
            if (i < targetLen - 1) {
                continue;
            }
            if (i >= targetLen) {
                sourceCode = sourceCode - (source.charAt(i - targetLen) * power) % BASE;
                if (sourceCode < 0) {
                    sourceCode += BASE;
                }
            }

            if (targetCode == sourceCode) {
                if (source.substring(i - targetLen + 1, i + 1).equals(target)) {
                    return i - targetLen + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(strStr2("tartarget", "target"));
    }

}