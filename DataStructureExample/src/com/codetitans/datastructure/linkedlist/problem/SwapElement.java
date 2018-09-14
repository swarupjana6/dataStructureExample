package com.codetitans.datastructure.linkedlist.problem;

import java.io.Serializable;

import com.codetitans.datastructure.linkedlist.Node;

public class SwapElement<T extends Serializable> {

	public void swapElement(Node<T> node, T x, T y) {
		
		if( x == y ){
			return;
		}
		
		Node<T> prevX = null;
		Node<T> currX = node;
		
		Node<T> prevY = null;
		Node<T> currY = node;
		
		while(currX != null && !currX.getData().equals(x)){
			prevX = currX;
			currX = currX.getNextNode();
		}
		
		while(currY != null && !currY.getData().equals(y)){
			prevY = currY;
			currY = currY.getNextNode();
		}
		
		if(currX == null || currY == null){
			return;
		}
		
		if(prevX != null){
			prevX.setNextNode(currY);
		} else{
			node = currY;
		}
		
		if(prevY != null){
			prevY.setNextNode(currX);
		} else{
			node = currX;
		}
		
		Node<T> temp = currX.getNextNode();
		currX.setNextNode(currY.getNextNode());
		currY.setNextNode(temp);
	}
}
