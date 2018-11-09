/**
 * Class for edge.
 */
class Edge implements Comparable<Edge> {
    /**
     * edge1 int variable.
     */
    private int edge1;
    /**
     * edge2 int variable.
     */
    private int edge2;
    /**
     * weight.
     */
    private int weight;
    /**
     * Constructs the object.
     *
     * @param      one   One
     * @param      two   Two
     * @param      w     { parameter_description }
     */
    Edge(final int one,final int two,final int w) {
        this.edge1 = one;
        this.edge2 = two;
        this.weight = w;
    }
    /**
     * Gets the weight.
     * complexity is O(1)
     *
     * @return     The weight.
     */
    public int getWeight() {
        return this.weight;
    }
    /**
     * gets other edge connected.
     * complexity is O(1)
     *
     * @param      one   One
     *
     * @return     { description_of_the_return_value }
     */
    public int other(final int one) {
        if (one == edge1) {
            return this.edge2;
        }
        return this.edge1;
    }
    /**
     * returns edge.
     * complexity is O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public int either() {
        return this.edge1;
    }
    /**
     * compares.
     * complexity is O(1)
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
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

