import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for index minimum pq.
 *
 * @param      <Key>  The key
 */
public class IndexMinPQ<Key extends Comparable<Key>>
implements Iterable<Integer> {
    /**
    * max no.of elements in PQ.
    */
    private int maxN;
    /**
     * no.of elements in PQ.
     */
    private int n;
    /**
     * binary heap using 1-based indexing.
     */
    private int[] pq;
    /**
     * inverse of pq(qp[pq[i]] = pq[qp[i]] = i).
     */
    private int[] qp;
    /**
     * keys[i] = priority of i.
     */
    private Key[] keys;
    /**
     * Constructs the object.
     *
     * @param      max   The maximum
     */
    public IndexMinPQ(final int max) {
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        this.maxN = max;
        n = 0;
        keys = (Key[]) new Comparable[max + 1];
        pq   = new int[max + 1];
        qp   = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            qp[i] = -1;
        }
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * contains.
     * complexity O(1)
     *
     * @param      i     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int i) {
        if (i < 0 || i >= maxN) {
            throw new IllegalArgumentException();
        }
        return qp[i] != -1;
    }
    /**
     * size.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    private int size() {
        return n;
    }
    /**
     * associates key with index.
     * complexity O(logn)
     *
     * @param      i     { parameter_description }
     * @param      key   The key
     */
    public void insert(final int i, final Key key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }
    /**
     * returns minimum key.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public int minIndex() {
        if (n == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }
    /**
     * min key.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public Key minKey() {
        if (n == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return keys[pq[1]];
    }
    /**
     * deletes minimum key.
     * complexity O(logn)
     *
     * @return     { description_of_the_return_value }
     */
    public int delMin() {
        if (n == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n + 1];
        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }
    /**
     * returns key associated with index.
     * complexity O(1)
     *
     * @param      i     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key keyOf(final int i) {
        return keys[i];
    }
    /**
     * change key.
     * complexity O(logn)
     *
     * @param      i     { parameter_description }
     * @param      key   The key
     */
    public void changeKey(final int i, final Key key) {
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }
    /**
     * change the key.
     *
     * @param      i     { parameter_description }
     * @param      key   The key
     */
    public void change(final int i, final Key key) {
        changeKey(i, key);
    }
    /**
     * decrease key.
     *
     * @param      i     { parameter_description }
     * @param      key   The key
     */
    public void decreaseKey(final int i, final Key key) {
        keys[i] = key;
        swim(qp[i]);
    }
    /**
     * increase key.
     *
     * @param      i     { parameter_description }
     * @param      key   The key
     */
    public void increaseKey(final int i, final Key key) {
        keys[i] = key;
        sink(qp[i]);
    }
    /**
     * delete the key.
     *
     * @param      i     { parameter_description }
     */
    public void delete(final int i) {
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }
    /**
     * greater method.
     * complexity O(1)
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(final int i, final int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
    /**
     * swap the elements.
     * complexity O(1)
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(final int i, final int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    /**
     * swim method.
     * complexity O(logn)
     *
     * @param      key   The key
     */
    private void swim(final int key) {
        int k = key;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * sink method.
     * complexity O(logn)
     *
     * @param      key   The key
     */
    private void sink(final int key) {
        int k = key;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * iterator.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }
    /**
     * Class for heap iterator.
     */
    private class HeapIterator implements Iterator<Integer> {
        /**
         * creates new pq.
         */
        private IndexMinPQ<Key> copy;
        /**
         * Constructs the object.
         */
        HeapIterator() {
            copy = new IndexMinPQ<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**
         * remove.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next.
         *
         * @return     { description_of_the_return_value }
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}

