package bit_Manipulation_2;
import java.util.*;

public class Is_Power_Of_Two_22 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		//write your code here
		int val = (n & (n - 1));
		if(val == 0){
		    System.out.println(true);
		}else{
		    System.out.println(false);
		}
	}
    
  }

}