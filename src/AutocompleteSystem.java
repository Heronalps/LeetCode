import java.util.*;

class AutocompleteSystem {

    class Node implements Comparable<Node>{
        String s;
        int times;
        public Node(String s, int times) {
            this.s = s;
            this.times = times;
        }
        @Override
        public int compareTo(Node a) {
            if (this.times == a.times) {
                return this.s.compareTo(a.s);
            }
            return a.times - this.times;
        }
    }

    class Trie {
        int times;
        Trie[] children;
        public Trie() {
            this.children = new Trie[27]; //Plus space
        }
    }
    private int toInt(char c) {
        return c != ' '? c - 'a' : 26;
    }
    private char toChar(int t) {
        return t == 26 ? ' ' : (char) (t + (int) 'a');
    }

    private void constructTrie(Trie root, String sentence, int times) {
        for (int i = 0; i < sentence.length(); i++) {
            if (root.children[toInt(sentence.charAt(i))] == null) {
                root.children[toInt(sentence.charAt(i))] = new Trie();
            }
            root = root.children[toInt(sentence.charAt(i))];
        }
        root.times += times;
    }


    Trie rootOrigin = new Trie();

    public AutocompleteSystem(String[] sentences, int[] times) {
        //Construct Trie
        for (int i = 0; i < times.length; i++) {
            constructTrie(rootOrigin, sentences[i], times[i]);
        }
    }

    private List<Node> lookup(Trie root, String str) {
        List<Node> result = new ArrayList<>();
        // Traverse to last letter
        for (int i = 0; i < str.length(); i++) {
            if (root.children[toInt(str.charAt(i))] == null) {
                return result;
            }
            root = root.children[toInt(str.charAt(i))];
        }
        traverse(root, str, result);
        return result;
    }

    private void traverse(Trie root, String currStr, List<Node> result) {
        if (root.times > 0) {
            result.add(new Node(currStr, root.times));
        }
        for (int i = 0; i < 27; i++) {
            if (root.children[i] != null) {
                traverse(root.children[i], currStr + toChar(i), result);
            }
        }
    }
    // currSent should be shared among input() invocations
    String currSent = "";
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            constructTrie(rootOrigin, currSent, 1);
            currSent = "";
            return result;
        }
        currSent += c;
        List<Node> list = lookup(rootOrigin, currSent);

        //Sort result
        Collections.sort(list);
        System.out.println("len : " + list.size());
        for (Node n : list) {
            System.out.println("str : " + n.s);
            System.out.println("times : " + n.times);
        }

        for (int i = 0; i < 3; i++) {
            if (i < list.size()) {
                result.add(list.get(i).s);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] sentences = {"i love you","island","iroman","i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem sys = new AutocompleteSystem(sentences, times);
        sys.input('w');
        sys.input(' ');
        sys.input('a');
        sys.input('#');
        sys.input('i');
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */