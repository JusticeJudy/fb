  static List<int[]> result = new ArrayList<int[]>();
    static boolean found = false;
    public static List<int[]> possiblePath(boolean[][] grid, int x1, int y1, int x2, int y2) {
        if (grid == null || grid.length == 0) {
            return null;   
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        helper(grid, visited, x1, y1, x2, y2, new ArrayList<int[]>());
        return result;
    }
    
    private static void helper(boolean[][] grid, boolean[][] visited, int x, int y, int x2, int y2, List<int[]> list) {
        if (x == x2 && y == y2) {
            List<int[]> newList = new ArrayList<int[]>(list);
            result.addAll(newList);
            result.add(new int[]{x, y});
            found = true;
            return;   
        }
        
        if (found || x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y]) {
            return;   
        }
        
        visited[x][y] = true;
        list.add(new int[]{x, y});
        helper(grid, visited, x + 1, y, x2, y2, new ArrayList<int[]>(list));
        helper(grid, visited, x - 1, y, x2, y2, new ArrayList<int[]>(list));
        helper(grid, visited, x, y + 1, x2, y2, new ArrayList<int[]>(list));
        helper(grid, visited, x, y - 1, x2, y2, new ArrayList<int[]>(list));
        
    }
