import java.util.*;
/**
 * Strings
 */
public class Strings {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int val=n & (n-1);
        if (val==0) {
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}