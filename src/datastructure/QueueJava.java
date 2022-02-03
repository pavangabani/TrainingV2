class ListNode{
    int value;
    ListNode next;
    ListNode first;
    ListNode(int value){
        this.value=value;
    }
    void start(){
        first=this;
    }
    void addLast(int value){
        ListNode node=new ListNode(value);
        ListNode traverse=first;
        while(traverse.next!=null) {
            traverse = traverse.next;
        }
        traverse.next=node;
        node.next=null;
    }
    void removeLast(){
        ListNode traverse=first;
        while(traverse.next.next!=null) {
            traverse = traverse.next;
        }
        traverse.next=null;
    }
    void addFirst(int value){
        ListNode node=new ListNode(value);
        node.next=this;
        first=node;
    }
    void removeFirst(){
        first=first.next;
    }
    void display(){
        ListNode traverse=first;
        while(traverse!=null){
            System.out.println(traverse.value);
            traverse=traverse.next;
        }
    }
}
public class QueueJava {
    public static void main(String []s){
        ListNode node=new ListNode(22);
        node.start();
        node.addLast(1);
        node.addLast(2);
        node.display();

        System.out.println("removeLast");
        node.removeLast();
        node.display();

        System.out.println("addFirst");
        node.addFirst(231);
        node.display();

        System.out.println("removeFirst");
        node.removeFirst();
        node.display();
    }
}
