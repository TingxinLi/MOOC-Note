package q181to200;

public class Q191Number1Bits {
    public int hammingWeight(int n) {
    	int count = 0, i = 32; 
    	while (i > 0){
    		count += n & 1;
    		n >>= 1;
    		i--;
    	}
        return count;
    }
    public static void main(String[] args) {
    	Q191Number1Bits n1 = new Q191Number1Bits();
    	System.out.println(n1.hammingWeight(11));
	}
}
