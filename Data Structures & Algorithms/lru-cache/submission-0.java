

class LRUCache {

    // Doubly Linked List Node
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head; // Dummy head
    private final Node tail; // Dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy nodes to avoid null checks during insertions/deletions
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                // Evict least recently used (node right before dummy tail)
                Node lruNode = tail.prev;
                removeNode(lruNode);
                cache.remove(lruNode.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
        }
    }

    // Helper: Add node right after dummy head (most recently used)
    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper: Remove an existing node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Move an existing node to the most recently used position
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }
}