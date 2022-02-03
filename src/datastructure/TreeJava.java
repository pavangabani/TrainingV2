package datastructure;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value=value;
        left=null;
        right=null;
    }
    void add(int value){
        TreeNode node=new TreeNode(value);
        TreeNode traverse=this;
        if(traverse.value>value && traverse.left==null){
            traverse.left=node;
        }
        if(traverse.value<value && traverse.right==null){
            traverse.right=node;
        }
        if(traverse.value>value && traverse.left!=null){
            traverse.left.add(value);
        }
        if(traverse.value<value && traverse.right!=null){
            traverse.right.add(value);
        }
    }
    void displayDFS(){
        TreeNode traverse=this;
        if(traverse.left!=null){
            traverse.left.displayDFS();
        }
        System.out.println(traverse.value);
        if(traverse.right!=null){
            traverse.right.displayDFS();
        }
    }
    void displayBFS()
    {
        TreeNode root=this;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
public class TreeJava {
    public static void main(String []s){
        TreeNode node=new TreeNode(50);
        //node.display();
        node.add(2);
        node.add(75);
        node.add(25);
        node.add(1);
        node.add(4);
        node.add(3);
        node.add(100);
        node.add(56);
        node.add(27);
        node.add(101);
        System.out.println("DFS");
        node.displayDFS();
        System.out.println("BFS");
        node.displayBFS();
    }
}
