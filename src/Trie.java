import java.util.HashMap;
import java.util.Map;

public class Trie {
    Map<Character, Trie> children;
    boolean isWord;
    /** Initialize your data structure here. */
    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }
    private Trie getChild(Character ch) {
        if (children.containsKey(ch)) {
            return children.get(ch);
        } else {
            return null;
        }
    }
    private void setChild(Character ch, Trie node) {
        children.put(ch, node);
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0);
    }
    private void insert(String word, int index) {
        if (index == word.length()) {
            isWord = true;//并没有创建新的node，而是修改了上层的node的isWord
            return;
        }
        Character current = word.charAt(index);
        Trie child = getChild(current);
        if (child == null) {
            child = new Trie();
            setChild(current, child);
        }
        child.insert(word, index + 1); //一定在child对象上调用
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0);
    }
    private boolean search(String word, int index) {
        if (index == word.length()) {
            return isWord; //要确定是词尾
        }
        Character current = word.charAt(index);
        Trie child = getChild(current);
        if (child == null) {
            return false;
        }
        return child.search(word, index + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }
    private boolean startsWith(String prefix, int index) {
        if (index == prefix.length()) {
            return true; //不需要是词尾
        }
        Character current = prefix.charAt(index);
        Trie child = getChild(current);
        if (child == null) {
            return false;
        }
        return child.startsWith(prefix, index + 1);
    }

    public static void main(String[] args) {
        String word = "michael";
        String prefix = "michael";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}