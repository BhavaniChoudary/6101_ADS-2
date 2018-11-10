/**
 * Class for edge weighted.
 */
class EdgeWeighted {
    /**
     * vertices variable.
     */
    private int vertices;
    /**
     * edges variable.
     */
    private int edges;
    /**
     * Bag class array.
     */
    private Bag<Edge>[] adjacent;
    /**
     * Constructs the object.
     * complexity is O(v) //v is the no.of vertices.
     *
     * @param      one   One
     */
    EdgeWeighted(final int one) {
        this.vertices = one;
        this.edges = 0;
        adjacent = (Bag<Edge>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new Bag<Edge>();
        }
    }
    /**
     * Adds an edge.
     * complexity O(1)
     *
     * @param      ed    { parameter_description }
     */
    public void addEdge(final Edge ed) {
        int one = ed.either();
        int two = ed.other(one);
        adjacent[one].add(ed);
        adjacent[two].add(ed);
        edges += 1;
    }
    /**
     * Iterator.
     * complexity O(v)
     *
     * @return     { description_of_the_return_value }
     */
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
    /**
     * edge to a particular vertex.
     * complexity O(1)
     *
     * @param      one   One
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Edge> adjacentEdges(final int one) {
        return adjacent[one];
    }
    /**
     * no.of vertices.
     * complexity O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public int vertices() {
        return vertices;
    }
}

