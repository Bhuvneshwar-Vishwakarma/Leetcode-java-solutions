package arrays_and_String_9;
import java.util.*;

public class Segmented_Sieve_20 {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~
	public static ArrayList<Integer> sieve(int n){
		boolean[] arr = new boolean[n + 1];
		
		for(int i = 2; i * i <= arr.length; i++) {
			if(arr[i] == false) {
				for(int j = 2 * i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == false) {
				res.add(i);
			}
		}
		
		return res;
	}

  public static void segmentedSieveAlgo(int a, int b) {
	  // 1. make a root of b
	  int rootb = (int)Math.sqrt(b);
	  boolean[] arr = new boolean[b - a + 1]; // false --> prime, true--> not prime
	  
	  // 2. get prime till root b using sieve
	  ArrayList<Integer> primes = sieve(rootb);
	  
	  // 3. marking using prime
	  for(int prime: primes) {
		  // find starting index for marking
		  int multiple = (int)Math.ceil((a * 1.0) / prime);
		  if(multiple == 1) {
			  multiple++;
		  }
		  
		  int index = multiple * prime - a;
		  for(int j = index; j < arr.length; j += prime) {
			  arr[j] = true;// not prime
		  }
	  }
	  
	  // display
	  for(int i = 0; i< arr.length; i++) {
		  if(arr[i] == false && i + a != 1) {
			  int val = i + a;
			  System.out.println(val);
		  }
	  }
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    segmentedSieveAlgo(a, b);
  }
}
