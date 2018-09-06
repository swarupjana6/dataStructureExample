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

	public boolean detectLoopUsingFlyodCycleAlgo(Node<T> node) {

		Node<T> firstPtr = node;
		Node<T> secondPtr = node;
		boolean loopFound = false;

		while (secondPtr != null && secondPtr.getNextNode() != null) {

			firstPtr = firstPtr.getNextNode();
			secondPtr = secondPtr.getNextNode().getNextNode();
			if (firstPtr == secondPtr) {
				loopFound = true;
				break;
			}

		}

		return loopFound;
	}

	// Returns count of loop nodes present using Flyod's Cycle detection
	// algorithm.
	public int countLoopNode(Node<T> node) {

		int count = 0;
		boolean loopFound = false;

		Node<T> firstPtr = node;
		Node<T> secondPtr = node;

		while (secondPtr != null && secondPtr.getNextNode() != null) {

			firstPtr = firstPtr.getNextNode();
			secondPtr = secondPtr.getNextNode().getNextNode();
			if (firstPtr == secondPtr) {
				loopFound = true;
				break;
			}

		}

		if (loopFound) {
			Node<T> temp = firstPtr;
			while (temp.getNextNode() != firstPtr) {
				count++;
				temp = temp.getNextNode();
			}
		}

		return count;
	}

	/**
	 * Method 1 (Check one by one) We know that Floyd’s Cycle detection
	 * algorithm terminates when fast and slow pointers meet at a common point.
	 * We also know that this common point is one of the loop nodes (2 or 3 or 4
	 * or 5 in the above diagram). We store the address of this in a pointer
	 * variable say ptr2. Then we start from the head of the Linked List and
	 * check for nodes one by one if they are reachable from ptr2. When we find
	 * a node that is reachable, we know that this node is the starting node of
	 * the loop in Linked List and we can get pointer to the previous of this
	 * node.
	 * 
	 * 1->2->3->4->5->
	 *    ^          |
	 *    |<----------
	 * 
	 * @param node
	 * @return
	 */
	public Node<T> removeLoopUsingFloydAlgo(Node<T> node) {

		Node<T> firstPtr = node;
		Node<T> secondPtr = node;

		while (secondPtr != null && secondPtr.getNextNode() != null) {

			firstPtr = firstPtr.getNextNode();
			secondPtr = secondPtr.getNextNode().getNextNode();
			if (firstPtr == secondPtr) {
				break;
			}
		}

		Node<T> current = node;
		Node<T> ptr2 = firstPtr;
		while (true) {
			/*
			 * Now start a pointer from loop_node and check if it ever reaches
			 * ptr2
			 */
			while (ptr2.getNextNode() != firstPtr && ptr2.getNextNode() != current) {
				ptr2 = ptr2.getNextNode();
			}

			/*
			 * If ptr2 reahced ptr1 then there is a loop. So break the loop
			 */
			if (ptr2.getNextNode() == current) {
				break;
			}

			/* If ptr2 did't reach ptr1 then try the next node after ptr1 */
			current = current.getNextNode();
		}

		/*
		 * After the end of loop ptr2 is the last node of the loop. So make next
		 * of ptr2 as NULL
		 */
		ptr2.setNextNode(null);

		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNextNode();
		}

		return node;
	}

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

	private LoopDetection<T>.NodeWithFlag createNodeWithFlag(Node<T> node) {

		if (node == null) {
			System.out.println("List is empty");
		}
		NodeWithFlag nodeWithFlag = new NodeWithFlag(node.getData());
		NodeWithFlag currentNode = nodeWithFlag;
		node = node.getNextNode();
		while (node != null) {

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
