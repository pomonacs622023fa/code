import java.util.Iterator;

/**
 * The {@code DoublyLinkedList} class represents a doubly linked list. It has
 * been adapted based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author Alexandra Papoutsaki
 * @author Aden Siebel
 *
 */
public class DoublyLinkedList<Item> implements Iterable<Item> {
	private Node head; // head of the doubly linked list
	private Node tail; // tail of the doubly linked list
	private int size; // number of nodes in the doubly linked list

	/**
	 * This nested class defines the nodes in the doubly linked list with a value
	 * and pointers to the previous and next node they are connected.
	 */
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	/**
	 * Returns true if the doubly linked list does not contain any item.
	 * 
	 * @return true if the doubly linked list does not contain any item
	 */
	public boolean isEmpty() {
		return size == 0; // return head == null && tail == null;
	}

	/**
	 * Returns the number of items in the doubly linked list.
	 * 
	 * @return the number of items in the doubly linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns item at the specified index.
	 * 
	 * @param index
	 *              the index of the item to be returned
	 * @return the item at specified index
	 * @pre: 0<=index<size
	 */
	public Item get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		if (index == 0) {
			return head.item;
		} else if (index == size - 1) {
			return tail.item;
		}
		Node finger = head;
		// search for index-th element or end of list
		while (index > 0) {
			finger = finger.next;
			index--;
		}
		return finger.item;
	}

	/**
	 * Inserts the specified item at the head of the doubly linked list.
	 * 
	 * @param item
	 *             the item to be inserted
	 */
	public void addFirst(Item item) {
		// Save the old node
		Node oldHead = head;

		// Make a new node and assign it to head. Fix pointers.
		head = new Node();
		head.item = item;
		head.next = oldHead;
		head.prev = null;

		// if first node to be added, adjust tail to it.
		if (tail == null) {
			tail = head;
		} else {
			oldHead.prev = head;
		}
		size++; // increase number of nodes in doubly linked list.
	}

	/**
	 * Inserts the specified item at the tail of the doubly linked list.
	 * 
	 * @param item
	 *             the item to be inserted
	 */
	public void addLast(Item item) {
		// Save the old node
		Node oldTail = tail;

		// Make a new node and assign it to tail. Fix pointers.
		tail = new Node();
		tail.item = item;
		tail.next = null;
		tail.prev = oldTail;

		// if first node to be added, adjust head to it.
		if (head == null) {
			head = tail;
		} else {
			oldTail.next = tail;
		}
		size++;
	}

	/**
	 * Inserts the specified item at the specified index.
	 * 
	 * @param index
	 *              the index to insert the item
	 * @param item
	 *              the item to insert
	 * @pre: 0<=index<=size
	 */
	public void add(int index, Item item) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		if (index == 0) {
			addFirst(item);
		} else if (index == size) {
			addLast(item);
		} else {

			Node previous = null;
			Node finger = head;
			// search for index-th position
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			// create new value to insert in correct position
			Node current = new Node();
			current.item = item;
			current.next = finger;
			current.prev = previous;
			previous.next = current;
			finger.prev = current;

			size++;
		}
	}

	/**
	 * Retrieves and removes the head of the doubly linked list.
	 * 
	 * @return the head of the doubly linked list.
	 */
	public Item removeFirst() {
		Node oldHead = head;
		// Fix pointers.
		head = head.next;
		// if there was only one node in the doubly linked list.
		if (head == null) {
			tail = null; // remove final node.
			
		} else {
			head.prev = null;
		}
		oldHead.next = null;

		size--;

		return oldHead.item;
	}

	/**
	 * Retrieves and removes the tail of the doubly linked list.
	 * 
	 * @return the tail of the doubly linked list.
	 */
	public Item removeLast() {

		Node temp = tail;
		tail = tail.prev;

		// if there was only one node in the doubly linked list.
		if (tail == null) {
			head = null;
		} else {
			tail.next = null;
		}
		size--;
		return temp.item;
	}

	/**
	 * Retrieves and removes the item at the specified index.
	 * 
	 * @param index
	 *              the index of the item to be removed
	 * @return the item previously at the specified index
	 * @pre: 0<=index<size
	 */
	public Item remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node previous = null;
			Node finger = head;
			// search for value indexed, keep track of previous
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			previous.next = finger.next;
			finger.next.prev = previous;

			size--;
			// finger's value is old value, return it
			return finger.item;
		}

	}

	/**
	 * Converts the doubly linked list to a String.
	 */
	public String toString() {
		if (isEmpty()) {
			return "Doubly Linked List: []";
		}

		String ret = "Doubly Linked List: [<- ";
		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += " <-> ";
		}
		ret = ret.substring(0, ret.length() - 5);

		ret += " ->] First: ";
		ret += head.item;
		ret += ", Last: " + tail.item;
		return ret;
	}

	/**
	 * Constructs an iterator for the doubly linked list.
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * A subclass that defines the iterator for the doubly linked list.
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = head;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String args[]) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(1);
		System.out.println(dll);
		dll.add(0, 2);
		System.out.println(dll);
		dll.addLast(20);
		System.out.println(dll);
		dll.addFirst(30);
		System.out.println(dll);
		dll.removeFirst();
		System.out.println(dll);
		dll.removeLast();
		System.out.println(dll);
		dll.removeLast();
		System.out.println(dll);
		dll.addLast(1);
		System.out.println(dll);
		dll.addFirst(3);
		System.out.println(dll);
		dll.removeFirst();
		System.out.println(dll);
		dll.removeFirst();
		System.out.println(dll);
		dll.removeFirst();
		System.out.println(dll);
	}
}