import java.util.ArrayList;
import java.util.LinkedList;


public class hasimpl {
    static class HashMap<K,V>{
        private class Nodes{
            K key;
            V value;
           public Nodes(K key,V value){
                this.key = key;
                this.value = value;
            }
        }
        private int N;
        private int n;
        public LinkedList<Nodes> Bucket[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.Bucket = new LinkedList[4];
            for(int i = 0;i<N;i++){
                this.Bucket[i] = new LinkedList<>();
            }
        }
        public int hash(K key){
            int val = key.hashCode();
            return Math.abs(val)%N;
        }
        public int searchinLL(K Key,int bi){
            LinkedList<Nodes> ll = Bucket[bi];
            for(int i = 0;i<ll.size();i++){
                if (ll.get(i).key.equals(Key))  {
                    return i;
                }
            }
            return -1;
        }
        public void rehash(){
            LinkedList<Nodes> oldBucket []= Bucket;
            N*=2;
            Bucket = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                Bucket[i] = new LinkedList<>();
            }
            for(int i = 0; i<oldBucket.length; i++){
               LinkedList<Nodes> ll = oldBucket[i];
            for(int j = 0; j<ll.size(); j++){
                Nodes node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }
        public void put(K key,V value){
            int bi = hash(key);
            int di = searchinLL(key,bi);
            if (di == -1) {
            Bucket[bi].add(new Nodes(key,value));
            n++;
            }else{
                Nodes exisitingIndex = Bucket[bi].get(di);
                exisitingIndex.value = value;
            }
            double Lambda = (double)n/N;
            if (Lambda > 2.0) {
                rehash();
            }
        }
        public V get(K key){
            int bi = hash(key);
            int di = searchinLL(key,bi);
            if (di == -1) {
           return null;
            }else{
                Nodes exisitingIndex = Bucket[bi].get(di);
                return exisitingIndex.value;
            }
        }
        public boolean containsKey(K key){
            int bi = hash(key);
            int di = searchinLL(key,bi);
            if (di == -1) {
          return false;
            }else{
               return true;
            }
        }
        public V remove(K key){
            int bi = hash(key);
            int di = searchinLL(key,bi);
            if (di == -1) {
           return null;
            }else{
                Nodes exisitingIndex = Bucket[bi].remove(di);
                n--;
               return exisitingIndex.value;
              
            }
        }
        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0;i<Bucket.length;i++){
                LinkedList<Nodes> ll = Bucket[i];
                for(int j = 0;j<ll.size();j++){
                    Nodes node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n == 0;
        }
    } 
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",190);
        map.put("Us",50);
        map.put("China",150);
        map.put("Russia",600);
        
        System.out.println(map.get("India"));
       System.out.println( map.containsKey("India"));
      ArrayList<String> keys = map.keyset();
      for(int i = 0; i<keys.size(); i++){
        System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
      }
    }
}