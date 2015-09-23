package q001to020;

import java.util.Hashtable;

public class Q3LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int result = 1, len = s.length(), cur = 0;
    	if (len == 0) return 0;
    	
    	Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
    	for (int i = 0; i < len; i++) {
    		if (ht.containsKey(s.charAt(i))) {
    			result = result > i - cur ? result : i - cur;
    			cur = ht.get(s.charAt(i)) + 1 > cur ? ht.get(s.charAt(i)) + 1 : cur;
    		}
    		ht.put(s.charAt(i), i);
    	}
    	result = result > len - cur ? result : len - cur;
    	return result;
    }
    
    //up next part is a much faster version to get the result.
    /**
    public int lengthOfLongestSubstring(String s) {
        int[] mOccur = new int[256];
        int maxL = 0;
        for(int i = 0, j = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            ++mOccur[ch];
            while(mOccur[ch] > 1){
                --mOccur[s.charAt(j++)];
            }
            maxL = maxL > i - j + 1 ? maxL : i - j + 1;
        }
        return maxL;
    }
    **/
    
    public static void main(String[] args) {
    	Q3LongestSubStringWithoutRepeat longSS = new Q3LongestSubStringWithoutRepeat();
    	String a = "abcabcabcabcabc";
    	String b = "abcdefghijklmnopoooo";
    	String c = "au";
    	String d = "aab";
    	String e = "abac";
    	String f = "abba";
    	
    	System.out.println(longSS.lengthOfLongestSubstring(a));
    	System.out.println(longSS.lengthOfLongestSubstring(b));
    	System.out.println(longSS.lengthOfLongestSubstring(c));
    	System.out.println(longSS.lengthOfLongestSubstring(d));
    	System.out.println(longSS.lengthOfLongestSubstring(e));
    	System.out.println(longSS.lengthOfLongestSubstring(f));
	}
}
