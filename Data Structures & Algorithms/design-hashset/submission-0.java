class MyHashSet {
    private class LL{
        public static class Node{
            int val;
            Node next;
            public Node(int val){
                this.val = val;
                this.next = null;
            }
        }
        Node head;
        public LL(){
            this.head = null;
        }
        public void add(int val){
            if(search(val))return;
            if(head == null)head = new LL.Node(val);
            else{
                LL.Node c = this.head;
                while(c.next!=null){
                    c = c.next;
                }
                c.next = new LL.Node(val);
            }
        }
        public void remove(int val){
            if(head==null)return;
            if(head.val==val){
                this.head = this.head.next;
                return;
            }

            LL.Node prev = this.head;
            LL.Node curr = this.head.next;

            while(curr!=null){
                if(curr.val==val){
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        public boolean search(int val){
            LL.Node c = this.head;
            while(c!=null){
                if(c.val==val)return true;
                c = c.next;
            }
            return false;
        }
    }
    int n;
    LL[] ht;
    int i;
    public MyHashSet() {
        n = 1000;
        ht = new LL[n];
    }
    private int hashing(int key){
        return key%n;
    }
    public void add(int key) {
        i = hashing(key);
        if(ht[i]==null){
            ht[i] = new LL();
        }
        ht[i].add(key);
    }
    
    public void remove(int key) {
        i = hashing(key);
        if(ht[i]!=null){
            ht[i].remove(key);
        }
    }
    
    public boolean contains(int key) {
        i = hashing(key);
        if(ht[i]!=null){
            return ht[i].search(key);
        }else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */