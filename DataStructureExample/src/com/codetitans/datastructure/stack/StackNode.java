package com.codetitans.datastructure.stack;

import java.io.Serializable;

import com.codetitans.datastructure.linkedlist.Node;

public class StackNode<T extends Serializable> {

	Node<T> root = null;
	
	public boolean isEmpty(){
		
		return root == null;
	}
	
	public void push(T data){
		
		Node<T> node = new Node<>(data);
		
		node.setNextNode(root);
		root = node;
		
	}
	
	public T pop() throws Exception{
		
		if(isEmpty()){
			System.out.println("Stack underflow");
			throw new Exception("Stack underflow");
		}
		Node<T> node = root;
		root = root.getNextNode();
		
		return node.getData();
	}
	
	public T peek() throws Exception {
		
		if(isEmpty()){
			System.out.println("Stack underflow");
			throw new Exception("Stack underflow");
		}
		
		return root.getData();
	}
	
	public static void main(String[] args) {
		
		StackNode<Integer> s = new StackNode<>();

		try {
			s.push(20);
			s.push(10);
			s.push(30);
			System.out.println(s.pop() + " Popped from stack");
			System.out.println(s.peek() + " peeked from stack");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
