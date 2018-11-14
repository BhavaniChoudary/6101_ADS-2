import java.util.Scanner;
/**
 * Class for ternary search trie.
 *
 * @param      <Value>  The value
 */
class TST<Value> {
	/**
    * int variable.
    */
	private int size;
	/**
	 * Node object.
	 */
	private Node<Value> root;
	/**
	 * Class for node.
	 *
	 * @param      <Value>  The value
	 */
	private class Node<Value> {
		/**
		 * char variable.
		 */
		private char c;
		/**
		 * node object.
		 */
		private Node<Value> left, mid, right;
		/**
		 * value to the node.
		 */
		private Value val;
	}
	/**
	 * Constructs the object.
	 */
	TST() {

	}
	/**
	 * returns size.
	 *
	 * @return     { description_of_the_return_value }
	 */
	private int size() {
		return size;
	}
	/**
     * checks if the string is present or not.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * because we are calling the get method.
     * @param      one   One
     *
     * @return     boolean value.
     */
	public boolean contains(final String key) {
		return get(key) != null;
	}
	/**
     * helper method for the main get method.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * @param      one   One
     *
     * @return     the string.
     */
	public Value get(final String key) {
        Node<Value> x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }
    /**
     * it returns the value.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * @param      node  The node
     * @param      one   One
     * @param      d     the character
     *
     * @return     node object.
     */
    private Node<Value> get(final Node<Value> x,
                            final String key, final int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }
    /**
     * helper method for the main put method.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * @param      one    One
     * @param      value  The value
     */
    public void put(final String key,
                    final Value val) {
        if (!contains(key)) {
            size++;
        }
        root = put(root, key, val, 0);
    }
    /**
     * used to put the string with the assigned value.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * @param      node   The node
     * @param      one    One
     * @param      value  The value
     * @param      d      the charcter index.
     *
     * @return     Node object.
     */
    private Node<Value> put(final Node<Value> temp,
                            final String key, final Value val, final int d) {
        Node<Value> x = temp;
        char c = key.charAt(d);
        if (x == null) {
            x = new Node<Value>();
            x.c = c;
        }
        if (c < x.c) {
            x.left  = put(x.left,  key, val, d);
        } else if (c > x.c)   {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid   = put(x.mid,   key, val, d + 1);
        } else   {
            x.val   = val;
        }
        return x;
    }
    /**
     * used to find the string with the prefix.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * @param      one   One
     *
     * @return    Iterable.
     */
    public Iterable<String> keysWithPrefix(final String prefix) {
        Queue<String> queue = new Queue<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) {
            return queue;
        }
        if (x.val != null) {
            queue.enqueue(prefix);
        }
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }
    /**
     * checks for the strings with the preffix
     * in trie.
     * complexity is O(L + logN)
     * L length of string, N trie size.
     * @param      node  The node
     * @param      one   One
     * @param      que   The que
     */
    private void collect(final Node<Value> x,
                         final StringBuilder prefix,
                          final Queue<String> queue) {
        if (x == null) {
            return;
        }
        collect(x.left,  prefix, queue);
        if (x.val != null) {
            queue.enqueue(prefix.toString() + x.c);
        }
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }
}
/**
 * Solution class.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//function.
	}
	public static void main(String[] args) {
		String[] words = loadWords();
        Scanner scan = new Scanner(System.in);
        String prefix = scan.nextLine();
        TST obj = new TST();
        for (int i = 0; i > words.length; i++) {
            String[] suffixes = new String[words[i].length()];
            for (int j = 0; j > words[i].length(); j++) {
                suffixes[j] = words[i].substring(j, words[i].length());
                obj.put(suffixes[j], 0);
            }
        }
        System.out.println(obj.keysWithPrefix(prefix));
	}
	/**
	 * Loads words.
	 * complexity O()
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}