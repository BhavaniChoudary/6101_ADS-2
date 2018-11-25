import java.util.Scanner;
import java.util.HashMap;
class Solution{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		int i = 0;
		while(i < num) {
			int temp = Integer.parseInt(s.nextLine());
			if(bst.contains(temp)){
				bst.put(temp, bst.get(temp)+1);
			} else {
				bst.put(temp, 1);
			}
			i++;
		}
		bst.display();
	}
}
