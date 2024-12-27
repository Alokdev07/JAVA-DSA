public class quepractice {
    static class que{
         static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;
        que(int size){
             arr = new int[size];
             this.size = size;
        }
    
    public static boolean isEmpty(){
        return rear == -1 && front == -1;
    }
    public static boolean isFull(){
        return front == (rear+1)%size;
    }
    public static void push(int data){
        if (isFull()) {
            System.out.println("full");
            return;
        }
       
       if (front == -1) {
        front = 0;
       }
       rear = (rear+1)%size;
       arr[rear] = data;
    }
    public static int pop(){
        if (isEmpty()) {
            return -1;
        }
        int top = arr[front];
        if (rear == front) {
            rear = front = -1;
        }else{
            front = (front+1)%size; 
        }
        return top;
    }
    public static int peek(){
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
}
    public static void main(String[] args) {
        que Q = new que(5);
        Q.push(1);
        Q.push(2);
        Q.push(3);
        Q.push(4);
        Q.push(5);
        Q.pop();
        Q.push(6);
        while (!Q.isEmpty()) {
            System.out.println(Q.peek());
            Q.pop();
        }
    }
}