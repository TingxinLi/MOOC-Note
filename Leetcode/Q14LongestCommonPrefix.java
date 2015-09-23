package q001to020;

public class Q14LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String pre = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	    return pre;
	}
	public static void main(String[] args) {
		Q14LongestCommonPrefix lcp = new Q14LongestCommonPrefix();
		String[] str = {"abcde", "abc", "abcdefg", "abcd"};
		System.out.println(lcp.longestCommonPrefix(str));
	}
}
