package com.codetitans.datastructure.stack;

import java.io.Serializable;

/**
 * A space efficient implementation.
 * 
 * This method efficiently utilizes the available space. It doesn’t cause an
 * overflow if there is space available in arr[]. The idea is to start two
 * stacks from two extreme corners of arr[]. stack1 starts from the leftmost
 * element, the first element in stack1 is pushed at index 0. The stack2 starts
 * from the rightmost corner, the first element in stack2 is pushed at index
 * (n-1). Both stacks grow (or shrink) in opposite direction. To check for
 * overflow, all we need to check is for space between top elements of both
 * stacks. This check is highlighted in the below code.
 * 
 * Java program to implement two stacks in a single array
 * 
 * @author Swarupkumar
 *
 * @param <T>
 */
public class TwoStackUsingArrays<T extends Serializable> {

	T[] stack;
	int size;
	int top1;
	int top2;

	@SuppressWarnings("unchecked")
	public TwoStackUsingArrays(int size) {

		this.stack = (T[]) new Serializable[size];
		this.size = size;
		top1 = -1;
		top2 = size;
	}

	// Method to push an element x to stack1
	public void push1(T data) throws Exception {

		// There is at least one empty space for
        // new element
		if ((top1 + 1) >= top2) {
			System.out.println("Stack1 is overflow");
			throw new Exception("Stack1 is overflowed");
		}

		stack[++top1] = data;

	}

	// Method to push an element x to stack2
	public T pop1() throws Exception {

		// There is at least one empty space for
        // new element
		if (top1 == -1) {
			System.out.println("Stack1 underflow");
			throw new Exception("Stack1 underflow");
		}

		return stack[top1--];
	}

	public T peek1() throws Exception {
		if (top1 == -1) {
			System.out.println("Stack1 underflow");
			throw new Exception("Stack1 underflow");
		}

		return stack[top1];
	}

	public void push2(T data) throws Exception {

		if (top1 >= (top2 - 1)) {
			System.out.println("Stack1 is overflow");
			throw new Exception("Stack1 is overflowed");
		}

		stack[--top2] = data;

	}

	public T pop2() throws Exception {

		if (top2 == size) {
			System.out.println("Stack2 underflow");
			throw new Exception("Stack2 underflow");
		}

		return stack[top2++];
	}

	public T peek2() throws Exception {

		if (top2 == size) {
			System.out.println("Stack2 underflow");
			throw new Exception("Stack2 underflow");
		}

		return stack[top2];
	}

	public static void main(String[] args) {

		TwoStackUsingArrays<Integer> ts = new TwoStackUsingArrays<>(10);

		try {
			ts.push1(5);
			ts.push2(10);
			ts.push2(15);
			ts.push1(11);
			ts.push2(7);
			System.out.println("Popped element from" + " stack1 is " + ts.pop1());
			ts.push2(40);
			System.out.println("Popped element from" + " stack2 is " + ts.pop2());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
