package com.codetitans.datastructure.linkedlist.problem;

import java.io.Serializable;

import com.codetitans.datastructure.linkedlist.Node;

/**
 * Program to check if a linked list is palindrome
 * 
 * @author Swarupkumar
 *
 * @param <T>
 * 
 * @see https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-
 *      is-palindrome/
 */
public class Palindrome<T extends Serializable> {

	public boolean isPalindrome(Node<T> node) {

		Node<T> slowPtr = node;
		Node<T> fastPtr = node;
		Node<T> prevSlowPtr = node;
		Node<T> midPtr = null;
		Node<T> secondHalf;

		/*
		 * Get the middle of the list. Move slow_ptr by 1 and fast_ptrr by 2,
		 * slow_ptr will have the middle node
		 */
		while (fastPtr != null && fastPtr.getNextNode() != null) {

			/*
			 * We need previous of the slow_ptr for linked lists with odd
			 * elements
			 */
			prevSlowPtr = slowPtr;

			slowPtr = slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode().getNextNode();
		}

		/*
		 * fast_ptr would become NULL when there are even elements in list. And
		 * not NULL for odd elements. We need to skip the middle node for odd
		 * case and store it somewhere so that we can restore the original list
		 */
		if (fastPtr != null) {
			midPtr = slowPtr;
			slowPtr = slowPtr.getNextNode();
		}

		// Now reverse the second half and compare it with first half
		secondHalf = slowPtr;

		prevSlowPtr.setNextNode(null);// NULL terminate first half
		reverseList(secondHalf);// Reverse the second half
		boolean res = compareList(node, secondHalf);

		// NULL terminate first half
		reverseList(secondHalf);// Reverse the second half again

		// If there was a mid node (odd size case) which
		// was not part of either first half or second half.
		if (midPtr != null) {

			prevSlowPtr.setNextNode(midPtr);
			midPtr.setNextNode(secondHalf);

		} else {
			prevSlowPtr.setNextNode(secondHalf);
		}

		return res;
	}

	private void reverseList(Node<T> node) {

		Node<T> current = node;
		Node<T> prev = null, next = null;

		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
		}

		node = prev;
	}

	private boolean compareList(Node<T> list1, Node<T> list2) {

		while (list1 != null && list2 != null) {

			if (list1.getData().equals(list2.getData())) {
				list1 = list1.getNextNode();
				list2 = list2.getNextNode();
			} else {
				return false;
			}
		}
		return true;
	}
}
