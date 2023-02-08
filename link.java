import java.util.Scanner;

public class link {

   public static void main(String[] args) {
      ll a = new ll();
       //ll a = new ll();
      int n;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      for(int i=0;i<n;i++)
      {
         int d=sc.nextInt();
         a.insertL(d);
      }
     // System.out.print(a.pos(3)+" ");
     int sizz=a.size();
     
      for(int i=0;i<sizz;i++){
         int val=a.pos(i);
        for(int j=i+1;j<sizz;j++){
         if(a.pos(i)==a.pos(j))
         {
            a.deleteNode(val);
         sizz--;
      }
        }
      }
     // a.deleteNode(4);
    //  a.deleteNode(4);
     // System.out.print(a.searchData(4, a.size())+"\n");
      a.print();
     // System.out.print("\n" + a.size());

   }

}

class ll {
   int sz,SIZE;

   static class Node {
      int data;
      Node next;

      Node(int dat) {
         data = dat;
         next = null;
      }
   }

   static Node head = null;

   public void insertF(int dat) {
      sz++;
      Node newnode = new Node(dat);
      if (head == null) {
         head = newnode;
         return;
      } else {
         newnode.next = head;
         head = newnode;
      }

   }
   void deleteNode(int key)
	{
		Node temp = head, prev = null;

		
		if (temp != null && temp.data == key) {
			head = temp.next; 
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

	
		if (temp == null)
			return;

	
		prev.next = temp.next;
	}
   public void delete(int key){
      if(head==null)
      return ;
      if(head.next==null&&head.data==key)
      head=null;

   }
   public int pos(int i){
      int cnt=0;
      Node current = head;
      int value=current.data;
      while (current != null) {
         if(cnt==i){
            value=current.data;
            break;
         
         }
         cnt++;
         current = current.next;
      }
      return value;
     
   }

   public int searchData(int key,int siz){
      int ex=-1;
      if(head==null)
      return ex;
      Node curr=head;
      int f=0;
      for(int i=0;i<siz;i++){
         if(curr.data==key){
            f=1;
            return curr.data;
         }
         curr=curr.next;

      }
      if(f!=1)
      return ex;
      return f;
    
      

   }

   public void insertL(int dat) {
      sz++;
      Node newnode = new Node(dat);
      if (head == null) {
         head = newnode;
         return;
      }
      Node current = head;
      while (current.next != null) {
         current = current.next;
      }

      current.next = newnode;

   }

   public void insertM(int dat, int pos) {
      sz++;
      Node newnode = new Node(dat);
      if (head == null) {
         head = newnode;
         return;
      }
      if (pos > sz || pos < 0)
         return;
      Node current = head;
      Node temp = null;
      for (int i = 0; i < sz; i++) {
         if (i == pos) {
            temp.next = newnode;   
            newnode.next = current;
            break;
         }
         temp=current;
         current = current.next;


      }

   }
   public void deleteF(){
      sz--;
      if(head==null){
         return ;
      }
      head=head.next;
   }
   public void deleteL(){
      sz--;
      if(head==null){
         return ;
      }
      if(head.next==null){
         head=null;
         return;
      }
      Node SecondLast=head;
      head=head.next;
     
      while(SecondLast.next!=null){
         
         SecondLast=SecondLast.next;
      }
      SecondLast.next=null;
      
     sz--;
   }
   

   public void print() {
      if (head == null) {
         System.out.println("Empty");
         return;
      }

      Node current = head;

      while (current != null) {
         System.out.print(current.data + " ");
         current = current.next;
      }

   }

   public int size() {

      if (head == null) {
         SIZE=0;
         return SIZE;
      }

      Node current = head;

      while (current != null) {
         SIZE++;
         current = current.next;
      }
      return SIZE;
   }

}