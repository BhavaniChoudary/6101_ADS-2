class Edge implements Comparable<Edge> {
	private int edge1;
	private int edge2;
	private int weight;
	Edge(int one, int two, int w) {
		this.edge1 = one;
        this.edge2 = two;
        this.weight = w;
	}
	public int getWeight() {
        return this.weight;
    }
    public int other(final int one) {
        if (one == edge1) {
            return this.edge2;
        }
        return this.edge1;
    }
    public int either() {
    	return this.edge1;
    }
    public int compareTo(final Edge that) {
        if (this.weight < that.weight) {
            return -1;
        }
        if (this.weight > that.weight) {
            return 1;
        }
        return 0;
    }
}