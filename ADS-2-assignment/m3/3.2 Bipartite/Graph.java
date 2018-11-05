public class Graph {
    private int vertices;
    private int edges;
    private Bag<Integer>[] adj;
    public Graph(final int v) {
        if (v < 0) {
            throw new RuntimeException(
                "Number of vertices must be nonnegative");
        }
        this.vertices = v;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    public int vertex() {
        return vertices;
    }
    public int edge() {
        return edges;
    }
    public void addEdge(final int v, final int w) {
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
}
