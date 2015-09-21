package week3Assignment;

import edu.princeton.cs.algs4.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Alexey Kutepov on 10.02.15.
 */
public class Fast {

  public static void main(String[] args) {
    HashSet<String> hashSetLine = new HashSet<String>();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    In in = new In(args[0]);
    Point[] pointList = new Point[in.readInt()];
    Point[] pointListNotSorted = new Point[pointList.length];
    int x, y;
    for (int i = 0; i < pointList.length; i++) {
      x = in.readInt();
      y = in.readInt();
      pointList[i] = new Point(x, y);
      pointListNotSorted[i] = new Point(x, y);
      pointList[i].draw();
    }
    ArrayList<Point> arrayList = new ArrayList<Point>();
    for (int i = 0; i < pointListNotSorted.length; i++) {
      Arrays.sort(pointList, pointListNotSorted[i].SLOPE_ORDER);
      int index = 0, count = 1;
      for (int j = 1; j < pointList.length; j++) {
        if (pointListNotSorted[i].SLOPE_ORDER.compare(pointList[index], pointList[j]) == 0) {
          count++;
          arrayList.add(pointList[j]);
        } else {
          if (count >= 3) {
            solve(arrayList, hashSetLine, pointListNotSorted[i]);
          }
          arrayList.clear();
          arrayList.add(pointList[j]);
          count = 1;
          index = j;
        }
      }
      if (count >= 3) {
        solve(arrayList, hashSetLine, pointListNotSorted[i]);
      }
      arrayList.clear();
    }
  }

  private static void solve(ArrayList<Point> arrayList, HashSet<String> hashSetLine, Point mainPoint) {
    arrayList.add(mainPoint);
    Collections.sort(arrayList);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(arrayList.get(0).toString());
    for (int k = 1; k < arrayList.size(); k++) {
      stringBuilder.append(" -> " + arrayList.get(k).toString());
    }
    if (!hashSetLine.contains(stringBuilder.toString())) {
      hashSetLine.add(stringBuilder.toString());
      StdOut.println(stringBuilder.toString());
      arrayList.get(0).drawTo(arrayList.get(arrayList.size() - 1));
    }
  }
}