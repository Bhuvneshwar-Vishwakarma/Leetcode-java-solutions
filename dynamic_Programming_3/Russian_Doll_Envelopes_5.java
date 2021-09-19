package dynamic_Programming_3;

import java.util.Arrays;
import java.util.Scanner;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/russian-doll-envelopes-official/ojquestion#
public class Russian_Doll_Envelopes_5 {
	
	
	public static class Envelope implements Comparable<Envelope>{
		int w;
		int h;
		
		Envelope(int w, int h){
			this.w = w;
			this.h = h;
		}
		
		public int compareTo(Envelope o){
			return this.w - o.w;
		}
	}


	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = Integer.parseInt(sc.nextLine());
			Envelope[] envelop = new Envelope[n];
			
			for(int i = 0; i < envelop.length; i++) {
				String line = sc.nextLine();
				String[] parts = line.split(" ");
				int w = Integer.parseInt(parts[0]);
				int h = Integer.parseInt(parts[1]);
				
				envelop[i] = new Envelope(w, h);
			}
			Arrays.sort(envelop);
			
			int[] dp = new int[n];
			
			int omax = 0;
			for(int i = 0; i < dp.length; i++) {
				int max = 0;
				 
				for(int j = 0; j < i; j++) {
					if(envelop[j].h < envelop[i].h && envelop[j].w < envelop[i].w) {
						if(dp[j] > max) {
							max = dp[j];
						}
					}	
				}
				dp[i] = max + 1;
				
				if(dp[i] > omax) {
					omax = dp[i];
				}
			}
			
			System.out.println(omax);
		}
		
	}

}
