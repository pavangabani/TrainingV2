class parent{
    int a=10;
    parent(){
        System.out.println("parent default constructor");
    }
    void display(){
        System.out.println("a :"+a);
    }
}
class child extends parent{
    int b=11;
    child(int a){
        System.out.println("child default constructor");
    }
    void display(){
        System.out.println("a :"+a+" b :"+b);
    }
}

class has_a{
    parent p=new parent();
    has_a()
    {
        System.out.println("using aggregation");
        p.display();
    }
}
public class Inheritance {
    public static void main(String []s){
        parent obj=new parent();
        obj.display();

        child obj2=new child(2);
        obj2.display();

        has_a obj3=new has_a();

    }
}
