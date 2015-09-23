package q001to020;

public class Q9PalindroneNumber {
	
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		int xRev = 0, xCopy = x;
		while (xCopy >= 10) {
			xRev = xRev * 10 + xCopy % 10;
			xCopy /= 10;
		}
		return xRev == x / 10 || xCopy == x % 10;
	} //this is the fastest one
	
	/**
	public boolean isPalindrome(int x) {
	    if (x == -2147483648 || x < 0) return false;
	    int xCopy = x, degree = 1, upDegree = 1;
	    while(xCopy > 9) {
	    	xCopy /= 10;
	    	degree *= 10;
	    }
	    //System.out.println(degree);
	    while (degree > upDegree) {
	    	int hi = x / degree % 10;
	    	int lo = x / upDegree % 10;
	    	if (hi != lo) {
	    		return false;
	    	}
	    	degree /= 10;
	    	upDegree *= 10;
	    }
	    return true;
	}
	**/
    /**
	public boolean isPalindrome(int x) {
		if ( x ==-2147483648 || x < 0) return false;
		if ( x < 10) return true;
		int xRev = 0;
		//int flag =  x < 0 ? -1 : 1;
		int xPo = x; //= x * flag;
		while ( xPo > 0){
			xRev = xRev * 10 + xPo % 10;
			xPo /= 10;
			if ( xRev < 1000000000 && xRev > 214748364) return false;
		}
		//System.out.println(xRev);
		if (xRev == x) return true;
		return false;
    }
    **/
	public static void main(String[] args) {
		Q9PalindroneNumber pn = new Q9PalindroneNumber();
		System.out.println(pn.isPalindrome(12321)); // true
		System.out.println(pn.isPalindrome(-12321)); // false
		System.out.println(pn.isPalindrome(1)); //true
		System.out.println(pn.isPalindrome(2147483164)); //false
		System.out.println(pn.isPalindrome(1000000001)); //true
	}
}
