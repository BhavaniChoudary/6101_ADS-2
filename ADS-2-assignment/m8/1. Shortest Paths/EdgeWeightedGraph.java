class EdgeWeighted {
	private int vertices;
	private int edges;
	private Bag<Edge>[] adjacent;
	EdgeWeighted(int one) {
		this.vertices = one;
        this.edges = 0;
        adjacent = (Bag<Edge>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new Bag<Edge>();
        }
	}
	public void addEdge(final Edge ed) {
        int one = ed.either();
        int two = ed.other(one);
        adjacent[one].add(ed);
        adjacent[two].add(ed);
        edges += 1;
    }
    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<Edge>();
        for (int i = 0; i < vertices; i++) {
            int temp = 0;
            for (Edge one : adjacentEdges(i)) {
                if (i < one.other(i)) {
                    bag.add(one);
                } else if (i == one.other(i)) {
                    if (temp % 2 == 0) {
                        bag.add(one);
                    }
                    temp += 1;
                }
            }
        }
        return bag;
    }
    public Iterable<Edge> adjacentEdges(int one) {
    	return adjacent[one];
    }
    public int vertices() {
    	return vertices;
    }
}