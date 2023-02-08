public class DLL {
   class Node {
      public int data;
      public Node prevNode;
      public Node nextNode;

      public Node(int data) {
         this.data = data;
      }
   }

   public void displayNode() {
      Node tempNode = headNode;
      while (tempNode != null) {
         System.out.print(tempNode.data + "–>");
         tempNode = tempNode.nextNode;
      }
      System.out.println("END");
   }

   Node headNode, tailNode = null;

   public void addNode(int data) {
      Node newNode = new Node(data);
      if (headNode == null) {
         headNode = tailNode = newNode;
         headNode.prevNode = null;
         tailNode.nextNode = null;
      } else {
         tailNode.nextNode = newNode;
         newNode.prevNode = tailNode;
         tailNode = newNode;
         tailNode.nextNode = null;
      }
   }

   public void deleteInitialNode() {
      if (headNode == null) {
         System.out.println("Doubly Linked List is empty");
         return;
      } else {
         if (headNode != tailNode) {
            headNode = headNode.nextNode;
         } else {
            headNode = tailNode = null;
         }
      }
   }

   void printNode() {
      Node currNode = headNode;
      if (headNode == null) {
         System.out.println("Doubly Linked List is empty");
         return;
      }
      while (currNode != null) {
         System.out.print(currNode.data + " ");
         currNode = currNode.nextNode;
      }
      System.out.println();
   }

   public static void main(String[] args) {
      DLL doublyLL = new DLL();
      doublyLL.addNode(3);
      doublyLL.addNode(5);
      doublyLL.addNode(7);
      doublyLL.addNode(9);
      doublyLL.addNode(11);
      System.out.println("Doubly linked list: ");
      doublyLL.printNode();
      doublyLL.addNode(15);
      doublyLL.addNode(17);
      doublyLL.addNode(19);
      doublyLL.deleteInitialNode();
      doublyLL.addNode(21);
      System.out.println("Doubly Linked List after deleting at the beginning: ");
      doublyLL.printNode();
   }
}