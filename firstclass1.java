import java.util.*;
public class firstclass1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of cols: ");
        int cols = sc.nextInt();

        int arr[][] = new int[rows][cols];

        // for input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // for output
        System.out.println("The spiral order matrix is:");

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colStart = 0;
        int colEnd = cols - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            // first row, left to right
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(arr[rowStart][i] + " ");
            }
            rowStart++;
             System.out.println();
            // last column, top to bottom
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(arr[i][colEnd] + " ");
            }
            colEnd--;
System.out.println();
            // last row, right to left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    System.out.print(arr[rowEnd][i] + " ");
                }
                rowEnd--;
                System.out.println();
            }

            // first column, bottom to top
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    System.out.print(arr[i][colStart] + " ");
                }
                colStart++;
                System.out.println();
            }
        }
    }
}