package q161to180;

public class Q171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int num = 0;
        char[] title = s.toCharArray();
        for (int i = 0; i < title.length; i++)
        	num = num * 26 + (int)title[i] + 1 - (int)'A';
        return num;
    }
	public static void main(String[] args) {
		Q171ExcelSheetColumnNumber toN = new Q171ExcelSheetColumnNumber();
		System.out.println(toN.titleToNumber("A"));
		System.out.println(toN.titleToNumber("AB"));
		System.out.println(toN.titleToNumber(""));
	}
}
