// link - https://leetcode.com/problems/word-search/description/

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (dfs(board, word, i, j, 0, visited)){ 
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited){
        int row = board.length;
        int col = board[0].length;

        if (word.length() == index){
            return true; 
        }
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] == true || board[i][j] != word.charAt(index))           return false;
        visited[i][j] = true;
        boolean res = dfs(board, word, i+1, j, index+1, visited) 
        || dfs(board, word, i-1, j, index+1,visited)
        || dfs(board,word, i, j+1, index+1, visited)
        || dfs(board, word, i, j-1, index+1, visited);
        visited[i][j] = false;
        return res;
    }
}
