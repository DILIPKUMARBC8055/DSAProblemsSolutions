class CustomStack {
    listNode head;
    int size;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (size >= maxSize) {
            return;
        }
        listNode newNode = new listNode(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public void increment(int k, int val) {
        k = Math.min(k, size);
        int dif = size - k;
        listNode temp = head;
        for (int i = 0; i < dif && temp != null; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            temp.data += val;
            temp = temp.next;
        }
    }
}

class listNode {
    int data;
    listNode next;

    public listNode(int data) {
        this.data = data;
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
