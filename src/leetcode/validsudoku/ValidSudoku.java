package leetcode.validsudoku;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，
 * 验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @author ASUS
 */
public class ValidSudoku {
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

    }

}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
//    	// check each row
//    	for (int row = 0; row < 9; row++) {
//			boolean[] taken = new boolean[9];
//			for (int i = 0; i < 9; i++) {
//				char c= board[row][i];
//				if (c != '.') {
//					int num = c - '1';
//					if (taken[num] == true) return false;
//					else taken[num] = true;
//				}		
//			}
//		}
//    	// check each column
//    	for (int col = 0; col < 9; col++) {
//			boolean[] taken = new boolean[9];
//			for (int i = 0; i < 9; i++) {
//				char c= board[i][col];
//				if (c != '.') {
//					int num = c - '1';
//					if (taken[num] == true) return false;
//					else taken[num] = true;
//				}		
//			}
//		}
        // check each column
        for (int i = 0; i < 9; i++) {
            boolean[] rowTaken = new boolean[9];
            boolean[] colTaken = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char row = board[j][i];
                char col = board[i][j];
                if (row != '.') {
                    int num = row - '1';
                    if (rowTaken[num] == true) return false;
                    else rowTaken[num] = true;
                }
                if (col != '.') {
                    int num = col - '1';
                    if (colTaken[num] == true) return false;
                    else colTaken[num] = true;
                }
            }
        }
        // check each 3x3 square
        for (int box = 0; box < 9; box++) {
            boolean[] taken = new boolean[9];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char c = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if (c != '.') {
                        int num = c - '1';
                        if (taken[num] == true) return false;
                        else taken[num] = true;
                    }
                }
            }
        }
        return true;
    }
}