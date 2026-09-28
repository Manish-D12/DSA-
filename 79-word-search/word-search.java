class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(board, word, i, j, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) return true;   // matched all chars
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || board[i][j] != word.charAt(k)) return false;

        char tmp = board[i][j];
        board[i][j] = '#';                     // mark visited

        boolean found = dfs(board, word, i + 1, j, k + 1)
                     || dfs(board, word, i - 1, j, k + 1)
                     || dfs(board, word, i, j + 1, k + 1)
                     || dfs(board, word, i, j - 1, k + 1);

        board[i][j] = tmp;                     // restore (backtrack)
        return found;
    }
}