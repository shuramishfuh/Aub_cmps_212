package Lab4;

public class Array_Reference {

    public static void main(String[] args) {
        int[] nums = {2, 4, -1, 3};
        incrementAll(nums);
// to every item in the array it increments the value by 1( it mutates the array paased)
    }
    public static void incrementAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
    }
}
