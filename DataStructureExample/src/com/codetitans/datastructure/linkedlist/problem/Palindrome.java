package com.codetitans.datastructure.linkedlist.problem;

import java.io.Serializable;

import com.codetitans.datastructure.linkedlist.Node;

public class Palindrome<T extends Serializable> {

	public boolean isPalindrome(Node<T> node) {

		Node<T> slowPtr = node;
		Node<T> fastPtr = node;
		Node<T> prevSlowPtr = node;
		Node<T> midPtr = null;
		Node<T> secondHalf;

		while (fastPtr != null && fastPtr.getNextNode() != null) {

			prevSlowPtr = slowPtr;
			slowPtr = slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode().getNextNode();
		}

		if (fastPtr != null) {
			midPtr = slowPtr;
			slowPtr = slowPtr.getNextNode();
		}

		secondHalf = slowPtr;
		prevSlowPtr.setNextNode(null);
		reverseList(secondHalf);
		boolean res = compareList(node, secondHalf);
		reverseList(secondHalf);

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
