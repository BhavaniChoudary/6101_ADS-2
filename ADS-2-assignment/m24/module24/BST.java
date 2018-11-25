import java.util.NoSuchElementException;
/**
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    Stopwatch stop = new Stopwatch();
    private double getTime;
    private double putTime;
    static Double putCounter = 0.0;
    static Double getCounter = 0.0;
    private class Node {
        
        private Key key;           // sorted by keys
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public void display() {
        double sum = putCounter + getCounter;
        System.out.println("No.of put function calls: "+putCounter);
        System.out.println("No of get function calls: "+getCounter);
        System.out.println("put ratio: "+putCounter/sum*100);
        System.out.println("get ratio: "+getCounter/sum*100);
        System.out.println("put fun/get fun: " + putCounter/getCounter);
        System.out.println("gettime: "+getTime);
        System.out.println("puttime: "+putTime);
        System.out.println("puttime/gettime: "+getTime/putTime);
    }


    /**
     * Initializes an empty symbol table.
     */
    public BST() {
        //this.flag = false;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    //  public Value get(Key key) {    
    //     Node x = root;    
    //     while (x != null)    {       
    //         int cmp = key.compareTo(x.key);
    //         getCounter++;
    //         getTime = stop.elapsedTime();     
    //         if      (cmp  < 0) x = x.left;       
    //         else if (cmp  > 0) x = x.right;       
    //         else if (cmp == 0) return x.val;    
    //     }    return null; 
    // }
    public Value get(Key key) {
        // getCounter++;
        getTime = stop.elapsedTime();
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        getCounter++;
        getTime = stop.elapsedTime();
        if      (cmp < 0) {


            return get(x.left, key);
        }
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;

    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calledput() with a null key");
        root = put(root, key, val);
        //assert check();
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        putCounter++;
        putTime = stop.elapsedTime();
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        
        return x;
    }
}
