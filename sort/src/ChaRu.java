import java.util.Arrays;

public class ChaRu {
    /**
     * 直接插入排序
     */
    public static void main(String[] args) {
        int[] arr={5,7,2,4,8};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //待排序中的元素比已排序的元素小，则交换位置
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
