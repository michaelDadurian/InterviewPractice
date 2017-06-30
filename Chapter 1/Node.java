class Node {
	Node next = null;
	int data;
	
	public Node(int d){
		data = d;
	}
	
	public appendToTail(int d){
		Node end = new Node(d);
		Node cursor = this;
		while (cursor != null){
			cursor = cursor.next();
		}
		cursor.next() = end;
	}
	
	Node deleteNode(Node head, int d){
		Node node = head;
		if (node.data == d){
			return head.next();
		}
	}
	
}