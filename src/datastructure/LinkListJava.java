class Node{
    int value;
    Node first;
    Node next;
    Node pre;
    Node last;
    Node(int value){
        this.value=value;
    }
    void start(){
        first=this;
    }
    void add(int addAfter,int value){
        Node node=new Node(value);
        Node traverse=first;
        while(traverse.value!=addAfter){
            traverse=traverse.next;
        }
        traverse.next.pre=node;
        node.next= traverse.next;
        traverse.next=node;
        node.pre=traverse;

    }
    void addLast(int value){
        Node node=new Node(value);
        Node traverse=first;
        while(traverse.next!=null){
            traverse=traverse.next;
        }
        traverse.next=node;
        node.pre=traverse;
        node.next=null;
        last=node;
    }
    void addFirst(int value){
        Node node=new Node(value);
        node.next=this;
        first.pre=node;
        node.pre=null;
        first=node;
    }
    void removeLast(){
        last=last.pre;
        last.next=null;
    }
    void removeFirst(){
        first=first.next;
        first.pre=null;
    }
    void remove(int value){
        Node traverse=first;
        while(traverse.next.value!=value){
            traverse=traverse.next;
        }
        traverse.next=traverse.next.next;
        traverse.next.pre=traverse;
    }
    void display(){
        System.out.println("onward :");
        Node traverse=first;
        while(traverse!=null){
            System.out.println(traverse.value);
            traverse=traverse.next;
        }
        System.out.println("backward :");
        traverse=last;
        while(traverse!=null){
            System.out.println(traverse.value);
            traverse=traverse.pre;
        }
    }
}
public class LinkListJava {
    public static void main(String []s){
        Node node=new Node(11);
        node.start();
        node.addLast(22);
        node.addLast(44);
        node.addLast(55);
        node.display();

        System.out.println("33 Add after 22 ");
        node.add(22,33);
        node.add(44,1);
        node.display();

        System.out.println("addFirst 0");
        node.addFirst(0);
        node.display();

        System.out.println("RemoveLast");
        node.removeLast();
        node.display();

        System.out.println("RemoveFirst");
        node.removeFirst();
        node.display();

        System.out.println("Remove 33");
        node.remove(33);
        node.display();
    }
}
