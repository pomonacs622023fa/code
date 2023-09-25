import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;

/**
 * The {@code ArrayList} class represents a resizing list. It has been
 * adapted based on Sedgewick and Wayne's Algorithms textbook (4th edition).
 * <p>
 * It doubles the underlying array when it is full and halves the underlying
 * array when it is one-quarter full.
 * 
 * @author Alexandra Papoutsaki
 * @author Aden Siebel
 *
 */
public class ArrayList<Item> implements Iterable<Item> {
	private Item[] data; // underlying array of items
	private int size; // number of items in arraylist. 
	
	/**
	 * Constructs an ArrayList with an initial capacity of 2.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		data = (Item[]) new Object[2];
		size = 0;
	}

	/**
	 * Constructs an ArrayList with the specified capacity.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (Item[]) new Object[capacity];
		size = 0;
	}

	/**
	 * Returns true if the ArrayList contains no items.
	 * 
	 * @return true if the ArrayList does not contain any item
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the number of items in the ArrayList.
	 * 
	 * @return the number of items in the ArrayList
	 */
	public int size() {
		return size;
	}

	/**
	 * Resizes the ArrayList's capacity to the specified capacity.
	 */
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= size;
		// recommended textbook implementation.
		Item[] temp = (Item[]) new Object[capacity];

		for (int i = 0; i < size; i++){
			temp[i] = data[i];
		}

		data = temp;

		// alternative implementation
		// data = java.util.Arrays.copyOf(data, capacity);
	}

	/**
	 * Appends the item to the end of the ArrayList. Doubles its capacity if
	 * necessary.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void add(Item item) {
		if (size == data.length){
			resize(2 * data.length);
		}

		data[size] = item;
		size++;
	}

	/**
	 * Inserts the item at the specified index. Shifts existing elements to the
	 * right and doubles its capacity if necessary.
	 * 
	 * @param index
	 *            the index to insert the item
	 * @param item
	 *            the item to be inserted
	 * @pre: 0 <= index <= size
	 */
	public void add(int index, Item item) {
		if (index > size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}

		if (size == data.length){
			resize(2 * data.length);
		}

		// shift elements to the right
		for (int i = size; i > index; i--){
			data[i] = data[i - 1];
		}

		size++;
		data[index] = item;
	}

	/**
	 * Replaces the item at the specified index with the specified item.
	 * 
	 * @param index
	 *            the index of the item to replace
	 * @param item
	 *            item to be stored at specified index
	 * @return the old item that was changed.
	 * @pre: 0<=index< size
	 */
	public Item set(int index, Item item) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}

		Item old = data[index];
		data[index] = item;

		return old;
	}

	/**
	 * Returns the item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to return
	 * @return the item at the specified index
	 * @pre: 0<=index<size
	 */
	public Item get(int index) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}

		return data[index];
	}

	/**
	 * Retrieves and removes the item from the end of the ArrayList.
	 * 
	 * @return the removed item
	 * @pre size>0
	 */
	public Item remove() {
		if (isEmpty()){
			throw new NoSuchElementException("The list is empty");
		}
		size--;
		Item item = data[size];
		data[size] = null; // Avoid loitering (see recommended textbook).

		// Shrink to save space if possible
		if (size > 0 && size == data.length / 4){
			resize(data.length / 2);
		}

		return item;
	}

	/**
	 * Retrieves and removes the item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to be removed
	 * @return the removed item
	 * @pre: 0<=index<size
	 */
	public Item remove(int index) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}

		Item item = data[index];
		size--;

		for (int i = index; i < size; i++){
			data[i] = data[i + 1];
		}

		data[size] = null; // Avoid loitering (see text).

		// shrink to save space if necessary
		if (size > 0 && size == data.length / 4){
			resize(data.length / 2);
		}

		return item;
	}

	/**
	 * Checks if the ArrayList contains the specified item.
	 * 
	 * @param item
	 *            the item to check if it is included in the ArrayList
	 * @return true if the item is in the list
	 */
	public boolean contains(Item item) {
		return indexOf(item) >= 0;
	}

	/**
	 * Check for the first index of an item in the ArrayList.
	 * 
	 * @param item
	 *            the item to check for
	 * @return the index of first occurrence of the specified item
	 */
	public int indexOf(Item item) {
		if (item == null) { // Special check for null elements
			for (int i = 0; i < size; i++){
				if (data[i] == null){
					return i;
				}
			}
		} else { // Regular check
			for (int i = 0; i < size; i++){
				if (item.equals(data[i])){
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * Clears the ArrayList of all items.
	 */
	public void clear() {

		// Help garbage collector.
		for (int i = 0; i < size; i++){
			data[i] = null;
		}

		size = 0;
	}

	/**
	 * Converts the ArrayList to a String.
	 */
	public String toString() {

		String ret = "ArrayList of " + data.length + " capacity: [";

		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += "; ";
		}

		ret += "]";
		return ret;
	}

	/**
	 * Constructs an iterator for the ArrayList
	 */
	public Iterator<Item> iterator() {
		return new ArrayListIterator();
	}

	/**
	 * A subclass that defines the iterator for the ArrayList.
	 */
	private class ArrayListIterator implements Iterator<Item> {
		private int i = 0;

		public boolean hasNext() {
			return i < size;
		}

		public Item next() {
			return data[i++];
		}

		public void remove() {
		}
	}

	public static void main(String args[]) {
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("CS062");
		System.out.println(a1);
		a1.add("ROCKS");
		System.out.println(a1);
		a1.add("!");
		System.out.println(a1);
		a1.add(1,"THROWS");
		System.out.println(a1);
		a1.add(3,"?");
		System.out.println(a1);
		a1.remove();
		System.out.println(a1);
		a1.remove();
		System.out.println(a1);
		a1.remove();
		System.out.println(a1);
		a1.remove(0);
		System.out.println(a1);
	}
}