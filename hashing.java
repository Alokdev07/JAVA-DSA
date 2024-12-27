/*
 * set doesnot contain duplicate values
 * it doesnot have sequence when we iterate over it
 */

import java.util.HashSet;
import java.util.Iterator;

public class hashing {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        //Add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        //contain
        if (set.contains(1)) {
            System.out.println("set contains one");
        }
        if(!set.contains(6)){
            System.out.println("set does not contain six");
        }
        //remove
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("we deleted one");
        }

        System.out.println(set.size());

       //print all elements

       System.out.println(set);
        //iterator to iterate all over the elements
       Iterator it = set.iterator();
       while (it.hasNext()) {
        System.out.println(it.next());
       }
    }
}
