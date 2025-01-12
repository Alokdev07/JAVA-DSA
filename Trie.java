public class Trie {
    static class Node{
        Node children[];
        boolean endOfWord;
        public Node(){
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }
    static Node root = new Node();
    public static void insert(String word){
        Node Current = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (Current.children[idx] == null) {
                Current.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                Current.children[idx].endOfWord = true;
            }
            Current = Current.children[idx];
        }
    }
    public static boolean search(String word){
        Node Current = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (Current.children[idx] == null) {
                return false;
            }
            if (i == word.length()-1 && Current.children[idx].endOfWord == false) {
                return false;
            }
            Current = Current.children[idx];
        }
        return true;
    }
    public static boolean wordBreak(String key){
        if (key.length() == 0) {
            return true;
        }
        for(int i = 1;i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secPart = key.substring(i);
            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String word[] = {"i","like","sam" ,"samsung","mobile"};
        String key = "ilikesamsung";
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
    //    System.out.println(search("their"));
    //    System.out.println(search("there"));
    //    System.out.println(search("a"));
    //    System.out.println(search("an"));
    System.out.println(wordBreak(key));
    }
}
