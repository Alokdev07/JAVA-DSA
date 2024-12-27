import java.util.*;
/**
 * main
 */
public class main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        int n=sc.nextInt();

        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
       
        for(int i=0;i<size;i++){
            if (arr[i]==n) {
               System.out.println(i);              
            }
           
        }
    }
}