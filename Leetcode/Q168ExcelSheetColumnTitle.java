package q161to180;

public class Q168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String title = "";
        while ( n > 0){
        	title = (char)('A' + ( n - 1 ) % 26) + title;
        	n = (n -1) / 26;
        }
        return title;
    }
    public static void main(String[] args) {
    	Q168ExcelSheetColumnTitle toT = new Q168ExcelSheetColumnTitle();
    	System.out.println(toT.convertToTitle(0));
    	System.out.println(toT.convertToTitle(26));
    	System.out.println(toT.convertToTitle(28));
	}
}
