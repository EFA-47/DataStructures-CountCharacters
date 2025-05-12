package HW2;

public class HW2 {
	// Node structure containing power and coefficient of variable
		static class Node
		{
		 // Your code here
			Node next;
			double coeff;
			int power;
			Node(double c,int p){
				coeff=c;
				power=p;
				next=null;
			}
			
		};
		
		//Function To Display The Linked list
		static void printList( Node ptr)
		{
			if (ptr == null) 
			{
				System.out.println();
				return;
			}
			else if (ptr.next != null)
			{
				while (ptr.next != null)
				{
					System.out.print( ptr.coeff + "x^" + ptr.power + " + ");
					ptr = ptr.next;
				}
			}
			System.out.println( ptr.coeff + "x^" + ptr.power);
		}
	  
		// Create a node and return
		static Node createNode(double coeff, int power)
		{
		// Your code here
			Node create= new Node(coeff,power);
			return create;
		}
	  
	  	// Function add a new node
		static Node addnode(Node head, double coeff, int power)
		{
		// Your code here
			if(head==null) {
				head=new Node(coeff,power);
			}
			else{
				Node current=head;
				while(current.next!=null) {
					if(current.power==power) {
						current.coeff+=coeff;
						return head;
					}
					current=current.next;
				}if(current.power==power) {
					current.coeff+=coeff;
					return head;
				}
				current.next=new Node(coeff,power);
			}
			return head;
			
		 
		}
	  
		static Node multiply(Node poly1, Node poly2)
		{
		// Your code here
			
			Node first=poly1;
			Node second=poly2;
			Node poly3=null;
			while(first!=null) {
				while(second!=null) {
					poly3=addnode(poly3, first.coeff*second.coeff, first.power+second.power);
					second=second.next;
				}second=poly2;
				first=first.next;
			}toparla(poly3);
			return poly3;
		}
	  
		static Node add(Node poly1, Node poly2)
		{
		// Your code here
			Node first=poly1;
			Node second=poly2;
			Node poly3=null;
			while(first!=null) {
				poly3=addnode(poly3, first.coeff, first.power);
				first=first.next;
			}
			
			while(second!=null) {
					poly3=addnode(poly3, second.coeff, second.power);
					second=second.next;
			}
				
			toparla(poly3);
			return poly3;
		}
		
		static void toparla(Node poly3) {
			Node first=poly3;
			Node second=first.next;
			int power;
			double coefficent;
			while(first!=null) {
				while(second!=null) {
					if(first.power<second.power) {
						power=first.power;
						coefficent=first.coeff;
						
						first.power=second.power;
						first.coeff=second.coeff;
						
						second.power=power;
						second.coeff=coefficent;
						
						
					}second=second.next;
					
					
				}first=first.next;
				if(first==null) {
					continue;
				}
				second=first.next;
			}
			
			
		}
}
		
