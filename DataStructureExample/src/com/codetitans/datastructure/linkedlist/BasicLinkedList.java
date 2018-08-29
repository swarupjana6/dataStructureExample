package com.codetitans.datastructure.linkedlist;

import java.io.Serializable;

public class BasicLinkedList<T extends Serializable> {

	private Node<T> head;

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above
	 */
	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.setNext(head);

		head = node;
	}

	/*
	 * This function is in LinkedList class. Inserts a new node after the given
	 * prev_node. This method is defined inside LinkedList class shown above
	 */
	public void insertAfter(Node<T> prevNode, T data) {
		if (prevNode == null) {
			System.out.println("Node details cannot be null");
			return;
		}

		Node<T> newNode = new Node<T>(data);

		newNode.setNext(prevNode.getNext());
		prevNode.setNext(newNode);
	}

	/*
	 * Appends a new node at the end. This method is defined inside LinkedList
	 * class shown above
	 */
	public void append(T data) {

		Node<T> newNode = new Node<T>(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node<T> currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(newNode);
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode(T key) {

		Node<T> currentNode = head;
		Node<T> prevNode = null;

		if (head == null) {
			System.out.println("LinkedList is empty");
			return;
		}

		if (head.getData() == key) {
			head = currentNode.getNext();
			return;
		}

		while (currentNode != null) {

			if (currentNode.getData() == key) {
				prevNode.setNext(currentNode.getNext());
				currentNode = prevNode.getNext();
			} else {
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a
	 * position, deletes the node at the given position
	 */
	void deleteNodeAtPosition(int position) {

		Node<T> currentNode = head;
		Node<T> prevNode = null;
		int count = 0;
		boolean positionFound = false;
		
		if(position == 0){
			head = currentNode.getNext();
		}
		
		while(currentNode != null){
			
			if(count == position){
				prevNode.setNext(currentNode.getNext());
				currentNode = prevNode.getNext();
				positionFound = true;
				break;
			}
			else {
				prevNode = currentNode;
				currentNode = currentNode.getNext();
				count++;
			}
		}
		
		if(!positionFound){
			System.out.println("LinkedList element count is less than the position provided.");
		}
	}

	public void printLinkedList() {
		if (head == null) {
			System.out.println("List is empty");
		}

		Node<T> currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
}
