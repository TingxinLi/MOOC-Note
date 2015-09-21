package week5Assignment;

import edu.princeton.cs.algs4.*;

import java.util.TreeSet;

/**
 * @author Travis
 * use java.util.TreeSet to implement the data structure
 * under the hood, it is implement by red-black tree
 */
public class PointSET {
	
	private TreeSet<Point2D> pointSet;
    
    public PointSET() {
	   pointSet = new TreeSet<Point2D>();
    }  // construct an empty set of points 
   
    public boolean isEmpty() {
	    return pointSet.size() == 0 || pointSet.isEmpty();
    }
   
    public int size()   {
        return pointSet.size();
    }   // number of points in the set 
   
    public void insert(Point2D p) {
    	if (p == null) throw new java.lang.NullPointerException();
    	
	    pointSet.add(p);
    }  // add the point to the set (if it is not already in the set)
   
    public boolean contains(Point2D p) {
    	if (p == null) throw new java.lang.NullPointerException();
    	
  	    return pointSet.contains(p);
    }         // does the set contain point p? 
   
    public void draw() {
    	for (Point2D p : pointSet) {
 		   p.draw();
 	    }
    }                        // draw all points to standard draw 
   
    public Iterable<Point2D> range(RectHV rect) {
    	if (rect == null) throw new java.lang.NullPointerException();
    	
	    Stack<Point2D> inside = new Stack<Point2D>();
	    for (Point2D p : pointSet) {
		   if (rect.contains(p)) {
			   inside.push(p);
		   }
	    }
	    return inside;
    }  // all points that are inside the rectangle 
   
    public Point2D nearest(Point2D p) {
    	if (p == null) throw new java.lang.NullPointerException();
    	if (isEmpty()) return null;
    	
	    Point2D near = null;
	    double smallDis = Double.MAX_VALUE;
	    double dis;
	    for (Point2D point : pointSet) {
	    	dis = point.distanceTo(p);
		    if (dis < smallDis) {
				 near = point;
				 smallDis = dis;
		    }
	    }
	    return near;
    }           // a nearest neighbor in the set to point p; null if the set is empty 

    public static void main(String[] args)  {
    	Point2D p = new Point2D(1.1, 2.2);
	    Point2D p2 = new Point2D(1.0, 2.3);
	    Point2D p3 = new Point2D(1.5, 1.5);
	    Point2D p4 = new Point2D(0.8, 1.3);
	    Point2D p5 = new Point2D(0.6, 1.4);
	    Point2D p6 = new Point2D(0.7, 0.7);
	    Point2D p7 = new Point2D(1.0, 2.3);
	    PointSET kt = new PointSET();
	    kt.insert(p);
	    kt.insert(p2);
	    kt.insert(p3);
	    kt.insert(p4);
	    kt.insert(p5);
	    kt.insert(p6);
	    kt.insert(p7);
	    System.out.println(kt.contains(p2));
	    System.out.println(kt.isEmpty());
        System.out.println(kt.size());
        Point2D p8 = new Point2D(1.2, 1.2);
        System.out.println(kt.contains(p7));
        System.out.println(kt.contains(p8));
        System.out.println(kt.contains(p3));
    }                // unit testing of the methods (optional) 
    
}
