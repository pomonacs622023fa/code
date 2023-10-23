/**
 * Queue interface (FIFO)
 * 
 * @author David Kauchak
 * @author Alexandra Papoutsaki
 *
 * @param <Item>
 */

public interface Queue<Item> extends Linear<Item> {

    /**
     * Enqueues an item to the end of the queue.
     * 
     * @param item the item to be added
     */
    public void enqueue(Item item);

    /**
     * Removes and return the item from the front of the queue.
     * 
     * @return the item at the front of the queue.
     */
    public Item dequeue();

    /**
     * Returns the data item at the front of the queue without removing it
     * 
     * @return the data item at the front of the queue
     */
    public Item peek();

    /**
     * Tests if the queue is empty
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return number of elements in queue.
     */
    public int size();
}