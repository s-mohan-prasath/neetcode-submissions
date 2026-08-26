class MyHashMap {
    private class LL {
        public static class Node {
            int key;
            int val;
            Node next;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }
        private Node head;
        public LL() {
            head = null;
        }
        public void add(int key, int val) {
            if (head == null) {
                LL.Node n = new LL.Node(key, val);
                head = n;
            } else {
                LL.Node curr = head;
                if (curr.key == key)
                    curr.val = val;
                else {
                    while (curr.next != null) {
                        if (curr.key == key) {
                            curr.val = val;
                            return;
                        }
                        curr = curr.next;
                    }
                    if (curr.key == key) {
                        curr.val = val;
                        return;
                    }
                    LL.Node n = new LL.Node(key, val);
                    curr.next = n;
                }
            }
        }
        public void remove(int key) {
            if (head != null && head.key == key) {
                head = head.next;
                return;
            }
            LL.Node curr, prev;
            curr = prev = head;
            while (curr != null) {
                if (curr.key == key) {
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        public int get(int key) {
            int out = -1;
            if (head != null && head.key == key) {
                out = head.val;
            } else {
                LL.Node curr = head;
                while (curr != null) {
                    if (curr.key == key) {
                        out = curr.val;
                        break;
                    }
                    curr = curr.next;
                }
            }
            return out;
        }
    }

    int n;
    LL[] ht;

    public MyHashMap() {
        n = 1000;
        ht = new LL[n];
    }

    public void put(int key, int value) {
        int i = hashing(key);
        if (ht[i] == null) {
            ht[i] = new LL();
        }
        ht[i].add(key, value);
    }

    public int get(int key) {
        int i = hashing(key);
        if (ht[i] == null)
            return -1;
        else
            return ht[i].get(key);
    }

    public void remove(int key) {
        int i = hashing(key);
        if (ht[i] != null)
            ht[i].remove(key);
    }

    public int hashing(int key) {
        return key % n;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */