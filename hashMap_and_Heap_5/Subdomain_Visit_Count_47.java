package hashMap_and_Heap_5;
import java.util.*;

public class Subdomain_Visit_Count_47 {
    
	public static List<String> subdomainVisits(String[] cpdomains) {
		// write your code here

		return null;
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int n = Integer.parseInt(s.nextLine());
			String[] cpd = new String[n];
			for (int i = 0; i < cpd.length; i++) {
				cpd[i] = s.nextLine();
			}
			List<String> ans = subdomainVisits(cpd);
			Collections.sort(ans);
			System.out.println(ans);
		}
	}

}
