/**
 * Stack interface (LIFO)
 * 
 * @author David Kauchak
 * @author Alexandra Papoutsaki
 *
 * @param <Item>
 */

public interface Stack<Item> extends Linear<Item> {

    /**
     * Pushes an item onto the top of the stack.
     * 
     * @param item the item to be added
     */
    public void push(Item item);

    /**
     * Removes the item at the top of this stack and returns the item
     * 
     * @return the item at the top of the stack
     */
    public Item pop();

    /**
     * Returns the data item at the top of the stack without removing it
     * 
     * @return the data item at the top of the stack
     */
    public Item peek();

    /**
     * Tests if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack.
     */
    public int size();
}