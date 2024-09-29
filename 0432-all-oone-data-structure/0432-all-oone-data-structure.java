class Node {
    int val;
    Node next;
    Node prev;
    Set<String> keys;
    Node(int val) {
        this.val = val;
        next = null;
        prev = null;
        keys = new HashSet<>();
    }
}
class AllOne {

    Map<String, Node> map;
    Node head, tail;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        if(!map.containsKey(key)) {
            if(head.next == tail || head.next.val > 1) {
                insert(head, new Node(1));
            }
            head.next.keys.add(key);
            map.put(key, head.next);
        } else {
            Node curr = map.get(key);
            curr.keys.remove(key);
            if(curr.next == tail || curr.next.val > curr.val + 1) {
                insert(curr, new Node(curr.val + 1));
            }
            curr.next.keys.add(key);
            map.put(key, curr.next);
            if(curr.keys.isEmpty()) {
                remove(curr);
            }
        }
    }
    
    public void dec(String key) {
        if(!map.containsKey(key)) return;

        Node curr = map.get(key);
        curr.keys.remove(key);
        if(curr.val > 1) {
            if(curr.prev == head || curr.prev.val < curr.val - 1) {
                insert(curr.prev, new Node(curr.val - 1));
            }
            curr.prev.keys.add(key);
            map.put(key, curr.prev);
        } else {
            map.remove(key);
        }
        if(curr.keys.isEmpty()) {
            remove(curr);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    public Node insert(Node node, Node nextNode) {
        nextNode.next = node.next;
        nextNode.prev = node;
        node.next.prev = nextNode;
        node.next = nextNode;
        return nextNode;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */