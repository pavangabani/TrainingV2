class Stack{
    int cursor=-1;
    int[] array=new int[5];
    void push(int value){
        try{
            array[++cursor]=value;
        }
        catch(Exception e){
            System.out.println("stack over flow");
            cursor--;
        }

    }
    int pop(){
        try {
            return array[cursor--];
        }
        catch(Exception e){
            System.out.println("Stack underflow");
            cursor++;
        }
        return -1;
    }
    void display(){
        for(int a:array){
            System.out.println(a);
        }
    }
}
public class StackJava {
    public static void main(String []s){
        Stack obj=new Stack();
        obj.push(1);
        obj.pop();
        obj.pop();
        System.out.println(obj.pop());
        //obj.display();

    }
}
