package com.codetitans.datastructure.linkedlist;

import java.io.Serializable;

public class Node<T extends Serializable> {

	private T data;
	private Node<T> nextNode;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> next) {
		this.nextNode = next;
	}

}
