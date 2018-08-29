package com.codetitans.datastructure.linkedlist;

public class RunLinkedList {

	public static void runBasicLinkedList() {

		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();

		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.append(5);
		linkedList.append(6);

		linkedList.printLinkedList();

		/*BasicLinkedList<String> linkedList1 = new BasicLinkedList<>();
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
