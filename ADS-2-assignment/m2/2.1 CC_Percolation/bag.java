/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElemenException;
/**
 *  The <tt>Bag</tt> class represents a bag (or multiset) of
 *  generic items. It supports insertion and iterating over the
 *  items in arbitrary order.
 *  <p>
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation
 *  take constant time. Iteration takes time proportional to the number
 *  of items.
 *  <p>
 *  For additional documentation, see
 *  <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
	/**
	 * n var_description.
	 */
	private int n; // no.of elements in bag
	/**
	 * first var_description.
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
	public Bag() {
		first = null;
		n= 0;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return n;
	}
	public void add(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
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