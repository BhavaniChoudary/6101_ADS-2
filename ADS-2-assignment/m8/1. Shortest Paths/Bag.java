/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/
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
     * item var_description.
     */
    private Item item;
    /**
     * next var_description.
     */
    private Node next;
  }
  /**
   * Constructs the object Bag.
   */
  public Bag() {
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
   * size.
   *
   * @return     { description_of_the_return_value }
   */
  public int size() {
    return n;
  }
  /**
   * add the item to the bag.
   * time complexity is O(1)
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
   * Return an iterator that iterates over the bag.
   *complexity is O(1)
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
     * temp node.
     */
    private Node current = first;
    /**
     * Determines if it has next.
     * complexity is O(1)
     *
     * @return     True if has next, False otherwise.
     */
    public boolean hasNext()  {
      return current != null;
    }
    /**
     * remove.
     */
    public void remove() {
      throw new UnsupportedOperationException();
    }
    /**
     * next.
     * complexity is O(1)
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

