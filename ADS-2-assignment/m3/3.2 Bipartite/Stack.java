import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of Stack.
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * size of the stack n.
     */
    private int n;
    /**
     * top of stack.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Item.
         */
        private Item item;
        /**
         * next.
         */
        private Node next;
    }
    /**
     * Create an empty stack.
     */
    public Stack() {
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
     * push.
     * complexity is O(1).
     *
     * @param      item  The item
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
     * pop.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    /**
     * peek.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }
    /**
     * Returns a string representation of the object.
     * complexity is O(N).
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    /**
     * Iterator.
     * complexity is O(N).
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current node.
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


