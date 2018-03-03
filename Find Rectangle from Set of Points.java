// 最简单的方法，四个for循环，每一层循环每一个点，判断这四个点是否能组成矩形，答案是O(n^4)
// 题目里面说到四个点组成平行于坐标轴的矩形，所以其实我们只用for循环3次，再判断另一个点是否存在，即可判断是否能组成矩形，O(n^3)
// 再进行优化，对于四个点组成平行于坐标轴的矩形ABCD(顺时针算点，A点是左下角的点)，满足A.x=B.x,C.x=D.x, A.y=D.y,B.y=C.y，
  // 我们只需要知道对角的两个点，即可推出其他的两个点，因此我们只需要两次for循环来枚举对角的两个点，再判断要组成的矩形的剩下两个点，复杂度O(n^2)

public boolean findRectangel(int[][] points) {
  Set<List<Integer>> set = new HashSet<List<Integer>>();
  for (int[] point : points) {
    set.add(Arrays.asList(point[0], point[1]);
  }
  for (int i = 0; i < points.length; i++) {
    for (int j = i + 1; j < points.length; j++) {
    // skip points that is vertical or horizontal to it
      if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
        continue;
      }
    // check if there exists a point with point i's x val as x val, and point i's y val as y val
      if (set.contains(Arrays.asList(points[i][0], points[j][1])) &&
        set.contains(Arrays.asList(point[j][0], point[i][1]))) {
          return true;
        }
    }
  }
  return false;
}


public String rectangle(Point[] pointSet) {
    Set<Long> hashtable = new HashSet<Long>();
    for(int i = 0; i < pointSet.length; i++) {
        hashtable.add(hash(pointSet[i].x, pointSet[i].y));
    }
    for(int i = 0; i < pointSet.length; i++) {
        for(int j = 0; j < pointSet.length; j++) {
            if(pointSet[i].x < pointSet[j].x && pointSet[i].y < pointSet[j].y) {
                long temp1 = hash(pointSet[i].x, pointSet[j].y);
                long temp2 = hash(pointSet[j].x, pointSet[i].y);
                if(hashtable.contains(temp1) && hashtable.contains(temp2)) {
                    return "YES";
                }
            }
        }
    }
    return "NO";
}
