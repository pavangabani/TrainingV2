package datastructure;

public class ArrayJava {
    public static void main(String []s){
        int  [][] matrix=new int[3][];
        matrix[0]= new int[]{1, 1};
        matrix[1]= new int[]{3, 3, 3};
        matrix[2]= new int[]{2, 2, 2, 2};
        for(int[] a:matrix){
            for(int b:a){
                System.out.println(b);
            }
        }
    }
}
