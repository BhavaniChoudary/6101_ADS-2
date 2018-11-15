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
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append("\n");
        }
        return s.toString();
    }
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        ListIterator(final Node<Item> first1) {
            current = first1;
        }
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

