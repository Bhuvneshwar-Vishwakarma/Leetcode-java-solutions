package trees_6;
import java.util.Scanner;
/*. You are given a partially written function to solve.
2. The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
3. Input and Output is managed for you.*/
/*https://www.youtube.com/watch?v=kTL5LhCTL1c&list=TLGG8TW2x47qXWMzMDA2MjAyMQ&t=1s*/

public class House_Robber_In_Binary_Tree_2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    
    /*************************************************************************/
    ///********** achhi approach 1 ****************/
    public static class Pair{
    	int withRobbery = 0;
    	int withOutRobbery = 0;
    }

    public static Pair HouseRobberHelper(TreeNode root) {
    	if(root == null) return new Pair();
    	
    	Pair left = HouseRobberHelper(root.left);
    	Pair right = HouseRobberHelper(root.right);
    	
    	Pair myAns = new Pair();
    	myAns.withRobbery = left.withOutRobbery + root.val + right.withOutRobbery;
    	myAns.withOutRobbery = Math.max(left.withRobbery, left.withRobbery) + Math.max(right.withRobbery, right.withOutRobbery);
    
        return myAns;
    }
    public static int HouseRobber(TreeNode root) {
    	
    	Pair res = HouseRobberHelper(root);
    	int ans = Math.max(res.withRobbery, res.withOutRobbery);
    	
    	return ans;
    }
    /**************************************************************/
    
    /*Also we can apply array of size 2
     * arr[0] = withRobbery
     * arr[1] = withOutRobbery
     * */
    public static int[] HouseRobberHelper2(TreeNode root) {
    	if(root == null) return new int[2];
    	
    	int[] left = HouseRobberHelper2(root.left);
    	int[] right = HouseRobberHelper2(root.right);
    	
    	int[] myAns = new int[2];
    	myAns[0] = left[1] + root.val + right[1];
    	myAns[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    
        return myAns;
    }
    public static int HouseRobber2(TreeNode root) {
    	
    	int[] res = HouseRobberHelper2(root);
    	int ans = Math.max(res[0], res[1]);
    	
    	return ans;
    }
    
    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(HouseRobber2(root));
    }

    public static void main(String[] args) {
        solve();
    }
}