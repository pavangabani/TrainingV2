package corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    Integer id;
    String name;
    Integer age;
    Student(int id,String name,int age){
        this.id=id;
        this.age=age;
        this.name=name;
    }
    static class SortStudent implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            int idCompare=o1.id.compareTo(o2.id);
            int nameCompare=o1.name.compareTo(o2.name);
            int ageCompare=o1.age.compareTo(o2.age);
            if(idCompare==0){
                if(nameCompare==0){
                    return ageCompare;
                }
                else{
                    return nameCompare;
                }
            }
            else {
                return idCompare;
            }
        }
    }
    public String toString(){
        String ans="id: "+id+" name: "+name+" age: "+age;
        return ans;
    }
}

public class ComperatorJAVA {
    public static void main(String[] args) {
        Student s1=new Student(2,"pavan",21);
        Student s2=new Student(1,"gabani",23);
        Student s3=new Student(1,"pavan",22);
        Student s4=new Student(1,"pavan",21);
        List<Student> list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println("Before Sort");
        for(Student i:list){
            System.out.println(i);
        }
        Collections.sort(list, new Student.SortStudent() );
        System.out.println("After Sort");
        for(Student i:list){
            System.out.println(i);
        }

    }
}
