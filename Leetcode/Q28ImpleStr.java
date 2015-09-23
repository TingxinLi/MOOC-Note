package q021to040;

public class Q28ImpleStr {
    public int strStr(String haystack, String needle) {
    	if ( needle.length() == 0 ) return 0;
        if ( needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
        	if (needle.equals(haystack.substring(i, i + needle.length()))) return i;
        return -1;
    }
    public static void main(String[] args) {
    	Q28ImpleStr is = new Q28ImpleStr();
    	System.out.println(is.strStr("abcdefghijk", "hij"));
    	System.out.println(is.strStr("abcdefghijk", "hik"));
	}
}
