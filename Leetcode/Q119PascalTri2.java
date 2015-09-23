package q101to120;
import java.util.*;

public class Q119PascalTri2 {
    public List<Integer> getRow(int rowIndex) {
    	java.util.List<Integer> row = new java.util.ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for(int j=i-1; j>0; j--) {
                row.set( j, row.get(j-1) + row.get(j) );
            }
        }
    	return row;
    }
    public static void main(String[] args) {
		Q119PascalTri2 pt2 = new Q119PascalTri2();
		java.util.List<Integer> a = new java.util.ArrayList<Integer>();
		a = pt2.getRow(1);
		for(int i = 0;i < a.size(); i ++){
	        System.out.println(a.get(i));
	    }
	}
}
