package graphs_4;

import java.util.Scanner;

public class Relation_Information {
	public static class MyNode{
		String data;
		MyNode next;
	}
	
	static MyNode root;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int m = sc.nextInt();
			MyNode[] relative = new MyNode[m];
			for(int i = 0; i < relative.length; i++) {
				relative[i] = new MyNode();
			}
			root = relative[0];
			
			
			relative[0].data = "Bhuvi";
			relative[0].next = relative[1];
			
			System.out.println(relative[0].data);
		
		
	}
}
