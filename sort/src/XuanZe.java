public class XuanZe {
    public static void main(String[] args) {
        int array[] = new int[]{5, 9, 7, 4, 8, 2, 6, 4, 3};
        int index = 0;
        for (int m:array) {
            System.out.print(m+"  ");
        }
        System.out.println();
        for (int i = 1; i < array.length; i++) {
            //找出最大值下标
            for (int j = 0; j <=array.length-i; j++) {
                if (array[j]>array[index]){
                    index = j;
                }
            }
            //array[index]和array[array.length-i]换位
            int b = array[index];
            array[index] = array[array.length-i];
            array[array.length-i] = b;
            b = array[index];
        }
        for (int mm:array) {
            System.out.print(mm+"  ");
        }
    }
}
