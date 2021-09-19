package trees_6;
import java.util.*;

public class Vertical_Order_Traversal_Of_A_Binarytree_18 {
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
    	TreeNode root = null;
    	int hl = 0;// horizontal level
    	
    	Pair(TreeNode root, int hl){
    		this.root = root;
    		this.hl = hl;
    	}
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal____Method_1(TreeNode root) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    	int minhl = 0, maxhl = 0;
     	LinkedList<Pair> que = new LinkedList<>();
     	
     	que.add(new Pair(root, 0));
     	while(que.size() != 0) {
     		int size = que.size();
     		while(size-- > 0) {
     			Pair rp = que.removeFirst();
     			
     			minhl = Math.min(minhl, rp.hl);	
     			maxhl = Math.max(maxhl, rp.hl);	
     			
     			map.putIfAbsent(rp.hl, new ArrayList<>());
     			map.get(rp.hl).add(rp.root.val);
     			
     			if(rp.root.left != null) {
     				que.addLast(new Pair(rp.root.left, rp.hl - 1));
     			}
     			if(rp.root.right != null) {
     				que.addLast(new Pair(rp.root.right, rp.hl + 1));
     			}
     		}
     	}
     	for(int i = minhl; i <= maxhl; i++) {
     		ans.add(map.get(i));
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal____Method_1(root);
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