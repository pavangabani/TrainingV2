interface bike {
    int tier=2;
    void handle();
    void tire();
}
abstract class hero implements bike{

    @Override
    public void handle() {
        System.out.println("handle");
    }

    @Override
    public void tire() {
        System.out.println("tire");
    }

    abstract void features();
}
class passion extends hero{

    @Override
    void features() {
        System.out.println("features");
    }
}
public class abstraction {
    public static void main(String []s){
        passion bike=new passion();
        bike.features();
        bike.handle();
        bike.tire();
        System.out.println("tyre :"+bike.tier);
    }

}
