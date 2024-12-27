import java.util.*;

public class arraylist {
     public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

//add operation in arraylist

        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(6);

        System.out.println(list);


//get operatiomn in arraylist


        int element = list.get(3);

        System.out.println(element);

//add in between in a list
   
         list.add(0,6);
         System.out.println(list);

//set element in arraylist
         list.set(1,1);
         System.out.println(list);
//delete elements in arraylist
         list.remove(0);
         list.remove(1);
         System.out.println(list);

//size of an arraylist
        int size = list.size();
        System.out.println(size);

        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i)+",");
        }
        System.out.println();

           Collections.sort(list);
        System.out.println(list);
     }
}
