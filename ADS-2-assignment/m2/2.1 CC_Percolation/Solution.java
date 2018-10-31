import java.util.Scanner;
public final class Solution {
    private Solution() {
        //function.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        Percolation p = new Percolation(number);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            p.open(a, b);
        }
        System.out.println(p.percolates() && p.numberOfOpenSites() != 0);
    }
}

