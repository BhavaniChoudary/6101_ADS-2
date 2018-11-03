import java.util.Scanner;

class PageRank {
	
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalVertices = Integer.parseInt(sc.nextLine());
		Digraph d = new Digraph(totalVertices);
		int i = 0;
		while(i < totalVertices) {
			String[] arra1 = sc.nextLine().split(" ");
			for(int j = 1;j < arra1.length; j++) {
				d.addEdge(Integer.parseInt(arra1[0]), Integer.parseInt(arra1[j]));
			}
			i++;
		}	
		System.out.println(d.toString());	
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}