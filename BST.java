public class Node{
	int data;
	Node left;
	Node right;
	
	//left and right node of a Leaf are null
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public Node getLeft(){
		return this.left;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public Node getLeft(){
		return this.left;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
	public Node getRight(){
		return this.right;
	}
}

//BinarySearchTree contains a root
public class BinarySearchTree{
	
	public static Node root;
	
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	
	//Find a node in O(logn) time
	public boolean find(int data){
		Node cursor = root;
		while (cursor != null){
			if (cursor.data == data)
				return true;
			else if (cursor.data > data)
				cursor = cursor.left;
			else
				cursor = cursor.right;
			
		}
		
		return false;
	}
	
	//delete in O(logn)
	public boolean delete(int data){
		Node parent = root;
		Node cursor = root;
		booealn isLeftChild = false;
		
		while(cursor.data != data){
			//save the parent of the node to be deleted so we can set its left or right node to null when its deleted
			parent = cursor;
			
			//if cursors data is greater than data of node to be deleted, the node to be deleted must be a left child.
			if (cursor.data > data){
				isLeftChild = true;
				cursor = cursor.left;
			}else{
				isLeftChild = false;
				cursor = cursor.right;
			}
			
			//if we cant find the node to delete, return false
			if (cursor == null)
				return false;
		}
		
		//Case 1: node to be deleted has no children (leaf node)
		if (cursor.left == null && cursor.right == null){
			
			//If it's the root node and it has no children, just set it to null
			if (cursor == root)
				root = null;
			
			//If it's the left child, set its parent left Node to null
			if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		
		//Case 2: node to be deleted has only one child
		//	-Has only left child
		//	-Has only right child
		else if (cursor.right == null){
			
			if (cursor == root)
				root = cursor.left;
			
			else if (isLeftChild)
				parent.left = cursor.left;
			
			else
				parent.right = cursor.right;
			
		}
		
		else if (cursor.left == null){
			
			if (cursor == root)
				root = cursor.right;
			
			else if (isLeftChild)
				parent.left = cursor.right;
			
			else
				parent.right = cursor.right;
		}
		
		
		//Case 3: Node has 2 children
		//	-Need to get the Node that will replace the one to be deleted
		else if (cursor.left != null && cursor.right != null){
			Node successor = getSuccessor(cursor);
			if (cursor == root)
				root = successor;
			else if (isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;
			
			successor.left = cursor.left;
		}
		
		return true;
		
	}
	
	public Node getSuccessor(Node deleteNode){
		//successor is the smallest node on the right subtree
		Node successor = null;
		Node successorParent = null;
		Node cursor = deleteNode.right;
		while (cursor != null){
			successorParent = successor;
			successor = cursor;
			cursor = cursor.left;
		}
		
		if (successor != deleteNode.right){
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		
		return successor;
		
	}
	
	//always insert as a leaf node (when cursor == null)
	public void insert (int data){
		//create the node to be inserted
		Node newNode = new Node(data);
		//if root is null, make new node the root
		if (root == null){
			root = newNode;
			return;
		}
		
		Node cursor = root;
		Node parent = null;
		while(true){
			parent = cursor;
			if (data < cursor.data){
				cursor = cursor.left;
				if (cursor == null){
					parent.left = newNode;
					return;
				}
			}else{
				cursor = cursor.right;
				if (cursor == null){
					parent.right = newNode;
					return;
				}
			}
		}
			
	}
	
	//Inorder display
	public void display(Node root){
		if (root != null){
			display(root.left);
			System.out.println(root.data);
			display(root.right);
		}
		
	}
	
}