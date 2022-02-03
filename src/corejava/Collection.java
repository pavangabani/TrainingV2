import java.util.ArrayList;

public class Collection {
    public static void main(String []s){
        ArrayList<Integer> practice=new ArrayList<>();
        System.out.println(practice.size());
        practice.add(1);
        practice.add(2);
        System.out.println(practice.get(0));
        System.out.println(practice.set(0,111));
        System.out.println(practice);
        System.out.println(practice.contains(2));
        Object[] array=practice.toArray();
        practice.ensureCapacity(20);
        System.out.println(practice.size());


    }
}
