public class insertion {
    public static void main(String []args){
        int arr[]={4,5,3,1,2};
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i;
            
            while (j>0 && arr[j-1]>temp) {
               
                arr[j]=arr[j-1];
                
                j--;
                                
            }
            arr[j]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
       
        }
    }
}
