class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
}

class Solution {

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        // Build Trie
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board,
                     int row,
                     int col,
                     TrieNode node,
                     List<String> result) {

        char ch = board[row][col];

        // already visited
        if (ch == '#') {
            return;
        }

        TrieNode nextNode = node.children[ch - 'a'];

        // No word starts with this prefix
        if (nextNode == null) {
            return;
        }

        // Word found
        if (nextNode.word != null) {
            result.add(nextNode.word);

            // Prevent duplicate addition
            nextNode.word = null;
        }

        // Mark visited
        board[row][col] = '#';

        // Up
        if (row > 0) {
            dfs(board, row - 1, col, nextNode, result);
        }

        // Down
        if (row < board.length - 1) {
            dfs(board, row + 1, col, nextNode, result);
        }

        // Left
        if (col > 0) {
            dfs(board, row, col - 1, nextNode, result);
        }

        // Right
        if (col < board[0].length - 1) {
            dfs(board, row, col + 1, nextNode, result);
        }

        // Backtrack
        board[row][col] = ch;
    }
}