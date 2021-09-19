package trie;
import java.io.*;
import java.util.*;

public class Longest_Word_In_Dictionary_9 {
	 public static class Node{
		  Node[] childs = new Node[26];
		  String str;
		  
	  }
	 
	 public static void insert(Node curr, String s) {
		 for(int i = 0; i < s.length(); i++) {
			 char ch = s.charAt(i);
			 
			 if(curr.childs[ch - 'a'] == null) {
				 curr.childs[ch - 'a'] = new Node();
			 }
			 curr = curr.childs[ch - 'a'];
		 }
		 curr.str = s;// means end
	 }
	 static String ans = "";
	 
	 public static void dfs(Node root) {
		 for(Node child: root.childs) {
			 if(child != null && child.str != null) {
				 if(child.str.length() > ans.length()) {
					 ans = child.str;
				 }
				 dfs(child);
			 }
		 }
	 }
  public static String longestWord(String[] words) {	  
	  Node root = new Node();
	  for(String s: words) {
		  insert(root, s);
	  }
	  dfs(root);
	  
	  return ans;

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = read.readLine();
    }

    String result = longestWord(words);
    System.out.println(result);

  }
}
