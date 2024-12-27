import java.util.*;
/**
 * firstclass
 */
public class firstclass {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the row of matrix");
        int a=sc.nextInt();
        System.out.println("enter the cols of matrix");
        int b=sc.nextInt();

        int arr[][]=new int[a][b];

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
              
                 arr[i][j]=sc.nextInt();

            }
        }
             //output

             for(int j=0;j<a;j++){
                for(int i=0;i<b;i++){
                    
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
             }
        
    }
}