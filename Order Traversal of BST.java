public List<Integer> preorderTraversal(TreeNode root) {
  List<Integer> result = new ArrayList<Integer>();
  Stack<TreeNode> s = new Stack<TreeNode>();
  TreeNode curr = root;
  
  while (!s.isEmpty() || curr != null) {
    if (curr != null) {
      s.push(curr);
      result.add(curr.val);
      curr = curr.left;
    } else {
      curr = s.pop();
      curr = curr.right;
    }
  }
  return result;
}

public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> st = new Stack<TreeNode>();
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) return result;
    TreeNode curr = root;
    st.push(curr);
    while (!st.isEmpty()) {
         curr = st.pop();
        result.add(curr.val);
        if (curr.right != null) st.push(curr.right);
        if (curr.left != null) st.push(curr.left);
    }
    return result;   
}

public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }

public List<Integer> postorderTraversal(TreeNode root) {
  List<Integer> result = new ArrayList<Integer>();
  Stack<TreeNode> s = new Stack<TreeNode>();
  TreeNode curr = root;
  
  while (!s.isEmpty() || curr != null) {
    if (curr != null) {
      s.push(curr);
      result.add(0, curr.val);
      curr = curr.right;
    } else {
      curr = s.pop();
      curr = curr.left;
    }
  }
  return result;
}

