class cutomexceptin extends Exception{
    cutomexceptin(String e){
        super(e);
    }
}
class pavan{
    int a=1;
    pavan(int da) throws Exception{
        a=a/da;
    }
    void errorcheck(){
        try{
            if (a<0){
                throw new cutomexceptin("Custom error is thrown");
            }
        }
        catch (Exception e){
            System.out.println("Custom error catched : " +e.getMessage());
        }
    }
}
public class Exceptionjava {
    public static void main(String []s){
        try {
            pavan o=new pavan(0);
            o.errorcheck();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("finally ran");
        }
        System.out.println("end");

    }
}
