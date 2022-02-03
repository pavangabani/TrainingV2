package corejava;
import java.util.*;
//class Country{
//    String name;
//    Country(String s){
//        name=s;
//   }
//}
public class Collectionjava {
    public static void main(String []s){
        //ArrayList
//        List<Integer> al=new ArrayList<Integer>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        Iterator it=al.iterator();
//        while(it.hasNext()){
//            System.out.println("ArrayList :"+it.next());
//        }
//        System.out.println(al.size());
//
//        System.out.println("-----------------------------------");
//        //ArrayDeque
//        ArrayDeque<Integer> ad=new ArrayDeque<Integer>();
//        ad.add(15);
//        ad.add(17);
//        for(Integer a : ad){
//            System.out.println(a);
//        }
//
//        System.out.println("-----------------------------------");
//        //hashset
//        HashSet<String> hs=new HashSet<String>();
//        hs.add("pavan");
//        hs.add("u");
//        hs.add("gabani");
//
//        for(String a:hs){
//            System.out.println(a);
//        }
//        Country country1=new Country("India");
//        Country country2=new Country("India");
//        HashSet<Country> countryName=new HashSet<>();
//        countryName.add(country1);
//        countryName.add(country2);
//
//        for(Country countries :countryName){
//            System.out.println(countries.name);
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"pavan");
        System.out.println(map.put(1,"gabani"));
      //  System.out.println(map.get(1));

        }

    }

