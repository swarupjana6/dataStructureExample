package com.codetitans.datastructure.linkedlist.problem;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.codetitans.datastructure.linkedlist.Node;
import com.codetitans.datastructure.linkedlist.SinglyLinkedList;

public class LoopDetection<T extends Serializable> {

	/**
	 * Use Hashing: Traverse the list one by one and keep putting the node
	 * addresses in a Hash Table. At any point, if NULL is reached then return
	 * false and if next of current node points to any of the previously stored
	 * nodes in Hash then return true.
	 */
	
	public boolean detectLoopHashTechnique(Node<T> node){
		
		Set<Node<T>> nodeStorage = new HashSet<>();
		
		while(node != null){
			if(nodeStorage.contains(node)){
				return true;
			}
			
			nodeStorage.add(node);
			node = node.getNextNode();
		}
		return false;
	}
	
	public SinglyLinkedList<T> createSimpleLoopLinkedList(SinglyLinkedList<T> simpleLinkedList){
		
		Node<T> head = simpleLinkedList.getHeadNode();
		Node<T> currentNode = simpleLinkedList.getHeadNode();
		
		if(currentNode == null){
			System.out.println("LinkedList is empty");
		}
		
		while(currentNode.getNextNode() != null){
			currentNode = currentNode.getNextNode();
		}
		
		currentNode.setNextNode(head.getNextNode());
		
		return new SinglyLinkedList<>(head);
	}
	
}
