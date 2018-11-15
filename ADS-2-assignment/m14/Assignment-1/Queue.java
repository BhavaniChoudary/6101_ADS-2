import java.util.Iterator;
/**
 * List of Queue.
 *
 * @param      <Item>  The item
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * beggining of Queue.
     */
    private Node<Item> first;
    /**
     * end of queue.
     */
    private Node<Item> last;
    /**
     * no.of elements.
     */
    private int n;
    /**
     * Class for node.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * item.
         */
        private Item item;
        /**
         * next.
         */
        private Node<Item> next;
    }
    /**
     * Constructs the object.
     */
    Queue() {
        first = null;
        last  = null;
        n = 0;
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
     * Returns the number of items in the queue.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * return last recently added item.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public Item peek() {
        return first.item;
    }
    /**
     * Adds the item to this queue.
     * complexity O(1)
     *
     * @param      item  The item
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }
    /**
     * Removes and returns the item on this queue that was least recently added.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    /**
     * Returns a string representation of the object.
     * complexity O(1)
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append("\n");
        }
        return s.toString();
    }
    /**
     * Iterator.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    /**
     * Class for list iterator.
     *
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * current node.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         *
         * @param      first1  The first 1
         */
        ListIterator(final Node<Item> first1) {
            current = first1;
        }
        /**
         * Determines if it has next.
         * complexity O(1)
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * remove method.
         * complexity O(1)
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * method for finding next.
         * complexity O(1)
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

