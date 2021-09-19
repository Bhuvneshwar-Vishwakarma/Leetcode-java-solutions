package hashMap_and_Heap_5;

import java.util.*;

public class Number_Of_Employees_Under_Every_Manager_1 {
	
	private static void findCount(HashMap<String, String> map) {
		HashMap<String, HashSet<String>> tree = new HashMap<>();
		String ceo = "";
		
		for(String emp: map.keySet()) {
			String mngr =  map.get(emp);
			
			if(mngr.equals(emp)) {
				ceo = mngr;
			}else {
				if(tree.containsKey(mngr)) {
					HashSet<String> emps = tree.get(mngr);
					emps.add(emp);
				}else {
					HashSet<String> emps = new HashSet<>();
					emps.add(emp);
					tree.put(mngr, emps);
				}
			}
		}
		HashMap<String, Integer> result = new HashMap<>();
		getSize(tree, ceo, result);
		
		for(String emp: result.keySet()) {
			System.out.println(emp + " " + result.get(emp));
		}
		
	}
	
	public static int getSize(HashMap<String, HashSet<String>> tree, String mngr, HashMap<String, Integer> result) {
		if(tree.containsKey(mngr) == false) {
			result.put(mngr, 0);
			return 1;
		}
		
		int size = 0;
		
		for(String emp: tree.get(mngr)) {
			int cs = getSize(tree, emp, result);
			size += cs;
		}
		
		result.put(mngr, size);
		return size + 1;
		
		
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			HashMap<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < n; i++) {
				map.put(sc.next(), sc.next());
			}
			findCount(map);
		}

	}

}

