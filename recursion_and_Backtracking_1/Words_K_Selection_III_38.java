//package recursion_and_Backtracking_1;
//import java.io.*;
//import java.util.*;
//
//public class Words_K_Selection_III_38 {
//
//  
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String str = br.readLine();
//    int k = Integer.parseInt(br.readLine());
//
//    HashMap<Character, Integer> unique = new HashMap<>();
//    String ustr = "";
//    for (char ch : str.toCharArray()) {
//      if (unique.containsKey(ch) == false) {
//        unique.put(ch, 1);
//        ustr += ch;
//      } else {
//        unique.put(ch, unique.get(ch) + 1);
//      }
//    }
//
//   
//  }
//
//}