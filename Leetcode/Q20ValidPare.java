package q001to020;

public class Q20ValidPare {
    public boolean isValid(String s) {
        if ( s.length() % 2 != 0 || s.length() == 0) return false;
        char[] left = new char[s.length()];
        int pointer = 0;
        left[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++){
        	if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
        		left[ ++pointer ] = s.charAt(i);
        	}
        	if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
        		if ( s.charAt(i) == ')' )  if ( left[ pointer ] != '(') return false; 
        		if ( s.charAt(i) == '}' )  if ( left[ pointer ] != '{') return false; 
        		if ( s.charAt(i) == ']' )  if ( left[ pointer ] != '[') return false; 
        		if ( pointer == 0 ) left[ pointer ] = ' ';
        		else left[ pointer-- ] = ' ';
        	}
        }
        if ( left[0] != ' ') return false;
    	return true;
    }
    public static void main(String[] args) {
    	Q20ValidPare vp = new Q20ValidPare();
    	String a = "(){}[]";
    	String b = "((([[]";
    	String c = "(())]]";
    	System.out.println(vp.isValid(a));
    	System.out.println(vp.isValid(b));
    	System.out.println(vp.isValid(c));
	}
}
