package q021to040;

public class Q38CountAndSay {
    public String countAndSay(int n) {
        if ( n == 1 ) return "1";
    	String s = new String();
    	StringBuffer sb = new StringBuffer();
    	s = "1";
        int count;
        for (int i = 2; i <= n; i++){
        	count = 1;
        	char temp = s.charAt(0);
        	for ( int j = 0; j < s.length()-1; j ++){
        		if (s.charAt(j+1)== s.charAt(j)) count++;
        		else {
        			sb.append(count);
        			sb.append(temp);
        			count = 1;
        			temp = s.charAt(j+1);
        		}
        	}
        	sb.append(count);
        	sb.append(s.charAt( s.length() - 1 ));
        	s = sb.toString();
        	sb.delete(0, sb.length());
        }
        return s;
    }
    public static void main(String[] args) {
    	Q38CountAndSay cas = new Q38CountAndSay();
    	System.out.println(cas.countAndSay(2));
    	System.out.println(cas.countAndSay(3));
    	System.out.println(cas.countAndSay(4));
	}
}
