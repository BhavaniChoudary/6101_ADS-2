import java.util.Iterator;
import java.util.NoSuchElementException;
public class IndexMinPQ<Key extends Comparable<Key>>implements Iterable<Integer> {
	private int maxN;
	private int n;
	private int[] pq;
	private int[] qp;
	private Key[] keys;
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
    public boolean isEmpty() {
        return n == 0;
    }
    public boolean contains(final int i) {
        if (i < 0 || i >= maxN) {
            throw new IllegalArgumentException();
        }
        return qp[i] != -1;
    }
    private int size() {
    	return n;
    }
    public void insert(final int i, final Key key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }
    public int minIndex() {
        if (n == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }
    public Key minKey() {
        if (n == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return keys[pq[1]];
    }
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
    public Key keyOf(int i) {
    	return keys[i];
    }
    public void changeKey(final int i, final Key key) {
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }
    public void change(final int i, final Key key) {
        changeKey(i, key);
    }
    public void decreaseKey(final int i, final Key key) {
        keys[i] = key;
        swim(qp[i]);
    }
    public void increaseKey(final int i, final Key key) {
        keys[i] = key;
        sink(qp[i]);
    }
    public void delete(final int i) {
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }
    private boolean greater(final int i, final int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
    private void exch(final int i, final int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    private void swim(final int key) {
        int k = key;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
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
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }
    private class HeapIterator implements Iterator<Integer> {
    	private IndexMinPQ<Key> copy;
    	HeapIterator() {
    		copy = new IndexMinPQ<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
    	}
    	public boolean hasNext() {
            return !copy.isEmpty();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}

