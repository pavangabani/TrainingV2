package datastructure;
class Node {
    Node first;
    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }

    void start() {
        first = this;
        first.next=first;
    }

    void add(int value) {
        Node node = new Node(value);
        Node traverse = first;
        while (traverse.next != first) {
            traverse = traverse.next;
        }
        traverse.next = node;
        node.next = first;
    }
    int remove(){
        Node traverse = first;
        while (traverse.next != first) {
            traverse = traverse.next;
        }
        int ans=traverse.next.value;
        traverse.next=traverse.next.next;
        first=first.next;
        return ans;
    }
    void display() {
        Node traverse = first;
        while (traverse.next != first) {
            System.out.println(traverse.value);
            traverse = traverse.next;
        }
        System.out.println(traverse.value);
    }
}

    public class CircularQueue {
        public static void main(String[] args) {
            Node node = new Node(1);
            node.start();
            node.add(3);
            node.add(5);
            node.display();

            System.out.println("Remove Element: "+node.remove());
            System.out.println("After Remove");
            node.display();
        }
    }

