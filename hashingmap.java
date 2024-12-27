import java.util.HashMap;
import java.util.*;

public class hashingmap {
    public static void main(String[] args) {
        HashMap<String,Integer> studs = new HashMap<>();
        //Add items
        studs.put("Alok Bhuyan", 12);
        studs.put("Akash swain", 11);
        studs.put("Achintya chetak sahoo", 8);
        studs.put("Asish Nayak", 24);

        System.out.println(studs);

        //Search in map using key

        if (studs.containsKey("Alok Bhuyan")) {
            System.out.println("this name of student exists");
        }

        //get the value of key

        System.out.println(studs.get("Alok Bhuyan"));

        for (HashMap.Entry<String,Integer> e : studs.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        Set<String> keys = studs.keySet();
        for (String key : keys) {
            System.out.println(key + " " + studs.get(key));
        }
    }
}
