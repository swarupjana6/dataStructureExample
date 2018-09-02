package com.codetitans.datastructure.linkedlist.problem;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.codetitans.datastructure.linkedlist.Node;
import com.codetitans.datastructure.linkedlist.SinglyLinkedList;

public class LoopDetection<T extends Serializable> {

	public SinglyLinkedList<T> createSimpleLoopLinkedList(SinglyLinkedList<T> simpleLinkedList) {

		Node<T> head = simpleLinkedList.getHeadNode();
		Node<T> currentNode = simpleLinkedList.getHeadNode();

		if (currentNode == null) {
			System.out.println("LinkedList is empty");
		}

		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}

		currentNode.setNextNode(head.getNextNode());

		return new SinglyLinkedList<>(head);
	}

	/**
	 * Use Hashing: Traverse the list one by one and keep putting the node
	 * addresses in a Hash Table. At any point, if NULL is reached then return
	 * false and if next of current node points to any of the previously stored
	 * nodes in Hash then return true.
	 */

	public boolean detectLoopHashTechnique(Node<T> node) {

		Set<Node<T>> nodeStorage = new HashSet<>();

		while (node != null) {
			if (nodeStorage.contains(node)) {
				return true;
			}

			nodeStorage.add(node);
			node = node.getNextNode();
		}
		return false;
	}

	/**
	 * Mark Visited Nodes: This solution requires modifications to basic linked
	 * list data structure. Have a visited flag with each node. Traverse the
	 * linked list and keep marking visited nodes. If you see a visited node
	 * again then there is a loop. This solution works in O(n) but requires
	 * additional information with each node. A variation of this solution that
	 * doesn’t require modification to basic data structure can be implemented
	 * using hash. Just store the addresses of visited nodes in a hash and if
	 * you see an address that already exists in hash then there is a loop.
	 * 
	 * Floyd’s Cycle-Finding Algorithm: This is the fastest method. Traverse
	 * linked list using two pointers. Move one pointer by one and other pointer
	 * by two. If these pointers meet at same node then there is a loop. If
	 * pointers do not meet then linked list doesn’t have loop.
	 */
	public boolean detectLoopUsingMarkVisitNode(Node<T> node) {

		NodeWithFlag nodeWithFlag = createNodeWithFlag(node);
		NodeWithFlag firstPtr = nodeWithFlag;
		NodeWithFlag secondPtr = nodeWithFlag;

		while (firstPtr != null && secondPtr != null) {
			if (secondPtr.isFlag()) {
				return true;
			}
			firstPtr.setFlag(true);
			
			firstPtr = (LoopDetection<T>.NodeWithFlag) firstPtr.getNextNode();
			secondPtr = (LoopDetection<T>.NodeWithFlag) secondPtr.getNextNode().getNextNode();
		}
		return false;
	}

	private LoopDetection<T>.NodeWithFlag createNodeWithFlag(Node<T> node) {
		
		if(node == null){
			System.out.println("List is empty");
		}
		NodeWithFlag nodeWithFlag = new NodeWithFlag(node.getData());
		NodeWithFlag currentNode = nodeWithFlag;
		node = node.getNextNode();
		while(node != null){
			
			NodeWithFlag newNode = new NodeWithFlag(node.getData());
			currentNode.setNextNode(newNode);
			currentNode = (LoopDetection<T>.NodeWithFlag) currentNode.getNextNode();
			node = node.getNextNode();
		}
		
		return nodeWithFlag;
	}

	public class NodeWithFlag extends Node<T> {

		boolean flag;

		public NodeWithFlag(T data) {
			super(data);
		}

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

	}

}
