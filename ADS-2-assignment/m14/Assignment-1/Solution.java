import java.util.Scanner;
class TST<Value> {
	private int size;
	private Node<Value> root;
	private class Node<Value> {
		private char c;
		private Node<Value> left, mid, right;
		private Value val;
	}
	TST() {

	}
	private int size() {
		return size;
	}
	public boolean contains(final String key) {
		return get(key) != null;
	}
	public Value get(final String key) {
        Node<Value> x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }
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
    public void put(final String key,
                    final Value val) {
        if (!contains(key)) {
            size++;
        }
        root = put(root, key, val, 0);
    }
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
final class Solution {
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
	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}