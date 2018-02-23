    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int sum = dfs(root);
        return maxSum;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int sum = Math.max(left, right) + node.val;
        maxSum = Math.max(maxSum, left + right + node.val);
        return sum;
    }
