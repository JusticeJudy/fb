public int[] leftMostOne(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;   
        }
        int row = 0, col = 0;
        int leftMostRow = binarySearch(matrix[0], matrix[0].length - 1);
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][leftMostRow] == 0) {
                col = leftMostRow;
                row = i;
                continue;
            } 
            leftMostRow = binarySearch(matrix[i], leftMostRow);
        }
        return new int[] {row, col};
    }
    private int binarySearch(int[] nums, int rightBound) {
        int start = 0;
        int end = rightBound;
        while (start + 1 < end) {
            int mid = (end - start)/2 + start;
            if (nums[mid] == 1) {
                end = mid;   
            } else {
                start = mid;   
            }
        }
        if (nums[start] == 1) {
            return start;   
        } 
        return end;
    }
