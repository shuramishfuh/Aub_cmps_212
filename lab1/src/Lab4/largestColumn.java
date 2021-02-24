package Lab4;

public class largestColumn {
    public static void main(String[] args) {
        int[][] b = {{6,7,9,4,8},{3,2,7,4,1},{9,4,5,8,3}};

//        System.out.println("");
        int[][] a = largestColumnFirst(b);
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public  static int[][]  largestColumnFirst(int[][] arr) {
//        get largest column
        int col =0;
        int psum =Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            int sum =0;
            for (int j = 0; j <arr[0].length ; j++) {
                sum+=arr[i][j];
            }
            if (sum > psum) col = i;
            }
//        swap values
        System.out.println("col is"+col);
        for (int i = 0; i <arr.length ; i++) {
            int temp = arr[i][0];
            arr[i][0]=arr[i][col];
            arr[i][col] =temp;


        }
        return arr;
    }
}
