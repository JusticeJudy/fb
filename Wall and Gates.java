public void wallsAndGates(int[][] rooms) {
        // write your code here
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == 0) {
                    dfs(rooms, row, col, 0);
                }
            }
        }
        return;
    }
    
    private void dfs(int[][] rooms, int x, int y, int distance) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < 0 || rooms[x][y] < distance) {
            return;
        }
        rooms[x][y] = distance;
        dfs(rooms, x + 1, y,distance + 1);
        dfs(rooms, x - 1, y, distance + 1);
        dfs(rooms, x, y + 1, distance + 1);
        dfs(rooms, x, y - 1, distance + 1);
    }
