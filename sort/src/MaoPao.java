public class MaoPao {

    public static void main(String[] args) {
        int a[] = new int[]{5,9,7,4,8,2,6,4,3};
        for (int i = 0; i <a.length-1; i++) {
            for (int j = 0; j <a.length-1-i; j++) {
                if (a[j]>a[j+1]){
                    int b = a[j];
                    a[j] = a[j+1];
                    a[j+1] = b;
                }
            }
        }
        for (int i:a) {
            System.out.println("冒泡排序");
            System.out.println(i+"  ");
        }

    }
}
