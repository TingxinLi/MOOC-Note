package week3Assignment;

import edu.princeton.cs.algs4.*;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeCom();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    
    private class SlopeCom implements Comparator<Point>{
		@Override
		public int compare(Point arg0, Point arg1) {
			// TODO Auto-generated method stub
			if ( slopeTo(arg0) > slopeTo(arg1)) return 1;
			else if ( slopeTo(arg0) < slopeTo(arg1)) return -1;
			else return 0;
		}
    }
    
    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {	
    	if (this.compareTo(that) == 0) return Double.NEGATIVE_INFINITY;
    	else if (this.x == that.x) return Double.POSITIVE_INFINITY;
    	else if (this.y == that.y) return 0;
    	else return (double)(this.y - that.y) / (this.x - that.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
    	if (this.y < that.y || (this.y == that.y && this.x < that.x)) return -1;
    	else if (this.y == that.y && this.x == that.x) return 0;
    	else return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
    	Point p1 =  new Point(2998, 28352);
    	Point p2 =  new Point(2018, 17782);
    	System.out.println(p1.slopeTo(p2));
    }
}