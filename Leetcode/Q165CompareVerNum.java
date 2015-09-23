package q161to180;

public class Q165CompareVerNum {
    public int compareVersion(String version1, String version2) {
        String [] ver1 =  version1.split("\\.");
        String [] ver2 =  version2.split("\\.");
        int dotNum = 0;
        while (ver1.length > dotNum && ver2.length > dotNum){
        	if ( Integer.parseInt(ver1[dotNum]) > Integer.parseInt(ver2[dotNum]) ) return 1;
        	else if ( Integer.parseInt(ver1[dotNum]) < Integer.parseInt(ver2[dotNum]) ) return -1;
        	dotNum ++;
        }
        if ( ver1.length > ver2.length && Integer.parseInt(ver1[dotNum]) != 0) return 1;
        else if ( ver1.length < ver2.length && Integer.parseInt(ver2[dotNum]) != 0) return -1;
        else return 0;
    }
    public static void main(String[] args) {
		Q165CompareVerNum comVN = new Q165CompareVerNum();
		System.out.println(comVN.compareVersion("1.5", "2.3"));
		System.out.println(comVN.compareVersion("1", "2"));
		System.out.println(comVN.compareVersion("01", "2"));
		System.out.println(comVN.compareVersion("01", "1"));
		System.out.println(comVN.compareVersion("1", "1.1"));
		System.out.println(comVN.compareVersion("2.3", "2.2"));
		System.out.println(comVN.compareVersion("2.3.2", "2.3.2.1"));
		System.out.println(comVN.compareVersion("2.3.2", "2.3.2.0"));
	}
}
