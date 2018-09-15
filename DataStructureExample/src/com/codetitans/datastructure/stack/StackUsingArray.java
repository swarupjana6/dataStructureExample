package com.codetitans.datastructure.stack;

import java.io.Serializable;

public class StackUsingArray<T extends Serializable> {

	int MAX_INDEX = 100;
	@SuppressWarnings("unchecked")
	T[] stack = (T[]) new Serializable[100];
	int top;
	
	public StackUsingArray() {
		this.top = -1;
	}
	
	public boolean isEmpty(){
		
		return (top < 0);
	}
	
	public boolean push(T data) throws Exception{
		
		if(top == (MAX_INDEX - 1)){
			System.out.println("Stack overflow");
			throw new Exception("Stack overflow");
		}
		
		stack[++top] = data;
		
		return true;
	}
	
	public T pop() throws Exception{
		
		if(isEmpty()){
			System.out.println("Stack underflow");
			throw new Exception("Stack underflow"); 
		}
		
		return stack[top--];
	}
	
	public T peek() throws Exception {
		
		if(isEmpty()){
			System.out.println("Stack underflow");
			throw new Exception("Stack underflow"); 
		}
		
		return stack[top];
	}
	
	public static void main(String[] args) {
		
		StackUsingArray<Integer> s = new StackUsingArray<>(); 
         
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
