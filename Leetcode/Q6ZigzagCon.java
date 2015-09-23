package q001to020;

public class Q6ZigzagCon {
    public String convert(String s, int numRows) {
        int len = s.length();
        String[] zigRow = new String[numRows];
        for (int i = 0; i < numRows; i++) zigRow[i] = "";
        int dir = -1, row = 0;
        for ( int i = 0; i < len; i++){
        	if ( row == 0 || row == numRows - 1) dir *= -1;
        	zigRow[row] += s.charAt(i);
        	row += dir;
        	//row %= numRows;
        }
        //String ans = "";
        //for( String zrow : zigRow) ans += zrow;
        // not using String because "+" operation of String is much slower than append of StringBuilder
        StringBuilder ans = new StringBuilder();
        for( String zrow : zigRow) ans.append(zrow);
        return ans.toString();
    }
	public static void main(String[] args) {
		Q6ZigzagCon zzc = new Q6ZigzagCon();
		String a = "abcdefghijkl";
		System.out.println(zzc.convert(a, 3));
		
		String b = "";
		System.out.println(zzc.convert(b, 1));
	}
}
