package q001to020;

public class Q5LongestPalinSubstring {
	private int maxLength = 1;
	private int maxBegin = 0;
	
	public String longestPalindrome(String s) {
		maxLength = 1; // if only one test is operated for one instance,
		maxBegin = 0;  // these two lines can be deleted.
		int len = s.length();
	    if (len <= 1) return s;
	    
	    for (int i = 0; i < s.length(); i++) {
	    	expand(s, len, i - 1, i + 1);
	    	expand(s, len, i, i+1);
	    }
	    
	    return s.substring(maxBegin, maxBegin + maxLength); 
	}
	
	private void expand(String s, int len, int lo, int hi) {
		while (lo >= 0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
			lo--;
			hi++;
		}
		if (--hi - ++lo + 1 > maxLength) {
			maxBegin = lo;
			maxLength = hi - lo + 1;
		}
		
	}
	
	/**
    public String longestPalindrome(String s) {
        int len = s.length();
        int oddL = 0, oddBegin = 0, oddEnd = 0;
        int evenL = 0, evenBegin = 0, evenEnd = 0;
        int longL = 0, longBegin = 0, longEnd = 0;
        
        for (int i = 0; i < len - 1; i++) {
        	oddBegin = i - 1;
        	oddEnd = i + 1;
        	oddL = 1;
        	while (oddBegin >= 0 && oddEnd < len && s.charAt(oddBegin) == s.charAt(oddEnd)) {
        			oddBegin--;
        			oddEnd++;
        			oddL += 2;
        	}
        	if (oddL > longL) {
        		longL = oddL;
        		longBegin = oddBegin + 1;
        		longEnd = oddEnd - 1;
        	}
        	
        	evenBegin = i;
        	evenEnd = i + 1;
        	evenL = 0;
        	while (evenBegin >= 0 && evenEnd < len && s.charAt(evenBegin) == s.charAt(evenEnd)) {
        			evenBegin--;
        			evenEnd++;
        			evenL += 2;
        	}
        	if (evenL > longL) {
        		longL = evenL;
        		longBegin = evenBegin + 1;
        		longEnd = evenEnd - 1;
        	}
        }
    	
        //System.out.println("Longest sub length: " + longL);
        return s.substring(longBegin, longEnd + 1);
    }
    **/

    
    public static void main(String[] args) {
    	Q5LongestPalinSubstring lps = new Q5LongestPalinSubstring();
    	
    	String a = "abcdefgfedcba";
    	String b = "abba";
    	String c = "abcdefgg";
    	System.out.println(lps.longestPalindrome(a));
    	System.out.println(lps.longestPalindrome(b));
    	System.out.println(lps.longestPalindrome(c));
	}
}
