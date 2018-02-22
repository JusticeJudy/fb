314. Binary Tree Vertical Order Traversal

    private class QueueNode {
        int idx;
        TreeNode node;
        public QueueNode(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<QueueNode> q = new LinkedList<QueueNode>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int lowestIdx = 0;
        int highestIdx = 0;
        q.offer(new QueueNode(0, root));
        
        while (!q.isEmpty()) {
            QueueNode qNode = q.poll();
            TreeNode node = qNode.node;
            int idx = qNode.idx;
            if (node.left != null) {
                q.offer(new QueueNode(idx - 1, node.left));
                map.getOrDefault(idx - 1, new ArrayList<Integer>()).add(node.left.val);
                lowestIdx = Math.min(lowestIdx, idx - 1);
            }
            if (node.right != null) {
                q.offer(new QueueNode(idx + 1, node.left));
                map.getOrDefault(idx + 1, new ArrayList<Integer>()).add(node.right.val);
                highestIdx = Math.max(highestIdx, idx + 1);
            }
        }
        
        while (lowestIdx <= highestIdx) {
            if (map.containsKey(lowestIdx)) {
                result.add(map.get(lowestIdx++));
            }
        }
        return result;
    }

//If you wanna avoid using hashmap cuz of key conflicts,you can use doubly-linked list,each node stores a Arraylist of vals,
//then replace Queue<Integer> cols with Queue<LinkedList> cols,each time we poll,we first add it to curr node's arraylist,
//put non-null left node to a new left list(if curr.prev == head),
//put non-null right node to a new right list(if curr.next == tail),
//finally iterate all lists from head to tail
