package com.Hw6;


import java.util.NoSuchElementException;

public class ListOfNodes {
	//terminal colors
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	static Node head;


	public static int count() {
		//return the number of nodes in the chain of nodes that starts at head
		int count = 0;
		Node  current = head;
		while( current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public static Node getInstance(int index) {
		isElementIndex(index);
		int count = 0;
		Node  current = head;
		while( current != null && count !=index) {
			current = current.next;
			count++;
		}
		return current;
	}

	private static void isElementIndex(int index) {
		if( !(index >= 0 && index < count())) {
			errorMsg(" does not exist as index",index);
		}
	}

	public static boolean isEmpty() {
		return (head==null);
	}

	public static void addFirst(char data) {
		//creates a new node, sets its data value, and makes it the first node in the chain
		Node node = new Node(data);
		head= node;
	}

	public static String print() {
		//returns all the elements (characters) of the node between square brackets [] followed by a comma then the number of nodes
		//ex: [hello],5

		int count =0;
		if (head == null) {
			System.out.println("[],"+count);
			return "[]";
		} else {
			String result = "[" + head.data;
			Node current = head.next;
			count++;
			while( current != null) {
				result += current.data;
				current = current.next;
				count++;
			}
			result += "]";
			System.out.println(result+","+count );
			return result;
		}

	}

	public static void addLast(char data) {
		//creates a new node, sets its data value, and adds data to the end of the chain
		Node n = new Node(data);
		if (isEmpty()){
			head =n;
		}
		else {
			Node node = getInstance(count()-1);
			node.next = n;
		}
	}

	public static void addMiddle(int index, char data) {
		//creates a new node, sets its data value, and inserts it right after the node whose number in the chain is index
		if (index == count()){
			Node node= getInstance(index-1);
			node.next = new Node(data);

		}
		else {
			Node node= getInstance(index);

			if (node == head){
				Node temp = head;
				head=new Node(data);
				head.next = temp;
			}
			else {
				Node nextNodeAfterCurrent = node.next;
				Node newNode = new Node(data);
				node.next=newNode;
				newNode.next=nextNodeAfterCurrent;
			}
		}
	}

	public static void set(int index, char data)  {
		//changes the data value of the node located at position index
		Node node = getInstance(index);
		node.data =data;
	}

	public static char get(int index) {
		//returns the char stored in the node located at position index
		return getInstance(index).data;
	}

	public static void addAfterFirstOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it after the first node whose data value is afterData
		if (contains(afterData)){
		Node  current = head;
		Node pre;
		while( current != null) {
			pre =current;
			if (current.data == afterData){
				Node next = current.next;
				Node n = new Node(data);
				pre.next = n;
				n.next =next;
				break;
			}

			current = current.next;
		}
		}
		else{ errorMsg("does not exist as data",afterData); }

	}

	public static void addAfterLastOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it after the last node whose data value is afterData
		if ((contains(afterData))) {
			int count = 0;
			int num = -1;
			Node current = head;
			while (current != null) {
				if (current.data == afterData) {
					num = count;
				}
				current = current.next;
				count++;
			}
			addMiddle(num,data);
		}
		else  {
			errorMsg("does not exist as data",afterData);
		}


	}

	public static void addBeforeLastOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it before the last node whose data value is afterData
		if ((contains(afterData))) {
			int count = 0;
			int num = -1;
			Node current = head;
			while (current != null) {
				if (current.data == afterData) {
					num = count;
				}
				current = current.next;
				count++;
			}
			addMiddle(num-1,data);
		}
		else  {
			errorMsg("does not exist as data",afterData);
		}
	}

	public static void clear() {
		head.next =null;
		head =null;
	}

	public static void removeDuplicates() {
		//removes all duplicate values of the chain
		Node ptr1 = null, ptr2 = null, dup = null;
		ptr1 = head;
		while (ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;
			while (ptr2.next != null) {
				if (ptr1.data == ptr2.next.data) {
					dup = ptr2.next;
					ptr2.next = ptr2.next.next;
					System.gc();
				} else {
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}


	}

	public static char removeFirst() {
		//removes the first node in the chain
		if(!isEmpty()) {
			char a = head.data;
			head = head.next;
			return a;
		}
		else{
			throw new NoSuchElementException();
		}
	}

	public static char removeLast() {
		//removes the last node in the chain
		char data;
		if (count() ==1){
			head =null;
			return ' ';

		}
		else if(count() ==2){
			data = head.data;
			head.next =null;
			return data;
		}
		else {
			Node node = getInstance(count()-2);
			data = node.data;
			node.next =null;
			return data;
		}


	}

	 public static int removeFirstOccurrence(char data) {
		 //removes the first node whose data value is data
		 int count = 0;

		 if (head.data == data){
		 	head = head.next;
		 }
		else if (contains(data)){
			 Node  current = head.next;
			 Node pre = head;
			 count++;
			 while( current != null) {

				 if (current.data == data){
					 Node next = current.next;
					 pre.next=null;
					 pre.next = next;
					 break;
				 }
				 current = current.next;
				 count++;
				 pre= pre.next;
			 }
		 }
		 else{ errorMsg("does not exist as data",data); }
		return count;
	 }

	public static int removeLastOccurrence(char data) {
		int count = 0;

		if (head.data == data){
			head = head.next;
		}
		else if (contains(data)){
			Node  current = head.next;
			Node pre = head;
			Node node = null; // hold previous node to last occurrence
			while( current != null) {

				if (current.data == data){
					node =pre;
				}
				current = current.next;
				count++;
				pre= pre.next;
			}

			Node next = node.next;
			Node after = next.next;
			node.next = null;
			node.next =after;
		}
		else{ errorMsg("does not exist as data",data); }
		return count;
	}

	public static boolean contains(char data) {
		//returns true if any of the nodes in the chain contains data
		Node  current = head;
		while( current != null) {
			if (current.data == data)
				return true;
			else
			current = current.next;
		}
		return false;
	}

	public static void addAll(int index, char[] chars){
		//adds all characters in chars to the chain starting at position index
		//you must add a test case to test for proper implementation of this method.
		for (char x : chars) {
			addMiddle(index,x);
			index++;
		}
	}

	public static void swapPairs(){
		//swaps element 0 with element 1, element 2 with element 3, element 4 with element 5, etc.
		//if the list has an odd number of elements, the the last element remains the same
		//ex: ['a','b','c','d','e'] will become ['b','a','d','c','e'] after calling on swapPairs
		// If linked list is empty or there is only one node in list

		Node node = head;


		if(head==null || head.next==null){}


		Node h = new Node('0');
		h.next = head;

		Node p1 = head;
		Node p2 = head.next;

		Node pre = h;
		while(p1!=null && p2!=null){
			pre.next = p2;

			Node t = p2.next;
			p2.next = p1;
			pre = p1;
			p1.next = t;

			p1 = p1.next;

			if(t!=null)
				p2 = t.next;
		}
	}
	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void tostring(Node node ){
		System.out.println(node.data);
	}

	public static void errorMsg(String s,Object object){
		System.out.println(ANSI_RED+"Program execution stopped" );
			System.out.println(object +" "+s +ANSI_RESET);
			Thread.currentThread().interrupt();
	}


	public static void main(String[] args) {
		char[] chars = new char[]{'1','2','3','4'};
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


		addFirst('e');
		addMiddle(0,'e');
		addLast('l');
		print();
		addAll(0,chars);
		print();

		swapPairs();
		print();
	}
}
