    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = depth(root);
        return maxPath;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        int depth = Math.max(left, right) + 1;
        maxPath = Math.max((left + right), maxPath);
        return depth;
    }
}
