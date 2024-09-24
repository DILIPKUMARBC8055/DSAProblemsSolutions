class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie obj = new Trie();
        int max = 0;
        for (int i : arr1) {
            obj.insert(Integer.toString(i));
        }
        for (int i : arr2) {
            int x = obj.startsWith(Integer.toString(i));
            if(x>max)
            {
                max=x;
            }
        }
        return max;
    }

}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('/');

    }

    public void insert(String word) {
        insert(root, word);
    }

    private void insert(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int index = word.charAt(0) - '0';
        TrieNode child = root.children[index];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }
        insert(child, word.substring(1));
    }

    public int startsWith(String word) {
        return startsWith(root, word, 0);
    }

    private int startsWith(TrieNode root, String word, int length) {
        if (word.length() == 0) {
            return length;
        }
        int index = word.charAt(0) - '0';
        TrieNode child = root.children[index];
        if (child == null) {
            return length;
        }
        return startsWith(child, word.substring(1), length + 1);
    }

}

class TrieNode {
    char data;
    int child;
    TrieNode children[];
    boolean isTerminating;

    public TrieNode(char data) {
        this.data = data;
        children = new TrieNode[10];
    }
}