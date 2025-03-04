/**
 * Recursion
 */
public class Recursion {
    public static void divide(int arr[],int mid,int si,int ei){
        int merged[] = new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int x = 0;
        while (idx1<=mid && idx2<=ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x] = arr[idx1];
                x++;
                idx1++;
            }
              else{
                merged[x] = arr[idx2];
                x++;
                idx2++;
              } 
           }
            

              while (idx1 <= mid) {
                  merged[x] = arr[idx1];
                  x++;
                  idx1++;
              }

              while (idx2 <= ei) {
                 merged[x] = arr[idx2];
                 x++;
                 idx2++;
              }

              for(int i=0, j=si; i<merged.length; i++,j++ ){
                arr[j] = merged[i];
              }
        }
    
    public static void merge(int arr[], int si, int ei){
        if (si>=ei) {
            return;
        }

        int mid = si+(ei-si)/2;
         
        merge(arr, si, mid);
        merge(arr, mid+1, ei);
        divide(arr, mid, si, ei);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,5,4};
        int n = arr.length;
         merge(arr, 0, n-1);
         for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
         }
    }
}