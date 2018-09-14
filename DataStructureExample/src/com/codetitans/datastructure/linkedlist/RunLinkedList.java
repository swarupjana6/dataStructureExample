package com.codetitans.datastructure.linkedlist;

import com.codetitans.datastructure.linkedlist.problem.LoopDetection;
import com.codetitans.datastructure.linkedlist.problem.Palindrome;
import com.codetitans.datastructure.linkedlist.problem.SwapElement;

public class RunLinkedList {

	private static void runBasicLinkedList() {

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

		/*
		 * System.out.println("======Delete Node======");
		 * linkedList.deleteNode(5); linkedList.deleteNode(2);
		 * linkedList.printLinkedList();
		 */

		System.out.println("======Delete Node at position 2======");
		linkedList.deleteNodeAtPosition(1);
		linkedList.printLinkedList();

		System.out.println("======Find the element is present in the linkedList======");
		System.out.println("is element 3 present in linkedlist : - " + linkedList.searchElement(3));

		System.out.println("======print the element by providing the position in the linkedList======");
		System.out.println("find element 4 position in linkedList :- " + linkedList.searchNodePosition(4));
		System.out.println("find element 8 position in linkedList :- " + linkedList.searchNodePosition(8));
		System.out.println("find element 2 position in linkedList :- " + linkedList.searchNodePosition(2));

		System.out.println("===print the element from the end by providing position in linkedList====");
		try {
			System.out.println(
					"find element of 2nd position from end in linkedList :- " + linkedList.searchNodeValueFromEnd(2));
			System.out.println(
					"find element of 4th position from end in linkedList :- " + linkedList.searchNodeValueFromEnd(4));
			System.out.println(
					"find element of 10th position from end in linkedList :- " + linkedList.searchNodeValueFromEnd(10));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("===Find the middle of a given linked list====");
		try {
			System.out.println("Print the middle element using two node: - " + linkedList.findMiddleElement());
			System.out.println(
					"Print the middle element using single node: - " + linkedList.findMiddleElementUsingCount());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * SinglyLinkedList<String> linkedList1 = new SinglyLinkedList<>();
		 * linkedList1.push("a"); linkedList1.push("b"); linkedList1.push("c");
		 * linkedList1.push("d"); linkedList1.printLinkedList();
		 */

	}

	private static void runDetectLoopLinkedList() {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		LoopDetection<Integer> loopDetectionLinkedList = new LoopDetection<>();

		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);
		linkedList.push(5);
		linkedList.push(6);
		linkedList.push(7);
		linkedList.push(8);

		System.out.println("LinkedList[ " + linkedList + "] contain loop using Hashing Technique:- "
				+ loopDetectionLinkedList.detectLoopHashTechnique(linkedList.getHeadNode()));
		System.out.println("LinkedList[ " + linkedList + "] contain loop using Mark Visit Technique:- "
				+ loopDetectionLinkedList.detectLoopUsingMarkVisitNode(linkedList.getHeadNode()));
		SinglyLinkedList<Integer> loopLinkedList = loopDetectionLinkedList.createSimpleLoopLinkedList(linkedList);
		// no require to print as operation will never come out of loop as
		// linkedlist contain loop. As of now if try to print looplinkedlist
		// then it will throw error. In later part function will write to handle
		// to print the loop.
		// loopLinkedList.printLinkedList();
		System.out.println("LinkedList[ " + loopLinkedList + "] contain loop using Hashing Technique:- "
				+ loopDetectionLinkedList.detectLoopHashTechnique(loopLinkedList.getHeadNode()));
		/*System.out.println("LinkedList[ " + loopLinkedList + "] contain loop using Mark Visit Technique:- "
				+ loopDetectionLinkedList.detectLoopUsingMarkVisitNode(loopLinkedList.getHeadNode()));*/

		
		//Find the Length of Loop node.
//		loopLinkedList.printLinkedList();
		System.out.println("Length of Loop Node :- " + loopDetectionLinkedList.countLoopNode(loopLinkedList.getHeadNode()));
		
		
		//Remove Loop
		System.out.println("Remove the loop using method 1 Floyd Alog 1");
		loopDetectionLinkedList.removeLoopUsingFloydAlgo(loopLinkedList.getHeadNode());
		System.out.println();
		System.out.println("Remove the loop using method 2 Floyd Alog 2");
		loopLinkedList = loopDetectionLinkedList.createSimpleLoopLinkedList(linkedList);
		loopDetectionLinkedList.removeLoopUsingFloydAlgo(loopLinkedList.getHeadNode());
		System.out.println();
		System.out.println("Remove the loop using method 3");
		loopLinkedList = loopDetectionLinkedList.createSimpleLoopLinkedList(linkedList);
		loopDetectionLinkedList.removeLoopMethod3(loopLinkedList.getHeadNode());
		System.out.println();
		
	}
	
	private static void runPalidromeTest() {

		String palidromeString = "abacaba";
		SinglyLinkedList<Character> linkedList = new SinglyLinkedList<>();
		Palindrome<Character> palindrome = new Palindrome<>();
		
		for (int index = 0; index < palidromeString.length(); index++) {
			char word = palidromeString.charAt(index);
			linkedList.push(word);
		}
		
		System.out.println("The word " + palidromeString + " is palidrome : - " + palindrome.isPalindrome(linkedList.getHeadNode()));
	}
	
	private static void swapLinkedListElemet() {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		SwapElement<Integer> swapEle = new SwapElement<>();
		int x = 12, y = 20;
		
		linkedList.push(10);
		linkedList.push(15);
		linkedList.push(12);
		linkedList.push(26);
		linkedList.push(5);
		linkedList.push(50);
		linkedList.push(20);
		linkedList.push(17);
		linkedList.push(32);
		
		System.out.println("Original List element position :- ");
		linkedList.printLinkedList();
		
		swapEle.swapElement(linkedList.getHeadNode(), x, y);
		
		System.out.println("Swapped List element position for " + x +" & " + y + " :- ");
		linkedList.printLinkedList();
	}

	public static void main(String[] args) {

		runBasicLinkedList();
		runDetectLoopLinkedList();
		runPalidromeTest();
		swapLinkedListElemet();
	}

}
