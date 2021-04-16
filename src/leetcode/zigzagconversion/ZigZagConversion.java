package leetcode.zigzagconversion;
/**
 * Z 字形变换
 * 
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * @author ASUS
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		int numRows = 3;
		String res = convert(s, numRows);
		System.out.println(res);

		String res2 = convert2(s, numRows);
		System.out.println(res2);
	}
	
	public static String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}
		int idnex = 0;
		while (idnex < len) {
			for (int i = 0; i < numRows && idnex < len; i++) {
				sb[i].append(c[idnex++]);
			}
			for (int i = numRows-2; i >= 1 && idnex < len; i--) {
				sb[i].append(c[idnex++]);
			}
		}
		for (int i = 1; i < sb.length; i++) {
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
    }
	
	/**
	 * 更快
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert2(String s, int numRows) {
		if(numRows==1){
	         return s;
	     }
	     int internal = (numRows - 1) * 2;
	     char[] chars = s.toCharArray();
	     char[] result=new char[chars.length];
	     int count=0;
	     for (int i = 0; i < numRows; i++) {
	         for (int j = 0; j < chars.length; j += internal) {
	             int index=j+i;
	             if (index>=chars.length){
	                 break;
	             }
	             result[count++]=chars[index];
	             if (i != 0 && i != numRows - 1) {
	                 int ii=((numRows-i)-1)*2+index;
	                 if (ii<chars.length){
	                     result[count++]=chars[ii];
	                 }
	             }
	         }
	     }
	     return new String(result);
    }
}
