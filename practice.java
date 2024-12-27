public class practice {
    public static void main(String[] args) {
        int arr[] ={9,1,7,2,4} ;

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length-1; j++){
                if (arr[i]<arr[j]) {
                    int temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }
}
