import java.util.Arrays;
public class BinarySearch {
    boolean search(int[] list,int target,int i,int j){
        if(j<i){
            int mid=(j+i)/2;
            if(list[mid]==target){
                return true;
            }
            else if(list[mid]<target){
                return search(list,target,mid+1,j);
            }
            else {
                return search(list,target,i,mid-1);
            }
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] list={5,4,3,2,1,4,2,123};
        int listSize=list.length;

        Arrays.sort(list);
        BinarySearch obj=new BinarySearch();
        System.out.println(obj.search(list,54,0,listSize));
    }
}
