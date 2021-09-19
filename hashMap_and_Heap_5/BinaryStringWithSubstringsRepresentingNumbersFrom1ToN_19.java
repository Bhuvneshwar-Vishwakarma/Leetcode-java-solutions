package hashMap_and_Heap_5;

import java.util.Scanner;

public class BinaryStringWithSubstringsRepresentingNumbersFrom1ToN_19 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String str = scn.next();
			int n = scn.nextInt();
			System.out.println(solution(str,n));
		}
	}

    public static boolean solution(String s, int n) {
        for(int i = 1; i<=n; i++){
            String binary = Integer.toBinaryString(i);
            if(!s.contains(binary)){
                return false;
            }
        }
        return true;

    }
    
}
