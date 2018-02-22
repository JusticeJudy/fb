    public static TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;   
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
        return; 
    }



// Flatten BST to DLL

    public static TreeNode prev = null;
    public static void flattenBST2DLL(TreeNode root) {
        helper(root);
    }
    
    private static  void  helper(TreeNode node) {
        if (node == null) {
            return;   
        }
        helper(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        helper(node.right);
        return;
    }
