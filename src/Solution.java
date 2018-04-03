import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) addWord(root, words[i], i);
        for (int i = 0; i < words.length; i++) search(root, words[i], i, result);
        return result;
    }
    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int curr = word.charAt(i) - 'a'; // i指向的是，当前节点的child，这点很关键
            if (root.children[curr] == null) {
                root.children[curr] = new TrieNode();
            }
            if (isPalindrome(word.substring(0, i + 1))) { // i之前的substring是palindrome，包括i
                root.pList.add(index);
            }
            root = root.children[curr]; // 学习这种Trie递归方式
        }
        root.index = index;
    }
    private void search(TrieNode root, String word, int index, List<List<Integer>> result) {
        // word length > trie sequence length
        for (int i = 0; i < word.length(); i++) {
            if (root.index != -1 && root.index != index && isPalindrome(word.substring(i))) {
                result.add(Arrays.asList(index, root.index));
            }
            root = root.children[word.charAt(i) - 'a'];
            if (root == null) return; //不能继续下去，返回null
        }
        // word length == trie sequence length
        if (root.index != -1 && index != root.index) {
            result.add(Arrays.asList(index, root.index));
        }
        //word length < trie sequence length
        for (int k : root.pList) {
            if (index == k) continue;
            result.add(Arrays.asList(index, k));
        }
    }
    private boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while ( i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
class TrieNode {
    TrieNode[] children;
    List<Integer> pList;
    int index;
    public TrieNode() {
        children = new TrieNode[26];
        pList = new ArrayList<>();
        index = -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"lls", "sssll", "ll"};
        System.out.println(sol.palindromePairs(words));
    }
}
