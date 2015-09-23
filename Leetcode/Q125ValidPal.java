package q121to140;

public class Q125ValidPal {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        if (sArray.length == 0) return true;
        int indexLo = 0, indexHi = sArray.length - 1;
        while ( indexHi - indexLo > 0){
        	boolean lo = false, hi = false;
        	int xlo = sArray[indexLo], xhi = sArray[indexHi];
        	while (!lo ){
        		xlo = sArray[indexLo];
        		if ( xlo >= 65 && xlo <= 90) { 
        			xlo += 32; 
        			lo = true;
        		}
        		else if ( xlo >= 97 && xlo <= 122 || xlo >= 48 && xlo <= 57) lo = true;
        		else indexLo++;
        		if ( hi == false && indexLo > indexHi) return true;
        	}
        	while (!hi){
        		xhi = sArray[indexHi];
        		if ( xhi >= 65 && xhi <= 90) { 
        			xhi += 32; 
        			hi = true;
        		}
        		else if ( xhi >= 97 && xhi <= 122 || xhi >= 48 && xhi <= 57) hi = true;
        		else indexHi--;
        	}
        	if ( xlo != xhi) return false;
        	indexLo++;
        	indexHi--;
        }
    	return true;
    }
	public static void main(String[] args) {
		Q125ValidPal vp = new Q125ValidPal();
		String a = "A man, a plan, a canal: Panama";
		String b = "race a car";
		String c = "a";
		String d = ".,";
		System.out.println(vp.isPalindrome(a));
		System.out.println(vp.isPalindrome(b));
		System.out.println(vp.isPalindrome(c));
		System.out.println(vp.isPalindrome(d));
	}
}
