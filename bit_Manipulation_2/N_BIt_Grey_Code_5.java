package bit_Manipulation_2;
import java.util.*;
/*The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
    sequence of gray code. A gray code sequence must begin with 0.*/
public class N_BIt_Grey_Code_5 {

    public static ArrayList<Integer> grayCode(int n) {
	 //Write your code here
    	if(n == 0) {
    		ArrayList<Integer> bres = new ArrayList<>();
    		bres.add(0);
    		bres.add(1);
    		return bres;
    	}
    	ArrayList<Integer> rres = grayCode(n - 1);
    	ArrayList<Integer> mres = new ArrayList<>();
    	
    	for(int i = 0; i<rres.size(); i++) {
    		int ci = rres.get(i);
    		mres.add(Integer.parseInt("0") + ci);
//    		mres.add(ci);
    	}
    	for(int i = rres.size() - 1; i>=0; i--) {
    		int ci = rres.get(i);
    		mres.add(Integer.parseInt("1") + ci);
//    		mres.add(ci);
    	}
    	
    	
    	
    	return mres;
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
			ArrayList<Integer> ans=grayCode(scn.nextInt());
//        Collections.sort(ans);
			System.out.println(ans);
		}
    }
}