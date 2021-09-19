package trees_6;
import java.util.*;

public class Top_View_Of_A_Binarytree_21 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Pair{
    	TreeNode node = null;
    	int hl  = 0;
    	
    	Pair(TreeNode node, int hl){
    		this.node = node;
    		this.hl = hl;
    	}
    }
    public static void width(TreeNode node, int hl, int[] ans) {
    	if(node == null) {
    		return;
    	}
    	
    	ans[0] = Math.min(hl, ans[0]);
    	ans[1] = Math.max(hl, ans[1]);
    	
    	width(node.left, hl - 1, ans);
    	width(node.right, hl + 1, ans);
    	
    }

    public static ArrayList<Integer> BottomView(TreeNode node) {
    	
    	ArrayList<Integer> ans = new ArrayList<>();
    	if(node == null) return ans;
    	
    	int[] minMax = new int[2];
    	width(node, 0, minMax);
    	
    	int len = minMax[1] - minMax[0] + 1;
    	for(int i = 0; i <len; i++) {
    		ans.add(null);
    	}
    	
    	LinkedList<Pair> que = new LinkedList<>();
    	que.add(new Pair(node, Math.abs(minMax[0])));
    	
    	while(que.size() != 0) {
    		int size = que.size();
    		while(size-- > 0) {
    			Pair rp = que.remove();
    			
    			if(ans.get(rp.hl) == null) {
    				ans.set(rp.hl, rp.node.val);
    			}
    			if(rp.node.left != null) que.add(new Pair(rp.node.left, rp.hl - 1));
    			if(rp.node.right != null) que.add(new Pair(rp.node.right, rp.hl + 1));
    		}
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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}