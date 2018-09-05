package com.codetitans.datastructure.tree;

class Node {
	int key;
	Node left;
	Node right;
	
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public int getKey() { return key; }
	public void setKey(int key) { this.key = key; }

	public Node getLeft() { return left; }
	public void setLeft(Node left) { this.left = left; }

	public Node getRight() { return right; }
	public void setRight(Node right) { this.right = right; }
}

public class BinaryTree {
	
	// Root Node
	private Node root;
	
	// Constructors
	private BinaryTree() {
        this.root = null;
    }
	
    private BinaryTree(int key) {
    	this.root = new Node(key);
    }
 
    public static void main(String[] args) {
    	BinaryTree tree = new BinaryTree();
    	
    	/*create root*/
        tree.root = new Node(1);
        
        /*Add Left and Right node*/
        tree.root.setLeft(new Node(2));
        tree.root.setRight(new Node(3));
        
        /* 2 and 3 become left and right children of 1
		        1
		      /   \
		     2      3
		   /    \    /  \
		 null null null null  */
        
        /*Add Left node to the above left node 2*/
        tree.root.getLeft().setLeft(new Node(4));
        /* 4 becomes left child of 2
		        1
		    /       \
		   2          3
		 /   \       /  \
		4    null  null  null
		/   \
		null null
		*/
    }
}


