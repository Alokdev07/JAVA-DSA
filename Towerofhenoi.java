/**
 * recursion
 */
/**
 * Tower of henoi
 */
public class Towerofhenoi {

  

  public static void towerofh(int n,String src, String helper,String dest){
    if (n == 1) {
      System.out.println(n+"from"+src+"to"+dest);
      return;
    }
    towerofh(n-1, src, dest, helper);//n-1 th term tower in helper tower
    System.out.println(n-1+"from"+src+"to"+dest);
    towerofh(n-1, helper, src, dest);//which n-1 term is transfer to helper take it on dest
  }


  
  public static void main(String[] args) {
    int n = 2;
      towerofh(n, "S", "H", "D");
  }
}