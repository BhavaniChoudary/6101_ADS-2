/**
 * List of Queue.
 *
 * @param      <Item>  The item
 */
public class Queue<Item> {
    /**
     * n var_description.
     */
    private int n;
    /**
     * first var_description.
     */
    private Node first;
    /**
     * last var_description.
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
        last  = null;
    }
    /**
     * Determines if empty.
     * complexity is O(1).
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * size.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * peek.
     * complexity is O(1).
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
     * enqueue.
     * complexity is O(1).
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
     * dequeue.
     * complexity is O(1).
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

