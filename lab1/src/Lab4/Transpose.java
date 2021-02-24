package Lab4;

public class Transpose {
    public static void main(String[] args) {
        int[][] a = {{6,7,9,4,8},{3,2,7,4,1},{9,4,5,8,3},{9,4,5,8,3},{3,2,7,4,1}};
        a =transpose(a);
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposedMatrix = new int[n][m];

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                transposedMatrix[x][y] = matrix[y][x];
            }
        }

        return transposedMatrix;
    }
}
