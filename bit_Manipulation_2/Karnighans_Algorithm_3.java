package bit_Manipulation_2;
import java.util.*;

public class Karnighans_Algorithm_3 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		
		//write your code here
		int counter = 0;
		while(n != 0){
		    int rsbm = n & -n;
		    n -= rsbm;
		    counter++;
		}
		System.out.println(counter);
	}
  }

}