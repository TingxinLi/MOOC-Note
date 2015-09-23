package q181to200;

public class Q190ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++)
        	result |= ((n >> i) & 1) << (31 - i);
        return result;
    }
    public static void main(String[] args) {
    	Q190ReverseBits rb = new Q190ReverseBits();
    	System.out.println(rb.reverseBits(43261596));
	}
}
