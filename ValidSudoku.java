// link- https://leetcode.com/problems/valid-sudoku/description/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == '.') {
              continue;
            }
            int num = board[i][j] - '1';
            if (rows[i][num]) {
              return false;
            }
            rows[i][num] = true;
            if (columns[j][num]) {
              return false;
            }
            columns[j][num] = true;
            if (squares[(i / 3) * 3 + j / 3][num]) {
              return false;
            }
            squares[(i / 3) * 3 + j / 3][num] = true;
          }
        }
        return true;
    }
}

// Second Approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}
}
