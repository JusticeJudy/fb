  public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        
        return traverse(root, set, k);
    }
    
    private boolean traverse(TreeNode node, Set<Integer> set, int k) {
        if (node == null) {
            return false;
        }
        
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return traverse(node.left, set, k) || traverse(node.right, set, k);
    }
