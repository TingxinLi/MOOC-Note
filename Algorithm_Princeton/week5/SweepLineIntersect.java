package week5;

import java.util.ArrayList;

/**
 * @author Travis
 * This class is for calculation of Exercise 5.2 the first question
 */
public class SweepLineIntersect {

	private ArrayList<Line> lineSet;
	
	private class Line implements Comparable<Line>{
		int xMin;
		int xMax;
		int yMin;
		int yMax;
		boolean ver;
		
		public Line(int xMin, int yMin, int xMax, int yMax, boolean ver) {
			this.xMin = xMin;
			this.yMin = yMin;
			this.xMax = xMax;
			this.yMax = yMax;
			this.ver = ver;
		}

		public int getxMin() {
			return xMin;
		}

		public int getxMax() {
			return xMax;
		}

		public int getyMin() {
			return yMin;
		}

		public int getyMax() {
			return yMax;
		}
		
		public boolean isVer() {
			return ver;
		}
		
		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			return isVer() ? this.xMin - o.xMin : this.yMin - o.yMin;
		}


	}
	
	public SweepLineIntersect() {
		lineSet = new ArrayList<Line>();
	}
	
	public void insert(int xMin, int yMin, int xMax, int yMax) throws java.util.NoSuchElementException{
		if (!(xMin == xMax || yMin == yMax)) throw new java.util.NoSuchElementException();
		
		Line line = new Line(xMin, yMin, xMax, yMax, xMin == xMax);
		lineSet.add(line);
		
	}
	
	public static void main(String[] args) {
		
	}	
}
