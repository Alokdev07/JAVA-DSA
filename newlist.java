public class newlist {
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
 

 
        public void addFirst(String data){
            Node newhead = new Node(data);
            if (head == null) {
                head = newhead;
                return;
            }

            newhead.next = head;
            head = newhead;
        }

        public void addLast(String data){
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node CurrNode = head;
            while (CurrNode.next != null) {
                CurrNode = CurrNode.next;
            }
            CurrNode.next = newNode; 
        }

        public void printList(){
            Node printNode = head;
            while (printNode != null) {
                System.out.print(printNode.data + "->");
                printNode = printNode.next;
            }
            System.out.println("null");
        }

        public void deleteFirst(){
            if (head == null) {
                System.out.println("empty");
                return;
            }
            head = head.next;
        }

        public void deleteLast(){
            if (head == null) {
                return;
            }
            Node currNode = head;
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }

            currNode.next = null;

        }

        public Node reverseiterate(){
            if (head == null) {
                return null;
            }
            if (head.next == null ) {
                return head;
            }
            Node prevNode = head;
            Node currNode = head;

            while (currNode != null) {
                Node NextNode = currNode.next;

                currNode.next = prevNode;

                prevNode = currNode;
                currNode = NextNode;
            }
            head.next = null;
            head = prevNode;

            return prevNode;
            
        }

        public Node reverseRecaursive(Node head){
           if (head == null || head.next == null) {
            return head;
           } 

           Node newhead = reverseRecaursive(head.next);
           Node front = head.next;
           front.next = head;
           head.next = null;

           return newhead;
        }

        public Node delete_nth_term(Node head,int n){
            Node tempNode = head;
            int count = 0;
            while (tempNode != null) {
                count++;
                tempNode = tempNode.next;    
                
            }
            if (n == count) {
                return head.next;
            }
            int i = 1;
            int nthterm = count-n;
            Node TempNode = head;
            while (i < nthterm) {
                TempNode = TempNode.next;
                nthterm--;
            }
            TempNode.next = TempNode.next.next;
            return head;
        }

        public Node reverse(Node head){
            if (head == null || head.next == null) {
                return head;
            }
            Node prevNode = head;
            Node currNode = head;

            while (currNode != null) {
                Node nexNode = currNode.next;

                currNode.next = prevNode;

                prevNode = currNode;
                currNode = nexNode;
            }

            head.next = null;
            head = prevNode;
            return prevNode;
        }
        public Node half(Node head){
            if(head.next == null) {
                return head;
            }
            Node hare = head;
            Node turtle = head;
            while (hare.next != null && hare.next.next != null) {
                turtle = turtle.next;
                hare = hare.next.next;
            }
            return turtle;
        }
 
        public boolean ispallindrome(Node head){
            if (head == null) {
                System.out.println("not palindrome");
                return false;
            }
            if (head.next == null) {
                System.out.println("is palindrome");
                return true;
            }
            Node middle = half(head);
            Node reversedhalf = reverse(middle.next);
            Node firsthalf = head;

           while (reversedhalf != null) {
            if (firsthalf.data != reversedhalf.data) {
                System.out.println(" not palindrome");
                return false;
            }
              reversedhalf = reversedhalf.next;
              firsthalf = firsthalf.next;
           }
           System.out.println("palindrome");
                return true;
        }
          
        public Node Meetpoint(){
            if (head == null) {
                return null;
            }
            if (hare.next == nul) {
                System.out.println("no meetpoint");
                return null;
            }
            Node hare = head;
            Node turtle = head;
            while (hare.next != null && hare.next.next != null) {
                turtle = turtle.next;
                hare = hare.next.next;
                if (hare == turtle) {
                    return turtle;
                }
            }
            System.err.println("no meetpoint");
            return null;
        }
        public void removecycle(){
            Node turtle1 = Meetpoint();
            Node turtle2 = head;
            Node prevmeetpoint = Meetpoint();
            while (turtle1 != turtle2) {
                prevmeetpoint = turtle1;
                turtle1 = turtle1.next;
                turtle2 = turtle2.next;
            }
            prevmeetpoint.next = null;
        }


    public static void main(String[] args) {
        newlist list = new newlist();

        list.addFirst("this");
        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        // list.deleteFirst();
        // list.deleteLast();
        // list.reverseiterate();
        // list.head = list.reverseRecaursive(list.head);
    //    list.delete_nth_term(list.head, 3);
    list.ispallindrome(list.head);
        // list.printList();
    }
}