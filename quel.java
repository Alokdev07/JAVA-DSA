public class quel {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }

        static class Que{
            static Node head = null;
            static Node tail = null;

            public static boolean isEmpty(){
                return head == null && tail == null;
            }

            public static void add(int data){
                Node newhead = new Node(data);

                if (tail == null) {
                    head = tail = newhead;
                    return;
                }

                tail.next = newhead;
                tail = newhead;
            }

            public static int remove(){
                if (isEmpty()) {
                    return -1;
                }
                if (head == tail) {
                    tail = null;
                }
                int front = head.data;
                head = head.next;
                return front;
            }

            public static int peek(){
                if (isEmpty()) {
                    return -1;
                }

                return head.data;
            }
        }

        public static void main(String[] args) {
            Que q =new Que();
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);

            while (!q.isEmpty()) {
                System.out.println(q.peek());
                q.remove();
            }
        }
    }
}
