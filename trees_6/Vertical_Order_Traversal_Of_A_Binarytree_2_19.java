package trees_6;
import java.util.*;

public class Vertical_Order_Traversal_Of_A_Binarytree_2_19 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    /// code /*************/
    public static class Pair{
    	TreeNode node = null;
    	int hl = 0;
    	
    	Pair(TreeNode node, int hl){
    		this.node = node;
    		this.hl = hl;
    	}
    }
    public static void width(TreeNode node, int hl, int[] arr) {
    	if(node == null) return;
    	
    	arr[0] = Math.min(hl, arr[0]);
    	arr[1] = Math.max(hl, arr[1]);
    	
    	width(node.left, hl - 1, arr);
    	width(node.right, hl + 1, arr);
    }
    
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node) {
    	// declare queue
    	PriorityQueue<Pair> parQue = new PriorityQueue<>((a, b)->{
    		return a.node.val - b.node.val;
    	});
    	PriorityQueue<Pair> chQue = new PriorityQueue<>((a, b)->{
    		return a.node.val - b.node.val;
    	});
    	
    	// find width
    	int[] arr = new int[2];
    	width(node, 0, arr);
    	int len = arr[1] - arr[0] + 1;
    	
    	// declare answer list
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    	for(int i = 0; i < len; i++) ans.add(new ArrayList<>());// allow space 
    	
    	parQue.add(new Pair(node, Math.abs(arr[0])));// apply BFS
    	
    	while(parQue.size() != 0) {
    		int size = parQue.size();
    		while(size-- > 0) {
    			Pair rp = parQue.remove();
    			ans.get(rp.hl).add(rp.node.val);
    			
    			if(rp.node.left != null) chQue.add(new Pair(rp.node.left, rp.hl - 1));
    			if(rp.node.right != null) chQue.add(new Pair(rp.node.right, rp.hl + 1));		
    		}
    		
    		// and then swap
    		PriorityQueue<Pair> temp = parQue;
    		parQue = chQue;
    		chQue = temp;
    	}
    	
        return ans;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}