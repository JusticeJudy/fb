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
      TreeNode tmp = s.pop();
      curr = tmp.right;
    }
  }
  return result;
}


public List<Integer> inorderTraversal(TreeNode root) {
  List<Integer> result = new ArrayList<Integer>();
  Stack<TreeNode> s = new Stack<TreeNode>();
  TreeNode curr = root;
  
  while (!s.isEmpty() || curr != null) {
    if (curr != null) {
      s.push(curr);
      curr = curr.left;
    } else {
      TreeNode tmp = s.pop();
      result.add(curr.val);
      curr = tmp.right;
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
      TreeNode tmp = s.pop();
      curr = tmp.left;
    }
  }
  return result;
}

