package trees_6;
import java.util.Scanner;
/*You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.*/
public class Cameras_In_Binary_Tree_1 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int cameras = 0;
    
    /*
     * 1 = Covered  by child (Do not need camera)
     * 0 = Itself a camera (Has Camera)
     * -1 = (need Camera) Covered by none */
    

    public static int MinCamerasInBT_(TreeNode root) {
    	
    	if(root == null) {
    		return 1;
    	}
    	
    	int lchild = MinCamerasInBT_(root.left);
    	int rchild = MinCamerasInBT_(root.right);
    	
    	if(lchild == -1 || rchild == -1) { // child need camera
    		cameras++;
    		return 0;// //Root becoming the camera since any or both of his child needs a camera
    	}
    	if(lchild == 0 || rchild == 0) {// child are covered
    		return 1; // //I'm covered by my child and parent you see for yourself
        
    	}
    	
        return -1; //left == 1 && right == 1
                   //Asking parent to cover him, since both of his child are covered by their child
    }
    public static int MinCamerasInBT(TreeNode root) {
    	
    	if(MinCamerasInBT_(root) == -1) cameras++; 
    	return cameras;
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}