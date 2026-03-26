class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }}
    class LRUCache {
        int capacity;
HashMap<Integer,Node> map;
Node head,tail;
    public LRUCache(int capacity) {
         map=new HashMap<>(); 
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        return -1;
        Node node=map.get(key);
        deleteNode(node);
        insertAfterhead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            insertAfterhead(node);
        }
        else{
            if(map.size()==capacity){
                Node node=new Node(key,value);
                Node temp=tail.prev;
                map.remove(temp.key);
                deleteNode(temp);
                insertAfterhead(node);
                map.put(key,node);

            }
            else{
        Node node=new Node(key,value);
        insertAfterhead(node);
        map.put(key,node);
        }}
    }
    public void insertAfterhead(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
       
    }
    public void deleteNode(Node node){
        Node temp=node.next;
        node.prev.next=node.next;
        temp.prev=node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */