package arrays_and_String_9;
import java.util.*;

public class Boats_To_Save_People_30 {

  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
  public static int numRescueBoats(int[] people, int limit) {
	  int boatCount = 0;
	  
	  Arrays.sort(people);
	  
	  int i = 0;
	  int j = people.length - 1;
	  while(i <= j) {
		  int sum = people[i] + people[j];
		  if(sum <= limit) {
			  boatCount++;
			  i++;
			  j--;
		  }else if(sum > limit){
			  boatCount++;
			  j--;
		  }
	  }
	  
	  return boatCount;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] people = new int[n];

    for (int i = 0; i < n; i++)
      people[i] = scn.nextInt();

    int limit = scn.nextInt();
    int boats = numRescueBoats(people, limit);
    System.out.println(boats);
  }
}