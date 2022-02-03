class motadata{
    String employeename="";
    motadata(String en){
        employeename=en;
    }
    void display(){
        System.out.println("Emplyee Name :"+employeename);
    }
}
class devteam extends motadata{
    String work="";
    int leave_count=0;
    devteam(String n,String w,int lc){
        super(n);
        work=w;
        leave_count=lc;
    }
    void change(String w){
        work=w;
        System.out.println("Work changed");
    }
    void change(int lc){
        leave_count=lc;
        System.out.println("leave count changed");
    }
    void display(){
        System.out.println("Employee Name:"+employeename+" Work :"+work+" Leave count :"+leave_count);
    }
}
public class Polymorphism {
    public static void main(String []s){
        //Compile time polymorphism
        devteam employee=new devteam("pavan","java trainee",0);
        employee.change(null); //change leave count
        employee.change("python"); //change work

        //Run time Pholymorphism
         motadata m=employee;
         m.display();
    }
}
