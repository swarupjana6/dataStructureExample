package com.codetitans.datastructure.linkedlist;

public class BasicLinkedList<T> {
	
	private Node<T> head;

	/* This function is in LinkedList class. Inserts a
	   new Node at front of the list. This method is 
	   defined inside LinkedList class shown above */
	public void push(T data)
	{
		Node<T> node = new Node<T>(data);
		node.setNext(head);
		
		head = node;
	}
	
	/* This function is in LinkedList class.
	   Inserts a new node after the given prev_node. This method is 
	   defined inside LinkedList class shown above */
	public void insertAfter(Node<T> prevNode, T data)
	{
		if(prevNode == null){
			System.out.println("Node details cannot be null");
			return;
		}
		
		Node<T> newNode = new Node<T>(data);
		
		newNode.setNext(prevNode.getNext());
		prevNode.setNext(newNode);
	}
	
	/* Appends a new node at the end.  This method is 
	   defined inside LinkedList class shown above */
	public void append(T data)
	{
		
		Node<T> newNode = new Node<T>(data);
		
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		Node<T> currentNode = head;
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(newNode);
	}
	
	public void printLinkedList()
	{
		if (head == null){
			System.out.println("List is empty");
		}
		
		Node<T> currentNode = head;
		while(currentNode != null)
		{
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
}
