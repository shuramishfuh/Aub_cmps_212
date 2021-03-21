package com.Hw6;

public class ListOfNodes {
	static Node head;

	public static void main(String[] args) {
		print();
		addFirst('e');
		print();
		addLast('l');
		print();
		addMiddle(0, 'H');
		print();
		addMiddle(count(), 'l');
		print();
		addLast('$');
		print();
		for (int i = 0; i < count(); i++) {
			set(i, (char) (65 + i));
		}

		print();
		
		for (int i = 0; i < count(); i++) {
			System.out.println(get(i));
		}
		print();
		addMiddle(2, 'C');
		print();
		addAfterFirstOccurrence('C', '$');
		print();
		addAfterFirstOccurrence('C', '$');
		print();
		addAfterLastOccurrence('C', 'X');
		print();
		addBeforeLastOccurrence('C', 'I');
		print();
		addBeforeLastOccurrence('$', '_');
		print();
		removeDuplicates();
		print();
		
		set(4,'C');
		set(6,'C');
		set(8,'C');
		print();
		int c = removeFirstOccurrence('C');
		print();
		System.out.println(c);
		
		c=removeLastOccurrence('C');
		print();
		System.out.println(c);
		while(count()>0) {
			c = removeLast();
			System.out.println((char)c);
			print();
		}
		
		boolean I = contains('I');
		System.out.println(I);
		boolean Y = contains('Y');
		System.out.println(Y);
		
		 while (count() > 0) {
		 System.out.println(removeFirst());
		 }
		 print();
	}

	public static int count() {
		//return the number of nodes in the chain of nodes that starts at head
		//your code here
	}

	public static void addFirst(char data) {
		//creates a new node, sets its data value, and makes it the first node in the chain
		//your code here
	}

	public static String print() {
		//returns all the elements (characters) of the node between square brackets [] followed by a comma then the number of nodes
		//ex: [hello],5
		//your code here
	}

	public static void addLast(char data) {
		//creates a new node, sets its data value, and adds data to the end of the chain 
		//your code here
	}

	public static void addMiddle(int index, char data) {
		//creates a new node, sets its data value, and inserts it right after the node whose number in the chain is index 
		//your code here
	}

	public static void set(int index, char data) {
		//changes the data value of the node located at position index
		//your code here
	}

	public static char get(int index) {
		//returns the char stored in the node located at position index
		//your code here
	}

	public static void addAfterFirstOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it after the first node whose data value is afterData
		//your code here
	}

	public static void addAfterLastOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it after the last node whose data value is afterData
		//your code here
	}

	public static void addBeforeLastOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it before the last node whose data value is afterData
		//your code here
	}

	public static void clear() {
		//makes count() return zero
		//your code here
	}

	public static void removeDuplicates() {
		//removes all duplicate values of the chain
		//your code here
	}

	public static char removeFirst() {
		//removes the first node in the chain
		//your code here
	}

	public static char removeLast() {
		//removes the last node in the chain
		//your code here
	}
	
	 public static int removeFirstOccurrence(char data) {
		 //removes the first node whose data value is data
		 //your code here
	 }
	
	public static int removeLastOccurrence(char data) {
		//removes the last node whose data value is data
		//your code here
	}
	

	public static boolean contains(char data) {
		//returns true if any of the nodes in the chain contains data
		//your code here
	}

	public static void addAll(int index, char[] chars) {
		//adds all characters in chars to the chain starting at position index
		//you must add a test case to test for proper implementation of this method.
	}
	
	public static void swapPairs(){
		//swaps element 0 with element 1, element 2 with element 3, element 4 with element 5, etc.
		//if the list has an odd number of elements, the the last element remains the same
		//ex: ['a','b','c','d','e'] will become ['b','a','d','c','e'] after calling on swapPairs
	}
}
