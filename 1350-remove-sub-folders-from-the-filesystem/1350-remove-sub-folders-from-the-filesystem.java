class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();

        
        for (String path : folder) {
            trie.insert(path.split("/"), trie.root, 1); 
        }

        List<String> result = new ArrayList<>();
        trie.collectFolders(trie.root, new StringBuilder(), result);
        return result;
    }
}

class TrieNode {
    boolean ending;
    HashMap<String, TrieNode> children;

    public TrieNode() {
        ending = false;
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String[] parts, TrieNode root, int index) {
        if (index == parts.length) {
            root.ending = true;
            return;
        }

        String part = parts[index];
        TrieNode child;

        if (root.children.containsKey(part)) {
            child = root.children.get(part);
        } else {
            child = new TrieNode();
            root.children.put(part, child);
        }

        if (!root.ending) {
            insert(parts, child, index + 1);
        }
    }

    public void collectFolders(TrieNode node, StringBuilder path, List<String> result) {
        if (node.ending) {
            result.add(path.toString());
            return;
        }

        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            int lengthBefore = path.length();
            path.append("/").append(entry.getKey());
            collectFolders(entry.getValue(), path, result);
            path.setLength(lengthBefore);
        }
    }
}
