package leetcode.sudokusolver;

/**
 * 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * @author ASUS
 */
public class SudokuSolver {

    static char[][] board =
            {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
            };

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveSudoku(board);
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}


class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        solveSudokuHelper(board, 0, 0);

    }

    public boolean solveSudokuHelper(char[][] board, int row, int col) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        while (row < 9 && col < 9) {
            // find the empty cell
            if (board[row][col] == '.') break;
            if (col == 8) {
                col = 0;
                row++;
            } else {
                col++;
            }
        }
        // check out of bound after getting location
        if (row >= 9) return true;

        // [newRow][newCol] == next cell
        int newRow = row + col / 8;
        int newCol = (col + 1) % 9;

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = (char) (num + '0');
                boolean result = solveSudokuHelper(board, newRow, newCol);
                if (result) return true;
                // backtracing
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, int num) {
        // check column and row
        for (int i = 0; i < 9; i++)
            if (board[row][i] == num + '0' || board[i][col] == num + '0')
                return false;
        // check square
        int rowoff = (row / 3) * 3; // ex. 4 -> 3
        int coloff = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowoff + i][coloff + j] == num + '0') return false;
            }
        }
        return true;
    }
}

class Solution2 {
    int N = 9;
    int M = 1 << N;
    int[] count = new int[M];
    int[] bit = new int[M];
    int[] row = new int[N];
    int[] col = new int[N];
    int[][] form = new int[3][3];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < N; i++) {
            bit[1 << i] = i;
        }
        for (int i = 0; i < M; i++) {
            int t = 0;
            for (int j = i; j > 0; j -= lowbit(j)) {
                t++;
            }
            count[i] = t;
        }
        for (int i = 0; i < N; i++) {
            row[i] = col[i] = (1 << N) - 1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                form[i][j] = (1 << N) - 1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    cnt++;
                else {
                    int n = board[i][j] - '1';
                    row[i] -= 1 << n;
                    col[j] -= 1 << n;
                    form[i / 3][j / 3] -= 1 << n;
                }
            }
        }
        dfs(cnt, board);
    }

    private boolean dfs(int cnt, char[][] board) {
        if (cnt == 0)
            return true;
        int min = 10;
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    if (count[get(i, j)] < min) {
                        min = count[get(i, j)];
                        x = i;
                        y = j;
                    }

                }
            }
        }
        for (int i = get(x, y); i > 0; i -= lowbit(i)) {
            int t = bit[lowbit(i)];
            row[x] -= 1 << t;
            col[y] -= 1 << t;
            form[x / 3][y / 3] -= 1 << t;
            board[x][y] = (char) (t + '1');
            if (dfs(cnt - 1, board))
                return true;
            row[x] += 1 << t;
            col[y] += 1 << t;
            form[x / 3][y / 3] += 1 << t;
            board[x][y] = '.';
        }
        return false;
    }

    private int get(int i, int j) {
        return row[i] & col[j] & form[i / 3][j / 3];
    }

    public int lowbit(int x) {
        return x & -x;
    }
}


