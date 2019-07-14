import java.util.ArrayList;
import java.util.Arrays;

public class KuaiSu {
    public static void main(String[] args) {
        int arr[]={23,56,83,35,33,43,42,64,67,15};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void  quickSort(int[] arr){
        int low =0;
        int high = arr.length-1;
        quickSort(arr,low,high);

    }
    private static void quickSort(int[] arr,int low, int high){
        if (low<high){
            //分区，将数组分为两个分区,返回分区界限索引
            int index = partition(arr,low,high);
            //对左分区进行快排
            quickSort(arr,low,index-1);
            //对右分区进行快排
            quickSort(arr, index+1, high);

        }

    }

    private static int partition(int[] arr, int low, int high) {
        //指定左右指针i,j
        int i = low;
        int j = high;
        //以第一个值为基准值X，造坑
        int x = arr[low];
        //循环实现分区
        while(i<j){
            //从右向左移动j，找到第一个小于基准值X的arr[j]
            while(i<j && arr[j]>=x){
                j--;
            }
            //将右侧找到的值，移到左侧的坑，左指针右移i++
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            //从左向右移动i;找到第一个大于等于基准值的arr[i]
            while(i<j && arr[i]<x){
                i++;
            }
            //将左侧找到的值，移到右边的坑，右指针左移j--
            if (i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        //用基准值填坑
        arr[i] = x;
        //返回基准值的位置索引
        System.out.println(i+Arrays.toString(arr));
        return i;

    }

}
