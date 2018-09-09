package com.codetitans.datastructure.linkedlist.problem;

import java.io.Serializable;

import com.codetitans.datastructure.linkedlist.Node;

public class ReverseList<T extends Serializable> {

	/**
	 * 1. Initialize three pointers prev as NULL, curr as head and next as NULL.
	 * 2. Iterate trough the linked list. 
	 * In loop, do following. 
	 * // Before changing next of current, 
	 * // store next node next = curr->next 
	 * // Now change next
	 * of current 
	 * // This is where actual reversing happens curr->next = prev
	 * 
	 * // Move prev and curr one step forward prev = curr curr = next
	 */
	public Node<T> iterativeMethod(Node<T> head) {

		Node<T> prev = null;
		Node<T> next = null;
		Node<T> current = head;

		if (head == null || head.getNextNode() != null) {
			return head;
		}

		while (current != null) {

			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
		}
		
		head = prev;
		
		return head;
	}
	
	/**
	 * 1) Divide the list in two parts - first node and rest of the linked list.
	 * 2) Call reverse for the rest of the linked list. 
	 * 3) Link rest to first.
	 * 4) Fix head pointer
	 */
	public Node<T> recurssiveMethod(Node<T> head, Node<T> prev){
		
		if(head.getNextNode() == null) {
			
			head = prev;
			return head;
		}
		
		Node<T> next1 = head.getNextNode();
		head.setNextNode(prev);
		
		recurssiveMethod(next1, head);
		
		return head;
	}
	
	public void reverseMethod(Node<T> current, Node<T> prev){
		
		
	}
}
