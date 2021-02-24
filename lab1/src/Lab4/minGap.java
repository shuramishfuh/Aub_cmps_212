package Lab4;

public class minGap {

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 7, 12};
        System.out.println(minGapp(array));
    }

    public static int minGapp(int[] arr){
        if (arr.length <2) {
            return 0;
        }
        int count =Integer.MAX_VALUE;
        for (int j = 0; j <arr.length-1 ; j++) {
            if ((arr[j+1]-arr[j])<count){
                count =arr[j+1]-arr[j];
            }
        }
        return count;
    }
}
