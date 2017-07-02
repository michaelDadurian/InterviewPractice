//single linked list implementation
public class Node{
	private Node next;
	private int data;
	
	public Node(int data){
		this.data = data;
	}
	
	
	public void appendToTail(int data){
		Node newNode = new Node(data);
		Node cursor = this;
		//iterate to end of list
		while (cursor.next != null){
			cursor = cursor.next;
		}
		//set cursor.next to the new node
		cursor.next = newNode;
	}
	
}
	
	public void removeDuplicates(Node node){
		Hashtable table = new Hashtable();
		Node previous = null;
		while (node != null){
			if (table.containsKey(node.data))
				previous.next = node.next;
			else{
				table.put(node.data, true);
				previous = node;
			}
			node = node.next;
		}
	}
	
	public Node findNthToLast(Node head, int n){
		if (head == null || n < 1)
			return null;
		Node cursor1 = head;
		Node cursor2 = head;
		
		//iterate to create distance of n between cursor1 and cursor2
		for (int i = 0; i < n-1; i++){
			//if list size < n, cursor2 will be null
			if (cursor2 == null){
				return null;
			}
			cursor2 = cursor2.next;
		}
		
		while (cursor2.next != null){
			//cursor1 is still referencing the head of the list
			cursor1 = cursor1.next;
			//iterate cursor2 to the end of the list, and cursor1 will now be at the nth to last element
			cursor2 = cursor2.next;
		}
		
		return cursor1;
		
	}
	
	public boolean deleteNodeInMiddle(Node n){
		if (n == null || n.next == null){
			return false;
		}
		
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
