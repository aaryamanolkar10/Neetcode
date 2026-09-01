class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {

        if (index == word.length()) {
            return node.isWord;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {
            int i = ch - 'a';

            if (node.children[i] == null) {
                return false;
            }

            return searchHelper(word, index + 1, node.children[i]);
        }

        // '.' means any character
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                if (searchHelper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
        }

        return false;
    }
}