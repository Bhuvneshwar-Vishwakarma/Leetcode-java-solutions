 package arrays_and_String_9;
import java.util.*;

public class Two_Sum_Target_Sum_Unique_Pairs_32 {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static List<List<Integer>> twoSum(int[] arr, int target) {
    // 1. sort the array
	  List<List<Integer>> res = new ArrayList<>();
	  if(arr.length < 2) return res;
	  Arrays.sort(arr);
	  int i = 0;
	  int j = arr.length - 1;
	  while(i < j) {
		  if(i != 0 && arr[i] == arr[i - 1]) {
			  i++;
			  continue;
		  }
		  int sum = arr[i] + arr[j];
		  if(sum == target) {
			  List<Integer> subRes = new ArrayList<>();
			  subRes.add(arr[i]);
			  subRes.add(arr[j]);
			  res.add(subRes);
			  i++;
			  j--;
		  }else if(sum < target){
			  i++;
		  }else {
			  j--;
		  }
	  }
	  
	  return res;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = twoSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }
}