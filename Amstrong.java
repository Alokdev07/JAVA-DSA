/**
 * Amstrong
 */
public class Amstrong {

    public static void main(String[] args) {
        int n=155;
        int temp=n;
        int sum=0;
        int rem;
        while (n>0) {
            rem=n%10;
            n=n/10;
            sum=(rem*rem*rem)+sum;


        }
        if (temp == sum){
            System.out.println("this is a amstrong number");
        } 
          else{
            System.out.println("this is not a amstrong number");
          }  
        
    }
}