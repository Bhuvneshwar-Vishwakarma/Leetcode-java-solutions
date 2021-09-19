package arrays_and_String_9;
import java.util.*;

public class Four_Sum_Target_Sum_With_Unique_Quadruple_34 {

  public static List<List<Integer>> fourSum(int[] arr, int target) {
    // write your code here
	  List<List<Integer>> res = new ArrayList<>();
	  int n = arr.length;
	  if(n < 4) {
		  return res;
	  }
	  Arrays.sort(arr);
	  
	  for(int i = 0; i <= arr.length - 4; i++) {
		  if(i != 0 && arr[i] == arr[i - 1]) {
			  continue;
		  }
		  int val1 = arr[i];
		  List<List<Integer>> subres = threeSum(arr, i + 1, target - val1);
		  
		  for(List<Integer> list: subres) {
			  list.add(val1);
			  res.add(list);
		  }
	  }
	  return res;
  }
  public static List<List<Integer>> threeSum(int[] arr, int si, int target) {
		  
		  List<List<Integer>> res = new ArrayList<>();
		  int n = arr.length;
		  if(n - si < 3) return res;
		  
		  for(int i = si; i <= n - 3; i++) {
			  if(i != si && arr[i] == arr[i - 1]) {
				  continue;
			  }
			  int val1 = arr[i];
			  int targ = target - val1;
			  List<List<Integer>> subres = twoSum(arr, i + 1, n - 1, targ);
			  for(List<Integer> list: subres) {
				  list.add(val1);
				  res.add(list);
			  }
		  }
		  return res;
	  }
	  public static List<List<Integer>> twoSum(int[] arr, int si, int ei, int target){
		  List<List<Integer>> res = new ArrayList<>();
		  int i = si;
		  int j = ei;
		  while(i < j) {
			  if(i != si && arr[i] == arr[i - 1]) {
				  i++;
				  continue;
			  }
			  int sum = arr[i] + arr[j];
			  if(sum == target) {
				  List<Integer> subres = new ArrayList<>();
				  subres.add(arr[i]);
				  subres.add(arr[j]);
				  res.add(subres);
				  i++;
				  j--;
				  
			  }else if(sum > target) {
				  j--;
			  }else {
				  i++;
			  }
		  }
		  
		  return res;
	  }



  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = fourSum(arr, target);
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