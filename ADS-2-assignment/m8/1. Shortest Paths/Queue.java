public class Queue<item> {
	private int n;
	private Node first;
	private Node last;
	private class Node {
		private Item item;
		private Node next;
	}
	Queue() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return n;
	}
	public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return first.item;
    }
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

