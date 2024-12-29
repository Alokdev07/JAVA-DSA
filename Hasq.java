import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Hasq {
    public static void majorityElement(int num[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = num.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key);
            }
        }
    }

    public static void UnionOfArray(int arr[], int arr1[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int j = 0; j < arr1.length; j++) {
            set.add(arr1[j]);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(set.size());
    }

    public static void intersectionOfTwo(int arr[],int arr1[]){
        HashSet<Integer> interSet = new HashSet<>();

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
                set.add(arr[i]);
            }
        
        for(int j=0;j<arr1.length;j++){
            if (set.contains(arr1[j])) {
                interSet.add(arr1[j]);
            }
        }

        Iterator it = interSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static String getStart(HashMap<String,String> tick){
        HashMap<String,String> revMap =  new HashMap<>();

        for (String keys : tick.keySet()) {
            revMap.put(tick.get(keys), keys);
        }
        for (String key : tick.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
   
    public static void main(String[] args) {
        int num[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // majorityElement(num);
        int arr[] = { 7, 3, 9 };
        int arr1[] = { 6, 3, 9, 2, 9, 4 };
        
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        while (tickets.containsKey(start)) {
            System.out.print(start + "->");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}
