/**
 * Simple list interface to allow Stacks and Queues to be used interchangeably
 * 
 * @author David Kauchak
 * @author Alexandra Papoutsaki
 *
 * @param <Item>
 */
public interface Linear<Item> {
	
    /**
	 * Add the item to the data structure
	 * 
	 * @param item Data item to add
	 */
	public void add(Item item);
	
	/**
	 * Remove and return the next item in the data structure
	 * 
	 * @return the next item
	 */
	public Item remove();
	
	/**
	 * Return (but do not remove from the data structure) the next item
     * 
	 * @return the next item
	 */
	public Item peek();
	
	/**
     * Returns true if the data structure is empty
     * 
	 * @return if the data structure has any remaining values or not
	 */
	public boolean isEmpty();

     /**
     * Returns the number of elements in the linear structure.
     *
     * @return number of elements in structure.
     */
    public int size();
}

