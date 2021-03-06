package com.codetitans.datastructure.linkedlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.codetitans.datastructure.linkedlist.problem.LoopDetection;

public class SinglyLinkedList<T extends Serializable> {

	private Node<T> head;

	public Node<T> getHeadNode() {
		return head;
	}
	
	public SinglyLinkedList() {
	}
	
	public SinglyLinkedList(Node<T> head) {
		this.head = head;
	}

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above
	 */
	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.setNextNode(head);

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

		newNode.setNextNode(prevNode.getNextNode());
		prevNode.setNextNode(newNode);
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
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}

		currentNode.setNextNode(newNode);
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	public void deleteNode(T key) {

		Node<T> currentNode = head;
		Node<T> prevNode = null;

		if (head == null) {
			System.out.println("LinkedList is empty");
			return;
		}

		if (head.getData() == key) {
			head = currentNode.getNextNode();
			return;
		}

		while (currentNode != null) {

			if (currentNode.getData() == key) {
				prevNode.setNextNode(currentNode.getNextNode());
				currentNode = prevNode.getNextNode();
			} else {
				prevNode = currentNode;
				currentNode = currentNode.getNextNode();
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

		if (position == 0) {
			head = currentNode.getNextNode();
		}

		while (currentNode != null) {

			if (count == position) {
				prevNode.setNextNode(currentNode.getNextNode());
				currentNode = prevNode.getNextNode();
				positionFound = true;
				break;
			} else {
				prevNode = currentNode;
				currentNode = currentNode.getNextNode();
				count++;
			}
		}

		if (!positionFound) {
			System.out.println("LinkedList element count is less than the position provided.");
		}
	}

	// Checks whether the value x is present in linked list
	public boolean searchElement(T data) {

		boolean found = false;
		Node<T> currentNode = head;

		if (currentNode == null) {
			return found;
		}

		while (currentNode != null) {

			if (currentNode.getData().equals(data)) {
				found = true;
				break;
			}

			currentNode = currentNode.getNextNode();
		}

		return found;
	}

	/* Takes index as argument and return data at index */
	public List<Integer> searchNodePosition(T key) {
		List<Integer> position = new ArrayList<>();
		Node<T> currentNode = head;
		int count = 0;

		if (currentNode == null) {
			return position;
		}

		while (currentNode != null) {

			if (currentNode.getData().equals(key)) {
				position.add(count);
			}
			count++;
			currentNode = currentNode.getNextNode();
		}

		return position;
	}

	/* Function to get the nth node from the last of a linked list */
	public T searchNodeValueFromEnd(int position) throws Exception {

		if (head == null) {
			throw new Exception("LinkedList is empty");
		}
		int positionToFind = getCount() - position;
		Node<T> currentNode = head;

		if (positionToFind < 0) {
			throw new Exception("Position provided is out of Bound");
		}
		for (int index = 0; index < positionToFind; index++) {
			currentNode = currentNode.getNextNode();
		}

		return currentNode.getData();
	}

	//Find the the mid element by traversing two node variable
	public T findMiddleElement() throws Exception {
		Node<T> firstPtr = head;
		Node<T> secondPtr = head;

		if (head == null) {
			throw new Exception("LinkedList is empty");
		}

		while (secondPtr != null && secondPtr.getNextNode() != null) {
			firstPtr = firstPtr.getNextNode();
			secondPtr = secondPtr.getNextNode().getNextNode();
		}

		if (secondPtr == null) {
			System.out.println("Provided LinkedList is having Even count");
		} else {
			System.out.println("Provided LinkedList is having Odd count");
		}
		return firstPtr.getData();
	}
	
	//Find the middle element using count
	public T findMiddleElementUsingCount(){
		
		Node<T> currentNode = head;
		Node<T> midNode = currentNode;
		int count = 0;
		
		while(currentNode != null){
			
			count++;
			if(count % 2 == 0){
				midNode = midNode.getNextNode();
			}
			currentNode = currentNode.getNextNode();
			
		}
		
		return midNode.getData();
	}

	public int getCount() {

		int count = 0;
		Node<T> currentNode = head;

		while (currentNode != null) {
			count++;
			currentNode = currentNode.getNextNode();
		}

		return count;
	}

	public void printLinkedList() {
		
		LoopDetection<T> loopDetection = new LoopDetection<>();
		if(loopDetection.detectLoopHashTechnique(head)){
			throw new UnsupportedOperationException("provided LinkedList detected with loop.");
		}
		System.out.println("LinkedList Count :- " + getCount());
		if (head == null) {
			System.out.println("List is empty");
		}

		Node<T> currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}
}
