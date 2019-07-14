import java.util.*;

public class ZheBan {

    /**
     * 折半查找
     * 用于数据有序排列的顺序表
     */

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr,10,0,9));

        TreeMap map = new TreeMap();
        TreeSet treeSet = new TreeSet();
        HashSet hashSet = new HashSet();

    }

    /**
     * 直接查找
     * 时间复杂度T(n)=O(log2_n)
     * 空间复杂度S(n)=O(1)
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array,int key){

        int low = 0;
        int high = array.length-1;
        int mid;

        while(low<=high){
            mid = (low+high)/2;
            if(key==array[mid]){
                return mid;
            }else if(key<array[mid]){
                high=mid-1;
            }else {
                low =mid +1;
            }
        }
        return -1;
    }


    /**
     * 递归查找
     * low:第一个下标
     * high:最后一个下标
     * 时间复杂度T(n)=O(log2_n)
     * 空间复杂度S(n)=O(log2_n)
     */
    public static int binarySearch(int[] array,int key,int low,int high){
        if (low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if (key==array[mid]){
            return mid;
        }else if(key<array[mid]){
            return binarySearch(array,key,low,mid-1);
        }else {
            return binarySearch(array,key,mid+1,high);
        }
    }
}
