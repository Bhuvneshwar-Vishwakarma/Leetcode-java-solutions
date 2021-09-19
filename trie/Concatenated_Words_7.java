package trie;
import java.io.*;
import java.util.*;

public class Concatenated_Words_7 {
	public static class Node{
		Node childs[] = new Node[26];
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
		curr.str = s;// ending has his string 
	}
	
	public static void search(Node curr, Node nword) {
		if(curr.str != null && nword.str != null) {// means has end word
			set.add(curr.str);
		}
		if(nword.str != null) {
			search(curr, root);
		}
		for(int i = 0; i < 26; i++) { 
			if(curr.childs[i] != null && nword.childs[i] != null) {
				search(curr.childs[i], nword.childs[i]);
			}
		}
	}
	public static void search1(Node curr){
		if(curr.str != null) { 
    		search(curr, root);
    	}
		for(Node child: curr.childs) {
			if(child != null) {
				search1(child);
			}
		}
    	
	}
	static Node root;
	static HashSet<String> set = new HashSet<>();// we use hashset to avoid duplicate
	
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
    	
    	root = new Node();
    	for(String s: words) {// creating trie
    		insert(root, s);
    	}
    	// search in trie and fill in HashSet
    	search1(root);
    	List<String> ans = new ArrayList<>(set);/// set converted to list
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]words = new String[n];

        for(int i=0;i<n;i++){
            words[i] = read.readLine();
        }

        List<String> result = findAllConcatenatedWordsInADict(words);
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for(String s: result){
            out.println(s);
        }
        out.close();
    }
}