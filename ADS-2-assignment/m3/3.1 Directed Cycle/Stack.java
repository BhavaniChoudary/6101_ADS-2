import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of stack.
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * n size var_description.
     */
    private int n;
    /**
     * top var_description.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item var_description.
         */
        private Item item;
        /**
         * next var_description.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    public Stack() {
        first = null;
        n = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * size function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * push to stack function_description.
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
     * pop to stack function_description.
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

    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
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
