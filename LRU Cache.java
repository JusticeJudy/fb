private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    public int n;
    public Map<Integer, Node> map;
    public List<Integer> list;
    public Node head = new Node(-1, -1);
    public Node tail= new Node(-1, -1);
    public LRUCache(int capacity) {
        this.list = new ArrayList<Integer>(n);
        this.n = capacity;
        this.map = new HashMap<Integer, Node>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;   
        }
        Node node = map.get(key);
         
        node.prev.next = node.next;
        node.next.prev = node.prev;
        moveToTail(node);
        map.put(key, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        } 
        if (map.size() == n) {
            removeTop();
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);
        
        return;
    }
    
    private void moveToTail(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        return;
    }
    private void removeTop() { 
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.prev = head;
        return;
    }
