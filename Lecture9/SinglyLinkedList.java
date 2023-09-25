import java.util.Iterator;

/**
 * The {@code SinglyLinkedList} class represents a singly linked list. It has
 * been adapted based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author Alexandra Papoutsaki
 * @author Aden Siebel
 *
 */
public class SinglyLinkedList<Item> implements Iterable<Item> {
	private Node head; // head of the singly linked list
	private int size; // number of nodes in the singly linked list

	/**
	 * This nested class defines the nodes in the singly linked list with a value
	 * and pointer to the next node they are connected.
	 */
	private class Node {
		Item item;
		Node next;
	}

	/**
	 * Returns true if the singly linked list does not contain any item.
	 * 
	 * @return true if the singly linked list does not contain any item
	 */
	public boolean isEmpty() {
		return head == null; // size() == 0
	}

	/**
	 * Returns the number of items in the singly linked list.
	 * 
	 * @return the number of items in the singly linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to be returned
	 * @return the item at specified index
     * @pre: 0<=index<size
	 */
	public Item get(int index) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
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
	 * Inserts the specified item at the head of the singly linked list.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void add(Item item) {
		// Save the old node
		Node oldHead = head;

		// Make a new node and assign it to head. Fix pointers.
		head = new Node();
		head.item = item;
		head.next = oldHead;

		size++; // increase number of nodes in singly linked list.
	}

	/**
	 * Inserts the specified item at the specified index.
	 * 
	 * @param index
	 *            the index to insert the item
	 * @param item
	 *            the item to insert
     * @pre: 0<=index<=size()
	 */
	public void add(int index, Item item) {
        if (index > size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
		if (index == 0) {
			add(item);
		} else {

			Node previous = null;
			Node finger = head;
			// search for index-th position
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			// create new value to insert in correct position.
			Node current = new Node();
			current.next = finger;
			current.item = item;
			// make previous value point to new value.
			previous.next = current;

			size++;
		}
	}

	/**
	 * Retrieves and removes the head of the singly linked list.
	 * 
	 * @return the head of the singly linked list.
	 */
	public Item remove() {
		Node temp = head;
		// Fix pointers.
		head = head.next;

		size--;

		return temp.item;
	}

	/**
	 * Retrieves and removes the item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to be removed
	 * @return the item previously at the specified index
     * @pre: 0<=index<size()
	 */
	public Item remove(int index) {
        if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
		if (index == 0) {
			return remove();
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

			size--;
			// finger's value is old value, return it
			return finger.item;
		}

	}

	/**
	 * Converts the singly linked list to a String.
	 */
	public String toString() {
		if (isEmpty()) {
			return "Singly Linked List: []";
		}

		String ret = "Singly Linked List: [";
		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += "->";
		}
		ret = ret.substring(0, ret.length() - 2);

		ret += "->] Head: ";
		ret += head.item;
		return ret;
	}

	/**
	 * Constructs an iterator for the singly linked list.
	 */
	public Iterator<Item> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * A subclass that defines the iterator for the singly linked list.
	 */
	private class SinglyLinkedListIterator implements Iterator<Item> {
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
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		System.out.println(sll);
		sll.add(1, 2);
		System.out.println(sll);
		sll.add(20);
		System.out.println(sll);
		sll.add(30);
		System.out.println(sll);
		sll.remove();
		System.out.println(sll);
		sll.remove();
		System.out.println(sll);
		sll.remove();
		System.out.println(sll);
		sll.add(1);
		System.out.println(sll);
		sll.add(3);
		System.out.println(sll);
		sll.remove();
		System.out.println(sll);
		sll.remove();
		System.out.println(sll);
		sll.remove();
		System.out.println(sll);
	}
}