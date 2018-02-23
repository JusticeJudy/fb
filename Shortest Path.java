    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        Queue<Point> q = new LinkedList<Point>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(source);
        int dist = 0;
        
        while (!q.isEmpty()) {
            int i = q.size();
            while (i > 0) {
                Point curr = q.poll();
                if (curr.x == destination.x && curr.y == destination.y) {
                    return dist;   
                }
                int x = curr.x;
                int y = curr.y;
                
                helper(x+1, y+2, q, visited, grid);
                helper(x+1, y-2, q, visited, grid);
                helper(x-1, y+2, q, visited, grid);
                helper(x-1, y-2, q, visited, grid);
                helper(x+2, y+1, q, visited, grid);
                helper(x+2, y-1, q, visited, grid);
                helper(x-2, y+1, q, visited, grid);
                helper(x-2, y-1, q, visited, grid);
                i--;
            }
            dist++;
        }
        return -1;
    }
    
    private void helper(int x, int y, Queue<Point> q, boolean[][] visited, boolean[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return;   
        }
        visited[x][y] = true;
        if (!grid[x][y]) {
            q.offer(new Point(x, y));
            
        }
        return;
    }
