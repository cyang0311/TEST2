public class test {


    public static void main(String[] args) {
        int array[][] = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        for (int arr[]:array) {
            for (int c:arr) {
                System.out.print(c+"  ");
            }
            System.out.println();

        }
        System.out.println();
        for (int i = 0; i <array.length; i++) {
            for (int j = i+1; j <array[i].length ; j++) {
                int b = array[i][j];
                array[i][j]=array[j][i];
                array[j][i]=b;
            }

            for (int arr[]:array) {
                for (int c:arr) {
                    System.out.print(c+"  ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
