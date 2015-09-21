package week5;
import edu.princeton.cs.algs4.*;


/**
 * @author Travis
 * KdTree implement by modified BST
 * nearest method implement by DFS method
 */
public class KdTree {
	
	private Node root;  
	private int size;
	
	private class Node {
		private Point2D point;
		private RectHV rect;
		private Node left;
		private Node right;
		private int level;
		
		public Node(Point2D p, RectHV rect) {
			this.rect = rect;
			this.point = p;
			this.left = null;
			this.right = null;
			this.level = 0;
		}

		public Point2D getPoint() {
			return point;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public RectHV getRect() {
			return rect;
		}
	}

    public KdTree() {
    	root = null;
    	size = 0;
    }   
   
    public boolean isEmpty() {
	    return root == null;
    }
    
    public int size()   {
        return size;
    }   // number of points in the set 
   
    /**
     * helper function to insert the new node
     * @param node: parent node of the new node
     * @param p: point of the new node
     * @param rect: rectangle of the new node
     * @param dir: left / right sub node of the parent node
     */
    private void subInsert(Node node, Point2D p, RectHV rect, boolean dir) {
    	Node in = new Node(p, rect);
		in.setLevel(node.getLevel() + 1);
		if (dir) {
			node.setRight(in);
		} else {
		    node.setLeft(in);
		}
    }
    
    public void insert(Point2D p) {
    	if (p == null) throw new java.lang.NullPointerException();
    	
    	if (contains(p)) {
    		return;
    	}
    	
    	if (root == null) {
    		RectHV rootRect = new RectHV(0.0, 0.0, 1.0, 1.0);
    		root = new Node(p, rootRect);
    		size++;
    		return;
    	}
    	
    	boolean beenIn = false;
    	Node find = root;
    	double compare;
    	RectHV rect;
    	while (!beenIn) {
    		RectHV curRect = find.getRect();
    		
    		if (find.getLevel() % 2 == 0) {
    			compare = p.x() - find.getPoint().x();
    			//compare = Point2D.X_ORDER.compare(p, find.getPoint());
    			
                if (compare < 0) {
                	if (find.getLeft() == null) {
                		rect = new RectHV(curRect.xmin(), curRect.ymin(), find.getPoint().x(), curRect.ymax());
        				subInsert(find, p, rect, false);
        				beenIn = true;
       				}
        			else {
        				find = find.getLeft();
        			}
                } else {
                	if (find.getRight() == null) {
                		rect = new RectHV(find.getPoint().x(), curRect.ymin(), curRect.xmax(), curRect.ymax());
                		subInsert(find, p, rect, true);
        				beenIn = true;
       				}
        			else {
        				find = find.getRight();
        			}
                }
    		}
    		else {
    			compare = p.y() - find.getPoint().y();
    			//compare = Point2D.Y_ORDER.compare(p, find.getPoint());
    			
    			if (compare < 0) {
                	if (find.getLeft() == null) {
                		rect = new RectHV(curRect.xmin(), curRect.ymin(), curRect.xmax(), find.getPoint().y());
        				subInsert(find, p, rect, false);
        				beenIn = true;
       				}
        			else {
        				find = find.getLeft();
        			}
                } else {
                	if (find.getRight() == null) {
                		rect = new RectHV(curRect.xmin(), find.getPoint().y(), curRect.xmax(), curRect.ymax());
                		subInsert(find, p, rect, true);
        				beenIn = true;
       				}
        			else {
        				find = find.getRight();
        			}
                }
    		}
    		
    	
    	}
    	size++;
    }  //insertion of new node
   
    public boolean contains(Point2D p) {
    	if (p == null) throw new java.lang.NullPointerException();
    	if (root == null) return false;
    	
  	    boolean cont = false;
  	    Node find = root;
    	double compare;
 	    while (find != null) {
 	    	if (find.getPoint().equals(p)) {
 	    		cont = true;
 	    		break;
 	    	}
 	    	
 	    	//compare = find.getLevel() % 2 == 0 ? Point2D.X_ORDER.compare(p, find.getPoint()) :
 	    		//Point2D.Y_ORDER.compare(p, find.getPoint());
 	    	compare = find.getLevel() % 2 == 0 ? p.x() - find.getPoint().x() : p.y() - find.getPoint().y();
    		
    		if (compare < 0) {
    			find = find.getLeft();
   			}
   			else {
    			find = find.getRight();
    		}

	    }
	    return cont;
    }         // does the set contain point p? 
   
    public void draw() {
    	if (root == null) return;
    	
    	StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.005);
    	root.getPoint().draw();
    	
    	StdDraw.setPenColor(StdDraw.RED);
    	StdDraw.line(root.getPoint().x(), 0, root.getPoint().x(), 1);
    	
    	subDraw(root.getLeft());
    	subDraw(root.getRight());
    } // draw all points to standard draw 
   
    /**
     * helper function to draw the KdTree
     * @param node: the root of the drawing process
     * @param endPo: the x/y end position of the line draw for the root node
     * @param direct: false means root line going left, true means going right
     */
    private void subDraw(Node node) {
    	if (node == null) return;
    	
    	StdDraw.setPenColor(StdDraw.BLACK);
    	node.getPoint().draw();
    	
    	if (node.getLevel() % 2 == 0) {
    		StdDraw.setPenColor(StdDraw.RED);
        	StdDraw.line(node.getPoint().x(), node.getRect().ymin(), node.getPoint().x(), node.getRect().ymax());
    	}
    	else {
    		StdDraw.setPenColor(StdDraw.BLUE);
        	StdDraw.line(node.getRect().xmin(), node.getPoint().y(), node.getRect().xmax(), node.getPoint().y());
    	}
    	
    	subDraw(node.getLeft());
    	subDraw(node.getRight());
    }
    
    public Iterable<Point2D> range(RectHV rect) {
	    Stack<Point2D> inside = new Stack<Point2D>();
	    if (isEmpty()) return inside;
        Stack<Node> trace = new Stack<Node>();
        Node top;
        Point2D p;
        RectHV r;
        
        trace.push(root);
        while (!trace.isEmpty()) {
        	top = trace.pop();
        	p = top.getPoint();
        	r = top.getRect();
        	
        	if (rect.contains(p)) {
        		inside.push(p);
        				
        	}
        	
        	if (top.getLeft() != null && r.intersects(rect)) {
        		trace.push(top.getLeft());
        	}
        	
        	if (top.getRight() != null && r.intersects(rect)) {
        		trace.push(top.getRight());
        	}
        }
	    return inside;
    } // all points that are inside the rectangle 
   
    
    public Point2D nearest(Point2D p)  {
    	if (p == null) throw new java.lang.NullPointerException();
    	if (isEmpty()) return null;
    	
	    Point2D near = null;
	    double smallDis = Double.MAX_VALUE;
	    
	    Stack<Node> trace = new Stack<Node>();
        Node top;
        Point2D point;
        double disLeft;
        double disRight;
        
        trace.push(root);
        while (!trace.isEmpty()) {
        	top = trace.pop();
        	point = top.getPoint();
        	boolean bothIn = false;
        	
        	if (top.getRect().distanceSquaredTo(p) > smallDis) {
        		continue;
        	} // if pruning of this subtree is enable
        	
        	if (point.distanceSquaredTo(p) < smallDis) {
        		near = point;
        		smallDis = point.distanceSquaredTo(p);
        	} // if this point is a nearer point than the current nearest one
        	
        	if (top.getRight() != null && top.getLeft() != null) {
        		disLeft = top.getLeft().getRect().distanceSquaredTo(p);
        		disRight = top.getRight().getRect().distanceSquaredTo(p);
        		if (disLeft <= smallDis && disRight <= smallDis) {
        			bothIn = true;
        			double comparePos = top.getLevel() % 2 == 0 ? p.x() - point.x() : p.y() - point.y();
        			if (comparePos < 0) {
        				trace.push(top.getRight());
        				trace.push(top.getLeft());
        			}
        			else {
        				trace.push(top.getLeft());
        				trace.push(top.getRight());
        			}
        			
        		}
        	} // if both of the subtree are possible, insert the the subtree 
        	  // that is not on the same side of the splitting line first
        	  // so that it will be checked later.
        	
        	if (!bothIn) {
                if (top.getRight() != null && top.getRight().getRect().distanceSquaredTo(p) <= smallDis) {
        		    trace.push(top.getRight());
        	    }
        	    else if (top.getLeft() != null && top.getLeft().getRect().distanceSquaredTo(p) <= smallDis) {
        		    trace.push(top.getLeft());
        	    }
        	} // if not both of the subtree are possible, insert the one that is possible
        }
        
	    return near;
    }         // a nearest neighbor in the set to point p; null if the set is empty 

    
    public String traverse(){
    	StringBuffer sb = new StringBuffer();
    	sb.append("(" + root.getPoint().x() + " , " + root.getPoint().y() + ")  Level: " + root.getLevel() + " ");
    	sb.append(subTra(root.getLeft()));
    	sb.append(subTra(root.getRight()));
    	return sb.toString();
    } // To Print the DFS traverse of the KdTree
    
    private String subTra(Node node){
    	if (node == null){
    		return "";
    	}
    	
        StringBuffer sb = new StringBuffer();
        sb.append("\n(" + node.getPoint().x() + " , " + node.getPoint().y() + ") Level: " + node.getLevel());
    	sb.append(subTra(node.getLeft()));
    	sb.append(subTra(node.getRight()));
    	return sb.toString();
    } // Helper function of travser()
    
    
    public static void main(String[] args)  {
	    Point2D p = new Point2D(0.29, 0.13);
	    Point2D p2 = new Point2D(0.86, 0.21);
	    Point2D p3 = new Point2D(0.74, 0.83);
	    Point2D p4 = new Point2D(0.68, 0.37);
	    Point2D p5 = new Point2D(0.04, 0.02);
	    Point2D p6 = new Point2D(0.56, 0.98);
	    Point2D p7 = new Point2D(0.67, 0.62);
	    Point2D p8 = new Point2D(0.05, 0.75);
	 
	    KdTree kt = new KdTree();
	    kt.insert(p);
	    kt.insert(p2);
	    kt.insert(p3);
	    kt.insert(p4);
	    kt.insert(p5);
	    kt.insert(p6);
	    kt.insert(p7);
	    kt.insert(p8);
        System.out.println(kt.traverse());
    }   // unit testing of insert & size & inEmpty & contains method
    
}
