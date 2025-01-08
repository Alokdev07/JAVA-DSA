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
    public static void main(String[] args) {
        String word[] = {"the","a","there" ,"their","any"};
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
       System.out.println(search("their"));
       System.out.println(search("there"));
       System.out.println(search("a"));
       System.out.println(search("an"));
    }
}
