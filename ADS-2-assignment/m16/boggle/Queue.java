import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return n;
    }
    public Item peek() {
        return first.item;
    }
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
     * @return the item on this queue that was least recently added
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
     * Returns a string representation of this queue.
     * complexity O(1)
     * @return the sequence of items in FIFO order, separated by spaces
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
     *
     * @return an iterator that iterates over the items
     * in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * Current Node.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         *
         * @param      first1  The first
         */
        ListIterator(final Node<Item> first1) {
            current = first1;
        }

        /**
         * Determines if it has next.
        * complexity O(1)
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * Method to remove.
        * complexity O(1)
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Method for finding the next.
         *complexity O(1)
         * @return     Item
         */
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}