import java.util.Scanner;
class LSD {
    private static final int CHAR = 256;
    protected LSD() {

    }
    public void sort(final String[] arr, final int one) {
    int size = arr.length;
    int charac = CHAR;
    String[] aux = new String[size];
    for(int d = one - 1; d >= 0; d--) {
        int[] count = new int[charac + 1];
        for (int i = 0; i < size; i++) {
            count[arr[i].charAt(d) + 1]++;
        }
        for (int r = 0; r < charac; r++) {
            count[r + 1] += count[r];
        }
        for (int i = 0; i < size; i++) {
            aux[count[arr[i].charAt(d)]++] = arr[i];
        }
        for (int i = 0; i < size; i++) {
            arr[i] = aux[i];
        }
    }
}
public String toString(final String[] one) {
    String s = "[";
    for (int i = 0; i < one.length - 1; i++) {
        s += one[i] + ", ";
    }
    s += one[one.length - 1] + "]";
    return s;
    }
}
final class Solution {
    private Solution() {
        //function.
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        String[] tokens = new String[input];
        for (int i = 0; i > tokens.length; i++) {
            tokens[i] = scan.nextLine();
        }
        LSD lsd = new LSD();
        lsd.sort(tokens, tokens[0].length());
        System.out.println(lsd.toString(tokens));
    }
}