import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * Main method.
     * complexity O()
     *
     * @param      args  The arguments
     */

    // Don't modify this method.
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash =
            loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }
    /**
     * to read files.
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */

    // Don't modify this method.
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }
    /**
     * Loads a dictionary.
     * complexity O(n)
     * n - length of the array.
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */
    public static BinarySearchST<String, Integer> loadDictionary(final
        String file) {
        BinarySearchST<String, Integer>  st = new
        BinarySearchST<String, Integer>();
        // your code goes here
        String[] arr1 = toReadFile(file);
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            String word = arr1[i].toLowerCase();
            if (st.contains(word)) {
                st.put(word, st.get(word) + 1);
            } else {
                st.put(word, 1);
            }
        }
        return st;
    }
}
/**
 * Class for t9.
 */
class T9 {
    /**
     * TST object.
     */
    private TST<Integer> t;
    /**
     * Constructs the object.
     * complexity O(n)
     *
     * @param      st    { parameter_description }
     */
    protected T9(final BinarySearchST<String, Integer> st) {
        // your code goes here
        t = new TST<Integer>();
        for (String str : st.keys()) {
            t.put(str, st.get(str));
        }
    }
    /**
     * Gets all words.
     * complexity O(L + logN)
     *
     * @param      prefix  The prefix
     *
     * @return     All words.
     */

    // get all the prefixes that match with given prefix.
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        return t.keysWithPrefix(prefix);
    }
    /**
     * Iterator.
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here
        return null;
    }
    /**
     * Gets the suggestions.
     *
     * @param      words  The words
     * @param      k      { parameter_description }
     *
     * @return     The suggestions.
     */

    // return all possibilities(words), find top k with highest frequency.
    public Iterable<String> getSuggestions(final Iterable<String> words,
        final int k) {
        // your code goes here
        return null;
    }
    /**
     * Iterator.
     *
     * @param      t9Signature  The t 9 signature
     * @param      k            { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    // final output
    // Don't modify this method.
    public Iterable<String> t9(final String t9Signature, final int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}


