/**
 * Class for percolation.
 */
class Percolation {
    /**
     * uf var_description.
     */
    private Graph uf;
    private int n;
    private int size, first, last, count;
    private boolean[] connected;
    Percolation(final int n1) {
        this.n = n1;
        this.size = n1 * n1;
        this.first = size;
        this.last = size + 1;
        this.count = 0;
        connected = new boolean[size];
        uf = new Graph(size + 2);
        for (int i = 0; i < n; i++) {
            uf.addEdge(first, i);
            uf.addEdge(last, size - i - 1);
        }
    }
    private int indexOf(final int i, final int j) {
        return (n * (i - 1)) + (j - 1);
    }
    private void linkOpenSites(final int row, final int col) {
        if (connected[col] && !uf.hasEdge(row, col)) {
            uf.addEdge(row, col);
        }
    }
    public void open(final int row, final int col) {
        int index = indexOf(row, col);
        connected[index] = true;
        count++;
        int top = index - n;
        int bottom = index + n;
        if (n == 1) {
            uf.addEdge(first, index);
            uf.addEdge(first, index);
        }
        if (bottom < size) {
            linkOpenSites(index, bottom);
        }
        if (top >= 0) {
            linkOpenSites(index, top);
        }
        if (col == 1) {
            if (col != n) {
                linkOpenSites(index, index + 1);
            }
            return;
        }
        if (col == n) {
            linkOpenSites(index, index - 1);
            return;
        }
        linkOpenSites(index, index + 1);
        linkOpenSites(index, index - 1);
    }
    public boolean isOpen(final int row, final int col) {
        return connected[indexOf(row, col)];
    }
    public int numberOfOpenSites() {
        return count;
    }
    public boolean percolates() {
        CC cc = new CC(uf);
        return cc.connected(first, last);
    }
    }

