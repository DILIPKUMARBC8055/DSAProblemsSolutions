class AllOne {
    HashMap<String, Node> hm;
    Node head;
    Node tail;

    public AllOne() {
        hm = new HashMap<>();
        // Initialize the head and tail sentinel nodes
        head = new Node("", Integer.MIN_VALUE, null, null);
        tail = new Node("", Integer.MAX_VALUE, null, head);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            node.data++;
            // Move the node forward if necessary
            Node current = node.next;
            while (current.data < node.data) {
                current = current.next;
            }
            if (current != node) {
                removeNode(node);
                addNode(current.prev, node.key, node.data);
            }
            //System.out.println(key + " " + node.data);
        } else {
            // Create a new node with data = 1 and insert it after the head
            Node newNode = new Node(key, 1, head.next, head);
            head.next.prev = newNode;
            head.next = newNode;
            hm.put(key, newNode);
            //System.out.println(key + " " + 1);
        }
    }

    public void dec(String key) {
        if (!hm.containsKey(key)) return;

        Node node = hm.get(key);
        node.data--;
        //System.out.println(key + " " + node.data);

        if (node.data == 0) {
            // Remove node from the list and the map if its count reaches 0
            removeNode(node);
            hm.remove(key);
        } else {
            // Move the node backward if necessary
            Node current = node.prev;
            while (current.data > node.data) {
                current = current.prev;
            }
            if (current != node) {
                removeNode(node);
                addNode(current, node.key, node.data);
            }
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.key;
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.key;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node previous, String key, int data) {
        Node newNode = new Node(key, data, previous.next, previous);
        previous.next.prev = newNode;
        previous.next = newNode;
        hm.put(key, newNode);
    }
}

class Node {
    String key;
    int data;
    Node next;
    Node prev;

    public Node(String key, int data, Node next, Node prev) {
        this.key = key;
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
