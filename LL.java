import java.util.*;
/**
 * LL
 */
public class LL {
  Node head;
  int size;

  LL() {
    this.size = 0;
  }

  class Node {

    String data;
   public Node next;

    Node(String data) {
      this.data = data;
      this.next = null;
      size++;
    }
  }

  public void Addfirst(String data) {

    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      return;
    }

    newNode.next = head;
    head = newNode;

  }

  public void Addlast(String data) {

    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      return;
    }

    Node currNode = head;

    while (currNode.next != null) {
      currNode = currNode.next;
    }

    currNode.next = newNode;
  }

  public void printlist() {
    Node currNode = head;

    while (currNode != null) {
      System.out.print(currNode.data + "->");
      currNode = currNode.next;
    }
    System.out.println();
  }

  public void Deletefirst() {

    if (head == null) {
      System.out.println("this is empty");
      return;
    }

    head = head.next;
    size--;
  }

  public void Deletelast() {

    if (head == null) {
      System.out.println("this is empty");
      return;
    }
    size--;
    if (head.next == null) {
      head = null;
      return;
    }

    Node secondlast = head;
    Node lastnode = head.next;

    while (lastnode.next != null) {

      lastnode = lastnode.next;
      secondlast = secondlast.next;
    }

    secondlast.next = null;
  }

  public void printsize() {
    System.out.println(size);
  }

  public void reverseiterate() {

    if (head == null || head.next == null) {
      return;
    }

    Node prevNode = head;
    Node currNode = head.next;

    while (currNode != null) {
      Node nextNode = currNode.next;

      currNode.next = prevNode;

      prevNode = currNode;
      currNode = nextNode;
    }

    head.next = null;
    head = prevNode;
  }

  public Node reacaursiveway(Node head){
        if (head == null || head.next == null) {
          return head;
        }

    Node newHead = reacaursiveway(head.next);
     head.next.next = head;
    head.next = null;
   return newHead;  

  }


  public Node deltion(Node head ,int n){
    

    Node tempNode = head;
    int count = 0;
    while (tempNode != null ) {
      
      count++;
      tempNode = tempNode.next;
    }
    if (n == count) {
      return head.next;
    }
    int nthterm = count-n;
    int i = 1;
    Node temporary = head;
    while (i < nthterm) {
      
      //  if (nthterm == 0) {
      //   break;
      //  }
       temporary = temporary.next;
       nthterm--;
       
    }
  //  Node delete = temporary;
   temporary.next = temporary.next.next;
    return head;
  }

  public Node reverse(Node head){
      Node prevhead = null;
      Node currhead = head;
      while (currhead != null) {
        Node nexthead = currhead.next;

        currhead.next = prevhead;

        prevhead = currhead;
        currhead =nexthead;
      }

      head.next = null;
      head = prevhead;

      return prevhead;
  }

  public Node ll(Node head){
    if (head.next == null) {
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

    if (head == null || head.next == null) {
      return true;
    }
     
  Node middle = ll(head);
  Node half = reverse(middle.next);
     
    
   Node firsthead = head;



   while (half != null) {
    if (half.data != firsthead.data) {
      System.out.println("not palindrome");
      return false;
    }
  
    half = half.next;
    firsthead = firsthead.next;
    
    }

     System.out.println("pallindrome");
     return true;
   }

   public Node detect(){
    // if (head == null) {
    //   return false;
    // }

    Node turtle = head;
    Node hare = head;

    while (hare != null) {
      turtle =turtle.next;
      hare = hare.next.next;

      if (hare == turtle) {
        System.out.println("it is in a cycle");
        return turtle;
      }
    }
    System.out.println("this is not in a cycle");
    return null;
   }

   public Node removecycle(){
    Node pointer = detect();
    Node startpoint = head;

    while (startpoint != pointer) {
      startpoint = startpoint.next;
      pointer = pointer.next;
    }

    return startpoint;
   }
  public static void main(String[] args) {
    LL list = new LL();
    list.Addfirst("list");
    list.Addfirst("is");
    list.Addfirst("this");
    
    list.Addlast("now");
    // list.Deletefirst();
    // list.Deletelast();
    // list.printlist();
    // list.printsize();

    // list.printlist();
    list.head = list.reacaursiveway(list.head);
    list.printlist();
    // list.reverseiterate();
    // list.eltion(list.head,2);d
    // list.printlist();
    list.ispallindrome(list.head);

  }
}