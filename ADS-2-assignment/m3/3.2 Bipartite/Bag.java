import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * n var_description.
     */
    private int n;
    /**
     * first var_description.
     */
    private Node first;
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
    public Bag() {
        first = null;
        n = 0;
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
     * add.
     * complexity is O(1).
     *
     * @param      item  The item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
     * iterator.
     * complexity is O(N).
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * gives current node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         * complexity is O(1).
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * remove.
         * complexity is O(1).
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next.
         * complexity is O(1).
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}


