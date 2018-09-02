package com.codetitans.datastructure.linkedlist;

public class RunLinkedList {

	public static void runBasicLinkedList() {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.append(5);
		linkedList.append(6);
		linkedList.push(7);
		linkedList.push(8);
		linkedList.push(2);

		linkedList.printLinkedList();
		
		System.out.println("======Delete Node======");
		linkedList.deleteNode(4);
		linkedList.printLinkedList();
		
		/*System.out.println("======Delete Node======");
		linkedList.deleteNode(5);
		linkedList.deleteNode(2);
		linkedList.printLinkedList();*/
		
		
		System.out.println("======Delete Node at position 2======");
		linkedList.deleteNodeAtPosition(1);
		linkedList.printLinkedList();
		
		System.out.println("is element 3 present in linkedlist : - " + linkedList.searchElement(3));
		System.out.println("find element 4 position in linkedList :- " + linkedList.searchNodePosition(4));
		System.out.println("find element 8 position in linkedList :- " + linkedList.searchNodePosition(8));
		System.out.println("find element 2 position in linkedList :- " + linkedList.searchNodePosition(2));
		

		/*SinglyLinkedList<String> linkedList1 = new SinglyLinkedList<>();
		linkedList1.push("a");
		linkedList1.push("b");
		linkedList1.push("c");
		linkedList1.push("d");
		linkedList1.printLinkedList();*/
		
	}

	public static void main(String[] args) {

		runBasicLinkedList();
	}
}
