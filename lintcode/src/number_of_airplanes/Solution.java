package number_of_airplanes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  class Point implements Comparable<Point> {
    int time;
    int flyingFlag;

    Point(int time, int flag) {
      this.time = time;
      flyingFlag = flag;
    }

    public int compareTo(Point point) {
      if (this.time == point.time) {
        return this.flyingFlag - point.flyingFlag;
      } else {
        return this.time - point.time;
      }
    }
  }

  /**
   * @param intervals: An interval array
   * @return: Count of airplanes are in the sky.
   */
  public int countOfAirplanes(List<Interval> airplanes) {
    if (airplanes == null || airplanes.size() == 0) {
      return 0;
    }
    int n = airplanes.size();
    int max = 0;
    int count = 0;
    List<Point> list = new ArrayList<Point>();
    for (int i = 0; i < n; i++) {
      list.add(new Point(airplanes.get(i).start, 1));
      list.add(new Point(airplanes.get(i).end, 0));
    }
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).flyingFlag == 1) {
        count++;
        max = Math.max(max, count);
      } else {
        count--;
      }
    }
    return max;
  }
}
