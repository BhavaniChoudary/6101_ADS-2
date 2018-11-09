/**
 * List of Queue.
 *
 * @param      <item>  The item
 */
public class Queue<item> {
    /**
     * no.of elements.
     */
	private int n;
    /**
     * beggining of queue.
     */
	private Node first;
    /**
     * end of queue.
     */
	private Node last;
    /**
     * Class for node.
     */
	private class Node {
        /**
         * item.
         */
		private Item item;
        /**
         * next.
         */
		private Node next;
	}
    /**
     * Constructs the object.
     */
	Queue() {
		first = null;
		last = null;
	}
    /**
     * Determines if empty.
     * complexity O(1)
     *
     * @return     True if empty, False otherwise.
     */
	public boolean isEmpty() {
		return first == null;
	}
    /**
     * size.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
	public int size() {
		return n;
	}
    /**
     * return the item least recently added to the queue.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
	public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return first.item;
    }
    /**
     * add the item.
     * complexity O(1)
     *
     * @param      item  The item
     */
    public void enqueue(final Item item) {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        n++;
    }
    /**
     * remove item in queue.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException(
                "Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}

