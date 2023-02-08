
// Java program to delete a given key from
// linked list.
import java.util.*;
import java.io.*;

public  class circularR {
   

   static class Node {
      int data;
      Node next;
      Node(int d){
         data=d;
         next=null;
      }
      public Node() {
      }
   };
   static Node head=null;

  
   static circularR.Node push( int data) {
     
      Node ptr1 = new Node();
      
    
      if (head != null) {

         Node temp = head;
         while (temp.next != head)
            temp = temp.next;
         temp.next = ptr1;
      } else
         ptr1.next = ptr1; 

      head = ptr1;
      return ;
   }

   /*
    * Function to print nodes in a given
    * circular linked list
    */
   static void printList() {
      Node temp = head;
      if (head != null) {
         do {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
         } while (temp != head);
      }

      System.out.printf("\n");
   }

   /* Function to delete a given node from the list */
   static void  deleteNode(int key) {
      if (head == null)
         return ;

      // Find the required node
      Node curr = head, prev = new Node();
      while (curr.data != key) {
         if (curr.next == head) {
            System.out.printf("\nGiven node is not found"
                  + " in the list!!!");
            break;
         }

         prev = curr;
         curr = curr.next;
      }

     
      if (curr == head && curr.next == head) {
         head = null;
         return ;
      }

     
      if (curr == head) {
         prev = head;
         while (prev.next != head)
            prev = prev.next;
         head = curr.next;
         prev.next = head;
      }

      // check if node is last node
      else if (curr.next == head) {
         prev.next = head;
      } else {
         prev.next = curr.next;
      }
      return prev ;
   }

   /* Driver code */
   public static void main(String args[]) {
    

      /* Created linked list will be 2.5.7.8.10 */
      head = push( 2);
      head = push( 5);
      head = push( 7);
      head = push( 8);
      head = push(10);

      System.out.printf("List Before Deletion: ");
      printList();

      head = deleteNode( 7);

      System.out.printf("List After Deletion: ");
      printList();
   }
}

// This code is contributed by Arnab Kundu
// This code is updated by Susobhan Akhuli
